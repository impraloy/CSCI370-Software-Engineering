package edu.qc.seclass.glm;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.ReminderViewHolder> {
    Context context;
    ArrayList<ReminderObject> reminderObject;
    DatabaseReference reference;

    public ReminderAdapter(Context c, ArrayList<ReminderObject> r) {
        context = c;
        reminderObject = r;
    }

    @NonNull
    @Override
    public ReminderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_does, parent, false);
        ReminderViewHolder holder = new ReminderViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReminderViewHolder holder, int position) {
        holder.reminderName.setText(reminderObject.get(position).getReminderName());
        holder.reminderDesc.setText(reminderObject.get(position).getReminderDesc());
        holder.reminderDate.setText(reminderObject.get(position).getReminderDate());
        holder.reminderType.setText(reminderObject.get(position).getReminderType());

        if (reminderObject.get(position).getIsChecked() == null) {
            holder.checkBox.setChecked(false);
        }
        else {
            holder.checkBox.setChecked(reminderObject.get(position).getIsChecked());
        }

        // Get the title name here
        final String getReminderName = reminderObject.get(position).getReminderName();
        final String getReminderDesc = reminderObject.get(position).getReminderDesc();
        final String getReminderDate = reminderObject.get(position).getReminderDate();
        final String getReminderKey = reminderObject.get(position).getReminderKey();
        final String getReminderType = reminderObject.get(position).getReminderType();
        final String getListKey = reminderObject.get(position).getListKey();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditReminderActivity.class);
                intent.putExtra("remindername", getReminderName);
                intent.putExtra("reminderdesc", getReminderDesc);
                intent.putExtra("reminderdate", getReminderDate);
                intent.putExtra("reminderkey", getReminderKey);
                intent.putExtra("remindertype", getReminderType);
                intent.putExtra("listkey", getListKey);
                context.startActivity(intent);
            }
        });

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                final String reminderKey = getReminderKey;
                final String listKey = getListKey;
                reference = FirebaseDatabase.getInstance().getReference().child("Lists")
                        .child("List" + listKey).child("Reminders").child("Reminder" + reminderKey);
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (holder.checkBox.isChecked() == false){
                            dataSnapshot.getRef().child("isChecked").setValue(false);
                        }else{
                            dataSnapshot.getRef().child("isChecked").setValue(true);
                        }
                        reminderObject.clear();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });


    }

    @Override
    public int getItemCount() {
        return reminderObject.size();
    }

    class ReminderViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        TextView reminderName;
        TextView reminderDesc;
        TextView reminderDate;
        TextView reminderType;

        public ReminderViewHolder(@NonNull View itemView) {
            super(itemView);

            reminderName = (TextView) itemView.findViewById(R.id.reminderName);
            reminderDesc = (TextView) itemView.findViewById(R.id.reminderDesc);
            reminderDate = (TextView) itemView.findViewById(R.id.reminderDate);
            reminderType = (TextView) itemView.findViewById(R.id.reminderType);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
        }
    }
}
