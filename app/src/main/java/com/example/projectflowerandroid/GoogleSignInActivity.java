package com.example.projectflowerandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


public class GoogleSignInActivity extends AppCompatActivity {

    GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_sign_in);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_WIDE);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if(account != null){
            setUIToLoggedInMode(account);
        }else{
            setUIToLoggedOutMode();
        }

        Button logoutButton = findViewById(R.id.sign_in_log_out_button);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });
//        updateUI(account);

    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);

            setUIToLoggedInMode(account);

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w("GOOGLE_SIGN_IN", "signInResult:failed code=" + e.getStatusCode());
//            updateUI(null);
            Toast.makeText(this, "Failed Error code=" + e.getStatusCode(), Toast.LENGTH_SHORT).show();
        }
    }

    private void setUIToLoggedInMode(GoogleSignInAccount googleSignInAccount){

        TextView tv = findViewById(R.id.sign_in_welcome_text);
        tv.setText("Welcome, " + googleSignInAccount.getEmail());

        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setVisibility(View.GONE);

        Button logoutButton = findViewById(R.id.sign_in_log_out_button);
        logoutButton.setVisibility(View.VISIBLE);

        Intent data = new Intent();
        data.putExtras(new Bundle());

        setResult(RESULT_OK, data);
        finishActivity(123);

    }

    private void setUIToLoggedOutMode(){

        TextView tv = findViewById(R.id.sign_in_welcome_text);
        tv.setText("");

        SignInButton signInButton = findViewById(R.id.sign_in_button);
        signInButton.setVisibility(View.VISIBLE);

        Button logoutButton = findViewById(R.id.sign_in_log_out_button);
        logoutButton.setVisibility(View.GONE);

    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        setUIToLoggedOutMode();
                    }
                });
    }


}