package com.example.registration;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Afterreg extends AppCompatActivity {

    private TextView firstname, lastname, emailview,phoneno,pswd,dobview, genderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afterreg);

        firstname = findViewById(R.id.fname);
        lastname = findViewById(R.id.lname);
        emailview = findViewById(R.id.email);
        dobview = findViewById(R.id.dob);
        genderView = findViewById(R.id.gender);
        phoneno = findViewById(R.id.phone);
        pswd = findViewById(R.id.pwd);

        loadData();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE);

        String firstName = sharedPreferences.getString("FirstName", "Not Available");
        String lastName = sharedPreferences.getString("LastName", "Not Available");
        String email = sharedPreferences.getString("Email", "Not Available");
        String dob = sharedPreferences.getString("DOB", "Not Available");
        String gender = sharedPreferences.getString("Gender", "Not Available");
        String phone = sharedPreferences.getString("Phone", "Not Available");
        String password = sharedPreferences.getString("Password", "Not Available");

        firstname.setText("First Name: " + firstName);
        lastname.setText("Last Name: " + lastName);
        emailview.setText("Email: " + email);
        dobview.setText("Date of Birth: " + dob);
        genderView.setText("Gender: " + gender);
        phoneno.setText("Phone: " + phone);
        pswd.setText("Password: " + password);
    }
}