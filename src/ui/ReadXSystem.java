package ui;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

import model.Book;
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
        if(input.hasNext("1")){
            System.out.println("Enter the product name");
            String name = input.next();
            System.out.println("Enter the pages number");
            int numberPages = input.nextInt();
            System.out.println("Enter the publication day");
            String auxiliarDate = input.next();
            Calendar publicationDate = controller.stringToCalendar(auxiliarDate);
            System.out.println("Enter the url");
            String url = input.next();
            System.out.println("Type the value of the product $");
            double valueProduct = input.nextDouble();
            System.out.println("Type 1 for a book or 2 for a magazine:");
            if(input.hasNext("1")){
                System.out.println("Type a short review:");
                String review = input.nextLine(); 
                System.out.println("Enter the product gender: 1. Science fiction, 2. Fantasy, 3. Historical novel");
                int gender = input.nextInt();
                System.out.println(controller.addBook(name, numberPages, publicationDate, url, valueProduct, review, gender));
            }else{
                System.out.println("Type the periodicity:");
                String periodicity = input.nextLine();
                System.out.println("Enter the product category: 1. Variety, 2. Design, 3. Scientist");
                int category = input.nextInt();
                System.out.println(controller.addMagazine(name, numberPages, publicationDate, url, valueProduct, periodicity, category));
            }

        }else if(input.hasNext("2")){
            System.out.println("Type the id of the product");
            String id = input.next();
            int option = -1;
            if(controller.getBibliographicProducts().get(controller.searchBibliograpicProduct(id)) instanceof Book){
                do{ 
                    System.out.println("Type the attribute to edit: 1. name, 2. numberPages, 3. publicationDate, 4. url, 5. valueProduct, 6. review, 7. gender, 0. Exit");
                    option = input.nextInt();
                    System.out.println("Enter the content of the change:");
                    String change = input.nextLine();
                    System.out.println(controller.editBook(id, option, change));
                }while(option != 0);
            }
            
        }
        else if(input.hasNext("3")){

        }
        else{
            System.out.println("invalid number");
            manageBibliographicProducts();
        }
    }

    public void generateAutomaticObjects(){
        
    }

    public void consultBibliographicProducts(){
        
    }

    public void readerBuyBook(){
        
    }

    public void readerSubscribeMagazine(){
        
    }

    public void cancelSubscriptionMagazineOfReader(){
        
    }

    public void presentLibraryReader(){
        
    }


}
