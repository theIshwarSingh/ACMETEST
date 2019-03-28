package com.theguide.guidesoft.myapplication;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {
    EditText stuname, fname, phone, oschool, percent;
    Spinner spinner;
    Button send;
    private DatabaseReference mFirebaseDb;
    private FirebaseDatabase mFirebaseins;
    private String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stuname = findViewById(R.id.stuname);
        fname = findViewById(R.id.fname);
        spinner = findViewById(R.id.spinner);
        phone = findViewById(R.id.phone);
        oschool= findViewById(R.id.oschool);
        percent = findViewById(R.id.percent);
        send = findViewById(R.id.button);

        mFirebaseins = FirebaseDatabase.getInstance();

        mFirebaseDb = mFirebaseins.getReference("users");

        // Save Data

        send.setOnClickListener(new View.OnClickListener(){

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
             String name = stuname.getText().toString();
             String father = fname.getText().toString();
             String clas = spinner.getSelectedItem().toString();
             String mobile = phone.getText().toString();
             String old = oschool.getText().toString();
             String grades = percent.getText().toString();
                if (TextUtils.isEmpty(userId)) {
                    createUser(name, father, clas,mobile, old, grades);
                    Toast.makeText(getBaseContext(), "Thanks For Registering!" , Toast.LENGTH_SHORT ).show();
                } else {
                    //updateUser(name, email);
                }
                //Clear EditText
                stuname.getText().clear();
                fname.getText().clear();
                phone.getText().clear();
                oschool.getText().clear();
                percent.getText().clear();
            }
        });
       toogleButton();
    }
    private  void toogleButton(){
        if(TextUtils.isEmpty(userId)){
            send.setText("Register for Test!");
        }
    }
    // Creating New Users
    private void createUser(String name, String father, String clas, String mobile, String old, String grades){
        if (TextUtils.isEmpty(userId)) {
            userId = mFirebaseDb.push().getKey();
        }

        User user = new User(name, father, clas,mobile, old, grades);

        mFirebaseDb.child(userId).setValue(user);

       // addUserChangeListener();

    }

}

