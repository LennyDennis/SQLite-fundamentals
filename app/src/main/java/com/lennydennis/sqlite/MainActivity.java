package com.lennydennis.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.lennydennis.sqlite.Database.DatabaseOpenHelper;
import com.lennydennis.sqlite.Model.Customer;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.customer_name) EditText customerName;
    @BindView(R.id.customer_age) EditText customerAge;
    @BindView(R.id.active_customer) Switch activeCustomer;
    @BindView(R.id.btn_add) Button btnAddCustomer;
    @BindView(R.id.btn_viewall) Button btnViewCustomers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Customer customer;
                try {
                    customer = new Customer(1,customerName.getText().toString(),Integer.parseInt(customerAge.getText().toString()),activeCustomer.isChecked());
                }catch (Exception e){
                    customer = new Customer(1,"error",0,false);
                }

                DatabaseOpenHelper databaseOpenHelper = new DatabaseOpenHelper(MainActivity.this);

                boolean success = databaseOpenHelper.addOne(customer);

                Toast.makeText(MainActivity.this, "Success ="+success, Toast.LENGTH_SHORT).show();
            }
        });

        btnViewCustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}