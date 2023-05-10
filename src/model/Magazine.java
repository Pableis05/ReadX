package model;

import java.util.Calendar;
import java.util.Random;

public class Magazine extends BibliographicProduct{
    
    private String periodicity;
    private CategotyType category;

    public Magazine(String nameProduct, int numberPages,Calendar publicationDate ,String url, double valueProduct, String periodicity, int category) {
        super(nameProduct, numberPages, publicationDate ,url, valueProduct);
        this.periodicity = periodicity;
        if(category == 1){
            this.category = CategotyType.VARIETY;
        }else if(category == 2){
            this.category = CategotyType.DESIGN;
        }else{
            this.category = CategotyType.SCIENTIST;
        }
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public void setCategory(CategotyType category) {
        this.category = category;
    }



    @Override
    public String createID() {
        String alphanumeric = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder codeBuilder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(alphanumeric.length());
            char randomChar = alphanumeric.charAt(index);
            codeBuilder.append(randomChar);
        }
        return codeBuilder.toString();
    }

    
}
