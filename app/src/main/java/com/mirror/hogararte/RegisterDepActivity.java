package com.mirror.hogararte;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RegisterDepActivity extends AppCompatActivity {

    EditText adress_name_edit,amount_edit, area_edit, description_edit;
    Button save_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register_dep);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        adress_name_edit = (EditText) findViewById(R.id.adress_name_edit);
        amount_edit = (EditText) findViewById(R.id.amount_edit);
        area_edit = (EditText) findViewById(R.id.area_edit);
        description_edit = (EditText) findViewById(R.id.description_edit);
        save_button = (Button) findViewById(R.id.save_button);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ejecutarServicio("http://192.168.1.6:80/webservices/insertar_departamento.php");
            }
        });
    }

   public void pushBotton(View v){
        ejecutarServicio("http://192.168.1.6:80/webservices/insertar_departamento.php");

    }
    private void ejecutarServicio(String URL) {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "OPERACION EXITOSA", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        })

        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
            Map<String, String> parametros = new HashMap<String, String>();
            parametros.put("adress", adress_name_edit.getText().toString());
            parametros.put("amount", amount_edit.getText().toString());
            parametros.put("area", area_edit.getText().toString());
            parametros.put("description", description_edit.getText().toString());
            return parametros;
            }

        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}


