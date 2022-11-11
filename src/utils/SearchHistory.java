package utils;

import java.util.Iterator;
import java.util.List;

import database.DataBase;
import model.*;

public class SearchHistory {
    // Method in toàn bộ list ra màn hình
    public static <E> void searchAll(List<E> list) {
        for (E e : list) {
            if (list.isEmpty()){
                System.out.println("Chưa có Thông tin nào");
            }else {
                System.out.println(e.toString());
            }
        }
    }
    // method tìm sản phẩm theo ID Product
    public static void searchProductById() {
        Iterator<History> it = DataBase.historyList.iterator();
        System.out.println("Nhap ID product:");
        String idProduct = InputValue.getString();
        while (it.hasNext()) {
            History history = it.next();
            if (idProduct.equals(history.getProduct().getIdProduct())) {
                System.out.println(history.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy Sản phẩm nào");
    }
    // Method tìm khách hàng theo ID Customer
    public static void searchCustomerByID() {
        Iterator<Invoice> it = DataBase.invoiceList.iterator();
        System.out.println("Nhap ID Customer:");
        String idCustomer = InputValue.getString();
        while (it.hasNext()) {
            Invoice invoice = it.next();
            if (idCustomer.equals(invoice.getCustomer().getIdCustomer())) {
                System.out.println(invoice.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng nào");
    }
    // Method tìm hóa đơn theo Code hóa đơn
    public static void searchInvoiceByID() {
        Iterator<Invoice> it = DataBase.invoiceList.iterator();
        System.out.println("Nhap ID Invoice:");
        String idInvoice = InputValue.getString();
        while (it.hasNext()) {
            Invoice invoice = it.next();
            if (idInvoice.equals(invoice.getCodeInvoive())) {
                System.out.println(invoice.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn nào");
    }
    // Method tìm tài khoản theo ID Employee
    public static void searchAccountByID() {
        Iterator<Account> it = DataBase.accountsList.iterator();
        System.out.println("Nhap ID Account:");
        String idAccount = InputValue.getString();
        while (it.hasNext()) {
            Account account = it.next();
            if (account.getUserName().equals(idAccount)) {
                System.out.println(account.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy Tài khoản nào");
    }
    // method tìm kiếm nhân viên theo ID Employee
    public static void searchEmployeeByID() {
        Iterator<Employee> it = DataBase.employeeList.iterator();
        System.out.println("Nhap ID Employee:");
        String idEmployee = InputValue.getString();
        while (it.hasNext()) {
            Employee employee = it.next();
            if (employee.getIdNhanVien().equals(idEmployee)) {
                System.out.println(employee.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy Nhân viên nào");
    }
    // method tìm kiếm khách hàng theo tên Customer
    public static void searchCustomerByName() {
        Iterator<Invoice> it = DataBase.invoiceList.iterator();
        System.out.println("Nhap Name Customer:");
        String name = InputValue.getString();
        while (it.hasNext()) {
            Invoice invoice = it.next();
            if (invoice.getCustomer().getNameCustomer().contains(name)) {
                System.out.println(invoice.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy khách hàng nào");
    }
    // method tòm kiếm hóa đơn oder vật liệu theo code invoice
    public static void searchInvoiceOderMaterialByCode() {
        Iterator<InvoiceMaterial> it = DataBase.invoiceMaterialList.iterator();
        System.out.println("Nhập Code Invoice Material");
        String codeInvoice = InputValue.getString();
        while (it.hasNext()){
            InvoiceMaterial invoiceMaterial = it.next();
            if (invoiceMaterial.getCodeMaterial().equals(codeInvoice)){
                System.out.println(invoiceMaterial.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn nào");
    }
    //Tìm kiếm input material bằng ID Material
    public static void searchInputMaterialByID() {
        Iterator<InputMaterial> it = DataBase.inPutMaterialList.iterator();
        System.out.println("Nhập ID Material");
        String idMaterial = InputValue.getString();
        while (it.hasNext()){
          InputMaterial inputMaterial = it.next();
            if (inputMaterial.getMaterial().getIdMaterial().equals(idMaterial)){
                System.out.println(inputMaterial.toString());
                return;
            }
        }
        System.out.println("Không tìm thấy vật liệu nào");
    }
}
