package network;

import model.Player;

import java.io.*;
import java.util.Properties;

/**
 * @author oguzb
 */
public class AccountStore {

    final static String FILENAME = "accountData.db";
    final static String kUSERNAME = "username";
    final static String kPASSWORD = "password";

    public static Player retrieve() {
        Properties props = getProperties();
        String username = props.getProperty(kUSERNAME);
        String password = props.getProperty(kPASSWORD);
        if(username != null && password != null) {
            return new Player(new String[0], username, password);
        }
        return null;
    }

    public static void store(Player player) {
        Properties props = getProperties();
        props.setProperty(kUSERNAME, player.getUsername());
        props.setProperty(kPASSWORD, player.getPassword());

        OutputStream output = null;
        try {
            File storeFile = new File(FILENAME);
            storeFile.createNewFile();
            output = new FileOutputStream(storeFile);
            props.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void logout() {
        File storeFile = new File(FILENAME);
        if(storeFile.exists()) {
            storeFile.delete();
        }
    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(FILENAME));
        } catch (IOException e) {

        }
        return properties;
    }
}
