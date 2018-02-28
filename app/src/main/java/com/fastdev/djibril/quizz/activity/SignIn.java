package com.fastdev.djibril.quizz.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fastdev.djibril.quizz.R;

public class SignIn extends AppCompatActivity {
    EditText email,password;
    Button btn_connexion;
    TextView link_singn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Create_cmpt.class));
            }
        });
        email= (EditText) findViewById(R.id.input_emailCon);
        password= (EditText) findViewById(R.id.input_passwordCon);
        btn_connexion=(Button) findViewById(R.id.btn_connexion);
        link_singn=(TextView) findViewById(R.id.link_signup);

        link_singn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);


            }
        });

        btn_connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().equals("") || password.getText().toString().equals("") ){

                    Snackbar snackbar = Snackbar.make(
                            v,
                            "Veuillez remplir tous les champs",
                            Snackbar.LENGTH_LONG);
                    snackbar.setActionTextColor(Color.RED);
                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(Color.WHITE);
                    TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(Color.parseColor("#303F9F"));


                    snackbar.show();



                }else if (password.getText().toString().length()  <= 5){
                    Toast.makeText(SignIn.this, "Mot de passe trop court", Toast.LENGTH_SHORT).show();


                }else {

                    Intent intent =new Intent(SignIn.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });




    }
}
