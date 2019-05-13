package com.avme.alexa.tutorialvolley;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EdgeEffect;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText etUsuario;
    private EditText etPass;
    private String urlLogin = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario=(EditText) findViewById(R.id.etUser);
        etPass=(EditText) findViewById(R.id.etPass);
    }

    public void btnAceptar(View view){
        final String usuario=etUsuario.getText().toString();
        final String password=etPass.getText().toString();

        //Iniciar la conexion con Volley
        StringRequest request = new StringRequest(Request.Method.POST, urlLogin,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // SE EJECUTA CUANDO LA CONSULTA SALIO BIEN, SIN ERRORES
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // SE EJECUTA CUANDO ALGO SALIO MAL AL INTENTAR HACER LA CONEXION

                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                //  AQUI SE ENVIARAN LOS DATOS EMPAQUETADOS EN UN OBJETO MAP<clave, valor>
                Map<String, String> parametros = new HashMap<>();
                parametros.put("usuario", usuario);
                parametros.put("contraseña", password);
                return parametros;
            }
        };
    }
}
