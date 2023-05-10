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
        return "The book has been created with the code:" + book.getIdProduct();
    }

    public String addMagazine(String nameProduct, int numberPages,Calendar publicationDate ,String url, double valueProduct, String periodicity, int category){
        BibliographicProduct magazine = new Magazine(nameProduct, numberPages, publicationDate,url, valueProduct, periodicity, category);
        bibliographicProducts.add(magazine);
        return "The magazine has been created with the code: " + magazine.getIdProduct();
    }

    public int searchNumberBibliograpicProduct(String id){
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

    public int searchNumberReader(String id){
        int position = -1;
        for (int i = 0; i < readers.size(); i++) {
            Reader reader = readers.get(i);
            if(reader.getIdReader().equals(id)){
                position = i;
                break;
            }
        }
        return position;
    }

    public String editBook(String id, int option, String change) throws ParseException{
        BibliographicProduct product = bibliographicProducts.get(searchNumberBibliograpicProduct(id));
        
        switch(option){
            case 1: 
            product.setNameProduct(change);
            break;
            case 2:
            int auxInt2 = Integer.parseInt(change);
            product.setNumberPages(auxInt2);
            break;
            case 3: 
            Calendar auxCalendar = stringToCalendar(change);
            product.setPublicationDate(auxCalendar);
            break;
            case 4:
            product.setUrl(change);
            break;
            case 5: 
            int auxInt5 = Integer.parseInt(change);
            product.setValueProduct(auxInt5);
            break;
            case 6:
            ((Book)product).setReview(change);
            break;
            case 7:
            GenderType auxGender;
            int auxInt7 = Integer.parseInt(change);
            if(auxInt7 == 1){
                auxGender = GenderType.SCIENCIE_FICTION;
            }else if(auxInt7 == 2){
                auxGender = GenderType.FANTASY;
            }else{
                auxGender = GenderType.HISTORICAL_NOVEL;
            }
            ((Book)product).setGender(auxGender);
            break;
        }
        return "The book has been edited";
    }

    public String editMagazine(String id, int option, String change) throws ParseException{
        BibliographicProduct product = bibliographicProducts.get(searchNumberBibliograpicProduct(id));
        
        switch(option){
            case 1: 
            product.setNameProduct(change);
            break;
            case 2:
            int auxInt2 = Integer.parseInt(change);
            product.setNumberPages(auxInt2);
            break;
            case 3: 
            Calendar auxCalendar = stringToCalendar(change);
            product.setPublicationDate(auxCalendar);
            break;
            case 4:
            product.setUrl(change);
            break;
            case 5: 
            int auxInt5 = Integer.parseInt(change);
            product.setValueProduct(auxInt5);
            break;
            case 6:
            ((Magazine)product).setPeriodicity(change);
            break;
            case 7:
            CategotyType auxCategory;
            int auxInt7 = Integer.parseInt(change);
            if(auxInt7 == 1){
                auxCategory = CategotyType.VARIETY;
            }else if(auxInt7 == 2){
                auxCategory = CategotyType.DESIGN;
            }else{
                auxCategory = CategotyType.SCIENTIST;
            }
            ((Magazine)product).setCategory(auxCategory);
            break;
        }
        return "The book has been edited";
    }

    public String removeProducts(String id){
        int product = searchNumberBibliograpicProduct(id);
        bibliographicProducts.remove(product);
        return "The bibliographic product have been removed";
    }

    public String initBasicObjects(){
        ArrayList<Reader>readers = new ArrayList<>();
        ArrayList<BibliographicProduct> bibliographicProducts = new ArrayList<>();
        Reader auxReader;
        BibliographicProduct auxbBibliographicProduct;
        for (int i = 0; i < 3; i++) {
            auxReader = new Regular("user"+i, "i"+i);
            readers.add(auxReader);
            auxReader = new Premium("user"+i, "i"+i+100);
            readers.add(auxReader);
            auxbBibliographicProduct = new Book("book"+i, i+1000, null, "url data", i, "review data", i);
            bibliographicProducts.add(auxbBibliographicProduct);
            auxbBibliographicProduct = new Magazine("Magazine"+i, i+10000, null, "url data", i, "review data", i);
            bibliographicProducts.add(auxbBibliographicProduct);
        }
        return "3 premium readers, 3 regular readers, 3 books, 3 magazine has been created";
    }

    public boolean checkTypeBibliographicProduct(String id){
        boolean isBook = false; 
        int product = searchNumberBibliograpicProduct(id);
        if(bibliographicProducts.get(product) instanceof Book){
            isBook = true;
        }
        return isBook;
    }

    public String consultCodeBibliographicProducts(String searchName){
        String msg = "";
        boolean find = false;
        for (int i = 0; i < bibliographicProducts.size(); i++) {
            if(bibliographicProducts.get(i).getNameProduct().contains(searchName)){
                find = true;
                msg += "Match " +i +":"+bibliographicProducts.get(i).getNameProduct();
                msg += "\nCode match" + i + ":"+bibliographicProducts.get(i).getIdProduct();
            }
        }
        if(!find){
            msg = "There is not a match with the product names";
        }
        return msg;
    }

    public Reader consultObjectReader(String idReader){
        Reader reader = readers.get(searchNumberReader(idReader));
        return reader;
    }

    public BibliographicProduct consultObjectProduct(String idProduct){
        BibliographicProduct product = bibliographicProducts.get(searchNumberBibliograpicProduct(idProduct));
        return product;
    }

    public String aggregateBookToReader(String idReader, String idBook){
        Reader reader = consultObjectReader(idReader);
        BibliographicProduct book = consultObjectProduct(idBook); 
        String confirmation = reader.addBook((Book)book);
        book.addAmountSales();
        return confirmation;
    }

    public String aggregateMagazineToReader(String idReader, String idMagazine){
        Reader reader = consultObjectReader(idReader);
        BibliographicProduct magazine = consultObjectProduct(idMagazine);
        String confirmation = reader.addMagazine((Magazine)magazine);
        magazine.addAmountSales();
        return confirmation;
    }

    public String cancelMagazineOfReader(String idReader, String idMagazine){
        Reader reader = consultObjectReader(idReader);
        BibliographicProduct magazine = consultObjectProduct(idMagazine);
        magazine.decreaseAmountSales();
        String confirmation = reader.removeMagazine((Magazine)magazine);
        
        return confirmation;
    }

    public boolean checkUserHaveAProduct(String idReader, String idProduct){
        boolean haveProduct = false;
        Reader reader = consultObjectReader(idReader);
        BibliographicProduct product = consultObjectProduct(idProduct);
        if(reader.checkUserHaveAProduct(product)){
           haveProduct = true; 
        }
        return haveProduct;
    }

    public void addNumberPagesRead(int newPages, BibliographicProduct product){
        product.addNumberPagesRead(newPages);
    }

    public ArrayList<BibliographicProduct> getBibliographicProducts() {
        return bibliographicProducts;
    }

    
}