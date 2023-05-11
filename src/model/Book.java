package model;

import java.util.Calendar;
import java.util.Random;

public class Book extends BibliographicProduct{
    private String review;
    private GenderType gender;

    public Book(String nameProduct, int numberPages, Calendar publicationDate ,String url, double valueProduct, String review, int gender) {
        super(nameProduct, numberPages, publicationDate ,url, valueProduct);
        this.review = review;
        if(gender == 1){
            this.gender = GenderType.SCIENCIE_FICTION;
        }else if(gender == 2){
            this.gender = GenderType.FANTASY;
        }else{
            this.gender = GenderType.HISTORICAL_NOVEL;
        }
    }

    

    public void setReview(String review) {
        this.review = review;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    

    @Override
    public String createID() {
        Random random = new Random();
        int randomNumber = random.nextInt(4096);
        String hexCode = Integer.toHexString(randomNumber);
        while(hexCode.length() < 3){
            hexCode = "0" + hexCode;
        }
        return hexCode;
    }

    
}
