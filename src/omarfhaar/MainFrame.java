/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omarfhaar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author mertoguz
 */
public class MainFrame extends javax.swing.JFrame {
    private PaintSurface p;    
    private Rectangle rect;
    JButton btnApprove;
    JButton btnRetry;
    private int counter = 1;
    
    public MainFrame(File[] fileList)
    {
        File[] fList = fileList;
        p = new PaintSurface();
        p.setPath(fList[0].toString());
        p.removeRectangle();
        p.createRectangle(fList[0].toString());
        
        btnApprove = new JButton("Okay - Next Image");
        btnRetry = new JButton("Retry");
        rect = new Rectangle();
        rect = p.rectangle;

        
        btnApprove.setSize((p.img1.getWidth()/2),150);
        
        btnApprove.setLocation(0, p.img1.getHeight());
        
        
        btnRetry.setLocation((p.img1.getWidth()/2+1), p.img1.getHeight());
        btnRetry.setSize((p.img1.getWidth()/2),150);
        
        
        
        this.add(btnApprove);
        this.add(btnRetry);
        this.add(p,BorderLayout.CENTER);
        
        this.setSize(p.img1.getWidth(), p.img1.getHeight()+160);
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        
        
        
        
        btnApprove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                                        
                
                    try 
                    {
                rect = p.rectangle;        
                rect.writeToTxt(rect.getFileName() ,rect.getStartDragX(), rect.getStartDragY(), rect.getWidth(), rect.getHeight());
                p.removeRectangle();
                p.setPath(fList[counter].toString());
                p.repaint();
                p.createRectangle(fList[counter].toString());
                
                //rect.printData();
                
                counter++;
                    }
                
                  catch(Exception ex)
                  {
                      JOptionPane.showMessageDialog(null, "You marked all all of images.");
//                      int state = JOptionPane.showOptionDialog(null, "Hello", "Test", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE, null, null, null);
//                      if (state == 0) System.out.println("You clicked OK btn");
//                      if (state == -1) System.out.println("You clicked X");
                     
                      counter = 1;
                      
                      
                  }
            }
        });
        
        btnRetry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //rect.createTxt(rect.getFileName() ,rect.getStartDragX(), rect.getStartDragY(), rect.getWidth(), rect.getHeight());
                p.removeRectangle();
                p.repaint();
            }
        });
        
        
        
    
    }
    
    
    
    
    
    
        
    } 



