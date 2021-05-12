package LogMessage;
import javax.swing.*;
import java.util.ArrayList;

public class FullMessages {

    public static ArrayList<Messages> FullMessages = new ArrayList<>();

    public FullMessages() {
        
    }

    public static void generateFullMessages() {
        FullMessages.add(new Messages("Client", "Security alert – repeated login failures"));
        FullMessages.add(new Messages("Server", "File not found"));
        FullMessages.add(new Messages("Webserver", "Disk offline"));
        FullMessages.add(new Messages("DiskDrive", "No records available"));
        FullMessages.add(new Messages("Directory", "Storage is full"));
        FullMessages.add(new Messages("HostName", "Error, unable to resolve hostname"));
        FullMessages.add(new Messages("SystemInfo", "Marcosoft Windows 10"));
        FullMessages.add(new Messages("DriverQuery", "No devices found"));
        FullMessages.add(new Messages("Netstat", "Connection lost"));
        FullMessages.add(new Messages("FilePath", "The system cannot find the path specified"));
    }

    public static void addMessage() {
    	String id = JOptionPane.showInputDialog("Please enter Machine ID: ");
        String description = JOptionPane.showInputDialog("Please enter description: ");
        if(id.equals(null) || description.equals(null) || description.length() == 0 || id.length() == 0) {
            JOptionPane.showMessageDialog(null,"Incorrect information!");
            addMessage();
        }
        FullMessages.add(new Messages(id, description));
    }

    public static void addRandomDes() {
        String choice = JOptionPane.showInputDialog("Type (random) to generate random description for a random Machine ID");
        if(choice.equals(null) || choice.length() == 0) {
            JOptionPane.showMessageDialog(null,"Information Inputed Was Incorrect, Please Try Again");
        }
        else if(choice.equals("random")){
            addRandomDes2();
        }
        else {
            addRandomDes2(choice);
        }

    }

    private static void addRandomDes2() {
        FullMessages.add(new Messages(Messages.ids.get((int)(Math.random() * Messages.ids.size())), Messages.descriptions.get((int)(Math.random() * Messages.descriptions.size()))));
    }

    private static void addRandomDes2(String id) {
        FullMessages.add(new Messages(id, Messages.descriptions.get((int)(Math.random() * Messages.descriptions.size()))));
    }

    public static void remove() {
        String choice = JOptionPane.showInputDialog("Type (keyword) to remove message by keyword or type (id) to remove message by Machine ID");
        if(choice.equals(null) || choice.length() == 0) {
            JOptionPane.showMessageDialog(null,"Incorrect Information!");
            remove();
        }
        else if(choice.equalsIgnoreCase("id")){
            String id = JOptionPane.showInputDialog(null, "Please type Machine ID (all messages with this id will be removed)");
            if(id.equals(null) || id.length() == 0) {
                JOptionPane.showMessageDialog(null,"Incorrect Information!");
                remove();
            }
            remove1(id);
        }
        else if(choice.equalsIgnoreCase("keyword")){
            String keyword = JOptionPane.showInputDialog(null, "Please enter Keyword (all messages containing this keyword (in ID or DESCRIPTION) will be erased)");
            if(keyword.equals(null) || keyword.length() == 0) {
                JOptionPane.showMessageDialog(null,"Incorrect Information!");
                remove();
            }
            remove2(keyword);
        }
        else {
            JOptionPane.showMessageDialog(null,"Incorrect Information!");
            remove();
        }
    }

    private static void remove1(String id) {
        for(int i = 0; i < FullMessages.size(); i++) {
            if(FullMessages.get(i).getId().equals(id)) {
                Messages.ids.remove(FullMessages.get(i).getId());
                FullMessages.remove(FullMessages.get(i));
                i--;
            }
        }
    }

    private static void remove2(String keyword) {
        for(int i = 0; i < FullMessages.size(); i++) {
            if(FullMessages.get(i).getMessage().contains(keyword)) {
                FullMessages.remove(FullMessages.get(i));
                i--;
            }
        }
    }

    public static void search() {
        String choice = JOptionPane.showInputDialog("Type (keyword) to search for all messages containing keyword or type (id) to search for all messages containing that ID");
        if(choice.equals(null) || choice.length() == 0) {
            JOptionPane.showMessageDialog(null,"Incorrect Information!");
            search();
        }
        else if(choice.equalsIgnoreCase("id")){
            String id = JOptionPane.showInputDialog(null, "What ID would you like to search for?");
            if(id.equals(null) || id.length() == 0) {
                JOptionPane.showMessageDialog(null,"Incorrect Information!");
                search();
            }
            search1(id);
        }
        else if(choice.equalsIgnoreCase("keyword")){
        
            String keyword = JOptionPane.showInputDialog(null, "What Keyword would you like to search for?");
            
            if(keyword.equals(null) || keyword.length() == 0) {
                JOptionPane.showMessageDialog(null,"Incorrect Information!");
                search();
            }
            search2(keyword);
        }
        else {
            JOptionPane.showMessageDialog(null,"Incorrect Information!");
            search();
        }
    }

    private static void search1(String id) {
        String messages = "";
        for(Messages msg: FullMessages) {
            if(msg.getId().equals(id)) {
                messages += msg.getMessage() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, ("All messages found with ID: " + id + "\n" + messages));

    }

    private static void search2(String keyword) {
        String messages = "";
        for(Messages msg: FullMessages) {
            if(msg.getMessage().contains(keyword)) {
                messages += msg.getMessage() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, ("All messages found with keyword: " + keyword + "\n" + messages));
    }

    public static String showCount() {
        String s = "";
        int cnt = 0;
        for(String word: Messages.ids) {
            for(Messages msg: FullMessages) {
                if(msg.getId().equals(word)) {
                    cnt++;
                }
            }
            s += word + ": " + cnt + "\n";
            cnt = 0;
        }
        JOptionPane.showMessageDialog(null, s);
        return s;
    }

    public static void showMessages() {
        String s = "";
        for(Messages msg: FullMessages) {
            s += msg.getMessage() + "\n";
        }
        JOptionPane.showMessageDialog(null,s);
    }

}
