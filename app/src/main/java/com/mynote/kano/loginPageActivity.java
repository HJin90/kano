package com.mynote.kano;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginPageActivity extends AppCompatActivity{


    private static final String TAG = "AnonymousAuth";

    // [START declare_auth]
    private FirebaseAuth mAuth;
    // [END declare_auth]
    private EditText mEmailField;
    private EditText mPasswordField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.github_loginpage);

        // [START initialize_auth]
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        // [END initialize_auth]

        // Fields
        mEmailField = findViewById(R.id.userID);
        mPasswordField = findViewById(R.id.userPW);



        Button loginpage_button = (Button) findViewById(R.id.submitLogin);


        loginpage_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), SelectPageActivity.class);
                startActivity(intent);
            }

        });


    }

    // [START on_start_check_user]
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }
    // [END on_start_check_user]



    private void updateUI(FirebaseUser user) {
        //hideProgressDialog();

        TextView idView = findViewById(R.id.userID);
        TextView emailView = findViewById(R.id.userID);
        boolean isSignedIn = (user != null);

        // Status text
        if (isSignedIn) {
         //   idView.setText(getString(R.string.id_fmt, user.getUid()));
         //   emailView.setText(getString(R.string.email_fmt, user.getEmail()));
        } else {
        //    idView.setText(R.string.signed_out);
            emailView.setText(null);
        }
/*
        // Button visibility
        findViewById(R.id.buttonAnonymousSignIn).setEnabled(!isSignedIn);
        findViewById(R.id.buttonAnonymousSignOut).setEnabled(isSignedIn);
        findViewById(R.id.buttonLinkAccount).setEnabled(isSignedIn);
        */

    }

}
