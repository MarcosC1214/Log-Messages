package LogMessage;

import java.util.ArrayList;

public class Messages { // Includes list of messages along with some getters and setters. 

    public static ArrayList<String> descriptions = new ArrayList<>();
    public static ArrayList<String> ids = new ArrayList<>();
    private String id;
    private String description;
    private String fullMsg;

    public Messages(String id, String description) {
        this.id = id;
        if(search(id, ids)) {
            ids.add(id);
        }
        this.description = description;
        if(search(description, descriptions)) {
            descriptions.add(description);
        }
        fullMsg = id + ": " + description;
    }

    private boolean search(String word, ArrayList<String> list) { // Search method for any strings within list.
        for(String s: list) {
            if(s.equals(word)) {
                return false;
            }
        }
        return true;
    }

    public String getDes() { // Getter for description.
        return description;
    }

    public String getId() { // Getter for identification.
        return id;
    }

    public String getMessage() { // Getter for message.
        return fullMsg;
    }

    public void setId(String id) { // Setter for identification.
        this.id = id;
    }

    public void setDes(String description) { // Setter for description.
        this.description = description;
    }

    public void setMsg(String id, String description) { // Setter for full message constiting of identification:description.
        this.id = id;
        this.description = description;
        fullMsg = id + ": " + description;
    }

}

