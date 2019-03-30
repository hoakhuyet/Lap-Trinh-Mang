/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De1.Cau2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Neik
 */
public class TuDien {

    private ArrayList<Word> tuDien;

    public TuDien() {
        tuDien = new ArrayList<>();
        initData();
    }

    public ArrayList<Word> getTuDien() {
        return tuDien;
    }
    
    public void initData() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("D:\\data.txt")));
            String line;
            while ((line = br.readLine()) != null) {
                String contents[] = line.split("\\$");
                tuDien.add(new Word(contents[0], contents[1], contents[2]));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TuDien.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TuDien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
