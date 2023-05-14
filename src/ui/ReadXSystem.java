package ui;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Scanner;

import model.ControllerLibrary;

/**
 * The ReadXSystem class is a Java program that implements a library management system with various
 * functions such as registering readers, managing bibliographic products, and simulating reading
 * sessions.
 */

public class ReadXSystem {

    private Scanner input;
    private ControllerLibrary controller;
    /**
    Constructs a ReadXSystem object which initializes the input Scanner and
    the controller for the library system.
    */
    ReadXSystem(){
        input = new Scanner(System.in);
        controller = new ControllerLibrary();
    }

    /**
     * The main function initializes an instance of the ReadXSystem class and calls its menu method to
     * display a library menu.
     */
    public static void main(String[] args) throws Exception {

        ReadXSystem readX = new ReadXSystem();
        System.out.println("!!!!!!!!!!!WELCOME TO THE NEW LIBRARY READX!!!!!!!!!!!!");
        readX.menu();

    }

    /**
     * This function displays a menu of options for a library management system and executes the
     * selected option.
     */
    public void menu() throws ParseException{
        int option = -1;
        do{ 
            System.out.println("-------------------------------------------MENU------------------------------------\n");
            System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n", "Type the option that you are going to do", "1. Register a reader", "2. Manage a bibliographic product", "3. Generate basic objects","4. Consult bibliographics products", "5. Buy a book by a reader", "6. Subscribe to a magazine by a reader", "7. Cancel a subscription for a reader", "8. Present library reader", "0. Exit");
            while (!integerInput(input)){
               input.nextLine();
               System.out.println("Enter again"); 
            }
            option = input.nextInt();

            switch(option){

                case 1: registerReader();
                break;
                case 2: manageBibliographicProducts();
                break;
                case 3: generateAutomaticObjects();
                break;
                case 4: consultBibliographicProducts();
                break;
                case 5: readerBuyBook();
                break;
                case 6: readerSubscribeMagazine();
                break;
                case 7: cancelSubscriptionMagazineOfReader();
                break;
                case 8: presentLibraryReader();
                break;
                case 0: System.out.println("Thank you!!!!!!!!!!!");
                break;
                default: System.out.println("Enter again, whit a valid number");
            }
            System.out.println("-----------------------------------------------------------------------------------\n");
        }while(option != 0);
    }


    /**
     * This function registers a reader by taking input for their type, name, and ID, and then adds
     * them to the system using a controller.
     */
    public void registerReader(){
        String typeReader;
        boolean premiumReader = false;
        String nameReader;
        String idReader;
        String confirmationRegister;
        System.out.println("Enter the type reader: \n1. Premium Reader \n2. Regular Reader");
        typeReader = input.next();
        if(typeReader.equals("1")){
            premiumReader = true;
            System.out.println("Type the reader name");
            nameReader = input.next();
            System.out.println("Enter the reader id");
            idReader = input.next();
            confirmationRegister = controller.addReader(premiumReader, nameReader, idReader);
            System.out.println(confirmationRegister);
        }
        else if(typeReader.equals("2")){
            premiumReader = false;
            System.out.println("Type the reader name");
            nameReader = input.next();
            System.out.println("Enter the reader id");
            idReader = input.next();
            confirmationRegister = controller.addReader(premiumReader, nameReader, idReader);
            System.out.println(confirmationRegister);
        }
        else{
            System.out.println("type a correct number");
            registerReader();
        }
        
    }

