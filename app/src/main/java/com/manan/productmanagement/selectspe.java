package com.manan.productmanagement;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class selectspe extends AppCompatActivity {
    Dbhandler dbhandler;
    EditText evt1,evt2;
    Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectspe);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent i = getIntent();
        Bundle bundle =i.getExtras();
        String type = bundle.getString("type");
        String name = bundle.getString("name");
        dbhandler =new Dbhandler(this);

        evt1 = findViewById(R.id.pname);
        evt2 =findViewById(R.id.ptype);
        btn1 =findViewById(R.id.update);
        btn2 = findViewById(R.id.delete);

        evt1.setText(name);
        evt2.setText(type);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(selectspe.this);
                builder.setTitle("UPDATE DATA");
                builder.setMessage("Are you sure ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       String name1 = evt1.getText().toString();
                       String type1 = evt2.getText().toString();

                       dbhandler.upatedata(name,name1,type1);
                       Intent ie = new Intent(selectspe.this,MainActivity.class);
                       startActivity(ie);



                    }
                })
                 .setNegativeButton("no", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         dialog.cancel();
                     }
                 }).setCancelable(false).show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder =new AlertDialog.Builder(selectspe.this);
                builder.setTitle("Delete Data");
                builder.setMessage("Are you Sure ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name1 = evt1.getText().toString();
                        dbhandler.deletedata(name1);
                        Intent iee = new Intent(selectspe.this,MainActivity.class);
                        startActivity(iee);

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }) .setCancelable(false).show();
            }
        });


    }
}