package com.gowoo.recyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.MyViewHolder> {
    private ArrayList<User> usersList;

    public recyclerAdapter(ArrayList<User> usersList) {
        this.usersList = usersList;
    }
    private View.OnClickListener mOnClickListerner;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView nameText;
        private ConstraintLayout box;

        public MyViewHolder(final View view){
            super(view);
            nameText = view.findViewById(R.id.textView2);
            box =view.findViewById(R.id.box);
        }
    }

    @NonNull
    @Override
    public recyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerAdapter.MyViewHolder holder, int position) {
        String name = usersList.get(position).getUsername();
        holder.nameText.setText(name);
        holder.box.setOnClickListener(view -> {
            Toast.makeText(view.getContext(), "You clicked on "+name, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
}
