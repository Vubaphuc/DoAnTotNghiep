package model;

public class Product {
    private String idProduct;
    private String nameProduct;
    private String nameErrol;

    public Product() {
    }

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

    @Override
    public String toString() {
        System.out.format("ID Product:  %-9s -  Tên Sản Phẩm:  %-20s  -  Lỗi:  %-30s  ",idProduct,nameProduct,nameErrol);
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        return "";
    }
}
