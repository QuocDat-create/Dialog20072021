package com.quocdat.dialog20072021;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
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

                AppDialog.createDialogRating(MainActivity.this, new OnListenerRating() {
                    @Override
                    public void onRatingChanges(float star) {
                        Log.d("BBB", "star");
                        Toast.makeText(MainActivity.this, "ban chon " + star + " sao", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}