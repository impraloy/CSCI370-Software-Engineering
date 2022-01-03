package edu.qc.seclass.glm;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    Context context;
    ArrayList<ListObject> listObject;

    public ListAdapter(Context c, ArrayList<ListObject> l) {
        context = c;
        listObject = l;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_does, parent, false);
        ListViewHolder holder = new ListViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.listName.setText(listObject.get(position).getListName());

        // Get the title name here
        final String getListName = listObject.get(position).getListName();
        final String getListKey = listObject.get(position).getListKey();
        final ArrayList<ReminderObject> getReminders = listObject.get(position).getReminders();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ReminderActivity.class);
                intent.putExtra("listname", getListName);
                intent.putExtra("listkey", getListKey);
                intent.putExtra("listreminders", getReminders);
                context.startActivity(intent);
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent intent = new Intent(context, EditListActivity.class);
                intent.putExtra("listname", getListName);
                intent.putExtra("listkey", getListKey);
                intent.putExtra("listreminders", getReminders);
                context.startActivity(intent);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listObject.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        TextView listName;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            listName = (TextView) itemView.findViewById(R.id.listName);
        }
    }
}
