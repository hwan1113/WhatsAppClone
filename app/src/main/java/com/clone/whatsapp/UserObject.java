package com.clone.whatsapp;

//25. Create User Object with name and phone
public class UserObject {

    private String name, phone;

    public UserObject(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "UserObject{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }



}
