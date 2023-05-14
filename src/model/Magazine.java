package model;

import java.util.Calendar;
import java.util.Random;

/**
 * The "Magazine" class extends the "BibliographicProduct" class and includes properties such as
 * periodicity and category, as well as methods for setting these properties and generating a random
 * alphanumeric ID.
 */
public class Magazine extends BibliographicProduct{
    
    private String periodicity;
    private CategotyType category;
    /**
    Constructor for a Magazine object.
    @param nameProduct the name of the magazine.
    @param numberPages the number of pages in the magazine.
    @param publicationDate the publication date of the magazine.
    @param url the URL of the magazine.
    @param valueProduct the value of the magazine.
    @param periodicity the periodicity of the magazine.
    @param category the category of the magazine (1 for Variety, 2 for Design, 3 for Scientist).
    */
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

    /**
     * This function sets the periodicity of an object.
     * 
     * @param periodicity The parameter "periodicity" is a String variable that represents the
     * frequency or interval at which something occurs or is repeated. It could be daily, weekly,
     * monthly, quarterly, annually, or any other time frame. The method "setPeriodicity" sets the
     * value of the "periodicity" variable
     */
    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    /**
     * This function sets the category of an object to a specified category type.
     * 
     * @param category The parameter "category" is of type "CategoryType" and is used to set the
     * category of an object. The object could be anything that has a category, such as a product, a
     * blog post, or a user account. The CategoryType could be an enum or a class that defines the
     */
    public void setCategory(CategotyType category) {
        this.category = category;
    }



    /**
     * The function creates a random alphanumeric ID consisting of three characters.
     * 
     * @return A randomly generated alphanumeric string of length 3.
     */
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
