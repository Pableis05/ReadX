package model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

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
        BibliographicProduct product = consultObjectProduct(id);
        bibliographicProducts.remove(product);
        for (int i = 0; i < readers.size(); i++) {
            if(readers.get(i).checkUserHaveAProduct(product)){
                readers.get(i).removeProduct(product);
            }
        }
        return "The bibliographic product have been removed";
    }

    public String initBasicObjects(){

        Reader auxReader;
        BibliographicProduct auxbBibliographicProduct;
        Calendar calendarTime = Calendar.getInstance();

        for (int i = 0; i < 3; i++) {
            auxReader = new Regular("user"+i, "00"+i);
            readers.add(auxReader);
            auxReader = new Premium("user"+i, "99"+i);
            readers.add(auxReader);
            auxbBibliographicProduct = new Book("Book"+i, 10, calendarTime, "url data", 10, "review data", 1);
            auxbBibliographicProduct.setIdProduct("aa"+i);
            bibliographicProducts.add(auxbBibliographicProduct);
            auxbBibliographicProduct = new Magazine("Magazine"+i, 10, calendarTime, "url data", 10, "review data", 1);
            auxbBibliographicProduct.setIdProduct("bb"+i);
            bibliographicProducts.add(auxbBibliographicProduct);
        }
        return "3 premium readers (id: 00 + iteration), 3 regular readers (id: 99 + iteration), 3 books (id: aa + iteration[0-2]), 3 magazine has been created (id: bb + iteration[0-2])";

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
        String confirmation = reader.removeProduct(magazine);
        
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

    public String sesionLecture(String idProduct, String idReader, String simulationOption){
        String msg = "";
        AddType add;
        Reader reader = consultObjectReader(idReader);
        BibliographicProduct product = consultObjectProduct(idProduct);

        if(simulationOption.equals("S")){
            if(reader.getCurrentSesionPage() == product.getNumberPages()){
                msg += ("The book is on the last page");
            }
            else{
                reader.addAmountSesionPage();
            }
        }
        
        else if(simulationOption.equals("A")){
            if(reader.getCurrentSesionPage() == 0){
                msg += ("The book is on the page 0");
            }
            else{
                reader.decreaseAmountSesionPage(); 
            }
        }

        if(reader instanceof Regular && ((reader.getCurrentSesionPage() % 20 == 0) || reader.getCurrentSesionPage() == 1)){
            Random random = new Random();
            int auxAdd = random.nextInt(3)+1;
            if(auxAdd == 1){
                add = AddType.COMBO_PLUS;
                msg += "Subscribe to Combo Plus and get Disney+ and Star+ at an incredible price!";
            }else if(auxAdd == 2){
                add = AddType.LAIKA;
                msg += "Now your pets have a favorite app: Laika. The best products for your furry.";
            }else{
                add = AddType.EXITO;
                msg += "We are celebrating our anniversary! Visit your nearest Éxito and be surprised with the best offers.";
            }
        }

        msg += ("\nReader sesion in progress \n Reading: " + product.getNameProduct() + "\n Reading page: " + reader.getCurrentSesionPage() + " of "+ product.getNumberPages()
                +"\n Type A for the previous page \n Type S for the next page\n Type B to back to the library");

        return msg;

    }

    public void addNumberPagesRead(int newPages, BibliographicProduct product){
        product.addNumberPagesRead(newPages);
    }

    public ArrayList<BibliographicProduct> getBibliographicProducts() {
        return bibliographicProducts;
    }

    
}