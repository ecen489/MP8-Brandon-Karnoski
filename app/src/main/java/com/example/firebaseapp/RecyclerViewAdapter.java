package com.example.firebaseapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mStudents = new ArrayList<>();
    private ArrayList<String> mClass = new ArrayList<>();
    private ArrayList<String> mClassGrade = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> mStudents, ArrayList<String> mClass, ArrayList<String> mClassGrade, Context mContext) {
        this.mStudents = mStudents;
        this.mClass = mClass;
        this.mClassGrade = mClassGrade;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d(TAG, "onBindViewHolder: called.");
        viewHolder.student.setText(mStudents.get(i));
        viewHolder.className.setText(mClass.get(i));
        viewHolder.classGrade.setText(mClassGrade.get(i));
    }

    @Override
    public int getItemCount() {
        return mStudents.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView className;
        TextView classGrade;
        TextView student;
        LinearLayout parentLayout;
        public ViewHolder(View itemView){
            super(itemView);
            className = itemView.findViewById(R.id.className);
            classGrade = itemView.findViewById(R.id.classGrade);
            student = itemView.findViewById(R.id.student);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
