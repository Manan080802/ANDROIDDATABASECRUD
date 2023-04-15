package com.manan.productmanagement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class productadapter extends RecyclerView.Adapter<productadapter.viewholder> {
    Context context;
    ArrayList<productModel> arr;
    productadapter(Context context, ArrayList<productModel> arr)
    {
        this.context=context;
        this.arr=arr;

    }
    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.productrecycleview,parent,false);
        viewholder viewholder= new viewholder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.proname.setText(arr.get(position).name);
        holder.protype.setText(arr.get(position).type);
        Integer id = arr.get(position).id;


    }

    @Override
    public int getItemCount() {
        return arr.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {
        TextView proname,protype;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            int id= arr.get(0).id;

            proname = itemView.findViewById(R.id.proname);
            protype= itemView.findViewById(R.id.protype);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(),selectspe.class);
                    Bundle bundle = new Bundle();
                   
                    bundle.putString("name",proname.getText().toString());
                    bundle.putString("type",protype.getText().toString());
                    intent.putExtras(bundle);
                    v.getContext().startActivity(intent);

                }
            });

        }
    }
}
