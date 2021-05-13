package resources;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Images { // Images class for formattig and rescaling images. 

    public void  display(String y, String x, String z) { // Display image helper method. 
        URL resource = getClass().getResource(y);
        ImageIcon icon = new ImageIcon(resource);
        Image imageSize = icon.getImage();

        Image modified = imageSize.getScaledInstance(600, 600, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(modified);

        JOptionPane.showMessageDialog(null, x, z, JOptionPane.INFORMATION_MESSAGE, icon);
    }
}
