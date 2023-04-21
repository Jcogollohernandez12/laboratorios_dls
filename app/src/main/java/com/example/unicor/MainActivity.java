package com.example.unicor;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.unicor.models.Users;
import com.example.unicor.view.NavDrawer;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText user, password;
   Users usuario;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Bienvenido");

        usuario = new Users();

        user = findViewById(R.id.txtUser);//toma de entrada del input user
        password = findViewById(R.id.txtPassword);//toma de entrada del lo input password
        loginButton = findViewById(R.id.btnIngresar);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //   login(v);
                new TaskLogin().execute();
            }
        });

    }

    class TaskLogin extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
          //  login_progress.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s) {
           // login_progress.setVisibility(View.INVISIBLE);
            newViewHome(s);
        }

        @Override
        protected String doInBackground(String... strings) {
            String resultValidateInfo = "";
            try {
                Thread.sleep(2000);
                resultValidateInfo = validateInfo();

        return resultValidateInfo;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "true";
        }
    }


    private String validateInfo() {
        String userLogin = user.getText().toString();
        String passwordLogin = password.getText().toString();
        if (!userLogin.isEmpty() && !passwordLogin.isEmpty() ) {
            if (userLogin.equals(usuario.getUser().trim()) && passwordLogin.equals(usuario.getPassword().trim())){
                return "true";
            }
          else{
              return "Usuario o contrasena incorrectos";
          }
        }
        else {
            return "Campos Vacios";
        }
    }



public void alerta(String title, String contet){
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle(title);
    builder.setMessage(contet);
  //builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
  //    @Override
  //    public void onClick(DialogInterface dialog, int which) {
  //        // Acción a realizar cuando se presione el botón de aceptar
  //    }
  //});
    builder.show();
}

    public void newViewHome(String result){
        if (result.equalsIgnoreCase("true")) {
            Intent view = new Intent(MainActivity.this, NavDrawer.class);
            startActivity(view);
        }else{
            alerta("Upss! error al iniciar", result);
        }
    }

}