package com.example.unicor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.unicor.view.homepage.home;

public class MainActivity extends AppCompatActivity {
    EditText user, password;
    String userTem,passTem;
    Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userTem = "sistemas";/// usuario temporal
        passTem ="unicor"; ///contrasena temporal
        user = findViewById(R.id.txtUser);//toma de entrada del input user
        password = findViewById(R.id.txtPassword);//toma de entrada del lo input password

        loginButton = findViewById(R.id.btnIngresar);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //   login(v);
                String userLogin = user.getText().toString();
                String passwordLogin = password.getText().toString();

                if (!userLogin.isEmpty() && !passwordLogin.isEmpty()   ){
                    if (userLogin.equals(userTem.trim()) && passwordLogin.equals(passTem.trim())) {
                        alerta("usuario: "+userLogin,"");
                        deleyeTime();
                        newViewHome(v);
                    } else {
                     alerta("Upshh!  error al iniciar","Usuario o contrasena incorrectos");
                    }
                } else {
                    alerta("Upshh!  error al iniciar","campos vacios");
                }
            }
        });

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

public void deleyeTime(){
    Handler handler = new Handler();

    handler.postDelayed(new Runnable() {
        @Override
        public void run() {

        }
    }, 2000); // Tiempo de espera en milisegundos (5 segundos en este ejemplo)

// Para cancelar el tiempo de espera en cualquier momento
    handler.removeCallbacksAndMessages(null);
}

    public void newViewHome(View View){
        Intent view = new Intent(MainActivity.this, home.class);
        startActivity(view);
    }

}