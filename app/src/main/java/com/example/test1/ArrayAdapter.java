package com.example.test1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ArrayAdapter extends RecyclerView.Adapter<ArrayAdapter.viewHolder> {


    private ArrayList<SmsModel>smsModel=new ArrayList<>();
    private Context context;

    public ArrayAdapter(Context context){this.context=context;}

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.smsview,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.ContactsNO.setText(smsModel.get(position).getContactNumber());
        holder.SmsText.setText(smsModel.get(position).getContactSms());
        holder.Time.setText(smsModel.get(position).getTime());
        holder.Number.setText(smsModel.get(position).getNumber());


    }

    @Override
    public int getItemCount() {
        return smsModel.size();
    }

    public void setSmsModel(ArrayList<SmsModel> smsModel) {
        this.smsModel = smsModel;
        notifyDataSetChanged();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        private final TextView ContactsNO;
        private final TextView SmsText;
        private final TextView Time;
        private final TextView Number;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ContactsNO=itemView.findViewById(R.id.contactsNo);
            SmsText=itemView.findViewById(R.id.smsText);
            Time=itemView.findViewById(R.id.time);
            Number=itemView.findViewById(R.id.Number);
        }
    }
}
