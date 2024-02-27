package com.nuon.computer;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Activity activity;
    private ArrayList<String> Id, Name, Quantity, Price;

    public CustomAdapter(
            DataActivity mainActivity,
            Activity activity,
            ArrayList<String> Id,
            ArrayList<String> Name,
            ArrayList<String> Quantity,
            ArrayList<String> Price) {
        this.activity = activity;
        this.Id = Id;
        this.Name = Name;
        this.Quantity = Quantity;
        this.Price = Price;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.IdTxt.setText(Id.get(position));
        holder.NameTxt.setText(Name.get(position));
        holder.QuantityTxt.setText(Quantity.get(position));
        holder.PriceTxt.setText(Price.get(position));


        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, UpdateActivity.class);
                intent.putExtra("id", Id.get(position));
                intent.putExtra("name", Name.get(position));
                intent.putExtra("quantity", Quantity.get(position));
                intent.putExtra("price", Price.get(position));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView IdTxt, NameTxt, QuantityTxt, PriceTxt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            IdTxt = itemView.findViewById(R.id.id_txt);
            NameTxt = itemView.findViewById(R.id.name_txt);
            QuantityTxt = itemView.findViewById(R.id.quantity_txt);
            PriceTxt = itemView.findViewById(R.id.price_txt);

            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
