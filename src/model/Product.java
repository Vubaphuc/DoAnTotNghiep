package model;

public class Product {
    private String idProduct;
    private String nameProduct;
    private String nameErrol;


    public Product(String idProduct, String nameProduct, String nameErrol) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.nameErrol = nameErrol;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getNameErrol() {
        return nameErrol;
    }

    public void setNameErrol(String nameErrol) {
        this.nameErrol = nameErrol;
    }
}
