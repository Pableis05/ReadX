package model;

import java.util.ArrayList;

public abstract class Reader {
    private String nameReader;
    private String idReader;
    protected ArrayList<Book>books;
    protected ArrayList<Magazine>magazines;

    public Reader(String nameReader, String idReadder){
        this.nameReader = nameReader;
        this.idReader = idReadder;
    }

    public String getNameReader() {
        return nameReader;
    }

    public String getIdReader() {
        return idReader;
    }
    
    public abstract String addBook(Book book);

    public abstract String addMagazine(Magazine magazine);

    public String removeMagazine(Magazine magazine){
        String msg = "The user have been desuscribe of the magazine";
        magazines.remove(magazine);
        return  msg;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Magazine> getMagazines() {
        return magazines;
    }

    public boolean checkUserHaveAProduct(BibliographicProduct product){
        boolean productFind = false;
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).equals(product)){
                productFind = true;
            }
        }
        for (int i = 0; i < magazines.size(); i++) {
            if(books.get(i).equals(product)){
                productFind = true;
            }
        }
        return productFind;
    }
    
}
