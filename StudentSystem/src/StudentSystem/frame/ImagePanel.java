package StudentSystem.frame;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private ImageIcon icon;
    private Image img;

    public ImagePanel(){
        icon=new ImageIcon(StudentSystemMainFrame.class.getResource("/1.png" ));
        img=icon.getImage();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(img,0,0,null );
    }
}
