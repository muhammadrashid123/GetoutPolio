package com.example.getoutpolio;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class TaskAdapter extends FirestoreRecyclerAdapter<TaskModel, TaskAdapter.ViewHolderTask> {

    public TaskAdapter(@NonNull FirestoreRecyclerOptions<TaskModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolderTask holder, int position, @NonNull TaskModel model) {
        holder.teamTV.setText(model.getTeam());
        holder.areaTV.setText(model.getArea());
    }

    @NonNull
    @Override
    public ViewHolderTask onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list_item,parent,false);
        ViewHolderTask objViewHolderTask =new ViewHolderTask(view);
        return objViewHolderTask;
    }

    class ViewHolderTask extends RecyclerView.ViewHolder
    {
        TextView teamTV;
        TextView areaTV;

        public ViewHolderTask(@NonNull View itemView) {
            super(itemView);
            teamTV=itemView.findViewById(R.id.task_team_name_id);
            areaTV=itemView.findViewById(R.id.task_area_id);
        }
    }
}