package network;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.okhttp.*;
import model.Player;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.*;

/**
 * @author oguzb
 */
public class GameClient {

    public static final String HOSTNAME = "localhost:9000";
    public static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");
    private OkHttpClient httpClient;
    // Keeping this as a list because we want #0 to be always GameController
    private List<GameClientListener> listeners;

    public GameClient() {
        httpClient = new OkHttpClient();
        listeners = new ArrayList<>();
    }

    private static String makeUrl(String route) {
        return "http://" + HOSTNAME + "/v1" + route;
    }

    public void login(String username, String password) {
        String url = makeUrl("/login");
        String[] addresses = getIpAddresses();

        final Player loginPlayer = new Player(addresses, username, password);
        loginPlayer.setPreferredAddress("");

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-type", "application/json; charset=UTF-8")
                .post(RequestBody.create(MEDIA_TYPE_JSON, loginPlayer.toJson()))
                .build();

        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                listeners.forEach(l -> l.onLoginFailure(ErrorType.CONNECTION_ERROR));
            }

            @Override
            public void onResponse(Response response) throws IOException {
                System.out.println(response.code());
                System.out.println(response.body().string());
                switch (response.code()) {
                    case 200:
                        listeners.forEach(l -> l.onLoginSuccess(loginPlayer));
                        break;
                    case 400:
                        listeners.forEach(l -> l.onLoginFailure(ErrorType.CONNECTION_ERROR));
                        break;
                    case 404:
                        listeners.forEach(l -> l.onLoginFailure(ErrorType.BAD_CREDENTIALS));
                        break;
                    default:
                        listeners.forEach(l -> l.onLoginFailure(ErrorType.SERVER_ERROR));
                }
            }
        });
    }

    public void signup(String username, String password) {
        String url = makeUrl("/signup");
        String[] addresses = getIpAddresses();

        final Player signupPlayer = new Player(addresses, username, password);
        signupPlayer.setPreferredAddress("");

        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-type", "application/json; charset=UTF-8")
                .post(RequestBody.create(MEDIA_TYPE_JSON, signupPlayer.toJson()))
                .build();

        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                listeners.forEach(l -> l.onSignupFailure(ErrorType.CONNECTION_ERROR));
            }

            @Override
            public void onResponse(Response response) throws IOException {
                switch (response.code()) {
                    case 200:
                        listeners.forEach(l -> l.onSignupSuccess(signupPlayer));
                        break;
                    case 400:
                        listeners.forEach(l -> l.onSignupFailure(ErrorType.USER_EXISTS));
                        break;
                    default:
                        listeners.forEach(l -> l.onSignupFailure(ErrorType.SERVER_ERROR));
                }
            }
        });
    }

    public void lookup(String username) {
        String url = makeUrl("/player/"+username);

        Request request = new Request.Builder()
                .url(url)
                .build();

        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                listeners.forEach(l -> l.onLookupFailure(ErrorType.CONNECTION_ERROR));
            }

            @Override
            public void onResponse(Response response) throws IOException {
                switch (response.code()) {
                    case 200:
                        String jsonStr = response.body().string();
                        JsonParser parser = new JsonParser();
                        JsonObject object = parser.parse(jsonStr).getAsJsonObject();
                        String preferredAdderss = object.get("preferredAddress").getAsString();
                        JsonArray addressArray = object.get("addresses").getAsJsonArray();
                        String[] addresses = new String[addressArray.size()];
                        for(int i=0;i<addressArray.size();i++) {
                            addresses[i] = addressArray.get(i).getAsString();
                        }

                        Player lookupPlayer = new Player();
                        lookupPlayer.setUsername(username);
                        lookupPlayer.setAddresses(addresses);
                        lookupPlayer.setPreferredAddress(preferredAdderss);
                        listeners.forEach(l -> l.onLookupSuccess(lookupPlayer));
                        break;
                    case 404:
                        listeners.forEach(l -> l.onLookupFailure(ErrorType.USER_DOES_NOT_EXIST));
                        break;
                    default:
                        listeners.forEach(l -> l.onLookupFailure(ErrorType.OTHER_FAILURE));
                }
            }
        });
    }

    public void loadWords() {
        String url = makeUrl("/words");

        Request request = new Request.Builder()
                .url(url)
                .build();

        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                listeners.forEach(l -> l.onLoginFailure(ErrorType.CONNECTION_ERROR));
            }

            @Override
            public void onResponse(Response response) throws IOException {
                switch (response.code()) {
                    case 200:
                        String jsonStr = response.body().string();
                        JsonParser parser = new JsonParser();
                        JsonArray wordsArray = parser.parse(jsonStr).getAsJsonArray();
                        String[] words = new String[wordsArray.size()];
                        for(int i=0;i<wordsArray.size();i++) {
                            words[i] = wordsArray.get(i).getAsString();
                        }
                        listeners.forEach(l -> l.onLoadWordsSuccess(words));
                        break;
                    default:
                        listeners.forEach(l -> l.onLoadWordsFailure(ErrorType.OTHER_FAILURE));
                }
            }
        });
    }

    public void addListener(GameClientListener listener) {
        listeners.add(listener);
    }

    public void removeListener(GameClientListener listener) {
        listeners.remove(listener);
    }

    public static String[] getIpAddresses() {
        List<String> addresses = new ArrayList<>();
        Enumeration e = null;
        try {
            e = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e1) {
            e1.printStackTrace();
        }
        while(e != null && e.hasMoreElements())
        {
            NetworkInterface n = (NetworkInterface) e.nextElement();
            Enumeration ee = n.getInetAddresses();
            while (ee.hasMoreElements())
            {
                InetAddress i = (InetAddress) ee.nextElement();
                addresses.add(i.getHostAddress());
            }
        }

        String[] arr = new String[addresses.size()];
        int i=0;
        for(String a : addresses) {
            arr[i++] = a;
        }
        return arr;
    }

    public enum ErrorType {
        USER_DOES_NOT_EXIST,
        USER_EXISTS,
        CONNECTION_ERROR,
        SERVER_ERROR,
        BAD_CREDENTIALS,
        OTHER_FAILURE
    }

    public interface GameClientListener {
        void onLoginFailure(ErrorType type);
        void onSignupFailure(ErrorType type);
        void onLookupFailure(ErrorType type);
        void onLoadWordsFailure(ErrorType type);
        void onLoginSuccess(Player player);
        void onSignupSuccess(Player player);
        void onLookupSuccess(Player player);
        void onLoadWordsSuccess(String[] words);
    }
}
