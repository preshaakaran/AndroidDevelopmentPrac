package com.example.roomlibrary;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtText;
    EditText edtAmount;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtText = findViewById(R.id.edtText);
        edtAmount = findViewById(R.id.edtAmount);
        btn = findViewById(R.id.btn);

        DatabaseHelper databaseHelper = DatabaseHelper.geetDB(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = edtText.getText().toString();
                String amount = edtAmount.getText().toString();

                databaseHelper.expenseDao().addTx(

                        new Expense(title, amount)

                );

                ArrayList<Expense> arrExpenses = (ArrayList<Expense>) databaseHelper.expenseDao().getAllExpense();

                for(int i=0;i<arrExpenses.size();i++){
                    Log.d("Data", "Title: "+arrExpenses.get(i).getTitle() + "Amount: "+arrExpenses.get(i).getAmount());
                }

            }
        });


    }
}