package com.example.getoutpolio;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Book> mData;

    public RecyclerviewAdapter(Context mContext, List<Book> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View mView =LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item_book,parent,false);
        return  new MyViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

    holder.tv_book_title.setText(mData.get(position).getTitle());
    holder.img_book_thembail.setImageResource(mData.get(position).getThembail());;

      holder.cardView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
//              Intent intent=new Intent(mContext,Book_Acitivity.class);
//              intent.putExtra("Title",mData.get(position).getTitle());
//              intent.putExtra("Description",mData.get(position).getDescripton());
//              intent.putExtra("Thembail",mData.get(position).getThembail());
//              mContext.startActivity(intent);
              Intent intent =new Intent(mContext,Book_Acitivity.class);
              mContext.startActivity(intent);
          }
      });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

     class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_book_title;
        ImageView img_book_thembail;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_book_title=(TextView) itemView.findViewById(R.id.book_title_id);
            img_book_thembail=(ImageView) itemView.findViewById(R.id.book_img_id);
            cardView=(CardView) itemView.findViewById(R.id.cardView_id);
        }





     }

}
