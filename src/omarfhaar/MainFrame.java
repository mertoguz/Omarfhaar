
package omarfhaar;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author mert
 */
public class MainFrame extends JFrame {
    
    public MainFrame(String path)
    {
        
        //imagePanel iPnl = new imagePanel(path);
        PaintSurface p = new PaintSurface();
        
        this.pack();
        this.setLocationRelativeTo(null);
        //add(iPnl);
        add(p,BorderLayout.CENTER);
        setSize(p.img1.getWidth(),p.img1.getHeight()); 
        
        //setSize(iPnl.getImg().getWidth(),iPnl.getImg().getHeight());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
    }
    
}
