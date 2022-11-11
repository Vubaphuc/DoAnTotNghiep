package model;

import constants.Type;

public class Account {
    private String userName;
    private String password;

    private Type type;


    public Account() {
    }

    public Account(String userName, String password, Type type) {
        this.userName = userName;
        this.password = password;
        this.type = type;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        System.out.printf("Tên tài khoản: %-s \n Mật khẩu: %-s  \n Loại: %-s",userName,password,type);
        System.out.println("----------------------------------------------------------------------------------------------------------------");
        return "";
    }
}
