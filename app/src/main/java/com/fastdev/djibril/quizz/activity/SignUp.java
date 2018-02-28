package com.fastdev.djibril.quizz.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fastdev.djibril.quizz.R;
import com.fastdev.djibril.quizz.data.models.Player;
import com.fastdev.djibril.quizz.data.remote.APIService;
import com.fastdev.djibril.quizz.data.remote.ApiUtils;

import org.json.JSONArray;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {
TextView textView;
    EditText name,email,adress,numtel,password,confpass;
    Button btn_inscription;
    CheckBox condition;
    private APIService mAPIService;
    String indicative;
    //User user1;

   // PrefixedEditText prefixedEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
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

        mAPIService = ApiUtils.getAPIService();

        textView=(TextView) findViewById(R.id.link_login);
        condition = (CheckBox) findViewById(R.id.checkBox);
        name= (EditText) findViewById(R.id.input_name);
        email= (EditText) findViewById(R.id.input_email);
        adress= (EditText) findViewById(R.id.input_address);
        numtel= (EditText) findViewById(R.id.input_mobile);
        password= (EditText) findViewById(R.id.input_password);
        confpass= (EditText) findViewById(R.id.input_reEnterPassword);
        btn_inscription = (Button) findViewById(R.id.btn_inscription);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignIn.class);
                startActivity(intent);


            }
        });

        btn_inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(name.getText().toString().equals("")||email.getText().equals("") ||adress.getText().toString().equals("") ||numtel.getText().toString().equals("")
                        || password.getText().toString().equals("") || confpass.getText().toString().equals("")){

                    Snackbar snackbar = Snackbar.make(
                            view,
                            "Veuillez remplir tous les champs",
                            Snackbar.LENGTH_LONG);
                    snackbar.setActionTextColor(Color.RED);
                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(Color.WHITE);
                    TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(Color.parseColor("#303F9F" +
                            ".0"));


                    snackbar.show();



                }else if(!password.getText().toString().equals(confpass.getText().toString())){

                    Snackbar snackbar = Snackbar.make(
                            view,
                            "Les deux mots de passe doivent être identiques",
                            Snackbar.LENGTH_LONG);
                    snackbar.setActionTextColor(Color.RED);
                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(Color.WHITE);
                    TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(Color.parseColor("#303F9F"));


                    snackbar.show();


                }
                else if(!condition.isChecked()){


                    Snackbar snackbar = Snackbar.make(
                            view,
                            "Veuillez accepter les contidions d'utilisations",
                            Snackbar.LENGTH_LONG);
                    snackbar.setActionTextColor(Color.RED);
                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(Color.WHITE);
                    TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
                    textView.setTextColor(Color.parseColor("#303F9F"));


                    snackbar.show();


                } else {



                    if (!verifEmail(email.getText().toString())) {

                        Toast.makeText(SignUp.this, "L'adresse email n'est pas correct", Toast.LENGTH_SHORT).show();




                    }else if(password.getText().toString().length()  <= 5){
                        Toast.makeText(SignUp.this, "Mot de passe trop court", Toast.LENGTH_SHORT).show();



                    }else {

                       /* Intent intent =new Intent(SignUp.this,MainActivity.class);
                        startActivity(intent);
                        finish();*/
                       mAPIService.getAnswers().enqueue(new Callback<List<Player>>() {
                           @RequiresApi(api = Build.VERSION_CODES.N)
                           @Override
                           public void onResponse(Call<List<Player>> call, Response<List<Player>> response) {

                             //  JSONArray jsonArray = new JSONArray(new String(((TypedByteArray) response.getBody()).getBytes()));


                               if(response.isSuccessful()) {
                                   List<Player> playerList = response.body();
                                //   playerList.forEach(change -> System.out.println(change.));
                               } else {
                                   System.out.println(response.errorBody());
                               }
                           }

                           @Override
                           public void onFailure(Call<List<Player>> call, Throwable t) {

                           }
                       });

                    }




                }



            }
        });

       /* try {
            PackageInfo info = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                String hashKey = new String(Base64.encode(md.digest(), 0));
                Log.i("Tag", "printHashKey() Hash Key: " + hashKey);
            }
        } catch (NoSuchAlgorithmException e) {
            Log.e("Tag", "printHashKey()", e);
        } catch (Exception e) {
            Log.e("Tag", "printHashKey()", e);
        }*/

    }
    public static boolean verifEmail(String email) {
        Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}$");
        Matcher m = p.matcher(email.toUpperCase());
        return m.matches();
    }
}
