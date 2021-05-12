package LogMessage;

import java.util.ArrayList;

public class Messages {

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

    private boolean search(String word, ArrayList<String> list) {
        for(String s: list) {
            if(s.equals(word)) {
                return false;
            }
        }
        return true;
    }

    public String getDes() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return fullMsg;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDes(String description) {
        this.description = description;
    }

    public void setMsg(String id, String description) {
        this.id = id;
        this.description = description;
        fullMsg = id + ": " + description;
    }

}

