package model;

import java.util.Calendar;

/**
 * The BibliographicProduct class contains methods and variables related to bibliographic products such
 * as books, including their ID, name, number of pages, publication date, URL, value, amount of sales,
 * and amount of pages read.
 */
public abstract class BibliographicProduct implements CreateID{
    
    private String idProduct;
    private String nameProduct;
    private int numberPages;
    private Calendar publicationDate;
    private String url;
    private double valueProduct;
    private int amountSales;
    private int amountPagesRead;

    /**
    The BibliographicProduct class represents a bibliographic product in the library system, which has a name, number of pages,
    publication date, URL, ID, value, amount of sales and amount of pages read.
    @param nameProduct the name of the bibliographic product
    @param numberPages the number of pages of the bibliographic product
    @param publicationDate the publication date of the bibliographic product
    @param url the URL of the bibliographic product
    @param valueProduct the value of the bibliographic product
    */
    public BibliographicProduct(String nameProduct, int numberPages, Calendar publicationDate ,String url, double valueProduct) {
        this.nameProduct = nameProduct;
        this.numberPages = numberPages;
        this.publicationDate = publicationDate;
        this.url = url;
        this.idProduct = createID();
        this.valueProduct = valueProduct;
        amountSales = 0;
        amountPagesRead = 0;
    }

    /**
     * This Java function adds a specified number of pages read to a variable.
     * 
     * @param newPages an integer representing the number of pages that the user has read and wants to
     * add to their total amount of pages read.
     */
    public void addNumberPagesRead(int newPages){
        this.amountPagesRead += newPages;
        
    }

    /**
     * The function increments the value of the "amountSales" variable by 1.
     */
    public void addAmountSales(){
        this.amountSales++;
    }

    /**
     * This function decreases the amount of sales by one.
     */
    public void decreaseAmountSales(){
        this.amountSales--;
    }

    /**
     * This function returns the ID of a product as a string.
     * 
     * @return The method `getIdProduct()` is returning a `String` value, which is the `idProduct`
     * variable.
     */
    public String getIdProduct() {
        return idProduct;
    }

    /**
     * This function sets the name of a product.
     * 
     * @param nameProduct The parameter nameProduct is a String that represents the name of a product.
     * The method setNameProduct sets the value of the instance variable nameProduct to the value
     * passed as a parameter.
     */
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    /**
     * This function returns the publication date as a Calendar object.
     * 
     * @return The method is returning a Calendar object representing the publication date.
     */
    public Calendar getPublicationDate() {
        return publicationDate;
    }

    /**
     * This Java function sets the number of pages for a document.
     * 
     * @param numberPages The parameter "numberPages" is an integer value representing the total number
     * of pages in a book. The method "setNumberPages" sets the value of the instance variable
     * "numberPages" to the passed parameter value.
     */
    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    /**
     * This function sets the publication date of an object using a Calendar object.
     * 
     * @param publicationDate a variable of type Calendar that represents the date of publication for a
     * certain publication. The method setPublicationDate sets the value of this variable to the value
     * passed as a parameter.
     */
    public void setPublicationDate(Calendar publicationDate) {
        this.publicationDate = publicationDate;
    }

    /**
     * This function sets the value of a variable called "url".
     * 
     * @param url The parameter "url" is a String type variable that represents the URL (Uniform
     * Resource Locator) of a web page or resource. The "setUrl" method is used to set the value of
     * this variable.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * This function sets the value of the idProduct variable.
     * 
     * @param idProduct The parameter "idProduct" is a String variable that represents the unique
     * identifier of a product. The method "setIdProduct" sets the value of this variable to the input
     * value passed as a parameter.
     */
    public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	/**
     * This function sets the value of a product.
     * 
     * @param valueProduct The parameter valueProduct is a double data type and represents the value of a
     * product. The method sets the value of the instance variable valueProduct to the value passed as a
     * parameter.
     */
    public void setValueProduct(double valueProduct) {
        this.valueProduct = valueProduct;
    }

    /**
     * The function returns the name of a product.
     * 
     * @return The method `getNameProduct()` is returning a `String` value, which is the name of a
     * product.
     */
    public String getNameProduct() {
        return nameProduct;
    }

    /**
     * The function returns the number of pages.
     * 
     * @return The method is returning an integer value representing the number of pages.
     */
    public int getNumberPages() {
        return numberPages;
    }

    /**
     * The function returns the value of a product as a double data type.
     * 
     * @return The method is returning a double value, which is the value of the variable
     * "valueProduct".
     */
    public double getValueProduct() {
        return valueProduct;
    }

    /**
     * The function returns the amount of sales.
     * 
     * @return The method is returning an integer value which represents the amount of sales.
     */
    public int getAmountSales() {
        return amountSales;
    }

    /**
     * This function returns the amount of pages read.
     * 
     * @return The method is returning the value of the variable "amountPagesRead", which is an integer
     * representing the number of pages read.
     */
    public int getAmountPagesRead() {
        return amountPagesRead;
    }

    /**
     * The function returns a string representing a URL.
     * 
     * @return The method `getUrl()` is returning a `String` value, which is the value of the variable
     * `url`.
     */
    public String getUrl() {
        return url;
    }

}
