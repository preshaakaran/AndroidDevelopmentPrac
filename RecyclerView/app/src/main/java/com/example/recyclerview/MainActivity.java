package com.example.recyclerview;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ContactModel> arrContacts = new ArrayList<>();
    FloatingActionButton btnOpenDialog;
    RecyclerContactAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerContact);
        btnOpenDialog = findViewById(R.id.btnOpenDialog);

        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_update_lay);
                EditText edtName = dialog.findViewById(R.id.edtName);
                EditText edtNumber = dialog.findViewById(R.id.edtNumber);
                Button btnAction = dialog.findViewById(R.id.btnAction);

                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name="",number="";

                        if(!edtName.getText().toString().equals("")){
                            name =edtName.getText().toString();
                        } else{
                            Toast.makeText(MainActivity.this,"Please Enter Contact Name!",Toast.LENGTH_SHORT);
                        }
                        if(!edtNumber.getText().toString().equals("")){
                            number=edtNumber.getText().toString();

                        } else{
                            Toast.makeText(MainActivity.this,"Please Enter Contact Number!",Toast.LENGTH_SHORT);

                        }

                        arrContacts.add(new ContactModel(R.drawable.baseline_portrait_24, name,number));
                        adapter.notifyItemInserted(arrContacts.size()-1);
                        recyclerView.scrollToPosition(arrContacts.size()-1);
                        dialog.dismiss();



                    }
                });

                dialog.show();

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        ContactModel model =new ContactModel(R.drawable.baseline_portrait_24, "A","9182545727");
//        arrContacts.add(model);
        arrContacts.add(new ContactModel(R.drawable.baseline_portrait_24, "A","9182545727"));
        arrContacts.add(new ContactModel(R.drawable.baseline_portrait_24, "B","9182874698"));
        arrContacts.add(new ContactModel(R.drawable.baseline_portrait_24, "C","9182826375"));
        arrContacts.add(new ContactModel(R.drawable.baseline_portrait_24, "D","9182241326"));
        arrContacts.add(new ContactModel(R.drawable.baseline_portrait_24, "E","9634577577"));
        arrContacts.add(new ContactModel(R.drawable.baseline_portrait_24, "F","9543675377"));
        arrContacts.add(new ContactModel(R.drawable.baseline_portrait_24, "G","9476867946"));
        arrContacts.add(new ContactModel(R.drawable.baseline_portrait_24, "H","8782545727"));
        arrContacts.add(new ContactModel(R.drawable.baseline_portrait_24, "I","8792545727"));
        arrContacts.add(new ContactModel(R.drawable.baseline_portrait_24, "A","9182545727"));
        arrContacts.add(new ContactModel(R.drawable.baseline_portrait_24, "B","9182874698"));
        arrContacts.add(new ContactModel(R.drawable.baseline_portrait_24, "C","9182826375"));
        arrContacts.add(new ContactModel(R.drawable.baseline_portrait_24, "D","9182241326"));
        arrContacts.add(new ContactModel(R.drawable.baseline_portrait_24, "E","9634577577"));
        arrContacts.add(new ContactModel(R.drawable.baseline_portrait_24, "F","9543675377"));
        arrContacts.add(new ContactModel(R.drawable.baseline_portrait_24, "G","9476867946"));
        arrContacts.add(new ContactModel(R.drawable.baseline_portrait_24, "H","8782545727"));
        arrContacts.add(new ContactModel(R.drawable.baseline_portrait_24, "I","8792545727"));
        arrContacts.add(new ContactModel(R.drawable.baseline_portrait_24, "J","9362545727"));
        adapter = new RecyclerContactAdapter(this,arrContacts);
        recyclerView.setAdapter(adapter);







    }
}