package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oguzb
 */
public class Player {

	protected List<String> addresses;
    protected String username;
    protected String password;

	public Player() {
        this.addresses = new ArrayList<>();
	}

    public Player(List<String> addresses, String username, String password) {
        this.addresses = addresses;
        this.username = username;
        this.password = password;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<String> addresses) {
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
}
