package com.example.user.logintask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    TextView txt;
    String str1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        txt=findViewById(R.id.txth_id);
        Intent i=getIntent();

        str1=i.getStringExtra("one");

        txt.setText("Welcome "+str1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    //    public boolean onCreateOptionMenu(Menu menu){
//    getMenuInflater().inflate(R.menu.option_menu,menu);
//        return true;
//    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getTitle().equals("Logout")){
            Toast.makeText(this, "Logout...", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(Main3Activity.this,MainActivity.class);
            startActivity(i);
            finish();
        }
        return true;
    }
}
