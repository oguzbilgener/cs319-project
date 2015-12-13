package ui.event;

/**
 * @author oguzb
 */
public class MenuEvent {

	public enum ItemType {
		host, join, credits, signup, login, logout
	}

	ItemType itemType;

	public interface Listener {
		void onMenuEvent(ItemType itemType);
	}
}
