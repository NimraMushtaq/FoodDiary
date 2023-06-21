package com.midterm.fooddiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText eusername,email,epass,econfirm;
    TextView existUser;
    Button registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        econfirm=findViewById(R.id.editTextConfirmPassword);
        epass=findViewById(R.id.editTextPassword);
        email=findViewById(R.id.editTextEmail);
        eusername=findViewById(R.id.editTextUsername);
        registerBtn=findViewById(R.id.button_register);
        existUser=findViewById(R.id.textViewExistingUser);
        Database db=new Database(getApplicationContext(),"Food Diary",null,1);
        existUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_name=eusername.getText().toString();
                String userEmail=email.getText().toString();
                String password=epass.getText().toString();
                String passConfirm=econfirm.getText().toString();

                if(user_name.length()==0 || userEmail.length()==0 || password.length()==0 || passConfirm.length()==0){
                    Toast.makeText(getApplicationContext(),"Please Fill All Details",Toast.LENGTH_SHORT).show();
                }
                else {
                    if(password.compareTo(passConfirm)==0){
                        if(isValid(password)){
                            db.register(user_name,userEmail,password);

                            Toast.makeText(getApplicationContext(), "Registration Successfull!", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Password must contain 8 charactrs including letter,digit and special characters", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Password must be same!", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }
    public static boolean isValid(String password) {
        int f1 = 0, f2 = 0, f3 = 0;
        if (password.length() < 8) {
            return false;
        } else {
            for (int p = 0; p < password.length(); p++) {
                if (Character.isLetter(password.charAt(p))) {
                    f1 = 1;
                }
            }
            for (int r = 0; r < password.length(); r++) {
                if (Character.isDigit(password.charAt(r))) {
                    f2 = 1;
                }
            }
            for (int s = 0; s < password.length(); s++) {
                char c = password.charAt(s);
                if (c >= 33 && c <= 46 || c == 64) {
                    f3 = 1;
                }
            }
        }
        if (f1 == 1 && f2 == 1 && f3 == 1) {
            return true;
        }
        return false;
    }
}