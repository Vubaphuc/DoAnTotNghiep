package services;

import constants.Status;
import constants.Type;
import database.DataBase;
import model.*;
import utils.InputValue;
import utils.SearchHistory;

import java.time.LocalDate;
import java.util.Iterator;

public class ReceptionistService {

    // màn hình chức năng nhân viên lễ tân
    public void showFunction() {
        while (true) {
            System.out.println("1. Manager by Customer");
            System.out.println("2. Manager by Product");
            System.out.println("3. Manager by Invoice");
            System.out.println("4. Transfer Product");
            System.out.println("5. Search History");
            System.out.println("0. Log Out");
            int choose = InputValue.getInt(1, 5);
            if (choose == 0) {
                DataBase.employee = null;
                break;
            }
            switch (choose) {
                case 1:
                    showManagerByCustomer();
                    break;
                case 2:
                    showManagerByProduct();
                    break;
                case 3:
                    showManagerByInvoice();
                    break;
                case 4:
                    showTransferProduct();
                    break;
                case 5:
                    showSearchHistory();
                    break;
            }
        }
    }
    // method màn hình chức năng quản lý khách hàng
    private void showManagerByCustomer() {
        while (true) {
            System.out.println("1. Nhập thông tin khách hàng");
            System.out.println("2. Sửa Thông tin khách hàng");
            System.out.println("3. Xóa thông tin khách");
            System.out.println("0. quay lại");
            int choose = InputValue.getInt(1, 3);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    setInformationByCustomer();
                    break;
                case 2:
                    showChangeCustomer();
                    break;
                case 3:
                    deteletCustomer();
                    break;
            }
        }
    }

    // method nhập thông tin khách hàng
    private void setInformationByCustomer() {
        System.out.println("Nhập ID Khách hàng");
        String idCustomer = InputValue.getString();
        System.out.println("Nhập Tên Khách hàng");
        String nameCustomer = InputValue.getString();
        System.out.println("Nhập địa chỉ khách hàng");
        String address = InputValue.getString();
        System.out.println("Nhập số điện thoại khách hàng");
        String phoneNumber = InputValue.getString();
        boolean checkIDCustomer = checkIDCutomer(idCustomer);
        if (checkIDCustomer == true){
            System.out.println("ID khách hàng đã tồn tại");
            return;
        }
        if (checkIDCustomer == false){
            Customer customer = new Customer(idCustomer, nameCustomer, address, phoneNumber);
            DataBase.customerList.add(customer);
        }
    }

    private boolean checkIDCutomer(String idCustomer) {
        for (Customer customer : DataBase.customerList){
            if (customer.getIdCustomer().equals(idCustomer)){
                return true;
            }
        }
        return false;
    }

    // method hiển thị chức năng quản lý sản phẩm
    private void showManagerByProduct() {
        while (true) {
            System.out.println("1. Nhập thông tin sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm");
            System.out.println("3. Xóa thông tin sản phẩm");
            System.out.println("0. quay lại");
            int choose = InputValue.getInt(1, 3);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    setInformationByProduct();
                    break;
                case 2:
                    changeInformationByProduct();
                    break;
                case 3:
                    deteletProduct();
                    break;
            }
        }
    }
    // method chức năng thay đổi thông tin sản phẩm
    private void changeInformationByProduct() {
        while (true) {
            System.out.println("1. Thay đổi tên Model");
            System.out.println("2. Thay đổi tên lỗi");
            System.out.println("0. quay lại");
            int choose = InputValue.getInt(1, 2);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    changeNameModel();
                    break;
                case 2:
                    changeNameErrol();
                    break;
            }
        }
    }
    // method thay đổi tên model
    private void changeNameModel() {
        System.out.println("Nhập Mã Sản Phẩm cần xóa");
        String idProduct = InputValue.getString();
        Iterator<Product> it = DataBase.productList.iterator();
        while (it.hasNext()) {
            Product product = it.next();
            if (product.getIdProduct().equals(idProduct)) {
                System.out.println("Nhập tên Model mới");
                String nameModelNew = InputValue.getString();
                product.setNameProduct(nameModelNew);
                System.out.println("Đã thay đổi thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm nào!");
    }
    // method sửa tên lỗi
    private void changeNameErrol() {
        System.out.println("Nhập Mã Sản Phẩm cần xóa");
        String idProduct = InputValue.getString();
        Iterator<Product> it = DataBase.productList.iterator();
        while (it.hasNext()) {
            Product product = it.next();
            if (product.getIdProduct().equals(idProduct)) {
                System.out.println("Nhập tên lỗi mới");
                String nameErrolNew = InputValue.getString();
                product.setNameErrol(nameErrolNew);
                System.out.println("Đã thay đổi thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm nào!");
    }

    // method xóa thông tin sản phẩm
    private void deteletProduct() {
        System.out.println("Nhập Mã Sản Phẩm cần xóa");
        String idProduct = InputValue.getString();
        Iterator<Product> it = DataBase.productList.iterator();
        while (it.hasNext()) {
            Product product = it.next();
            if (product.getIdProduct().equals(idProduct)) {
                it.remove();
                System.out.println("Đã xóa thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy sản phẩm nào!");
    }
    // method nhập thông tin sản phẩm
    private void setInformationByProduct() {
        System.out.println("Nhập ID sản phẩm");
        String idProduct = InputValue.getString();
        System.out.println("Nhập Tên Model");
        String nameModel = InputValue.getString();
        System.out.println("Nhập Tên lỗi");
        String nameErrol = InputValue.getString();
        boolean checkIDProduct = checkIDProduct(idProduct);
        if (checkIDProduct == true){
            System.out.println("ID Product đã tồn tại");
            return;
        }
        if (checkIDProduct == false){
            Product product = new Product(idProduct, nameModel, nameErrol);
            DataBase.productList.add(product);
            LocalDate dateNow = LocalDate.now();
        }
    }

    private boolean checkIDProduct(String idProduct) {
        for (Product product : DataBase.productList){
            if (product.getIdProduct().equals(idProduct)){
                return true;
            }
        }
        return false;
    }

    // method hiển thị chức năng quản lý hóa đơn
    private void showManagerByInvoice() {
        while (true) {
            System.out.println("1. Tạo hóa đơn");
            System.out.println("2. In Hóa Đơn");
            System.out.println("3. Xóa hóa đơn");
            System.out.println("4. Xác Nhận Hoàn thành Hóa đơn");
            System.out.println("0. quay lại");
            int choose = InputValue.getInt(1, 4);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    showCreateInvoice();
                    break;
                case 2:
                    showGetInvoice();
                    break;
                case 3:
                    deteletInvoice();
                    break;
                case 4:
                    completedInvoice();
                    break;
            }
        }
    }


    // method xác nhận hoàn thành hóa đơn(Xác nhận Trả sản phẩm cho khách hàng)
    private void completedInvoice() {
        String codeInvoice = getCodeInvoice();
        // lấy ra 1 hóa đơn theo Code hóa đơn nhập vào
        Invoice invoice = getInvoice(codeInvoice);
        String statusInvoice = "Hoàn Thành";
        LocalDate dayCompleted = LocalDate.now();
        CompletedInvoice completedInvoice = new CompletedInvoice(invoice,statusInvoice,dayCompleted);
        DataBase.completedInvoiceList.add(completedInvoice);
    }

    // check Code Invoice có tồn tại hay không. cso trả về. không quay lại
    private String getCodeInvoice() {
        System.out.println("Nhập Mã Hóa Đơn");
        String codeInvoice = InputValue.getString();
        for (Invoice invoice : DataBase.invoiceList) {
            if (invoice.getCodeInvoive().equals(codeInvoice)) {
                return codeInvoice;
            }
        }
        System.out.println("Mã hóa đơn đã tồn tại. Vui lòng nhập lại");
        return getCodeInvoiceNotExist();
    }

    // lấy ra 1 hóa đơn
    private Invoice getInvoice(String codeInvoice) {
        for (Invoice invoice : DataBase.invoiceList){
            if (invoice.getCodeInvoive().equals(codeInvoice)){
                return  invoice;
            }
        }
        return null;
    }


    // method tạo hóa đơn
    private void showCreateInvoice() {
        String codeInvoice = getCodeInvoiceNotExist();
        if (codeInvoice == null){
            System.out.println("Code Invoice đã tồn tại");
            return;
        }
        Customer customer = getByCustomer();
        if (customer == null){
            System.out.println("Không tìm thấy mã khách nào");
            return;
        }
        Product product = getByProduct();
        if (product == null){
            System.out.println("Không tìm thấy sản phẩm nào");
            return;
        }
        System.out.println("Nhập số lượng");
        int amount = InputValue.getInputInt();
        System.out.println("Nhập số tiền sửa");
        double price = InputValue.getInputDouble();
        LocalDate startDay = LocalDate.now();
        System.out.println("Nhập ngày trả");
        LocalDate endDay = InputValue.getInputLocalDate();
        Employee employee = DataBase.employee;
        Invoice invoice = new Invoice(codeInvoice, customer, product, amount, price, startDay, endDay, employee);
        DataBase.invoiceList.add(invoice);
    }
    // method lấy hóa đơn/in hóa đơn
    private void showGetInvoice() {
        System.out.println("Nhập Code hóa đơn cần In");
        String codeInvoice = getCodeInvoiceToPrint();
        for (Invoice invoice : DataBase.invoiceList) {
            if (invoice.getCodeInvoive().equals(codeInvoice)) {
                System.out.println(invoice.toString());
            }
        }
    }
    // method xóa hóa đơn
    private void deteletInvoice() {
        System.out.println("Nhập Mã Hóa Đơn");
        String codeInvoice = InputValue.getString();
        Iterator<Invoice> it = DataBase.invoiceList.iterator();
        while (it.hasNext()) {
            Invoice invoice = it.next();
            if (invoice.getCodeInvoive().equals(codeInvoice)) {
                it.remove();
                System.out.println("Đã xóa thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy hóa đơn nào!");
    }
    // method lấy ra mã hóa đơn để in
    private String getCodeInvoiceToPrint() {
        String codeInvoice = InputValue.getString();
        for (Invoice invoice : DataBase.invoiceList) {
            if (invoice.getCodeInvoive().equals(codeInvoice)) {
                return codeInvoice;
            }
        }
        System.out.println("Không tìm thấy hóa đơn.Vui lòng nhập lại");
        return getCodeInvoiceToPrint();
    }
    // method chuyển sản phẩm lỗi sang nhân viên công đoạn sau để xử lý
    private void showTransferProduct() {
        Product product = getByProduct();
        if (product == null){
            System.out.println("Không tìm mã sản phẩm nào");
            return;
        }
        Status status = Status.PENDING;
        Employee employeeRece = DataBase.employee;
        Employee employeeWIP = getEmployeeWIP();
        if (employeeWIP == null){
            System.out.println("Không tìm thấy nhân viên nào hoặc nhân viên không phải nhân viên WIP");
            return;
        }
        LocalDate dayInputRece = LocalDate.now();
        History history = new History(product, status, employeeRece, dayInputRece, employeeWIP);
        DataBase.historyList.add(history);
    }

    // lấy thông tin 1 nhân viên viên WIP
    private Employee getEmployeeWIP() {
        System.out.println("Nhập ID nhân viên After");
        String idNhanVien = InputValue.getString();
        for (Employee employee : DataBase.employeeList) {
            if (employee.getIdNhanVien().equals(idNhanVien) && employee.getType() == Type.NHANVIENWIP) {
                return employee;
            }
        }
        return null;
    }

    // method lấy thông tin 1 sản phẩm
    private Product searchProduct() {
        System.out.println("Nhập ID sản phẩm");
        String idProduct = InputValue.getString();
        for (Product product : DataBase.productList) {
            if (product.getIdProduct().equals(idProduct)) {
                return product;
            }
        }
        return null;
    }


    // method thay đổi thông tin khách hàng
    private void showChangeCustomer() {
        while (true) {
            System.out.println("1. Thay đổi tên khách hàng");
            System.out.println("2. Thay đổi địa chỉ khách hàng");
            System.out.println("3. Thay đổi số điện thoại");
            System.out.println("0. quay lại");
            int choose = InputValue.getInt(1, 3);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    changeNameCustomer();
                    break;
                case 2:
                    changeAddressCustomer();
                    break;
                case 3:
                    changePhoneNumberCustomer();
                    break;
            }
        }
    }
    // method thay đổi số điện thoại khách hàng
    private void changePhoneNumberCustomer() {
        System.out.println("Nhập Mã Khách hàng cần thay đổi");
        String idCustomer = InputValue.getString();
        if (DataBase.customerList.isEmpty()){
            System.out.println("Chưa có thông tin khách hàng nào");
            return;
        }
        Iterator<Customer> it = DataBase.customerList.iterator();
        while (it.hasNext()) {
            Customer customer = it.next();
            if (customer.getIdCustomer().equals(idCustomer)) {
                System.out.println("Nhập số điện thoại khách hàng mới");
                String phoneNumberCustomerNew = InputValue.getString();
                customer.setPhoneNumber(phoneNumberCustomerNew);
                System.out.println("Đã thay đổi thành công");
                return;
            }
        }
        System.out.println("Không Tìm thấy khách hàng nào!");
    }
    // method thay đổi địa chỉ khách hàng
    private void changeAddressCustomer() {
        System.out.println("Nhập Mã Khách hàng cần thay đổi");
        String idCustomer = InputValue.getString();
        if (DataBase.customerList.isEmpty()){
            System.out.println("Chưa có thông tin khách hàng nào");
            return;
        }
        Iterator<Customer> it = DataBase.customerList.iterator();
        while (it.hasNext()) {
            Customer customer = it.next();
            if (customer.getIdCustomer().equals(idCustomer)) {
                System.out.println("Nhập địa chỉ khách hàng mới");
                String addressCustomerNew = InputValue.getString();
                customer.setAddress(addressCustomerNew);
                System.out.println("Đã thay đổi thành công");
                return;
            }
        }
        System.out.println("Không Tìm thấy khách hàng nào!");
    }
    // method thay đổi tên khách hàng
    private void changeNameCustomer() {
        System.out.println("Nhập Mã Khách hàng cần thay đổi");
        String idCustomer = InputValue.getString();
        if (DataBase.customerList.isEmpty()){
            System.out.println("Chưa có thông tin khách hàng nào");
            return;
        }
        Iterator<Customer> it = DataBase.customerList.iterator();
        while (it.hasNext()) {
            Customer customer = it.next();
            if (customer.getIdCustomer().equals(idCustomer)) {
                System.out.println("Nhập tên khách hàng mới");
                String nameCustomerNew = InputValue.getString();
                customer.setNameCustomer(nameCustomerNew);
                System.out.println("Đã thay đổi thành công");
                return;
            }
        }
        System.out.println("Không Tìm thấy khách hàng nào!");
    }

    // method lấy ra mã hóa đơn
    private String getCodeInvoiceNotExist() {
        System.out.println("Nhập Mã Hóa Đơn");
        String codeInvoice = InputValue.getString();
        for (Invoice invoice : DataBase.invoiceList) {
            if (invoice.getCodeInvoive().equals(codeInvoice)) {
                System.out.println("Mã hóa đơn đã tồn tại. Vui lòng nhập lại");
                return null;
            }
        }
        return codeInvoice;
    }
    // lấy ra thông tin 1 sản phẩm
    private Product getByProduct() {
        System.out.println("Nhập mã Sản phẩm");
        String idProduct = InputValue.getString();
        for (Product product : DataBase.productList) {
            if (product.getIdProduct().equals(idProduct)) {
                return product;
            }
        }
        return null;
    }
    // method lấy thông tin 1 khách hàng
    private Customer getByCustomer() {
        System.out.println("Nhập Mã khách hàng");
        String idCustomer = InputValue.getString();
        for (Customer customer : DataBase.customerList) {
            if (customer.getIdCustomer().equals(idCustomer)) {
                return customer;
            }
        }
        return null;
    }
    // method xóa 1 khách hàng theo ID khách hàng
    private void deteletCustomer() {
        System.out.println("Nhập Mã Khách hàng cần Xóa");
        String idCustomer = InputValue.getString();
        if (DataBase.customerList.isEmpty()){
            System.out.println("Chưa có thông tin khách hàng nào");
            return;
        }
        Iterator<Customer> it = DataBase.customerList.iterator();
        while (it.hasNext()) {
            Customer customer = it.next();
            if (customer.getIdCustomer().equals(idCustomer)) {
                it.remove();
                System.out.println("Đã xóa thành công");
                return;
            }
        }
        System.out.println("Không Tìm thấy khách hàng nào!");
    }

    // method hiển thị chức năng tìm kiếm lịch sử
    private void showSearchHistory() {
        while (true) {
            System.out.println("1. Search history Product");
            System.out.println("2. Search history Customer");
            System.out.println("3. Search history Invoice");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 3);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    showSearchProduct();
                    break;
                case 2:
                    showSearchCustomer();
                    break;
                case 3:
                    showSearchInvoice();
                    break;
            }
        }
    }
    // methoa hiển thị chức năng tìm kiếm lịch sử của sản phẩm
    private void showSearchProduct() {
        while (true) {
            System.out.println("1. Search By ID");
            System.out.println("2. Search All");
            System.out.println("0. Back");
            int choose = InputValue.getInt(1, 2);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    // tìm kiếm theo ID sản phẩm
                    SearchHistory.searchProductById();
                    break;
                case 2:
                    // in ra toàn bộ danh sách sản phẩm
                    SearchHistory.searchAll(DataBase.historyList);
                    break;
            }
        }
    }
    // method tìm  kiếm lịch sử khách hàng
    private void showSearchCustomer() {
        while (true) {
            System.out.println("1. Search By ID");
            System.out.println("2. Search By Name");
            System.out.println("3. Search All");
            System.out.println("0. Back");
            int choose = InputValue.getInt(1, 3);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    // tìm theo ID khách hàng
                    searchCustomerByID();
                    break;
                case 2:
                    // tìm theo tên khách hàng
                    SearchHistory.searchCustomerByName();
                    break;
                case 3:
                    // in ra toàn bộ danh sách khách hàng
                    SearchHistory.searchAll(DataBase.customerList);
                    break;
            }
        }
    }
    // tìm kiếm khách hàng bằng ID và COde
    private void searchCustomerByID(){
        while (true){
            System.out.println("1. Search By ID Customer");
            System.out.println("2. Search By Code Invoice");
            System.out.println("0. Quay Lại");
            int choose = InputValue.getInt(1, 2);
            if (choose == 0){
                break;
            }
            switch (choose){
                case 1:
                    SearchHistory.searchCustomerByID();
                    break;
                case 2:
                    SearchHistory.searchCustomerByCodeInvoice();
                    break;
            }
        }
    }
    // method tìm kiếm hóa đơn
    private void showSearchInvoice() {
        while (true) {
            System.out.println("1. Search By ID");
            System.out.println("2. Search All");
            System.out.println("0. Back");
            int choose = InputValue.getInt(1, 2);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    // tìm theo mã hóa đơn
                    SearchHistory.searchInvoiceByID();
                    break;
                case 2:
                    // in toàn bộ danh sách hóa đơn
                    SearchHistory.searchAll(DataBase.invoiceList);
                    break;
            }
        }
    }

}
