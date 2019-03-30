/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De1.Cau2;

/**
 *
 * @author Neik
 */
public class Word {
    private String English;
    private String Vietnamese;
    private String meaning;

    public Word(String English, String Vietnamese, String meaning) {
        this.English = English;
        this.Vietnamese = Vietnamese;
        this.meaning = meaning;
    }

    public String getEnglish() {
        return English;
    }

    public String getVietnamese() {
        return Vietnamese;
    }

    public String getMeaning() {
        return meaning;
    }    
}