    /**
     * This function manages the addition, modification, and deletion of bibliographic products by
     * taking user input and calling corresponding methods from the controller class.
     */
    public void manageBibliographicProducts() throws ParseException{

        System.out.println("Type your option: \n1. add bibliographic product \n2. modify bibliographic product \n3. delete bibliographic product");
        String optionManage = input.next();
        
        if(optionManage.equals("1")){
            System.out.println("Enter the product name");
            
            String name = input.nextLine();
            System.out.println("Enter the pages number");
            int numberPages = 0;
            while (!integerInput(input)) {
                input.nextLine();
                System.out.println("Type again");
            }
            numberPages = input.nextInt();
            System.out.println("Enter the publication day in format (dd-MM-yyyy)");

            Calendar publicationDate = null;
            while(publicationDate == null){
                String dateAux= input.nextLine().trim();
                try{
                    publicationDate = controller.stringToCalendar(dateAux);
                }
                catch(ParseException e){
                    
                }
            }

            System.out.println("Enter the url");
            String url = input.next();
            System.out.println("Type the value of the product $");
            double valueProduct = 0;
            while(!doubleInput(input)){ 
                input.nextLine();
                System.out.println("Type again");
            }   
            do {
                valueProduct = input.nextDouble();
            } while (!(valueProduct > 0));
            
            System.out.println("Type 1 for a book or 2 for a magazine:");
            String typeProduct ="";
            while(!typeProduct.equals("1") && !typeProduct.equals("2")){
                input.nextLine();
                typeProduct = input.next();
                if(typeProduct.equals("1")){
                    System.out.println("Type a short review:");
                    input.nextLine();
                    String review = input.nextLine(); 
                    System.out.println("Enter the product gender: 1. Science fiction, 2. Fantasy, 3. Historical novel");
                    int gender = 0;
                    while (!integerInput(input)){
                        input.nextLine();
                        System.out.println("Enter again"); 
                    }
                    while (gender > 3 || gender < 1){
                       
                        gender = input.nextInt();  
                    } 
                    String confirmationRegster = controller.addBook(name, numberPages, publicationDate, url, valueProduct, review, gender);
                    System.out.println(confirmationRegster);
                }else if(typeProduct.equals("2")){
                    System.out.println("Type the periodicity:");
                    input.nextLine();
                    String periodicity = input.nextLine();
                    System.out.println("Enter the product category: 1. Variety, 2. Design, 3. Scientist");
                    int category = 0;
                    while (!integerInput(input)){
                        input.nextLine();
                        System.out.println("Enter again"); 
                    }
                    while (category > 3 || category < 1){
                        
                        category = input.nextInt();  
                    } 
                    String confirmationRegister =controller.addMagazine(name, numberPages, publicationDate, url, valueProduct, periodicity, category);
                    System.out.println(confirmationRegister);
                }
                else{
                    System.out.println("Enter a correct number");
                }
            } 

        }else if(optionManage.equals("2")){
            System.out.println("Type the id of the product");
            String idProduct = input.next();
            int option = -1;
            if(controller.searchNumberBibliograpicProduct(idProduct) != -1){
                if(controller.checkTypeBibliographicProduct(idProduct)){
                    while(option != 0){ 
                        System.out.println("Type the attribute to edit: 1. name, 2. numberPages, 3. publicationDate, 4. url, 5. valueProduct, 6. review, 7. gender, 0. Exit");
                        while (!integerInput(input)){
                            input.nextLine();
                            System.out.println("Enter again"); 
                        }
                        option = input.nextInt();  
                        
                        if(option != 0){
                            System.out.println("Enter the content of the change:");
                            input.nextLine();
                            String change = input.nextLine();
                            String confirmationEdit = controller.editBook(idProduct, option, change);
                            System.out.println(confirmationEdit);
                        } 
                
                    }
                }
                else{
                    do{ 
                        System.out.println("Type the attribute to edit: 1. name, 2. numberPages, 3. publicationDate, 4. url, 5. valueProduct, 6. periodicity, 7. category, 0. Exit");
                        while (!integerInput(input)) {
                            do {
                                option = input.nextInt();  
                            } while (option > 7 || option < 0);
                        }
                        if(option != 0 ){
                            System.out.println("Enter the content of the change:");
                            input.nextLine();
                            String change = input.nextLine();
                            String confirmationDelete = controller.editMagazine(idProduct, option, change); 
                            System.out.println(confirmationDelete);
                        }
                     
                    }while(option != 0); 
                }
            }
            else{
                System.out.println("The id doesn't have a product match");
            }
        }
        else if(optionManage.equals("3")){
            System.out.println("Type the id of the product");
            String idProduct = input.next();
            System.out.println(controller.removeProducts(idProduct));
        }
        else{
            System.out.println("invalid number");
            manageBibliographicProducts();
        }
    }

    /**
     * This function generates automatic objects and prints the initialization of basic objects using a
     * controller.
     */
    public void generateAutomaticObjects(){
        String confirmationCreation = controller.initBasicObjects(); 
        System.out.println(confirmationCreation);
    }

