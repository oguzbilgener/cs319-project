package network;

import com.google.gson.Gson;

/**
 * @author oguzb
 */
public class Message {
    protected P2PManager.MessageType type;
    protected Object content;

    public Message(P2PManager.MessageType type, String content) {
        this.type = type;
        this.content = content;
    }

    public Message(P2PManager.MessageType type, Object contentObject) {
        this.type = type;
        if(contentObject != null) {
            this.content = new Gson().toJson(contentObject);
        }
        else {
            this.content = "";
        }
    }

    public Message(P2PManager.MessageType type) {
        this.type = type;
        this.content = "";
    }

    public P2PManager.MessageType getType() {
        return type;
    }

    public void setType(P2PManager.MessageType type) {
        this.type = type;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String makeJson() {
        return new Gson().toJson(this);
    }
}
