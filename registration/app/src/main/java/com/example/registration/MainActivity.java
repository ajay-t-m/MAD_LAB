package com.example.registration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText fname,lname,Email,phoneno,pwd,DOB;
    private RadioGroup gender;
    private Button Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = findViewById(R.id.et1);
        lname = findViewById(R.id.et2);
        Email = findViewById(R.id.eteml);
        phoneno = findViewById(R.id.etphone);
        pwd = findViewById(R.id.etpwd);
        DOB = findViewById(R.id.et4);
        gender = findViewById(R.id.gender);
        Button = findViewById(R.id.button);

        Button.setOnClickListener(v -> {
            if (validateInputs()) {
                saveData();
                Intent intent = new Intent(MainActivity.this, Afterreg.class);
                startActivity(intent);
            }
        });
    }

    private boolean validateInputs() {
        String firstName = fname.getText().toString().trim();
        String lastName = lname.getText().toString().trim();
        String email = Email.getText().toString().trim();
        String phone = phoneno.getText().toString().trim();
        String password = pwd.getText().toString().trim();
        String dob = DOB.getText().toString().trim();

        if (TextUtils.isEmpty(firstName)) {
            showToast("First Name is required");
            return false;
        }
        if (TextUtils.isEmpty(lastName)) {
            showToast("Last Name is required");
            return false;
        }
        if (TextUtils.isEmpty(email) || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            showToast("Valid Email is required");
            return false;
        }
        if (TextUtils.isEmpty(phone) || phone.length()<10 ) {
            showToast("Valid Phone Number is required");
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            showToast("Password is required");
            return false;
        }
        if (TextUtils.isEmpty(dob)) {
            showToast("Date of Birth is required");
            return false;
        }

        int selectedId = gender.getCheckedRadioButtonId();
        if (selectedId == -1) {
            showToast("Gender is required");
            return false;
        }

        return true;
    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("UserDetails", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String firstName = fname.getText().toString().trim();
        String lastName = lname.getText().toString().trim();
        String email = Email.getText().toString().trim();
        String phone = phoneno.getText().toString().trim();
        String password = pwd.getText().toString().trim();
        String dob = DOB.getText().toString().trim();

        int selectedId = gender.getCheckedRadioButtonId();
        RadioButton selectedGenderRadioButton = findViewById(selectedId);
        String gender = selectedGenderRadioButton.getText().toString();

        editor.putString("FirstName", firstName);
        editor.putString("LastName", lastName);
        editor.putString("Email", email);
        editor.putString("Phone", phone);
        editor.putString("Password", password);
        editor.putString("DOB", dob);
        editor.putString("Gender", gender);

        editor.apply();

        Log.d("MainActivity", "Data saved successfully");
    }

    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
