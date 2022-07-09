package com.example.basicbanking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.basicbanking.RoomDatabase.CustomerDatabase;

public class SplashScreen extends AppCompatActivity {
    CustomerDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        db = Room.databaseBuilder(getApplicationContext(), CustomerDatabase.class, "Customer").allowMainThreadQueries().build();
        init();

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Home.class);
                startActivity(intent);
                finish();
            }
        }, 4500);

    }

    public void init() {
        db.customerDOA().DeleteAll();
        db.customerDOA().InsertCustomer(new Model("Abanoub Gamal", "email2@Yahoo.com", "Cairo", "Business", 5000));
        db.customerDOA().InsertCustomer(new Model("Armia", "email2@Yahoo.com", "Cairo", "Business", 5000));
        db.customerDOA().InsertCustomer(new Model("Mina", "email2@Yahoo.com", "Cairo", "Business", 6000));
        db.customerDOA().InsertCustomer(new Model("Adham", "email2@Yahoo.com", "Cairo", "Business", 1500));
        db.customerDOA().InsertCustomer(new Model("Soror", "email2@Yahoo.com", "Cairo", "Business", 200));
        db.customerDOA().InsertCustomer(new Model("Gerges", "email2@Yahoo.com", "Cairo", "Business", 800));
        db.customerDOA().InsertCustomer(new Model("Bakr", "email2@Yahoo.com", "Cairo", "Business", 1600));
        db.customerDOA().InsertCustomer(new Model("Micheal", "email2@Yahoo.com", "Cairo", "Business", 1900));
        db.customerDOA().InsertCustomer(new Model("Madona", "email2@Yahoo.com", "Cairo", "Business", 2500));
        db.customerDOA().InsertCustomer(new Model("Kerina", "email2@Yahoo.com", "Cairo", "Business", 3000));
        db.customerDOA().InsertCustomer(new Model("Peter", "email2@Yahoo.com", "Cairo", "Business", 4500));
        db.customerDOA().InsertCustomer(new Model("Omer", "email2@Yahoo.com", "Cairo", "Business", 4900));
        db.customerDOA().InsertCustomer(new Model("Mark", "email2@Yahoo.com", "Cairo", "Business", 2300));
        db.customerDOA().InsertCustomer(new Model("Beshoy", "email2@Yahoo.com", "Cairo", "Business", 3200));
        db.customerDOA().InsertCustomer(new Model("Marina", "email2@Yahoo.com", "Cairo", "Business", 1400));

    }

}