package model;

import java.util.ArrayList;

/**
 * The Reader class contains information about a reader, including their name, ID, current and last
 * session page, and the books and magazines they have access to.
 */
public abstract class Reader {

    private String nameReader;
    private String idReader;
    private int currentSessionPage;
    private int lastSessionPage;
    protected ArrayList<Book>books;
    protected ArrayList<Magazine>magazines;

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
    public void decreaseAmountSesionPage(){
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
     * This Java function sets the current session page.
     * 
     * @param currentSesionPage This is an integer variable that represents the current page number of a
     * session. The method sets the value of this variable to the value passed as a parameter.
     */
    public void setCurrentSessionPage(int currentSesionPage) {
		this.currentSessionPage = currentSesionPage;
	}

	/**
     * This is an abstract method that adds a book to a collection.
     * 
     * @param book The "book" parameter is an object of the class "Book". It is being passed as an
     * argument to the method "addBook". The method is expected to use the information contained in the
     * "book" object to add a new book to a collection or database. The "Book" class likely
     * @return A String is being returned.
     */
    public abstract String addBook(Book book);

    /**
     * This is an abstract method that adds a magazine and returns a string.
     * 
     * @param magazine The "magazine" parameter is an object of the class "Magazine". It is being
     * passed as an argument to the method "addMagazine". The method is expected to use this object to
     * add a new magazine to some kind of collection or database and return a string indicating the
     * success or failure
     * @return A String is being returned.
     */
    public abstract String addMagazine(Magazine magazine);

    /**
     * This function removes a bibliographic product (magazine) from a list and returns a message
     * indicating that the user has been unsubscribed from the magazine.
     * 
     * @param bibliographicProduct an object of type BibliographicProduct that represents the magazine
     * to be removed from the list of magazines.
     * @return The method is returning a String message that says "The user have been desuscribe of the
     * magazine".
     */
    public String removeProduct(BibliographicProduct bibliographicProduct){
        String msg = "The user have been desuscribe of the magazine";
        magazines.remove(bibliographicProduct);
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
    
    
}
