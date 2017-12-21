/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omarfhaar;

import java.io.File;
import java.io.FilenameFilter;

/**
 *
 * @author mert
 */


public class ManageDir {
    
    private File directory;       
    private String path;
    private FilenameFilter filter;
            
    public ManageDir()
    {
        
       
    }
    
    public File[] listFiles()
    {
         filter = new FilenameFilter(){
            
			public boolean accept(File dir, String name) {
				
	
                                if (name.endsWith(".jpg")) {
			
                                    return true;
				
                                } else {
				
                                    return false;
				}
			}
		};
                
                
        directory = new File(this.path);
       
        //adding all files to file list on current folder.
        return directory.listFiles(filter);
    }

    
    public void setpath(String path) {
        this.path = path;
    }
    
    
 
}

