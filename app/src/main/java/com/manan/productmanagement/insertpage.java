package com.manan.productmanagement;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class insertpage extends AppCompatActivity {
    EditText etv1,etv2;
    Button btn;
    Dbhandler dbhandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_insertpage);
        etv1 = findViewById(R.id.productname);
        etv2 = findViewById(R.id.prodcuttype);
        btn = findViewById(R.id.insertdata);
        dbhandler =new Dbhandler(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etv1.getText().toString().isEmpty())
                {
                    etv1.setError("PLEASE ENER THE PRODUCT NAME");
                }
                else if(!etv1.getText().toString().matches("[a-zA-Z ]+"))
                {
                    etv1.setError("only string ");
                }
                else if(etv2.getText().toString().isEmpty())
                {
                    etv2.setError("PLEASE ENTER THE PRODUCT TYPE");
                }
//                else if(Patterns.WEB_URL.matcher(etv2.getText().toString()).matches())
//                {
//                    etv2.setError("only website");
//                }
                else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(insertpage.this);
                    builder.setTitle("Insert Data");
                    builder.setMessage("Are you sure ?");
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dbhandler.insertdata(etv1.getText().toString(),etv2.getText().toString());
                            Intent intent = new Intent(insertpage.this,MainActivity.class);
                            startActivity(intent);
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                     .setCancelable(false).show();
                }
            }
        });
    }
}