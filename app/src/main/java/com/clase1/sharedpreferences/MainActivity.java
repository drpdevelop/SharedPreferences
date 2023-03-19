package com.clase1.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etname;

    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = findViewById(R.id.name);
        save = findViewById(R.id.guardar);

        SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        etname.setText(preferences.getString("name", ""));


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardar(view);
            }
        });

    }


    public void guardar(View view){
        SharedPreferences preferen = getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_edito = preferen.edit();
        Obj_edito.putString("name", etname.getText().toString());
        Obj_edito.commit();
        finish();
    }
}