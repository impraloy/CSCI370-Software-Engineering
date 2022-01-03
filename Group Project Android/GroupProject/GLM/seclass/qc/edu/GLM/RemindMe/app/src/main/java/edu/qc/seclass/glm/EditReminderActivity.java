package edu.qc.seclass.glm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditReminderActivity extends AppCompatActivity {
    EditText title, description, date, type;
    Button btnSaveUpdate, btnDelete;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_reminder);

        title = findViewById(R.id.reminderName);
        description = findViewById(R.id.reminderDesc);
        date = findViewById(R.id.reminderDate);
        type = findViewById(R.id.reminderType);

        btnSaveUpdate = findViewById(R.id.btnSaveUpdate);
        btnDelete = findViewById(R.id.btnDelete);

        // get a value from previous page
        title.setText(getIntent().getStringExtra("remindername"));
        description.setText(getIntent().getStringExtra("reminderdesc"));
        date.setText(getIntent().getStringExtra("reminderdate"));
        type.setText(getIntent().getStringExtra("remindertype"));
        String reminderKey = getIntent().getStringExtra("reminderkey");
        String subtitlename = getIntent().getStringExtra("listname");

        // get listKey
        String listKey = getIntent().getStringExtra("listkey");

        reference = FirebaseDatabase.getInstance().getReference()
                .child("Lists").child("List" + listKey).child("Reminders").child("Reminder" + reminderKey);

        // make event for update button
        btnSaveUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("reminderName").setValue(title.getText().toString());
                        dataSnapshot.getRef().child("reminderDesc").setValue(description.getText().toString());
                        dataSnapshot.getRef().child("reminderDate").setValue(date.getText().toString());
                        dataSnapshot.getRef().child("reminderType").setValue(type.getText().toString());
                        dataSnapshot.getRef().child("reminderKey").setValue(reminderKey);
                        dataSnapshot.getRef().child("listKey").setValue(listKey);

                        Intent a = new Intent(EditReminderActivity.this, ReminderActivity.class);
                        a.putExtra("listkey", listKey);
                        a.putExtra("listname", subtitlename);
                        startActivity(a);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                    }
                });
            }
        });

        // make event for delete button
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reference.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Intent a = new Intent(EditReminderActivity.this, ReminderActivity.class);
                            a.putExtra("listkey", listKey);
                            a.putExtra("listname", subtitlename);
                            startActivity(a);
                        }else{
                            Toast.makeText(getApplicationContext(), "Failed to Delete!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

    }
}