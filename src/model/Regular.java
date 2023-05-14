package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * The "Regular" class extends the "Reader" class and contains methods to add books and magazines to
 * their respective lists, with a limit on the number of items that can be added.
 */
public class Regular extends Reader{

    /**
    Constructs a Regular Reader with the given name and ID.
    @param nameReader the name of the Regular Reader
    @param idReader the ID of the Regular Reader
    */
    public Regular(String nameReader, String idReadder){
        super(nameReader, idReadder);
        books = new ArrayList<>(5);
        magazines = new ArrayList<>(2);
    }

    /**
     * This Java function adds a book to a list and returns a confirmation message with the date and
     * value of the book, or a message indicating that the list is full.
     * 
     * @param book The parameter "book" is an object of the class "Book" which contains information
     * about a book such as its title, author, ISBN, and value. This parameter is used in the method to
     * add a new book to a list of books.
     * @return The method `addBook` returns a message indicating whether the book was successfully
     * added to the list of books or not. If the list is full, the message will be "The book size is
     * full". If the book was added successfully, the message will contain a confirmation ticket with
     * the date the book was added and its value.
     */
    @Override
    public String addBook(Book book){
        String msg = "The book size is full";
        if(books.size() < 5){
            books.add(book);
            Calendar calendarTime = Calendar.getInstance();
            String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(calendarTime.getTime());

            msg = "Confirmation ticket: \n The Book has been added in the Date: "+ timeStamp + " \n The product value is $" + book.getValueProduct() ;
            
        }
        return msg;
    }
    /**
     * The function adds a magazine to a list and returns a confirmation message if the list is not
     * full.
     * 
     * @param magazine The parameter "magazine" is an object of the class "Magazine" that contains
     * information about a magazine, such as its title, publisher, publication date, and value. This
     * object is being passed as an argument to the method "addMagazine" which adds the magazine to a
     * list of
     * @return The method is returning a message indicating whether the magazine was successfully added
     * or not. If the magazine size is full, the message "The magazine size is full" is returned. If
     * the magazine was added successfully, a confirmation ticket message is returned with the date and
     * value of the product.
     */
    @Override
    public String addMagazine(Magazine magazine){
        String msg = "The magazine size is full";
        if(magazines.size() < 2){
            magazines.add(magazine);
            Calendar calendarTime = Calendar.getInstance();
            String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(calendarTime.getTime());

            msg = "Confirmation ticket: \n The magazine has been added in the Date: "+ timeStamp + " \n The product value is $" + magazine.getValueProduct() ;
        }
        return msg;
        
    }


    
}
