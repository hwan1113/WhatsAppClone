package com.clone.whatsapp.Chat;

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
//43. Create ChatListAdpater as in userListAdapter
public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ChatListViewHolder> {

    ArrayList<ChatObject> ChatList;
    public ChatListAdapter (ArrayList<ChatObject> ChatList) {
        this.ChatList = ChatList;
    }

    @NonNull
    @Override
    public ChatListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, null, false);
        //For layout purpose
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutView.setLayoutParams(lp);

        //recycle view
        ChatListViewHolder rcv = new ChatListViewHolder(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatListViewHolder holder, final int position) {
        holder.mTitle.setText(ChatList.get(position).getChatId());


        holder.mLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            }
        });

    }

    @Override
    public int getItemCount() {
        return ChatList.size();
    }

    //    27. Extends RecyclerView.Viewholder
    public class ChatListViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitle;
        public LinearLayout mLayout;
        public ChatListViewHolder(View view) {
            super(view);
            mTitle = view.findViewById(R.id.title);
            mLayout = view.findViewById(R.id.layout);

        }
    }
}
