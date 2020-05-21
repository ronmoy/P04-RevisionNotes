package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    RadioGroup rg1;
    Button b1, b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.editTextNote);
        rg1 = findViewById(R.id.radioGroupStars);
        b1 = findViewById(R.id.buttonInsertNote);
        b2 = findViewById(R.id.buttonShowList);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                db.insertNote(et1.getText().toString(), Integer.parseInt(((RadioButton) rg1.getChildAt(rg1.indexOfChild(rg1.findViewById(rg1.getCheckedRadioButtonId())))).getText().toString()));
                //yes i am genius
                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_LONG).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
