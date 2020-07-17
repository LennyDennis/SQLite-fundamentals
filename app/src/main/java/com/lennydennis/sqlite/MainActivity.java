package com.lennydennis.sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.lennydennis.sqlite.Adapter.CustomerAdapter;
import com.lennydennis.sqlite.Database.DatabaseOpenHelper;
import com.lennydennis.sqlite.Model.Customer;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.customer_name) EditText customerName;
    @BindView(R.id.customer_age) EditText customerAge;
    @BindView(R.id.active_customer) Switch activeCustomer;
    @BindView(R.id.btn_add) Button btnAddCustomer;
    @BindView(R.id.btn_viewall) Button btnViewCustomers;
    private DatabaseOpenHelper mDatabaseOpenHelper;
    private CustomerAdapter mCustomerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mDatabaseOpenHelper = new DatabaseOpenHelper(MainActivity.this);
        displayCustomers();

        btnAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Customer customer;
                try {
                    customer = new Customer(1,customerName.getText().toString(),Integer.parseInt(customerAge.getText().toString()),activeCustomer.isChecked());
                }catch (Exception e){
                    customer = new Customer(1,"error",0,false);
                }

                mDatabaseOpenHelper = new DatabaseOpenHelper(MainActivity.this);

                boolean success = mDatabaseOpenHelper.addCustomer(customer);

                Toast.makeText(MainActivity.this, success?"Successfully Added":"Error", Toast.LENGTH_SHORT).show();

                displayCustomers();
            }
        });

        btnViewCustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseOpenHelper = new DatabaseOpenHelper(MainActivity.this);

                displayCustomers();
            }
        });
    }

    private void displayCustomers() {
        RecyclerView recyclerView = findViewById(R.id.customer_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mCustomerAdapter = new CustomerAdapter(MainActivity.this, mDatabaseOpenHelper.getCustomer());
        recyclerView.setAdapter(mCustomerAdapter);
    }

//    private Cursor getAllCustomer(){
//        return
//    }
}