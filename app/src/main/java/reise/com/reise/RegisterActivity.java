package reise.com.reise;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        showMessage();
    }

    public void openLoginActivity(View v){
        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(i);
        finish();
    }

    public void openForgotPassword(View v){
        Intent i = new Intent(RegisterActivity.this, ForgotPassword.class);
        startActivity(i);
    }


    public void onRegisterClick(View v){
        showMessage();
    }

    public void showMessage(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert!");
        builder.setMessage("This is just a dummy activity. It has no application as of now. To login, use the password - admin ");
        builder.show();
    }
}
