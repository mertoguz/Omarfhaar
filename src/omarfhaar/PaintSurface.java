package omarfhaar;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JComponent;


/**
 *
 * @author mertoguz
 */
  class PaintSurface extends JComponent {
    //ArrayList<Shape> shapes = new ArrayList<Shape>();
    Shape shape;
    Rectangle rectangle;
    public BufferedImage img1;
    String path = "İmage's path";
    
   
    

    Point startDrag, endDrag;

    public PaintSurface() {
        try {
           
            img1 = ImageIO.read(new File(path));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
      this.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
            rectangle = new Rectangle();
            rectangle.setFileName(path);
            
          startDrag = new Point(e.getX(), e.getY());
          endDrag = startDrag;
          
          rectangle.setStartDragX(e.getX());
          rectangle.setStartDragY(e.getY());
          repaint();
        }

        public void mouseReleased(MouseEvent e) {
          Shape r = makeRectangle(startDrag.x, startDrag.y, e.getX(), e.getY());
          shape = r;
          //shapes.add(r);
          
          
          rectangle.setWidth(Math.abs(endDrag.x - startDrag.x));
          rectangle.setHeight(Math.abs(endDrag.y - startDrag.y));
          rectangle.printData();
          rectangle.createTxt(rectangle.getFileName() ,rectangle.getStartDragX(), rectangle.getStartDragY(), rectangle.getWidth(), rectangle.getHeight());
          startDrag = null;
          endDrag = null;
          repaint();
        }
      });

      this.addMouseMotionListener(new MouseMotionAdapter() {
        public void mouseDragged(MouseEvent e) {
          endDrag = new Point(e.getX(), e.getY());          
          repaint();
        }
      });
    }

    public void paint(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      
      
      
      g2.drawImage(img1, 0,0, this);
      
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
     
     
      g2.setStroke(new BasicStroke(3));
      g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.50f));

      
        g2.setPaint(Color.BLACK);
        if (shape != null) {
            g2.draw(shape);
            g2.setPaint(Color.RED);
            g2.fill(shape);
        }
        


      if (startDrag != null && endDrag != null) {
        g2.setPaint(Color.RED);
        Shape r = makeRectangle(startDrag.x, startDrag.y, endDrag.x, endDrag.y);
        g2.draw(r);
      }
    }

    private Rectangle2D.Float makeRectangle(int x1, int y1, int x2, int y2) {
      return new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
    }
  }