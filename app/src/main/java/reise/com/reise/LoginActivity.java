package reise.com.reise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText t1, t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        t1 = (EditText) findViewById(R.id.editText1);
        t2 = (EditText) findViewById(R.id.editText2);

        Toast.makeText(this, "Password = admin ", Toast.LENGTH_LONG).show();

    }

    public void openRegisterActivity(View v) {
        Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(i);
    }

    public void openForgotPassword(View v) {
        Intent i = new Intent(LoginActivity.this, ForgotPassword.class);
        startActivity(i);
    }

    public void openHome(View v) {
        if (t1.getText().toString().isEmpty()) {
            Toast.makeText(LoginActivity.this, "Please enter a valid username", Toast.LENGTH_SHORT).show();
        } else if (!t2.getText().toString().equals("admin")) {
            Toast.makeText(LoginActivity.this, "Incorrect password", Toast.LENGTH_SHORT).show();
        } else {
            if (!t1.getText().toString().isEmpty() && t2.getText().toString().equals("admin")) {
                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(i);
            }
        }
    }
}