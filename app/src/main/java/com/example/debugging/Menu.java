package com.example.debugging;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends AppCompatActivity implements View.OnClickListener{

    private Button buttonExit, buttonInformation, buttonNameChange, buttonNext;
    private TextView textViewName;
    private String seged = "";

    private AlertDialog alertDialog;
    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        init();
        buttonNameChange.setOnClickListener(this);
        buttonInformation.setOnClickListener(this);
        buttonExit.setOnClickListener(this);
        buttonNext.setOnClickListener(this);

    }

    public void init()
    {
        buttonExit = findViewById(R.id.buttonExit);
        buttonInformation = findViewById(R.id.buttonInformation);
        buttonNameChange = findViewById(R.id.buttonNameChange);
        buttonNext = findViewById(R.id.buttonNext);
        textViewName = findViewById(R.id.textViewName);

        SharedPreferences sharedPreferences = getSharedPreferences("Adatok", Context.MODE_PRIVATE);
        seged = sharedPreferences.getString("Nev","Nincs elmentve a neved!");
        textViewName.setText(seged);


        alertDialogBuilder = new AlertDialog.Builder(Menu.this);
        alertDialogBuilder.setMessage("Ki akarsz lépni az alkalmazásból?");
        alertDialogBuilder.setPositiveButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Menu.this, "Nem zártad be az alkalmazás!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        alertDialogBuilder.setNegativeButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialogBuilder.setNeutralButton("Mégse", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialogBuilder.setCancelable(false);
        alertDialog = alertDialogBuilder.create();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.buttonNameChange:
                Intent nameChange = new Intent(Menu.this, MainActivity.class);
                startActivity(nameChange);
                finish();
                break;
            case R.id.buttonInformation:
                Toast.makeText(this, "A neved:" + seged, Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonExit:
                break;
            case R.id.buttonNext:
                Intent next = new Intent(Menu.this,ThirdActivity.class);
                startActivity(next);
                finish();
                break;
        }
    }
}
