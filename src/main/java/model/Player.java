package model;

import com.google.gson.Gson;

/**
 * @author oguzb
 */
public class Player {

	protected String[] addresses;
    protected String preferredAddress;
    protected String username;
    protected String password;

	public Player() {
        this.addresses = new String[2];
	}

    public Player(String[] addresses, String username, String password) {
        this.addresses = addresses;
        this.username = username;
        this.password = password;
    }

    public Player(String preferredAddress, String username) {
        this.preferredAddress = preferredAddress;
        this.username = username;
        this.addresses = new String[] {preferredAddress};
        this.password = "";
    }

    public static Player fromJson(String jsonStr) {
        return new Gson().fromJson(jsonStr, Player.class);
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
}
