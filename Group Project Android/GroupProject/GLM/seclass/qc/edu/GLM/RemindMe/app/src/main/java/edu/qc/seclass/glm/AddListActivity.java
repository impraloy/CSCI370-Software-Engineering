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

public class AddListActivity extends AppCompatActivity {
    TextView titlepage, addName;
    EditText listName;
    Button btnCreateList, btnCancel;
    DatabaseReference reference;
    Integer listNum = new Random().nextInt();
    String listKey = Integer.toString(listNum);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);

        titlepage = findViewById(R.id.titlepage);

        addName = findViewById(R.id.addName);

        listName = findViewById(R.id.listName);

        btnCreateList = findViewById(R.id.btnCreateList);
        btnCancel = findViewById(R.id.btnCancel);

        btnCreateList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //upload data to firebase
                reference = FirebaseDatabase.getInstance().getReference()
                        .child("Lists").child("List" + listNum);
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        dataSnapshot.getRef().child("listName").setValue(listName.getText().toString());
                        dataSnapshot.getRef().child("listKey").setValue(listKey);

                        Intent a = new Intent(AddListActivity.this, ListActivity.class);
                        startActivity(a);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });

            }

        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(AddListActivity.this, ListActivity.class);
                startActivity(a);
            }
        });

    }
}