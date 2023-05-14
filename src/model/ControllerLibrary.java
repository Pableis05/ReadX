package model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

/**
The ControllerLibrary class represents the main controller for a library system. It contains methods
for adding readers and bibliographic products to their respective ArrayLists, as well as a method for
checking whether a given reader ID is already in use. The class also contains methods for converting a
date string to a Calendar object, reading simulation sessions, and to many other methods than able all 
the program requriments that ReadX needs in their library.
*/
public class ControllerLibrary{

    private ArrayList<Reader>readers;
    private ArrayList<BibliographicProduct>bibliographicProducts;
    
    /**
    Constructor for the ControllerLibrary class.
    Initializes the readers and bibliographicProducts ArrayLists.
    */
    public ControllerLibrary(){
        readers = new ArrayList<Reader>();
        bibliographicProducts = new ArrayList<BibliographicProduct>();
        
    }

    
    /**
     * This function adds a new reader to a list of readers, either as a premium or regular reader, and
     * returns a message indicating the success or failure of the operation.
     * 
     * @param premiumReader a boolean value indicating whether the reader being added is a premium
     * reader or not
     * @param nameReader A String representing the name of the reader being added.
     * @param idReader A unique identifier for the reader being added.
     * @return A message indicating whether a premium or regular reader has been created and added to a
     * list of readers, or an error message if the ID provided is already in use.
     */
    public String addReader(boolean premiumReader, String nameReader, String idReader){
        String msg;
        if(!checkIdReader(idReader)){
            msg = "That ID is not valid, because someone has it";
        }
        else if(premiumReader){
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

    /**
     * The function checks if a given ID is already in use by a reader in a list of readers.
     * 
     * @param id The parameter "id" is a String representing the ID of a reader that needs to be
     * checked for availability. The method "checkIdReader" checks if the ID is already present in the
     * "readers" list and returns a boolean value indicating whether the ID is free or not.
     * @return A boolean value indicating whether the given ID is already associated with a reader in
     * the list of readers or not. If the ID is already associated with a reader, the method returns
     * false, otherwise it returns true.
     */
    public boolean checkIdReader(String id){
        boolean free = true;
        for (int i = 0; i < readers.size(); i++) {
            if(readers.get(i).getIdReader().equals(id)){
                free = false;
                break;
            }
        }
        return free;
    }

    /**
     * This Java function converts a string representing a date in the format "dd-MM-yyyy" to a
     * Calendar object.
     * 
     * @param origindate origindate is a String variable that represents a date in the format
     * "dd-MM-yyyy".
     * @return A Calendar object is being returned.
     */
    public Calendar stringToCalendar(String origindate) throws ParseException{
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        Calendar modifyDate = Calendar.getInstance();
        modifyDate.setTime(date.parse(origindate));
        
        return modifyDate;
    }

    
    /**
     * This function adds a new book to a list of bibliographic products and returns its unique
     * identifier.
     * 
     * @param nameProduct The name of the book being added.
     * @param numberPages The number of pages in the book.
     * @param publicationDate The publication date of the book, represented as a Calendar object.
     * @param url The URL parameter is a string that represents the web address or location where the
     * book can be found or purchased online. It could be a link to an online bookstore, a publisher's
     * website, or any other website that provides information about the book.
     * @param valueProduct The value or price of the book.
     * @param review The parameter "review" is a String that represents the review or description of
     * the book. It could include information about the plot, characters, writing style, or any other
     * relevant details about the book.
     * @param gender The "gender" parameter in this method is likely referring to the target audience
     * or intended readership of the book. It could be an integer value representing a specific
     * demographic or genre, such as 1 for "children's books" or 2 for "romance novels". However,
     * without more context
     * @return The method is returning a String message that confirms the creation of a new book with
     * its corresponding ID code.
     */
    public String addBook(String nameProduct, int numberPages, Calendar publicationDate, String url, double valueProduct, String review, int gender){
        BibliographicProduct book = new Book(nameProduct, numberPages, publicationDate, url, valueProduct, review, gender);
        bibliographicProducts.add(book);
        return "The book has been created with the code:" + book.getIdProduct();
    }

    /**
     * This Java function adds a new magazine to a list of bibliographic products and returns its
     * unique identifier.
     * 
     * @param nameProduct The name of the magazine being added.
     * @param numberPages The number of pages in the magazine.
     * @param publicationDate It is a Calendar object that represents the date of publication of the
     * magazine.
     * @param url The "url" parameter is a String that represents the URL (Uniform Resource Locator) of
     * the magazine, which is the web address where the magazine can be accessed online.
     * @param valueProduct The value or price of the magazine.
     * @param periodicity Periodicity refers to the frequency at which the magazine is published, such
     * as weekly, monthly, quarterly, etc.
     * @param category The "category" parameter in the "addMagazine" method is an integer value that
     * represents the category of the magazine. The specific categories and their corresponding integer
     * values may be defined by the system or application using this method.
     * @return The method is returning a String message that confirms the creation of a new magazine
     * with its corresponding product code.
     */
    public String addMagazine(String nameProduct, int numberPages,Calendar publicationDate ,String url, double valueProduct, String periodicity, int category){
        BibliographicProduct magazine = new Magazine(nameProduct, numberPages, publicationDate,url, valueProduct, periodicity, category);
        bibliographicProducts.add(magazine);
        return "The magazine has been created with the code: " + magazine.getIdProduct();
    }

    /**
     * This Java function searches for a bibliographic product in a list by its ID and returns its
     * position.
     * 
     * @param id The parameter "id" is a String variable that represents the unique identifier of a
     * bibliographic product. The method "searchNumberBibliograpicProduct" searches for the position of
     * the bibliographic product with the given id in the "bibliographicProducts" list. If the product
     * is found
     * @return The method is returning an integer value which represents the position of the
     * bibliographic product in the list of bibliographic products. If the product with the given ID is
     * not found in the list, the method returns -1.
     */
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

    /**
     * The function searches for a reader's ID in a list of readers and returns its position.
     * 
     * @param id The parameter "id" is a String variable that represents the unique identifier of a
     * reader. The method "searchNumberReader" searches for the position of the reader with the given
     * id in the "readers" ArrayList. If the reader is found, the method returns its position in the
     * ArrayList, otherwise
     * @return The method is returning an integer value which represents the position of the reader
     * with the given ID in the list of readers. If the reader is not found, the method returns -1.
     */
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

    /**
     * This Java function edits a book's information based on the given option and change.
     * 
     * @param id The ID of the book to be edited.
     * @param option The option parameter is an integer that represents the field of the book that will
     * be edited. Each option corresponds to a specific field, as follows:
     * @param change The new value that will replace the old value of the selected option in the
     * editBook method.
     * @return The method is returning a String message "The book has been edited".
     */
    public String editBook(String id, int option, String change) throws ParseException{
        if (searchNumberBibliograpicProduct(id) == -1) {
            return "That id doesn't match with a product";
        } else {
            BibliographicProduct product = bibliographicProducts.get(searchNumberBibliograpicProduct(id));
            String msg="The book has been edited";
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
                default: msg ="The option is not valid";
            }
            return msg;    
        }
        
    }

    /**
     * This Java function edits a magazine object's properties based on the given option and change
     * values.
     * 
     * @param id A String representing the ID of the magazine to be edited.
     * @param option The option parameter is an integer that represents the type of information to be
     * edited in a magazine. The possible values are:
     * @param change The new value that will replace the old value of the selected option in the
     * magazine object.
     * @return The method is returning a String message "The book has been edited".
     */
    public String editMagazine(String id, int option, String change) throws ParseException{
        if (searchNumberBibliograpicProduct(id) == -1) {
            return "That id doesn't match with a product";
        } else {
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
        
    }

    /**
     * This Java function removes a bibliographic product from a list and removes it from any readers
     * who have borrowed it.
     * 
     * @param id The parameter "id" is a String that represents the unique identifier of a
     * bibliographic product that needs to be removed from the system.
     * @return The method is returning a String message "The bibliographic product have been removed".
     */
    public String removeProducts(String id){
        if (searchNumberBibliograpicProduct(id) == -1) {
            return "That id doesn't match with a product";
        } else {
            BibliographicProduct product = consultObjectProduct(id);
            bibliographicProducts.remove(product);
            for (int i = 0; i < readers.size(); i++) {
                if(readers.get(i).checkUserHaveAProduct(product)){
                    readers.get(i).removeProduct(product);
                }
            }
            return "The bibliographic product have been removed";
        }
        
    }

    /**
     * The function creates a set of readers and bibliographic products and returns a string confirming
     * their creation.
     * 
     * @return The method is returning a string that indicates that 1 premium reader, 1 regular
     * reader, 1 book, and 1 magazine have been created with specific IDs.
     */
    public String initBasicObjects(){

        Reader auxReader;
        BibliographicProduct auxbBibliographicProduct;
        Calendar calendarTime = Calendar.getInstance();

        auxReader = new Regular("user1", "001");
        readers.add(auxReader);
        auxReader = new Premium("user2", "999");
        readers.add(auxReader);
        auxbBibliographicProduct = new Book("Book", 10, calendarTime, "url data", 10, "review data", 1);
        auxbBibliographicProduct.setIdProduct("aa1");
        bibliographicProducts.add(auxbBibliographicProduct);
        auxbBibliographicProduct = new Magazine("Magazine", 10, calendarTime, "url data", 10, "review data", 1);
        auxbBibliographicProduct.setIdProduct("bb1");
        bibliographicProducts.add(auxbBibliographicProduct);
        
        return "1 regular reader (id: 001), 1 premium reader (id: 999), 1 book (id: aa1), 1 magazine has been created (id: bb1)";

    }

    /**
     * The function checks if a bibliographic product with a given ID is a book or not.
     * 
     * @param id The parameter "id" is a String representing the identification number of a
     * bibliographic product.
     * @return A boolean value indicating whether the bibliographic product with the given ID is a book
     * or not.
     */
    public boolean checkTypeBibliographicProduct(String id){
        boolean isBook = false; 
        int product = searchNumberBibliograpicProduct(id);
        if(bibliographicProducts.get(product) instanceof Book){
            isBook = true;
        }
        return isBook;
    } 

    /**
     * This function searches for a product name in a list of bibliographic products and returns the
     * corresponding product code if found.
     * 
     * @param searchName a String variable that represents the name of the product being searched for
     * in the bibliographicProducts list.
     * @return The method `consultCodeBibliographicProducts` returns a `String` message that either
     * contains the matching product names and their corresponding codes or a message indicating that
     * there is no match with the given search name.
     */
    public String consultCodeBibliographicProducts(String searchName){
        String msg = "";
        boolean find = false;
        int followUp = 0;
        for (int i = 0; i < bibliographicProducts.size(); i++) {
            if(bibliographicProducts.get(i).getNameProduct().contains(searchName)){
                find = true;
                msg += "Match " +followUp +":"+bibliographicProducts.get(i).getNameProduct();
                msg += "\nCode match" + followUp + ":"+bibliographicProducts.get(i).getIdProduct()+"\n";
                followUp++;
            }
        }
        if(!find){
            msg = "There is not a match with the product names";
        }
        return msg;
    }

    /**
     * This Java function returns a Reader object based on a given ID.
     * 
     * @param idReader The parameter "idReader" is a String variable that represents the identification
     * number of a reader.
     * @return The method `consultObjectReader` is returning a `Reader` object.
     */
    public Reader consultObjectReader(String idReader){
        Reader reader = readers.get(searchNumberReader(idReader));
        return reader;
    }

    /**
     * This Java function returns a BibliographicProduct object based on a given product ID.
     * 
     * @param idProduct The parameter "idProduct" is a String variable that represents the unique
     * identifier of a bibliographic product. This method "consultObjectProduct" takes this identifier
     * as input and returns the corresponding BibliographicProduct object from the
     * "bibliographicProducts" collection.
     * @return The method `consultObjectProduct` is returning a `BibliographicProduct` object.
     */
    public BibliographicProduct consultObjectProduct(String idProduct){
    
        BibliographicProduct product = bibliographicProducts.get(searchNumberBibliograpicProduct(idProduct));
        return product;
    }

    /**
     * This function adds a book to a reader's list of books and increases the book's sales count.
     * 
     * @param idReader A string representing the unique identifier of the reader who is borrowing the
     * book.
     * @param idBook The parameter idBook is a String that represents the unique identifier of a
     * bibliographic product (book) that is being aggregated to a reader's collection.
     * @return The method is returning a String variable named "confirmation".
     */
    public String aggregateBookToReader(String idReader, String idBook){
        if (searchNumberReader(idReader) == -1) {
            return "That id doesn't match with a reader";
        } else if(searchNumberBibliograpicProduct(idBook) == -1){
            return "That id doesn't match with a product";
        }else{
            Reader reader = consultObjectReader(idReader);
            BibliographicProduct book = consultObjectProduct(idBook);
            String confirmation = reader.addBook((Book)book);
            book.addAmountSales();
            return confirmation;
        }
        
    }

    /**
     * This function adds a magazine to a reader's collection and increases the sales count of the
     * magazine.
     * 
     * @param idReader A string representing the ID of the reader who wants to aggregate a magazine to
     * their collection.
     * @param idMagazine The ID of the magazine that is being added to the reader's collection.
     * @return The method is returning a String variable named "confirmation".
     */
    public String aggregateMagazineToReader(String idReader, String idMagazine){
        if (searchNumberReader(idReader) == -1) {
            return "That id doesn't match with a reader";
        } else if(searchNumberBibliograpicProduct(idMagazine) == -1){
            return "That id doesn't match with a product";
        }else{
            Reader reader = consultObjectReader(idReader);
            BibliographicProduct magazine = consultObjectProduct(idMagazine);
            String confirmation = reader.addMagazine((Magazine)magazine);
            magazine.addAmountSales();
            return confirmation;
        }
    }

    /**
     * This function cancels a magazine subscription for a reader and updates the magazine's sales
     * amount.
     * 
     * @param idReader A String representing the ID of the reader who wants to cancel a magazine
     * subscription.
     * @param idMagazine The ID of the magazine that needs to be cancelled for the reader.
     * @return The method is returning a String variable named "confirmation".
     */
    public String cancelMagazineOfReader(String idReader, String idMagazine){
        if (searchNumberReader(idReader) == -1) {
            return "That id doesn't match with a reader";
        } else if(searchNumberBibliograpicProduct(idMagazine) == -1){
            return "That id doesn't match with a product";
        }else{
            String confirmation = "The reader doesn't has the subscription on the product" ;
            if(checkUserHaveAProduct(idReader, idMagazine)){
                Reader reader = consultObjectReader(idReader);
                BibliographicProduct magazine = consultObjectProduct(idMagazine);
                magazine.decreaseAmountSales();
                confirmation = reader.removeProduct(magazine);
            }
            return confirmation;
        }
    }

    /**
     * This function checks if a user has a specific product by consulting the reader and product
     * objects.
     * 
     * @param idReader This parameter is a String representing the ID of a reader/user.
     * @param idProduct The id of the product that we want to check if the user has.
     * @return A boolean value indicating whether the user with the given ID has the product with the
     * given ID or not.
     */
    public boolean checkUserHaveAProduct(String idReader, String idProduct){
        boolean haveProduct = false;
        Reader reader = consultObjectReader(idReader);
        BibliographicProduct product = consultObjectProduct(idProduct);
        if(reader.checkUserHaveAProduct(product)){
           haveProduct = true; 
        }
        return haveProduct;
    }

    /**
     * The function simulates a reading session for a reader with options to move forward or backward
     * in the book and displays ads for certain readers.
     * 
     * @param idProduct The ID of the bibliographic product being read.
     * @param idReader A string representing the ID of the reader who is currently reading the book.
     * @param simulationOption A string that determines whether the user wants to simulate turning to
     * the next page ("S"), simulate turning to the previous page ("A"), or exit the reading session
     * and go back to the library ("B").
     * @return A String message containing information about the reading session, such as the current
     * page being read, the name of the product being read, and options for the reader to navigate
     * through the pages. It may also include advertisements for certain products or services.
     */
    public String readingSession(String idProduct, String idReader, String simulationOption){
        String msg = "";
        AdType ad;
        Reader reader = consultObjectReader(idReader);
        BibliographicProduct product = consultObjectProduct(idProduct);

        if(simulationOption.equals("S")){
            if(reader.getCurrentSessionPage() == product.getNumberPages()){
                msg += ("The book is on the last page");
            }
            else{
                reader.addAmountSessionPage();
            }
        }
        
        else if(simulationOption.equals("A")){
            if(reader.getCurrentSessionPage() == 0){
                msg += ("The book is on the page 0");
            }
            else{
                reader.decreaseAmountSesionPage(); 
            }
        }

        if(reader instanceof Regular && ((reader.getLastSessionPage() % 20 == 0) || reader.getCurrentSessionPage() == 1)){
            Random random = new Random();
            int auxAdd = random.nextInt(3)+1;
            if(auxAdd == 1){
                ad = AdType.COMBO_PLUS;
                msg += ad + ": Subscribe to Combo Plus and get Disney+ and Star+ at an incredible price!";
            }else if(auxAdd == 2){
                ad = AdType.LAIKA;
                msg += ad +": Now your pets have a favorite app: Laika. The best products for your furry.";
            }else{
                ad = AdType.EXITO;
                msg += ad + ": We are celebrating our anniversary! Visit your nearest Éxito and be surprised with the best offers.";
            }
        }

        msg += ("\nReader sesion in progress \n Reading: " + product.getNameProduct() + "\n Reading page: " + reader.getCurrentSessionPage() + " of "+ product.getNumberPages()
                +"\n Type A for the previous page \n Type S for the next page\n Type B to back to the library");

        return msg;

    }

    /**
     * This function adds the number of pages read to a bibliographic product.
     * 
     * @param newPages an integer representing the number of pages that the user has read for a
     * particular bibliographic product.
     * @param product The parameter "product" is an object of the class "BibliographicProduct". It is
     * being passed as an argument to the method "addNumberPagesRead".
     */
    public void addNumberPagesRead(int newPages, BibliographicProduct product){
        product.addNumberPagesRead(newPages);
    }
    
}