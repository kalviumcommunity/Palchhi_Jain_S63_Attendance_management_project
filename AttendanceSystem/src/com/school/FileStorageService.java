package com.school;

import java.io.*;
import java.util.List;

public class FileStorageService {
    
    public void saveData(List<? extends Storable> items, String filename) {
        try (FileWriter fw = new FileWriter(filename);
             PrintWriter pw = new PrintWriter(fw)) {
            
            for (Storable item : items) {
                pw.println(item.toDataString());
            }
            
            System.out.println("Data successfully saved to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to file " + filename + ": " + e.getMessage());
        }
    }
}