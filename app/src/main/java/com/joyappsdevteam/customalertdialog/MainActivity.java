package com.joyappsdevteam.customalertdialog;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private String hint_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hint_string = "Your Text Here";
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hintDialog(hint_string);
            }
        });


    }

    private void hintDialog(String hintString) {

        final Dialog alertDialog = new Dialog(MainActivity.this);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        alertDialog.setContentView(R.layout.hint_layout);
        Objects.requireNonNull(alertDialog.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button backButtom_Hint = alertDialog.findViewById(R.id.back_button);
        TextView hint_text = alertDialog.findViewById(R.id.hint_text);
        hint_text.setText(hintString);

        backButtom_Hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.hide();
            }
        });

        alertDialog.show();
        alertDialog.setCancelable(false);
    }
}
