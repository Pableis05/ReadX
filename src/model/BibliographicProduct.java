package model;

import java.util.Calendar;

public abstract class BibliographicProduct {
    
    private String idProduct;
    private String nameProduct;
    private int numberPages;
    private Calendar publicationDate;
    private String url;
    private double valueProduct;
    private int amountSales;
    private int amountPagesRead;

    public BibliographicProduct(String nameProduct, int numberPages, Calendar publicationDate ,String url, double valueProduct) {
        this.nameProduct = nameProduct;
        this.numberPages = numberPages;
        this.publicationDate = publicationDate;
        this.url = url;
        this.idProduct = createID();
        this.valueProduct = valueProduct;
        amountSales = 0;
        amountPagesRead = 0;
    }

    public abstract String createID();

    public void addNumberPagesRead(int newPages){
        this.amountPagesRead += newPages;
        
    }

    public void addAmountSales(){
        this.amountSales++;
    }

    public void decreaseAmountSales(){
        this.amountSales--;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public void setNumberPages(int numberPages) {
        this.numberPages = numberPages;
    }

    public void setPublicationDate(Calendar publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setValueProduct(double valueProduct) {
        this.valueProduct = valueProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public int getNumberPages() {
        return numberPages;
    }

    public double getValueProduct() {
        return valueProduct;
    }

    public int getAmountSales() {
        return amountSales;
    }

    public int getAmountPagesRead() {
        return amountPagesRead;
    }

    
    

}
