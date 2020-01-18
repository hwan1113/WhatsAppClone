package com.clone.whatsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.clone.whatsapp.Chat.ChatListAdapter;
import com.clone.whatsapp.Chat.ChatObject;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainPageActivity extends AppCompatActivity {

    //40. Add this field as in FindUserActivity
    private RecyclerView mChatList;
    private RecyclerView.Adapter mChatListAdapter;
    private RecyclerView.LayoutManager mChatListLayoutManager;

    ArrayList<ChatObject> chatList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        //13. Get the Logout Component.
        Button mLogout = findViewById(R.id.logout);
        //19. Get the findUser Component.
        Button mFindUser = findViewById(R.id.findUser);

        //14. Make the eventlistener of the Logout button
        mLogout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent (getApplicationContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                return;

            }
        });
        //20. Make the eventlistener of the findUser button
        mFindUser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               startActivity(new Intent(getApplicationContext(), FindUserActivity.class));

            }
        });

//      28. Add get permission methods
        getPermissions();
//      42. Initialize RecyclerView
        initializeRecyclerView();
//      48. Call user chat list function.
//        getUserChatList();


    }

    private void getPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.WRITE_CONTACTS, Manifest.permission.READ_CONTACTS}, 1);
        }
    }
    //41. Create this methods as in FindUserActivity.
    private void initializeRecyclerView() {
        mChatList= findViewById(R.id.chatList);
        mChatList.setNestedScrollingEnabled(false);
        mChatList.setHasFixedSize(false);
        mChatListLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false);
        mChatList.setLayoutManager(mChatListLayoutManager);
        mChatListAdapter = new ChatListAdapter(chatList);
        mChatList.setAdapter(mChatListAdapter);
    }
// 46. Create a method to get the user chat list
    private void getUserChatList () {
        DatabaseReference mUserChatDB = FirebaseDatabase.getInstance().getReference().child("user").child(FirebaseAuth.getInstance().getUid()).child("chat");
        mUserChatDB.addValueEventListener(new ValueEventListener() {
            //47. Put the chat object into the chatList
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()) {
                    for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                        ChatObject mChat = new ChatObject(childSnapshot.getKey());
                        boolean exists = false;
//                      49. Create a function to prevent creating multiple chat ID
                        for (ChatObject mChatIterator : chatList) {
                            if (mChatIterator.getChatId().equals(mChat.getChatId())) {
                                exists = true;
                            }
                        }
                        if (exists)
                            continue;
                        chatList.add(mChat);
                        mChatListAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
