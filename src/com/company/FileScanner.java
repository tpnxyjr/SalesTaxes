package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Kevin on 3/20/2017.
 */
public class FileScanner {
    private FileReader targetFile;
    public FileScanner(String filename){
        try {
            targetFile = new FileReader(new File(filename));
        }
        catch(FileNotFoundException e){
        }
    }

    public boolean scanFile(String s){
        try {
            String ln;
            BufferedReader br = new BufferedReader(targetFile);
            while ((ln = br.readLine())!= null) {
                if(ln.equals(s))return true;
            }
            return false;
        }catch(Exception e){
            return false;
        }
    }
}
