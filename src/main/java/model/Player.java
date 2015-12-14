package model;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * @author oguzb
 */
public class Player {

	protected String[] addresses;
    protected String preferredAddress;
    protected String username;
    protected String password;
    protected int score;

	public Player() {
        this.addresses = new String[2];
	}

    public Player(String[] addresses, String username, String password) {
        this.addresses = addresses;
        this.username = username;
        this.password = password;
        this.score = 0;
    }

    public Player(String preferredAddress, String username) {
        this.preferredAddress = preferredAddress;
        this.username = username;
        this.addresses = new String[] {preferredAddress};
        this.password = "";
        this.score = 0;
    }

    public static Player fromJson(String jsonStr) {
        return new Gson().fromJson(jsonStr, Player.class);
    }

    public static Player fromMessageJson(String jsonStr) {
        JsonElement element = new JsonParser().parse(jsonStr);
        JsonObject object = element.getAsJsonObject();
        try {
            JsonObject content = object.get("content").getAsJsonObject();
            Player player = new Player();
            player.setUsername(content.get("username").getAsString());
            player.setPreferredAddress(content.get("preferredAddress").getAsString());
            return player;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toJson() {
        return new Gson().toJson(this);
    }

    public String[] getAddresses() {
        return addresses;
    }

    public void setAddresses(String[] addresses) {
        this.addresses = addresses;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPreferredAddress() {
        return preferredAddress;
    }

    public void setPreferredAddress(String preferredAddress) {
        this.preferredAddress = preferredAddress;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }
}
