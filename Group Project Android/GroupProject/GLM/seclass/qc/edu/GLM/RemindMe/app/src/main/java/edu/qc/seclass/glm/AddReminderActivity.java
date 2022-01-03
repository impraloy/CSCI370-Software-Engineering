package edu.qc.seclass.glm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class AddReminderActivity extends AppCompatActivity {
    TextView titlepage, addName, addDesc, addDate, addType;
    EditText reminderName, reminderDesc, reminderDate, reminderType;
    Button btnCreateReminder , btnCancel;
    DatabaseReference reference;
    Integer reminderNum = new Random().nextInt();
    String reminderKey = Integer.toString(reminderNum);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);

        titlepage = findViewById(R.id.titlepage);

        addName = findViewById(R.id.addName);
        addDesc = findViewById(R.id.addDesc);
        addDate = findViewById(R.id.addDate);
        addType = findViewById(R.id.addType);

        reminderName = findViewById(R.id.reminderName);
        reminderDesc = findViewById(R.id.reminderDesc);
        reminderDate = findViewById(R.id.reminderDate);
        reminderType = findViewById(R.id.reminderType);

        btnCreateReminder = findViewById(R.id.btnCreateReminder);
        btnCancel = findViewById(R.id.btnCancel);

        // get data from previous page
        String listKey = getIntent().getStringExtra("listkey");
        String subtitlename = getIntent().getStringExtra("listname");

        // make event for create reminder button
        btnCreateReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //upload data to firebase
                reference = FirebaseDatabase.getInstance().getReference()
                        .child("Lists").child("List" + listKey).child("Reminders").child("Reminder" + reminderKey);
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("reminderName").setValue(reminderName.getText().toString());
                        dataSnapshot.getRef().child("reminderDesc").setValue(reminderDesc.getText().toString());
                        dataSnapshot.getRef().child("reminderDate").setValue(reminderDate.getText().toString());
                        dataSnapshot.getRef().child("reminderType").setValue(reminderType.getText().toString());
                        dataSnapshot.getRef().child("reminderKey").setValue(reminderKey);
                        dataSnapshot.getRef().child("isChecked").setValue(false);
                        dataSnapshot.getRef().child("listKey").setValue(listKey);

                        Intent a = new Intent(AddReminderActivity.this, ReminderActivity.class);
                        a.putExtra("listkey", listKey);
                        a.putExtra("listname", subtitlename);
                        startActivity(a);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        // make event for cancel button
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(AddReminderActivity.this, ReminderActivity.class);
                a.putExtra("listkey", listKey);
                a.putExtra("listname", subtitlename);
                startActivity(a);
            }
        });

    }
}