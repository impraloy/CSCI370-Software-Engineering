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

public class ListActivity extends AppCompatActivity {

    TextView titlepage;
    TextView subtitlepage;
    Button btnAddNew;

    DatabaseReference reference;
    RecyclerView listRecycle;
    ArrayList<ListObject> listArrayList;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        titlepage = findViewById(R.id.titlepage);
        subtitlepage = findViewById(R.id.subtitlepage);

        btnAddNew = findViewById(R.id.btnAddNew);

        btnAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(ListActivity.this, AddListActivity.class);
                startActivity(a);
            }
        });

        // working with data
        listRecycle = findViewById(R.id.lists);
        listRecycle.setLayoutManager(new LinearLayoutManager(this));
        listArrayList = new ArrayList<ListObject>();

        // get data from firebase
        reference = FirebaseDatabase.getInstance().getReference().child("Lists");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // retrieve data and replace layout
                for (DataSnapshot snapshot: dataSnapshot.getChildren()) {
                    ListObject l = snapshot.getValue(ListObject.class);
                    listArrayList.add(l);
                }

                adapter = new ListAdapter(ListActivity.this, listArrayList);
                listRecycle.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                listArrayList = new ArrayList<ListObject>();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // show error when no data
                Toast.makeText(getApplicationContext(), "No Data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}