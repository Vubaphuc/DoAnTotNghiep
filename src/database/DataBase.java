package database;

import constants.Type;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
        accountsList.add(admin);
        Employee employees = new Employee();
        employees.setIdNhanVien("admin");
        employees.setFullName("admin");
        employees.setType(Type.ADMIN);
        employeeList.add(employees);
        Employee employees1 = new Employee("1","A",Type.NHANVIENWIP);
        Employee employees2 = new Employee("2","B",Type.NHANVIENSUAFONT);
        Employee employees3 = new Employee("3","C",Type.NHANVIENSUAPHANMEM);
        Employee employees4 = new Employee("4","D",Type.NHANVIENSUAPCB);
        Employee employees5 = new Employee("5","E",Type.NHANVIENLETAN);
        Employee employees6 = new Employee("6","F",Type.NHANVIENKHO);
        Employee employees7 = new Employee("7","G",Type.QUANLY);
        employeeList.add(employees1);
        employeeList.add(employees2);
        employeeList.add(employees3);
        employeeList.add(employees4);
        employeeList.add(employees5);
        employeeList.add(employees6);
        employeeList.add(employees7);
        Account admin1 = new Account("1","1");
        Account admin2 = new Account("2","1");
        Account admin3 = new Account("3","1");
        Account admin4 = new Account("4","1");
        Account admin5 = new Account("5","1");
        Account admin6 = new Account("6","1");
        Account admin7 = new Account("7","1");
        accountsList.add(admin1);
        accountsList.add(admin2);
        accountsList.add(admin3);
        accountsList.add(admin4);
        accountsList.add(admin5);
        accountsList.add(admin6);
        accountsList.add(admin7);






    }
    public static Employee employee;
}
