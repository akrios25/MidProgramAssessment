package nyc.c4q.midprogramassessment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private SharedPreferences registeredPrefs;
    private EditText userEmail;
    private EditText userPassword;
    private Button saveUserButton;
    private CheckBox rememberUserBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userEmail = (EditText) findViewById(R.id.user_email);
        userPassword = (EditText) findViewById(R.id.user_password);
        saveUserButton = (Button) findViewById(R.id.save_button);
        rememberUserBox = (CheckBox) findViewById(R.id.cb_button);

        saveUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = registeredPrefs.edit();
                if(rememberUserBox.isChecked() && userEmail.equals("user@aol.com") && userPassword.equals("password1234")){
                    Intent listIntent = new Intent(LoginActivity.this, ListActivity.class);
                    editor.putString("user's email: " + userEmail.getText().toString(), userEmail.getText().toString());
                    editor.putString("user's password: " + userPassword.getText().toString(), userPassword.getText().toString());
                    editor.commit();
                    listIntent.putExtra("user email", userEmail.getText().toString());
                    listIntent.putExtra("user password", userPassword.getText().toString());
                    startActivity(listIntent);
                }
            }
        });
    }
}
