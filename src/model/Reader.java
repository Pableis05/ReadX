package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * The Reader class contains information about a reader, including their name, ID, current and last
 * session page, and the books and magazines they have access to.
 */
public abstract class Reader implements AddProduct{

    private String nameReader;
    private String idReader;
    private int currentSessionPage;
    private int lastSessionPage;
    protected ArrayList<Book>books;
    protected ArrayList<Magazine>magazines;
    private ArrayList<String[][]>libraryUser;
    

    /**
    Constructs a new Reader object with a name and an identification number.
    @param nameReader the name of the reader
    @param idReader the identification number of the reader
    */    
    public Reader(String nameReader, String idReadder){
        this.nameReader = nameReader;
        this.idReader = idReadder;
        currentSessionPage = 1;
        lastSessionPage = 0;
        libraryUser = new ArrayList<>();
    }

    /**
     * This Java function returns the ArrayList of BibliographicProducts of the user sorted by their publication
     * date.
     * 
     * @return The user ArrayList of BibliographicProduct objects sorted by their publication date.
     */
    public ArrayList<BibliographicProduct> returnBibliographicProductsByDate(){
        ArrayList<BibliographicProduct>auxBibliographicProducts = new ArrayList<>();
        auxBibliographicProducts.addAll(books);
        auxBibliographicProducts.addAll(magazines);
        Collections.sort(auxBibliographicProducts, Comparator.comparing(BibliographicProduct::getPublicationDate));
        return auxBibliographicProducts;
    }

    
    /**
     * The function searches for a bibliographic product by its ID in a list of books and magazines and
     * returns its position.
     * 
     * @param id The parameter "id" is a String representing the unique identifier of a bibliographic
     * product that needs to be searched for in the "books" and "magazines" ArrayLists.
     * @return The method is returning an integer value which represents the position of the
     * BibliographicProduct with the given id in the combined ArrayList of books and magazines. If the
     * product is not found, the method returns -1.
     */
    public int searchNumberBibliograpicProductReader(String id){
        ArrayList<BibliographicProduct>auxBibliographicProducts = new ArrayList<>();
        auxBibliographicProducts.addAll(books);
        auxBibliographicProducts.addAll(magazines);
        int position = -1;
        for (int i = 0; i < auxBibliographicProducts.size(); i++) {
            BibliographicProduct product = auxBibliographicProducts.get(i);
            if(product.getIdProduct().equals(id)){
                position = i;
                break;
            }
        }
        return position;
    }

    /**
     * This function increments the current session page and updates the last session page if
     * necessary.
     */
    public void addAmountSessionPage(){
        this.currentSessionPage++;
        if(checkLastSessionPage()){
            this.lastSessionPage++;
        }
    }

    /**
     * This function checks if the last session page is less or equal than the current session page and returns
     * a boolean value indicating whether there was a change.
     * 
     * @return The method is returning a boolean value, which is either true or false depending on
     * whether the last session page is less than the current session page.
     */
    public boolean checkLastSessionPage(){
        boolean change = false;
        if(lastSessionPage <= currentSessionPage){
            change = true;
        }
        return change;
    }

    /**
     * This function decreases the value of the current session page by 1.
     */
    public void decreaseAmountSessionPage(){
        this.currentSessionPage--;
    }

    /**
     * The function returns the name of the reader as a string.
     * 
     * @return The method is returning a String value, which is the value of the variable "nameReader".
     */
    public String getNameReader() {
        return nameReader;
    }

    /**
     * The function returns the value of the idReader variable as a string.
     * 
     * @return The method `getIdReader()` is returning a `String` value, which is the value of the
     * variable `idReader`.
     */
    public String getIdReader() {
        return idReader;
    }
    
    
    /**
     * This function returns the current session page as an integer value.
     * 
     * @return The method is returning an integer value which represents the current session page.
     */
    public int getCurrentSessionPage() {
		return currentSessionPage;
	}

    /**
     * The function checks if the user library is empty by verifying if there are no books or magazines
     * in it.
     * 
     * @return A boolean value is being returned, either true or false.
     */
    public boolean checkUserLibraryIsEmpty(){
        if(books.size() == 0 && magazines.size() == 0){
            return true;
        }else{
            return false;
        }
    }

	/**
     * This Java function sets the current session page.
     * 
     * @param currentSesionPage This is an integer variable that represents the current page number of a
     * session. The method sets the value of this variable to the value passed as a parameter.
     */
    public void setCurrentSessionPage(int currentSesionPage) {
		this.currentSessionPage = currentSesionPage;
	}

    /**
     * This function removes a bibliographic product (magazine) from a list and returns a message
     * indicating that the user has been unsubscribed from the magazine.
     * 
     * @param bibliographicProduct an object of type BibliographicProduct that represents the magazine
     * to be removed from the list of magazines.
     * @return The method is returning a String message that says "The user have been desuscribe of the
     * magazine".
     */
    @Override
    public String removeProduct(BibliographicProduct bibliographicProduct){
        String msg = "The user has been removed the product";
        if(bibliographicProduct instanceof Book){
            books.remove(bibliographicProduct);
        }else{
            magazines.remove(bibliographicProduct);
        }
        return  msg;
    }

    /**
     * The function returns an ArrayList of Book objects.
     * 
     * @return An ArrayList of Book objects is being returned.
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     * The function returns an ArrayList of Magazine objects.
     * 
     * @return An ArrayList of Magazine objects is being returned.
     */
    public ArrayList<Magazine> getMagazines() {
        return magazines;
    }

    /**
     * The function checks if a given bibliographic product is present in the list of books or
     * magazines.
     * 
     * @param product BibliographicProduct object that represents a product (book or magazine) to be
     * checked if it exists in the library's collection.
     * @return The method is returning a boolean value which indicates whether the given
     * BibliographicProduct object is present in the list of books or magazines. If the product is
     * found in either of the lists, the method returns true, otherwise it returns false.
     */
    public boolean checkUserHaveAProduct(BibliographicProduct product){
        boolean productFind = false;
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).equals(product)){
                productFind = true;
                break;
            }
        }
        for (int i = 0; i < magazines.size(); i++) {
            if(magazines.get(i).equals(product)){
                productFind = true;
                break;
            }
        }
        return productFind;
    }

	/**
     * This function returns the last session page.
     * 
     * @return The method is returning an integer value which represents the last session page.
     */
    public int getLastSessionPage() {
		return lastSessionPage;
	}

	/**
     * This is a Java function that sets the value of a variable called "lastSessionPage".
     * 
     * @param lastSesionPage The parameter `lastSesionPage` is an integer value representing the last page
     * visited by a user in a session. The method `setLastSessionPage` sets the value of the instance
     * variable `lastSessionPage` to the provided value.
     */
    public void setLastSessionPage(int lastSesionPage) {
		this.lastSessionPage = lastSesionPage;
	}

   /**
    * This function returns an ArrayList of String arrays representing the library users.
    * 
    * @return An ArrayList of two-dimensional String arrays (String[][]) named "libraryUser".
    */
    public ArrayList<String[][]> getLibraryUser() {
        return libraryUser;
    }
    

    
}
