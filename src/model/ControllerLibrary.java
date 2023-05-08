package model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ControllerLibrary{

    private ArrayList<Reader>readers;
    private ArrayList<BibliographicProduct>bibliographicProducts;

    public ControllerLibrary(){
        readers = new ArrayList<Reader>();
        bibliographicProducts = new ArrayList<BibliographicProduct>();
    }

    public String addReader(boolean premiumReader, String nameReader, String idReader){
        String msg;
        if(premiumReader){
            Reader premium = new Premium(nameReader, idReader);
            msg = "The premium reader have been created";
            readers.add(premium);
        }
        else{
            Reader regular = new Regular(nameReader, idReader);
            msg = "The regular reader have been created";
            readers.add(regular);
        }
        return msg;
    }

    public Calendar stringToCalendar(String Origindate) throws ParseException{
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        Calendar modifyDate = Calendar.getInstance();
        modifyDate.setTime(date.parse(Origindate));
        
        return modifyDate;
    }

    
    public String addBook(String nameProduct, int numberPages, Calendar publicationDate, String url, double valueProduct, String review, int gender){
        BibliographicProduct book = new Book(nameProduct, numberPages, publicationDate, url, valueProduct, review, gender);
        bibliographicProducts.add(book);
        return "The book has been created";
    }

    public String addMagazine(String nameProduct, int numberPages,Calendar publicationDate ,String url, double valueProduct, String periodicity, int category){
        BibliographicProduct magazine = new Magazine(nameProduct, numberPages, publicationDate,url, valueProduct, periodicity, category);
        bibliographicProducts.add(magazine);
        return "The magazine has been created";
    }

    public int searchBibliograpicProduct(String id){
        int position = -1;
        for (int i = 0; i < bibliographicProducts.size(); i++) {
            BibliographicProduct product = bibliographicProducts.get(i);
            if(product.getIdProduct().equals(id)){
                position = i;
                break;
            }
        }
        return position;
    }

    public String editBook(String id, int option, String change) throws ParseException{
        BibliographicProduct product = bibliographicProducts.get(searchBibliograpicProduct(id));
        int auxInt = Integer.parseInt(change);
        Calendar auxCalendar = stringToCalendar(change);
        GenderType auxGender;
        switch(option){
            case 1: 
            product.setNameProduct(change);
            break;
            case 2:
            product.setNumberPages(auxInt);
            break;
            case 3: 
            product.setPublicationDate(auxCalendar);
            break;
            case 4:
            product.setUrl(change);
            break;
            case 5: 
            product.setValueProduct(auxInt);
            break;
            case 6:
            ((Book)product).setReview(change);
            break;
            case 7:
            if(auxInt == 1){
                auxGender = GenderType.SCIENCIE_FICTION;
            }else if(auxInt == 2){
                auxGender = GenderType.FANTASY;
            }else{
                auxGender = GenderType.HISTORICAL_NOVEL;
            }
            ((Book)product).setGender(auxGender);
            break;
        }
        return "The book has been edited";
    }

    public ArrayList<BibliographicProduct> getBibliographicProducts() {
        return bibliographicProducts;
    }

    
}