package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Regular extends Reader{

    public Regular(String nameReader, String idReadder){
        super(nameReader, idReadder);
        books = new ArrayList<>(5);
        magazines = new ArrayList<>(2);
    }
    @Override
    public String addBook(Book book){
        String msg = "The book size is full";
        if(books.size() < 6){
            books.add(book);
            Calendar calendarTime = Calendar.getInstance();
            String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(calendarTime.getTime());

            msg = "Confirmation ticket: \n The Book has been added in the Date: "+ timeStamp + " \nThe product value is $" + book.getValueProduct() ;
            
        }
        return msg;
    }
    @Override
    public String addMagazine(Magazine magazine){
        String msg = "The magazine size is full";
        if(magazines.size() < 3){
            magazines.add(magazine);
            Calendar calendarTime = Calendar.getInstance();
            String timeStamp = new SimpleDateFormat("dd-MM-yyyy").format(calendarTime.getTime());

            msg = "Confirmation ticket: \n The magazine has been added in the Date: "+ timeStamp + " \nThe product value is $" + magazine.getValueProduct() ;
        }
        return msg;
        
    }


    
}
