package omarfhaar;

import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author mertoguz
 */
public class Rectangle {
    private int startDragX;
    private int startDragY;
    private int width;
    private int height;
    private String fileName;

    public Rectangle(int startDragX, int startDragY, int width, int height, String fileName) {
        this.startDragX = startDragX;
        this.startDragY = startDragY;
        this.width = width;
        this.height = height;
            
        this.fileName = fileName;
    }    

    Rectangle() {
        
    }
    
    public void printData(){
        System.out.println("Start X : " + startDragX + " - Start Y: " + startDragY + " | " + "Width: " + width + " - Height: " + height);
    }
    
    public void createTxt(String path, int x, int y, int width, int height){
        
       
        
        try {
             File outputFile = new File("positive.txt");
             FileWriter fw = new FileWriter(outputFile); 
             fw.write(path + " 1 " + String.valueOf(x) + " " + String.valueOf(y) + " " + String.valueOf(width) + " " + String.valueOf(height));
             fw.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
    
    //Getter & Setter
    public int getStartDragX() {
        return startDragX;
    }

    public void setStartDragX(int startDragX) {
        this.startDragX = startDragX;
    }

    public int getStartDragY() {
        return startDragY;
    }

    public void setStartDragY(int startDragY) {
        this.startDragY = startDragY;
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    
    
    
    
}
