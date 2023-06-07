

package com.example.roomdata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {

    private Context context;
    private List<User> userList;
    private OnUserClickListener userClickListener;

    public UserListAdapter(Context context, OnUserClickListener userClickListener) {
        this.context = context;
        this.userList = new ArrayList<>();
        this.userClickListener = userClickListener;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.MyViewHolder holder, int position) {
        holder.tvFirstName.setText(this.userList.get(position).FirstName);
        holder.tvLastName.setText(this.userList.get(position).LastName);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userClickListener != null) {
                    userClickListener.onUserClick(position);
                }
            }
        });
    }
    public void deleteUser(int position) {
        // Check if the position is within the valid range
        if (position >= 0 && position < userList.size()) {
            userList.remove(position);
            notifyItemRemoved(position);
        }
    }
    @Override
    public int getItemCount() {
        return userList.size();
    }
    public interface OnUserClickListener {
        void onUserClick(int position);
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvLastName;
        TextView tvFirstName;

        public MyViewHolder(View view) {
            super(view);
            tvFirstName = view.findViewById(R.id.tvFirstName);
            tvLastName = view.findViewById(R.id.tvLastName);
        }
    }
}
