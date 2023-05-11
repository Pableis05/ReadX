package model;

import java.util.ArrayList;

public abstract class Reader {
    private String nameReader;
    private String idReader;
    private int currentSesionPage;
    private int lastSesionPage;
    protected ArrayList<Book>books;
    protected ArrayList<Magazine>magazines;

    public Reader(String nameReader, String idReadder){
        this.nameReader = nameReader;
        this.idReader = idReadder;
        currentSesionPage = 1;
        lastSesionPage = 0;
    }

    public void addAmountSesionPage(){
        this.currentSesionPage++;
        if(checkLastSesionPage()){
            this.lastSesionPage++;
        }
    }

    public boolean checkLastSesionPage(){
        boolean change = false;
        if(lastSesionPage < currentSesionPage){
            change = true;
        }
        return change;
    }

    public void decreaseAmountSesionPage(){
        this.currentSesionPage--;
    }

    public String getNameReader() {
        return nameReader;
    }

    public String getIdReader() {
        return idReader;
    }
    
    
    public int getCurrentSesionPage() {
		return currentSesionPage;
	}

	public void setCurrentSesionPage(int currentSesionPage) {
		this.currentSesionPage = currentSesionPage;
	}

	public abstract String addBook(Book book);

    public abstract String addMagazine(Magazine magazine);

    public String removeProduct(BibliographicProduct bibliographicProduct){
        String msg = "The user have been desuscribe of the magazine";
        magazines.remove(bibliographicProduct);
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
                break;
            }
        }
        for (int i = 0; i < magazines.size(); i++) {
            if(magazines.get(i).equals(product)){
                productFind = true;
                break;
            }
        }
        return productFind;
    }

	public int getLastSesionPage() {
		return lastSesionPage;
	}

	public void setLastSesionPage(int lastSesionPage) {
		this.lastSesionPage = lastSesionPage;
	}
    
    
}
