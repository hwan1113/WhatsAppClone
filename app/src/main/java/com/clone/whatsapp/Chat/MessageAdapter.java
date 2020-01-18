package com.clone.whatsapp.Chat;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.clone.whatsapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
//43. Create MessageAdpater as in userListAdapter
public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    ArrayList<ChatObject> MessageList ;
    public MessageAdapter (ArrayList<ChatObject> MessageList) {
        this.MessageList = MessageList;
    }


    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, null, false);
        //For layout purpose
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);

        //recycle view
        MessageViewHolder rcv = new MessageViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, final int position) {


    }

    @Override
    public int getItemCount() {
        return MessageList.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout mLayout;
        public MessageViewHolder(View view) {
            super(view);
            mLayout = view.findViewById(R.id.layout);

        }
    }
}

