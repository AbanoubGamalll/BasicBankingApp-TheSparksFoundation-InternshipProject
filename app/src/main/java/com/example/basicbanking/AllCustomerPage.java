package com.example.basicbanking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.basicbanking.Adabtor.CustomerAdapter;
import com.example.basicbanking.Adabtor.onClickRecyclerView;
import com.example.basicbanking.RoomDatabase.CustomerDatabase;

import java.util.ArrayList;
import java.util.List;

public class AllCustomerPage extends AppCompatActivity implements onClickRecyclerView {

    RecyclerView recyclerView;
    CustomerAdapter adapter;
    List<Model> list = new ArrayList<>();
    CustomerDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_customer_page);


        db = Room.databaseBuilder(getApplicationContext(), CustomerDatabase.class, "Customer").allowMainThreadQueries().build();


        list = db.customerDOA().DBList();

        recyclerView = findViewById(R.id.recycleviewcustomer);
        adapter = new CustomerAdapter(list,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
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


    @Override
    public void onclick(int id) {
        Intent i = new Intent(this, ShowCustomerDetailsPage.class);
        i.putExtra("FromName",id);
        startActivity(i);
    }
}