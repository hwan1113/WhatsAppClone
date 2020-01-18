package com.clone.whatsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.clone.whatsapp.Chat.ChatObject;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView mChat;
    private RecyclerView.Adapter mChatAdapter;
    private RecyclerView.LayoutManager mChatLayoutManager;

    ArrayList<ChatObject> messageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }

    //51. Copy initializeRecyclerView from mainPage activity.
    private void initializeRecyclerView() {
        mChat= findViewById(R.id.message);
        mChat.setNestedScrollingEnabled(false);
        mChat.setHasFixedSize(false);
        mChatLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        mChat.setLayoutManager(mChatLayoutManager);
        mChatAdapter = new ChatAdapter(messageList);
        mChat.setAdapter(mChatAdapter);
    }


}