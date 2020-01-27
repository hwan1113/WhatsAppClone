package com.clone.whatsapp.User;

import java.io.Serializable;

//25. Create User Object with name and phone
//86. pass Serializable in order to pass object between two activities
public class UserObject implements Serializable {

    private String name, phone, uid, notificationKey;

    //89. add this line for group chat purpose
    private Boolean selected = false;



    //83. create this for data info purpose
    public UserObject (String uid) {
        this.uid = uid;
    }

    public UserObject(String name, String phone, String uid) {
        this.name = name;
        this.phone = phone;
        this.uid = uid;
    }

    public String getNotificationKey() {
        return notificationKey;
    }

    public void setNotificationKey(String notificationKey) {
        this.notificationKey = notificationKey;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getUid() { return uid; }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }
}
