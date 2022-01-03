package edu.qc.seclass.glm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

public class ReminderActivity extends AppCompatActivity {

    TextView titlepage;
    TextView subtitlepage;
    Button btnAddNew;
    Button btnUncheckAll;

    DatabaseReference reference;
    RecyclerView reminderRecycle;
    ArrayList<ReminderObject> reminderArrayList;
    ReminderAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        titlepage = findViewById(R.id.titlepage);
        subtitlepage = findViewById(R.id.subtitlepage);

        btnAddNew = findViewById(R.id.btnAddNew);
        btnUncheckAll = findViewById(R.id.btnUncheckAll);

        String subtitlename = getIntent().getStringExtra("listname");
        subtitlepage.setText(subtitlename);

        // get listKey
        String listKey = getIntent().getStringExtra("listkey");

        // add button
        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ReminderActivity.this, AddReminderActivity.class);
                a.putExtra("listkey", listKey);
                a.putExtra("listname", subtitlename);
                startActivity(a);
            }
        });

        // working with data
        reminderRecycle = findViewById(R.id.reminders);
        reminderRecycle.setLayoutManager(new LinearLayoutManager(this));
        reminderArrayList = new ArrayList<ReminderObject>();

        // get data from firebase
        reference = FirebaseDatabase.getInstance().getReference()
                .child("Lists").child("List" + listKey).child("Reminders");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                reminderArrayList = new ArrayList<ReminderObject>();
                // retrieve data and replace layout
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    ReminderObject r = snapshot.getValue(ReminderObject.class);
                    reminderArrayList.add(r);
                }

                Collections.sort(reminderArrayList);
                adapter = new ReminderAdapter(ReminderActivity.this, reminderArrayList);
                reminderRecycle.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // show error when no data
                Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();
            }
        });

        // titlepage is go back button
        titlepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ReminderActivity.this, ListActivity.class);
                a.putExtra("listkey", listKey);
                a.putExtra("listname", subtitlename);
                startActivity(a);
            }
        });

        btnUncheckAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (ReminderObject i: reminderArrayList){
                    if(i.isChecked == true){
                        i.isChecked = false;
                    }
                }
                adapter.notifyDataSetChanged();
            }
        });

    }
}