package ui;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Scanner;

import model.BibliographicProduct;
import model.ControllerLibrary;


public class ReadXSystem {

    private Scanner input;
    private ControllerLibrary controller;

    ReadXSystem(){
        input = new Scanner(System.in);
        controller = new ControllerLibrary();
    }

    public static void main(String[] args) throws Exception {

        ReadXSystem readX = new ReadXSystem();
        System.out.println("!!!!!!!!!!!WELCOME TO THE NEW LIBRARY READX!!!!!!!!!!!!");
        readX.menu();

    }

    public void menu() throws ParseException{
        int option = -1;
        do{ 
            System.out.printf("%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n%s%n", "Type the option that you are going to do", "1. Register a reader", "2. Manage a bibliographic product", "3. Generate basic objects","4. Consult bibliographics products", "5. Buy a book by a reader", "6. Subscribe to a magazine by a reader", "7. Cancel a subscription for a reader", "8. Present library reader", "0. Exit");
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
        }while(option != 0);
    }

    public void registerReader(){
        boolean premiumReader;
        String nameReader;
        String idReader;
        System.out.println("Enter the type reader: \n1. Premium Reader \n2. Regular Reader");
        if(input.hasNext("1")){
            premiumReader = true;
        }
        else{
            premiumReader = false;
        }
        System.out.println("Type the reader name");
        input.next();
        nameReader = input.next();
        System.out.println("Enter the reader id");
        idReader = input.next();
        System.out.println(controller.addReader(premiumReader, nameReader, idReader));
    }

    public void manageBibliographicProducts() throws ParseException{

        System.out.println("Type your option: \n1. add bibliographic product \n2. modify bibliographic product \n3. delete bibliographic product");
        String optionManage = input.next();
        if(optionManage.equals("1")){
            System.out.println("Enter the product name");
            input.nextLine();
            String name = input.next();
            System.out.println("Enter the pages number");
            input.nextLine();
            int numberPages = input.nextInt();
            System.out.println("Enter the publication day");
            String auxiliarDate = input.next();
            Calendar publicationDate = controller.stringToCalendar(auxiliarDate);
            System.out.println("Enter the url");
            String url = input.next();
            System.out.println("Type the value of the product $");
            double valueProduct = input.nextDouble();
            System.out.println("Type 1 for a book or 2 for a magazine:");
            String typeProduct = input.next();
            if(typeProduct.equals("1")){
                System.out.println("Type a short review:");
                input.nextLine();
                String review = input.nextLine(); 
                System.out.println("Enter the product gender: 1. Science fiction, 2. Fantasy, 3. Historical novel");
                int gender = input.nextInt();
                System.out.println(controller.addBook(name, numberPages, publicationDate, url, valueProduct, review, gender));
            }else{
                System.out.println("Type the periodicity:");
                input.nextLine();
                String periodicity = input.nextLine();
                System.out.println("Enter the product category: 1. Variety, 2. Design, 3. Scientist");
                int category = input.nextInt();
                System.out.println(controller.addMagazine(name, numberPages, publicationDate, url, valueProduct, periodicity, category));
            }

        }else if(optionManage.equals("2")){
            System.out.println("Type the id of the product");
            String id = input.next();
            int option = -1;
            if(controller.checkTypeBibliographicProduct(id)){
                do{ 
                    System.out.println("Type the attribute to edit: 1. name, 2. numberPages, 3. publicationDate, 4. url, 5. valueProduct, 6. review, 7. gender, 0. Exit");
                    option = input.nextInt();
                    System.out.println("Enter the content of the change:");
                    input.nextLine();
                    String change = input.nextLine();
                    System.out.println(controller.editBook(id, option, change));
                }while(option != 0);
            }
            else{
                do{ 
                    System.out.println("Type the attribute to edit: 1. name, 2. numberPages, 3. publicationDate, 4. url, 5. valueProduct, 6. periodicity, 7. category, 0. Exit");
                    option = input.nextInt();
                    if(option != 0 ){
                        System.out.println("Enter the content of the change:");
                        input.nextLine();
                        String change = input.nextLine();
                        System.out.println(controller.editMagazine(id, option, change));
                    }
                 
                }while(option != 0); 
            }
            
        }
        else if(optionManage.equals("3")){
            System.out.println("Type the id of the product");
            String id = input.next();
            System.out.println(controller.removeProducts(id));
        }
        else{
            System.out.println("invalid number");
            manageBibliographicProducts();
        }
    }

    public void generateAutomaticObjects(){
        System.out.println(controller.initBasicObjects());
    }

    public void consultBibliographicProducts(){
        System.out.println("Enter the product name");
        input.nextLine();
        String searchName = input.nextLine();
        System.out.println(controller.consultCodeBibliographicProducts(searchName));
    }

    public void readerBuyBook(){
        System.out.println("Type the user id:");
        String idReader = input.next();
        System.out.println("Type the book id:");
        String idBook = input.next();
        System.out.println(controller.aggregateBookToReader(idReader, idBook));
    }

    public void readerSubscribeMagazine(){
        System.out.println("Type the user id:");
        String idReader = input.next();
        System.out.println("Type the magazine id to suscribe:");
        String idMagazine = input.next();
        System.out.println(controller.aggregateMagazineToReader(idReader, idMagazine));
    }

    public void cancelSubscriptionMagazineOfReader(){
        System.out.println("Type the user id:");
        String idReader = input.next();
        System.out.println("Type the magazine id to desuscribe:");
        String idMagazine = input.next();
        System.out.println(controller.cancelMagazineOfReader(idReader, idMagazine));    
    }

    public void presentLibraryReader(){
        String libraryOption = "";
        
        do{
            System.out.println("Type A to do a simultation, E to exit");
            libraryOption = input.next();
            if (libraryOption.equals("A")) {
                System.out.println("Type the id reader");
                String idReader = input.next();
                System.out.println("Type the id product");
                String idProduct = input.next();
                String simulationOption = "";
                int pagesRead = 0;
                int maxPage = 0;
                BibliographicProduct product = controller.consultObjectProduct(idProduct);

                if(controller.checkUserHaveAProduct(idReader, idProduct)){ 
                    do {
                        System.out.println("Reader sesion in progress \n Reading: " +  product.getNameProduct() + "\n Reading page: " + pagesRead + " of "+ product.getNumberPages()
                        +"\n Type A for the previous page \n Type S for the next page\n Type B to back to the library");
                        
                        simulationOption = input.next();
        
                        if(simulationOption.equals("S")){
                            if(pagesRead == controller.consultObjectProduct(idProduct).getNumberPages()){
                                System.out.print("\nThe book is on the last page");
                            }
                            else{
                                pagesRead++; 
                            }
                        }
        
                        else if(simulationOption.equals("A")){
                            if(pagesRead == 0){
                                System.out.print("The book is on the page 0");
                            }
                            else{
                                pagesRead--; 
                            }
                        }
        
                        if(maxPage < pagesRead){
                            maxPage = pagesRead;
                        }
        
                    }while (!simulationOption.equals("B"));  
                    controller.addNumberPagesRead(pagesRead, product);
                }
                else{
                    System.out.println("The user doesn't have that product, Type B to back to the library");
                }
                 
            }

        }while (!libraryOption.equals("E"));
    }

}
