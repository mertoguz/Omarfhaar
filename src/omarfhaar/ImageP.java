/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omarfhaar;


import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ImageP {
    
    private BufferedImage image;
    private String path;
    
    public ImageP(){
        
        

}
    
    public void rescale(String path)
    {
        this.path = path;
        BufferedImage img = this.image;
        int imgWidth = img.getWidth();
        int imgHeight = img.getHeight();
        int width;
        int height;
        
         
         
        if(imgWidth < imgHeight)
        {
            width = 480;
            height = 640;
        } else {
            
            width = 640;
            height = 480;
            
        }
        
        BufferedImage newImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D g = newImage.createGraphics();
        
        try
        {
              g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BICUBIC);
               g.drawImage(img, 0, 0, width, height, null);

        }
        
        finally {
        g.dispose();
        }
        
        this.image = newImage;
        saveImg();
    }
    
    
    private void saveImg()
    {
        
        try {
                File outputfile = new File(this.path);
                ImageIO.write(this.image,"jpg",outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
     
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    
    
    
    
}
