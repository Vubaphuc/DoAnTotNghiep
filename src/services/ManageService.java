package services;

import constants.Type;
import database.DataBase;
import model.Account;
import model.Employee;
import utils.InputValue;
import utils.SearchHistory;

import java.util.Iterator;

public class ManageService implements IService {
    //màn hình chính của Quản lý
    public void showFunction() {
        while (true) {
            System.out.println("1. Thay đổi công việc nhân viên");
            System.out.println("2. Thêm tài khoản");
            System.out.println("3. Đổi mật khẩu tài khoản");
            System.out.println("4. Search History");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 4);
            if (choose == 0) {
                DataBase.employee = null;
                break;
            }
            switch (choose) {
                case 1:
                    changeWorkEmployee();
                    break;
                case 2:
                    showAddAcc();
                    break;
                case 3:
                    changePasswordAcc();
                    break;
                case 4:
                    showSearchHistoryFunction();
                    break;
            }
        }
    }


    private void changePasswordAcc() {
        System.out.println("Nhập tài khoản cần thay đổi");
        String userName = InputValue.getString();
        boolean ketQuaCheckAcc = InputValue.checkAccount(userName);
        if (ketQuaCheckAcc == true) {
            System.out.println("Nhập mật khẩu mới");
            String newPassword = InputValue.getString();
            Iterator<Account> it = DataBase.accountsList.iterator();
            while (it.hasNext()) {
                Account account = it.next();
                if (account.equals(userName)) {
                    account.setPassword(newPassword);
                    System.out.println("Đã thay đổi thành công");
                }
            }
        }
        if (ketQuaCheckAcc == false) {
            System.out.println("Tài khoản không tồn tại");
        }
    }

    public void showAddAcc() {
        String userName = InputValue.getIDEmployee();
        System.out.println("Nhập Mật Khẩu");
        String password = InputValue.getString();
        System.out.println("Nhập loại nhân viên");
        Type type = inputType();
        Account account = new Account(userName, password, type);
        DataBase.accountsList.add(account);
    }

    private void changeWorkEmployee() {
        System.out.println("Nhập ID Nhân Viên cần thay đổi");
        String idNhanVien = InputValue.getString();
        boolean ketQuaCheckID = InputValue.checkEmployee(idNhanVien);
        if (ketQuaCheckID == true) {
            Type type = inputType();
            Iterator<Employee> it = DataBase.employeeList.iterator();
            while (it.hasNext()) {
                Employee employee = it.next();
                if (employee.getIdNhanVien().equals(idNhanVien)) {
                    employee.setType(type);
                    System.out.println("Đã thay đổi thành công");
                }
            }
        }
        if (ketQuaCheckID == false) {
            System.out.println("Nhân Viên không tồn tại");
        }
    }

    private Type inputType() {
        Type type = null;
        System.out.println("1. Nhân Viên Lễ Tân " +
                "2. Nhân viên WIP " +
                "3. Nhân Viên sửa chữa Font " +
                "4. Nhân viên sửa chữa phần mềm " +
                "5. Nhân viên sửa chữa PBA " +
                "6. Nhân viên Kho ");
        int choose = InputValue.getInt(1, 6);
        switch (choose) {
            case 1:
                type = Type.NHANVIENLETAN;
                break;
            case 2:
                type = Type.NHANVIENWIP;
                break;
            case 3:
                type = Type.NHANVIENSUAFONT;
                break;
            case 4:
                type = Type.NHANVIENSUAPHANMEM;
                break;
            case 5:
                type = Type.NHANVIENSUAPCB;
                break;
            case 6:
                type = Type.NHANVIENKHO;
                break;
        }
        return type;
    }

    private void showSearchHistoryFunction() {
        while (true) {
            System.out.println("1. Search history Product");
            System.out.println("2. Search history Customer");
            System.out.println("3. Search history Invoice");
            System.out.println("4. Search history Employee");
            System.out.println("5. Search history Account");
            System.out.println("6. Search History Material");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 6);
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
                case 4:
                    showSearchEmployee();
                    break;
                case 5:
                    showSearchAccount();
                    break;
                case 6:
                    showSearchMaterial();
                    break;
            }
        }
    }

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
                    SearchHistory.searchProductById();
                    break;
                case 2:
                    SearchHistory.searchAll(DataBase.historyList);
                    break;
            }
        }
    }

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
                    SearchHistory.searchCustomerByID();
                    break;
                case 2:
                    SearchHistory.searchCustomerByName();
                    break;
                case 3:
                    SearchHistory.searchAll(DataBase.invoiceList);
                    break;
            }
        }
    }

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
                    SearchHistory.searchInvoiceByID();
                    break;
                case 2:
                    SearchHistory.searchAll(DataBase.invoiceList);
                    break;
            }
        }
    }

    private void showSearchEmployee() {
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
                    SearchHistory.searchEmployeeByID();
                    break;
                case 2:
                    SearchHistory.searchAll(DataBase.employeeList);
                    break;
            }
        }
    }

    private void showSearchAccount() {
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
                    SearchHistory.searchAccountByID();
                    break;
                case 2:
                    SearchHistory.searchAll(DataBase.accountsList);
                    break;
            }
        }
    }
    private void showSearchMaterial() {
        while (true) {
            System.out.println("1. Search History Invoice Material");
            System.out.println("2. Search History Input Material");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 2);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    searchInvoiceMaterial();
                    break;
                case 2:
                    searchInputMaterial();
                    break;
            }
        }
    }

    private void searchInputMaterial() {
        while (true) {
            System.out.println("1. Search By Code");
            System.out.println("2. Search All Invoice Material");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 2);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    SearchHistory.searchInputMaterialByID();
                    break;
                case 2:
                    SearchHistory.searchAll(DataBase.inPutMaterialList);
                    break;
            }
        }
    }

    private void searchInvoiceMaterial() {
        while (true) {
            System.out.println("1. Search By Code");
            System.out.println("2. Search All Invoice Material");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 2);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    SearchHistory.searchInvoiceOderMaterialByCode();
                    break;
                case 2:
                    SearchHistory.searchAll(DataBase.invoiceMaterialList);
                    break;
            }
        }
    }

}
