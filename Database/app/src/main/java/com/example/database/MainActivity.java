package com.example.database;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        MyDBHelper myDBHelper = new MyDBHelper(this);

//        myDBHelper.addContact("Karan", "9876543210");
//        myDBHelper.addContact("John", "8876545510");
//        myDBHelper.addContact("William", "9876543210");
//        myDBHelper.addContact("Johnny", "7876543210");
//        myDBHelper.addContact("Leena", "9886543210");
//        myDBHelper.addContact("Will", "9896543210");

//        ContactModel contactModel = new ContactModel();
//        contactModel.id = 1;
//        contactModel.name = "Raman";
//        contactModel.phone_no = "9853489756";
//        myDBHelper.updateContact(contactModel);

        myDBHelper.deleteContact(2);

        ArrayList<ContactModel> arrContacts = myDBHelper.fetchContacts();
        for (int i = 0; i < arrContacts.size(); i++){
            Log.d("CONTACT_INFO", "Name: " + arrContacts.get(i).name+", Phone No: " + arrContacts.get(i).phone_no);

        }

    }
}