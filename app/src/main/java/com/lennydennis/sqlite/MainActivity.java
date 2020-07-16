package com.lennydennis.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.customer_name) EditText customerName;
    @BindView(R.id.customer_age) EditText customerAge;
    @BindView(R.id.active_customer) Switch activeCustomer;
    @BindView(R.id.btn_add) Button btnAddCustomer;
    @BindView(R.id.btn_viewall) Button btnViewCustomers;
    @BindView(R.id.display_name) TextView displayName;
    @BindView(R.id.display_id) TextView displayId;
    @BindView(R.id.display_age) TextView displayAge;
    @BindView(R.id.display_active) TextView displayActive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnAddCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnViewCustomers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}