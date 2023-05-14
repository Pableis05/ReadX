package model;

import java.util.Calendar;
import java.util.Random;

/**
 * The Book class extends the BibliographicProduct class and includes variables for review and gender,
 * as well as methods for setting these variables and generating a random hexadecimal ID.
 */
public class Book extends BibliographicProduct{
    private String review;
    private GenderType gender;
    /**
    The Book class represents a bibliographic product of type book, which extends from the BibliographicProduct class.
    It includes information about the review and gender of the book.
    @param nameProduct The name of the book.
    @param numberPages The number of pages in the book.
    @param publicationDate The publication date of the book.
    @param url The url where the book can be found.
    @param valueProduct The value of the book.
    @param review The review of the book.
    @param gender The gender of the book.
    */
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

    /**
     * This function sets the review for a particular object.
     * 
     * @param review The parameter "review" is a String that represents the review of a product or
     * service. The method "setReview" sets the value of the instance variable "review" to the value
     * passed as a parameter.
     */
    public void setReview(String review) {
        this.review = review;
    }

    /**
     * This function sets the gender of an object to a specified gender type.
     * 
     * @param gender a variable of type GenderType that represents the gender of a person. The method
     * setGender() sets the value of this variable.
     */
    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    

    /**
     * The function generates a random hexadecimal ID with a length of 3 digits.
     * 
     * @return A randomly generated hexadecimal ID code with a length of 3 characters.
     */
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
