package com.example.debugging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName;
    private Button buttonBelepes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        buttonBelepes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(editTextName.getText().toString().equals(""))) {
                    SharedPreferences sharedPreferences = getSharedPreferences("Adatok", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("nev", editTextName.getText().toString());
                    editor.apply();
                    Intent intent = new Intent(MainActivity.this, Menu.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "A név mezőt kötelező kitölteni!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void init()
    {
        editTextName = findViewById(R.id.editTextName);
        buttonBelepes = findViewById(R.id.buttonBelepes);
        SharedPreferences sharedPreferences = getSharedPreferences("Adatok", Context.MODE_PRIVATE);
        String seged = "";
        seged = sharedPreferences.getString("nev","Nincs elmentve a neved!");
    }
}
