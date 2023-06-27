package com.example.myapplicationtareados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import WebService.Asynchtask;
import WebService.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void login (View view){

        //consulta
        Map<String, String> datos = new HashMap<String, String>();

        WebService ws= new WebService(
                "https://jsonplaceholder.typicode.com/users"
                ,datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");

    }

    @Override
    public void processFinish(String result) throws JSONException {

        String lista = "";
        String lista2 ="";
        String lista3 ="";

        JSONArray JSONLista = new JSONArray(result);
        for(int i=0; i< JSONLista.length();i++)
        {
            JSONObject banco= JSONLista.getJSONObject(i);
            lista = lista + "\n" + banco.getString("name").toString();
            lista2 = lista2 + "\n" + banco.getString("email").toString();
            lista3 = lista3 + "\n" + banco.getString("username").toString();

        }

        TextView txtmensaje = (TextView)findViewById(R.id. resultMensaje);
        txtmensaje.setText("Nombre:" + lista + "\n" +"Email:" + lista2 + "\n" + "Apodo" + lista3 );

    }
}