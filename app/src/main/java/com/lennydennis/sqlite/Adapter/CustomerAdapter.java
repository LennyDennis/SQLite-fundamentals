package com.lennydennis.sqlite.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lennydennis.sqlite.Model.Customer;
import com.lennydennis.sqlite.R;

import java.util.List;

public class CustomerAdapter extends  RecyclerView.Adapter<CustomerAdapter.ViewHolder> {

    List<Customer> mCustomerList;
    private Context mContext;

    public CustomerAdapter(Context context, List<Customer> customerList) {
        mCustomerList = customerList;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.customer_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Customer customer = mCustomerList.get(position);

        holder.displayId.setText("Customer ID : " + String.valueOf(customer.getId()));
        holder.displayName.setText("Customer Name : " +customer.getCustomerName());
        holder.displayAge.setText("Customer Age : " +String.valueOf(customer.getCustomerAge()));
        holder.displayActive.setText("Active : " +String.valueOf(customer.getActive()));


    }

    @Override
    public int getItemCount() {
        return mCustomerList.size();
    }

//    public void swapCursor(Cursor cursor){
//        if(mCursor != null){
//            mCursor.close();
//        }
//
//        mCursor = cursor;
//
//        if(cursor != null){
//            notifyDataSetChanged();
//        }
//    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView displayName;
        TextView displayAge;
        TextView displayId;
        TextView displayActive;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            displayName = itemView.findViewById(R.id.display_name);
            displayAge = itemView.findViewById(R.id.display_age);
            displayActive = itemView.findViewById(R.id.display_active);
            displayId = itemView.findViewById(R.id.display_id);
        }
    }
}
