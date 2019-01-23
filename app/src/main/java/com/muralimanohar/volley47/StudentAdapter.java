package com.muralimanohar.volley47;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/****
 *
 *
 *
 * RecyclerView.Adapter
 * RecyclerView.ViewHolder
 *
 *
 */
public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {

    Context mCtx;
    List<Studendconstant> studendconstantslist;

    public StudentAdapter(Context mCtx, List<Studendconstant> studendconstantslist) {
        this.mCtx = mCtx;
        this.studendconstantslist = studendconstantslist;
    }

    @NonNull

    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(mCtx);
        View view = layoutInflater.inflate(R.layout.list_layout, null);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int i) {
        Studendconstant studendconstant = studendconstantslist.get(i);
        holder.firstname.setText(studendconstant.getFirstname());
        holder.lastname.setText(studendconstant.getSecondname());
        holder.age.setText(studendconstant.getAge());

    }

    @Override
    public int getItemCount() {
        return studendconstantslist.size();
    }

    class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView firstname, lastname, age;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            firstname = itemView.findViewById(R.id.list_firstname);
            lastname = itemView.findViewById(R.id.list_secondname);
            age = itemView.findViewById(R.id.list_age);
        }
    }
}
