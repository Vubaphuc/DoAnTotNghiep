package services;

import constants.Status;
import database.DataBase;
import model.*;
import utils.InputValue;
import utils.SearchHistory;

import java.time.LocalDate;
import java.util.Iterator;

public class EmployeeFontService implements IService {
    // màn hình chính chức năng nhan viên suar chữa Font
    public void showFunction() {
        while (true) {
            System.out.println("1. Output Product");
            System.out.println("2. Seach History Product");
            System.out.println("3. Oder Vật Liệu");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 3);
            if (choose == 0) {
                DataBase.employee = null;
                break;
            }
            switch (choose) {
                case 1:
                    showOutputProduct();
                    break;
                case 2:
                    searchHistoryProduct();
                    break;
                case 3:
                    showOderMaterial();
                    break;
            }
        }
    }
    // chức năng oder vật liệu về thay thế
    private void showOderMaterial() {
        while (true) {
            System.out.println("1. Tạo hóa đơn Oder Material");
            System.out.println("2. Search history Hóa Đơn Oder Material");
            System.out.println("0. Quay lại");
            int choose = InputValue.getInt(1, 2);
            if (choose == 0) {
                break;
            }
            switch (choose) {
                case 1:
                    createInvoiceMaterial();
                    break;
                case 2:
                    searchHistoryInvoiceOderMaterial();
                    break;
            }
        }
    }
    // tìm kiêếm lịch sử hóa đơn oder vật liệu
    private void searchHistoryInvoiceOderMaterial(){
        while (true) {
            System.out.println("1. Search By Id");
            System.out.println("2. Search All History");
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
    // tạo 1 hóa đơn oder vật liệu mới
    private void createInvoiceMaterial() {
        System.out.println("Nhập code hóa đơn");
        String codeInvoice = InputValue.checkCodeInvoiceMaterial();
        if (codeInvoice == null){
            return;
        }
        System.out.println("Nhập ID Vật liệu");
        String idMaterial = InputValue.getString();
        Material material = getMaterial(idMaterial);
        if (material == null){
            System.out.println("Không có vật liệu nào");
            return;
        }
        Employee employee = DataBase.employee;
        System.out.println("Nhập số lượng Oder");
        int amountOder = InputValue.getInputInt();
        LocalDate dayOder = LocalDate.now();
        InvoiceMaterial invoiceMaterial = new InvoiceMaterial(codeInvoice,material,employee,amountOder,dayOder);
        DataBase.invoiceMaterialList.add(invoiceMaterial);
    }
    // lấy ra 1 material
    private Material getMaterial(String idMaterial) {
        for (Material material : DataBase.materialList){
            if (material.getIdMaterial().equals(idMaterial)){
                return material;
            }
        }
        return null;
    }
    // tìm kiếm lịch sử Product
    private void searchHistoryProduct() {
        while (true) {
            System.out.println("1. Search By Id");
            System.out.println("2. Search All History");
            System.out.println("0. Quay lại");
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

    // output sản phẩm
    private void showOutputProduct() {
        System.out.println("Nhập ID sản phẩm");
        String idProduct = InputValue.getString();
        if (DataBase.historyList.isEmpty()){
            System.out.println("Không có thông tin nào");
            return;
        }
        for (History history : DataBase.historyList) {
            if (history.equals(idProduct)) {
                System.out.println("Nhập vị trí lỗi");
                String location = InputValue.getString();
                Status status = checkStatus();
                LocalDate dayInput = LocalDate.now();
                history.setLocation(location);
                history.setStatusFuncion(status);
                history.setDayInputFuncion(dayInput);
            }
        }
    }
    // check trạng thái sản phẩm
    private Status checkStatus() {
        Status status = null;
        System.out.println("Chọn trạng thái sản phẩm");
        System.out.println("1. OK " +
                "2. Hỏng");

        int choose = InputValue.getInt(1, 2);
        if (choose == 0 && choose > 2) {
            return checkStatus();
        }
        switch (choose) {
            case 1:
                status = Status.OK;
                break;
            case 2:
                status = Status.NG;
                break;
        }
        return status;
    }
}
