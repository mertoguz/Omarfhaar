package omarfhaar;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author mert
 */
public class imagePanel extends JPanel {
    
    private BufferedImage img;
    
    public imagePanel(String path)
    {
        try
        {
            img = ImageIO.read(new File(path));
        }
        
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    
    
    
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }
    
    
    public void paintComponent(Graphics g)
    {
        g.drawImage(this.img, 0, 0, null);
        repaint();
    }
    
}