    /**
     * This function prompts the user to enter a product name and then calls a controller method to
     * search for the product code in a bibliographic database.
     */
    public void consultBibliographicProducts(){
        System.out.println("Enter the product name");
        input.nextLine();
        String searchNameString = input.nextLine();
        String listProducts = controller.consultCodeBibliographicProducts(searchNameString); 
        System.out.println(listProducts);
    }

    /**
     * This Java function prompts the user to input a reader ID and a book ID, and then calls a
     * controller method to aggregate the book to the reader.
     */
    public void readerBuyBook(){
        System.out.println("Type the user id:");
        String idReader = input.next();
        System.out.println("Type the book id:");
        String idBook = input.next();
        String confirmationBuy = controller.aggregateBookToReader(idReader, idBook); 
        System.out.println(confirmationBuy);
    }

    /**
     * This function prompts the user to input a reader ID and a magazine ID, and then calls a
     * controller method to subscribe the reader to the magazine.
     */
    public void readerSubscribeMagazine(){
        System.out.println("Type the user id:");
        String idReader = input.next();
        System.out.println("Type the magazine id to suscribe:");
        String idMagazine = input.next();
        String confirmationSuscribe = controller.aggregateMagazineToReader(idReader, idMagazine); 
        System.out.println(confirmationSuscribe);
    }

    /**
     * This function cancels a magazine subscription of a reader by taking input of user id and
     * magazine id.
     */
    public void cancelSubscriptionMagazineOfReader(){
        System.out.println("Type the user id:");
        String idReader = input.next();
        System.out.println("Type the magazine id to desuscribe:");
        String idMagazine = input.next();
        String confirmationNotSuscribe = controller.cancelMagazineOfReader(idReader, idMagazine); 
        System.out.println(confirmationNotSuscribe);    
    }

    /**
     * This function presents a library reader simulation and allows the user to input their reader and
     * product IDs to start a reading session.
     */
    public void presentLibraryReader(){
        String libraryOption = "";
        
        do{
            System.out.println("Type A to do a simultation, E to exit");
            libraryOption = input.next();
            if (libraryOption.equals("A")) {
                System.out.println("Type the id reader");
                String idReader = input.next();
                System.out.println("Type the id product");
                input.nextLine();
                String idProduct = input.next();
                String simulationOption = "";

                if(controller.searchNumberReader(idReader)!= -1 && controller.searchNumberBibliograpicProduct(idProduct) != -1 && controller.checkUserHaveAProduct(idReader, idProduct) ){ 
                
                    while (!simulationOption.equals("B")){

                        System.out.println(controller.readingSession(idProduct, idReader,simulationOption));
                        simulationOption = input.next();

                    }
                    
                    controller.addNumberPagesRead(controller.consultObjectReader(idReader).getLastSessionPage(), controller.consultObjectProduct(idProduct));
                    controller.consultObjectReader(idReader).setCurrentSessionPage(1);
                    controller.consultObjectReader(idReader).setLastSessionPage(0);

                }
                else{
                    System.out.println("That user doesn't have that product");
                }
                 
            }

        }while (!libraryOption.equals("E"));
    }

    /**
     * This function checks if the input from a scanner is an integer and returns a boolean value
     * indicating its validity.
     * 
     * @param input The input parameter is a Scanner object, which is used to read input from the user.
     * @return The method is returning a boolean value, which indicates whether the input provided by
     * the user is an integer or not. If the input is an integer, the method returns true, otherwise it
     * returns false.
     */
    public boolean integerInput(Scanner input){
        boolean valid = false;
        if(input.hasNextInt()){
            valid = true;
        }
        return valid;
    }

    /**
     * This function checks if the input from a scanner is a valid double and returns a boolean value
     * indicating its validity.
     * 
     * @param input The input parameter is a Scanner object, which is used to read input from the user.
     * @return The method is returning a boolean value, which indicates whether the input from the
     * Scanner object is a double or not. If the input is a double, the method returns true, otherwise
     * it returns false.
     */
    public boolean doubleInput(Scanner input){
        boolean valid = false;
        if(input.hasNextDouble()){
            valid = true;
        }
        return valid;
    }

}
