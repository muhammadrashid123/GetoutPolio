package com.example.getoutpolio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class AreaAdapter extends FirestoreRecyclerAdapter<AreaModel,AreaAdapter.ViewHolderArea> {
    private RecyclerViewAreaClicKInterface recyclerViewAreaClicKInterface;

    public AreaAdapter(@NonNull FirestoreRecyclerOptions<AreaModel> options , RecyclerViewAreaClicKInterface recyclerViewAreaClicKInterface) {
        super(options);
        this.recyclerViewAreaClicKInterface=recyclerViewAreaClicKInterface;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolderArea holder, int position, @NonNull AreaModel model) {
        holder.nameTV.setText(model.getName());
    }

    @NonNull
    @Override
    public ViewHolderArea onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.areas_list_item,parent,false);
        ViewHolderArea objViewHolderArea=new ViewHolderArea(view);
        return objViewHolderArea;
    }

    class ViewHolderArea extends RecyclerView.ViewHolder
    {
       TextView nameTV;
          public ViewHolderArea(@NonNull View itemView) {
            super(itemView);
            nameTV=itemView.findViewById(R.id.area_name_id);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    recyclerViewAreaClicKInterface.onAreaClick(getAdapterPosition());
                }
            });
        }
    }
}
