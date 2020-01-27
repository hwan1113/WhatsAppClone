package com.clone.whatsapp.Chat;

import com.clone.whatsapp.User.UserObject;

import java.io.Serializable;
import java.util.ArrayList;

//44.Create ChatObject
public class ChatObject implements Serializable {
    private String chatId;

    //83. Create this field and add function for info purpose
    private ArrayList<UserObject> userObjectArrayList = new ArrayList<>();

    public ChatObject(String chatId) {
        this.chatId = chatId;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public ArrayList<UserObject> getUserObjectArrayList() {
        return userObjectArrayList;
    }
    public void setUserObjectArrayList(ArrayList<UserObject> userObjectArrayList) {
        this.userObjectArrayList = userObjectArrayList;
    }

    public void addUserToArrayList (UserObject mUser) {
        userObjectArrayList.add(mUser);
    }

}
