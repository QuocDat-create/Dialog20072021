package com.quocdat.dialog20072021;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDialog = findViewById(R.id.btnDialog);

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Menu");
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setCancelable(false);

                String[] arrayFood = {"Chicken", "Pasta", "CoCaCola", "Salad"};
                boolean[] arrayChecked = new boolean[arrayFood.length];

                builder.setMultiChoiceItems(arrayFood, arrayChecked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                });

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int y = 0; y < arrayChecked.length; y++) {
                            if (arrayChecked[y]){
                                stringBuilder.append(arrayFood[y] + " + ");
                            }
                        }
                        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()-1);
                        Toast.makeText(MainActivity.this, "Your order is: " + stringBuilder.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();
            }
        });
    }
}