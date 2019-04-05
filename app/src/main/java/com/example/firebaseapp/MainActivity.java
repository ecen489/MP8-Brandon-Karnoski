package com.example.firebaseapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button createAccount, login;
    EditText emailInput, passwordInput;

    FirebaseDatabase fbdb;
    FirebaseAuth mAuth;
    FirebaseUser user = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createAccount = (Button) findViewById(R.id.CreateAccount);
        login = (Button) findViewById(R.id.Login);
        emailInput = (EditText) findViewById(R.id.UsernameInput);
        passwordInput = (EditText) findViewById(R.id.PasswordInput);

        mAuth = FirebaseAuth.getInstance();


}

    public void newAccount(View view){
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){

                        Toast.makeText(getApplicationContext(),"Created Account",Toast.LENGTH_SHORT).show();
                        user = mAuth.getCurrentUser();  //The new user is already signed in
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
                    }

                }
            });
    }

    public void loginAccount(View view){
        String email = emailInput.getText().toString();
        String password = passwordInput.getText().toString();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Login Successful!",Toast.LENGTH_SHORT).show();
                            user = mAuth.getCurrentUser(); //The user is signed in

                            final Intent forwardIntent = new Intent(MainActivity.this, Pull.class);
                            startActivity(forwardIntent);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



}
