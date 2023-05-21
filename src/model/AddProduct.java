package model;

public interface AddProduct {
    /**
     * This is an abstract method that adds a book to a collection.
     * 
     * @param book The "book" parameter is an object of the class "Book". It is being passed as an
     * argument to the method "addBook". The method is expected to use the information contained in the
     * "book" object to add a new book to a collection or database. The "Book" class likely
     * @return A String is being returned.
     */
    public String addBook(Book book);

    /**
     * This is an abstract method that adds a magazine and returns a string.
     * 
     * @param magazine The "magazine" parameter is an object of the class "Magazine". It is being
     * passed as an argument to the method "addMagazine". The method is expected to use this object to
     * add a new magazine to some kind of collection or database and return a string indicating the
     * success or failure
     * @return A String is being returned.
     */
    public String addMagazine(Magazine magazine);


    /**
     * The function removes a bibliographic product from a collection.
     * 
     * @param bibliographicProduct The parameter "bibliographicProduct" is of type
     * BibliographicProduct, which is likely a class representing a product in a bibliographic system
     * (such as a book or article). The method "removeProduct" likely takes in an instance of this
     * class and removes it from the bibliographic system. The
     * @return The method signature indicates that a String is being returned, but without the
     * implementation of the method it is not possible to determine what the String represents.
     */
    public String removeProduct(BibliographicProduct bibliographicProduct);

}
