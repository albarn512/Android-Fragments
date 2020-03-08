package com.example.fragments;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private Context context;
    private ArrayList<CartModel> cartList = new ArrayList<>();

    public ArrayList<CartModel> getCartList(){
        return cartList;
    }
    public CartAdapter(ArrayList<CartModel> cartList, Context context) {
        this.cartList = cartList;
        this.context = context;
    }
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.item_list,viewGroup,false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final  int i) {
        viewHolder.ivItem.setImageResource(getCartList().get(i).getThumb());
        viewHolder.tvItem.setText(getCartList().get(i).getNama());
        viewHolder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String nama = "Kau memesan " + getCartList().get(i).getNama();
                intent.putExtra(Intent.EXTRA_TEXT, nama);
                context.startActivity(Intent.createChooser(intent, "Share Using"));
            }
        });
        viewHolder.btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CartDetail.class);
                intent.putExtra("img_url", getCartList().get(i).getThumb());
                intent.putExtra("title", getCartList().get(i).getNama());
                intent.putExtra("detail", getCartList().get(i).getDes());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return getCartList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivItem;
        TextView tvItem;
        Button btnLihat, btnShare;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivItem = itemView.findViewById(R.id.iv_item);
            tvItem = itemView.findViewById(R.id.tv_itemjudul);
            btnLihat = itemView.findViewById(R.id.btnDetail);
            btnShare = itemView.findViewById(R.id.btnShare);
        }
    }
}
