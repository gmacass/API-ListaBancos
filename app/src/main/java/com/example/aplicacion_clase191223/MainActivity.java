package com.example.aplicacion_clase191223;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;

import java.util.HashMap;
import java.util.Map;

import webServices.Asynchtask;
import webServices.WebService;

public class MainActivity
        extends AppCompatActivity
        implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ClickLogin(View v) {
        Bundle bundle = this.getIntent().getExtras();
        Map<String, String> datos = new HashMap<String, String>();

        EditText txtUsr = findViewById(R.id.txtUsr);
        EditText txtClave = findViewById(R.id.txtClave);

        WebService ws= new WebService(
                "https://revistas.uteq.edu.ec/ws/login.php?usr=cristian&pass=123" + txtUsr.getText().toString() +
                        "&pass=" + txtClave.getText().toString(),
                datos,
                MainActivity.this, MainActivity.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {
        TextView txtRespuesta = findViewById(R.id.txtResp);
        txtRespuesta.setText(result);
        Intent x = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(x);

    }
}

