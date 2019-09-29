package com.example.user.logintask;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.dd.CircularProgressButton;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");
    private TextInputLayout edt1,edt2;
    Button btn;
    TextView tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.bt_id);
        edt1 = findViewById(R.id.unameL_id);
        edt2 = findViewById(R.id.passl_id);


        tx = findViewById(R.id.tx_id);

        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);
                finish();
            }
        });


    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    private boolean validateUsername() {
        String usernameInput = edt1.getEditText().getText().toString().trim();

        if (usernameInput.isEmpty()) {
            edt1.setError("Field can't be empty");
            edt1.setErrorTextColor(ColorStateList.valueOf(getColor(R.color.blue)));

            return false;
        }else {
            edt1.setError(null);
            return true;
        }
    }
    private boolean validatePassword() {
        String passwordInput = edt2.getEditText().getText().toString().trim();

        if (passwordInput.isEmpty()) {
            edt2.setError("Field can't be empty");
           // edt5.setError("Field can't be empty");
            return false;
        } else {
            edt2.setError(null);
            //edt5.setError(null);
            return true;
        }
    }

    public void confirmInput(View v) {
        if(edt1.getEditText().getText().toString().equals("xyz") && edt2.getEditText().getText().toString().equals("J@y12345")){

            String a=edt1.getEditText().getText().toString().trim();
            String e=edt2.getEditText().getText().toString().trim();
            Intent i=new Intent(MainActivity.this,Main3Activity.class);
            i.putExtra("one",a);
            startActivity(i);
            finish();
        }

        if (!validateUsername() | !validatePassword()) {
            return;
        }

        String input = "Username: " + edt1.getEditText().getText().toString();
        input += "\n";
        input += "Password: " + edt2.getEditText().getText().toString();
        input += "\n";
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }


}
