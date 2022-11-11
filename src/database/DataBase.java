package database;

import constants.Type;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    // danh sách nhân viên
    public static List<Employee> employeeList = new ArrayList<>();
    // danh sách khách hàng
    public static List<Customer> customerList = new ArrayList<>();
    // danh sách sản phẩm
    public static List<Product> productList = new ArrayList<>();
    // danh sách tài khoản
    public static List<Account> accountsList = new ArrayList<>();
    // danh sách hóa đơn
    public static List<Invoice> invoiceList = new ArrayList<>();
    // danh sách lịch sử lỗi
    public static List<History> historyList = new ArrayList<>();
    // list hoàn thành hóa đơn khách hàng
    public static List<CompletedInvoice> completedInvoiceList = new ArrayList<>();
    // danh sách hóa đơn oder vật liệu của Fuction
    public static List<InvoiceMaterial> invoiceMaterialList = new ArrayList<>();

    // danh sách input vật liệu (Material)
    public static List<InputMaterial> inPutMaterialList = new ArrayList<>();
    // list vật liệu
    public static List<Material> materialList = new ArrayList<>();


    static {
        Account admin = new Account();
        admin.setUserName("admin");
        admin.setPassword("admin");
        admin.setType(Type.ADMIN);
        accountsList.add(admin);

    }
    public static Employee employee;
}
