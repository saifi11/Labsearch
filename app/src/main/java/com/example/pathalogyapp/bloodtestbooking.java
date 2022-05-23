package com.example.pathalogyapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;


public class bloodtestbooking extends AppCompatActivity implements PaymentResultListener
{
    TextView testname ,testprice;
    Button makepayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bloodtestbooking);
        testname =findViewById(R.id.testname_blood);
        testprice =findViewById(R.id.bloodtest_price);
        makepayment = findViewById(R.id.makepayment);

        Checkout.preload(getApplicationContext());

        testname.setText(getIntent().getStringExtra("testname"));
        testprice.setText(getIntent().getStringExtra("testprice"));

        String testprice_ = testprice.getText().toString();



        makepayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onlinepayment(testprice_);
            }
        });
    }

    private void onlinepayment(String testprice_) {

        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_EmIAnjmUVDvpgS");
        checkout.setImage(R.drawable.logo);
        final Activity activity = this;
        try {
            JSONObject options = new JSONObject();

            options.put("name", "LAB SEARCH");
//            options.put("description", "Reference No. #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
//            options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            String account = testprice_;
            double total = Double.parseDouble(account);
            total = total * 100;
            options.put("amount",total);//pass amount in currency subunits
//            options.put("prefill.email", "");
//            options.put("prefill.contact","");
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);

            checkout.open(activity, options);

        } catch(Exception e) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }
    }



    @Override
    public void onPaymentSuccess(String s) {

        String testprice_ = testprice.getText().toString();
        String testname_ = testname.getText().toString();

        Toast.makeText(getApplicationContext(), "Successfull Payment", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), com.example.pathalogyapp.patientdetail.class);
        intent.putExtra("testname" ,testname_);
        intent.putExtra("testprice" ,testprice_);
        startActivity(intent);
        finish();

    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText(getApplicationContext(), "Payment failed", Toast.LENGTH_SHORT).show();

    }
}


