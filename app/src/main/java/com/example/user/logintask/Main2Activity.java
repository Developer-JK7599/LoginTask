package com.example.user.logintask;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Main2Activity extends AppCompatActivity {
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
    private TextInputLayout edt1, edt2, edt3, edt4, edt5;
    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edt1 = findViewById(R.id.unames_id);
        edt2 = findViewById(R.id.email_id);
        edt3 = findViewById(R.id.branch_id);
        edt4 = findViewById(R.id.passs_id);
        edt5 = findViewById(R.id.cpasss_id);
        txt=findViewById(R.id.txt_id);
        btn=findViewById(R.id.bts_id);

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inn=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(inn);
                finish();
            }
        });
    }

    private boolean validateUsername() {
        String usernameInput = edt1.getEditText().getText().toString().trim();

        if (usernameInput.isEmpty()) {
            edt1.setError("Field can't be empty");
            return false;
        } else if (usernameInput.length() > 15) {
            edt1.setError("Username too long");
            return false;
        } else {
           edt1.setError(null);
            return true;
        }
    }

    private boolean validateEmail() {

        String emailid = edt2.getEditText().getText().toString().trim();

        if (emailid.isEmpty()) {
            edt2.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailid).matches()) {
            edt2.setError("Please enter valid email-id");
            return false;
        } else {
            edt2.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = edt4.getEditText().getText().toString().trim();

        if (passwordInput.isEmpty()) {
            edt4.setError("Field can't be empty");
            edt5.setError("Field can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            edt4.setError("Password too weak");
            edt5.setError("Field can't be empty");
            return false;
        } else {
          edt4.setError(null);
          edt5.setError(null);
            return true;
        }
    }
    public void confirmInput(View v) {

        if (!validateEmail() | !validateUsername() | !validatePassword()) {
            return;
        }

        String input = "Email: " + edt2.getEditText().getText().toString();
        input += "\n";
        input += "Username: " + edt1.getEditText().getText().toString();
        input += "\n";
        input += "Password: " +edt4.getEditText().getText().toString();
        input += "\n";
        input += "Confirm Password: " +edt5.getEditText().getText().toString();
        input += "\n";
        input += "Branch: " + edt2.getEditText().getText().toString();
        Toast.makeText(this, input, Toast.LENGTH_SHORT).show();
    }
}
