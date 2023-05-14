package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * The "Premium" class extends the "Reader" class and adds functionality to add books and magazines to
 * a list and return a confirmation message with the date and value of the added product.
 */
public class Premium extends Reader{

    /**
    A Premium Reader class that extends the Reader class.
    @param nameReader The name of the reader.
    @param idReadder The ID of the reader.
    This constructor initializes a new Premium Reader object with the given name and ID,
    and creates new ArrayLists for books and magazines.
    */
    public Premium(String nameReader, String idReadder){
        super(nameReader, idReadder);
        books = new ArrayList<>();
        magazines = new ArrayList<>();
    }

    /**
     * The function adds a book to a list and returns a confirmation message with the date and value of
     * the book.
     * 
     * @param book The parameter "book" is an object of the class "Book" which contains information
     * about a book such as its title, author, ISBN, and value. The method "addBook" adds this book
     * object to a list of books and returns a confirmation message with the date and value of the
     * added
     * @return The method is returning a confirmation message that includes the date the book was added
     * and the value of the book.
     */
    @Override
    public String addBook(Book book){

        books.add(book);
        Calendar calendarTime = Calendar.getInstance();
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(calendarTime.getTime());
        String msg = "Confirmation ticket: \n The Book has been added in the Date: "+ timeStamp + " \n The product value is $" + book.getValueProduct() ;
        return msg;
    }

    /**
     * The function adds a magazine to a list and returns a confirmation message with the date and
     * value of the added magazine.
     * 
     * @param magazine The parameter "magazine" is an object of the class "Magazine" that contains
     * information about a magazine such as its title, publisher, publication date, and value. The
     * method "addMagazine" adds this magazine object to a list of magazines and returns a confirmation
     * message with the date and
     * @return A confirmation message that the magazine has been added, including the date and value of
     * the product.
     */
    @Override
    public String addMagazine(Magazine magazine){

        magazines.add(magazine);
        Calendar calendarTime = Calendar.getInstance();
        String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(calendarTime.getTime());

        String msg = "Confirmation ticket: \n The magazine has been added in the Date: "+ timeStamp + "\n  The product value is $" + magazine.getValueProduct() ;
        return msg;

    }
}
