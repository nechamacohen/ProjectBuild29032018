package cohen.nechama.projectbuild.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cohen.nechama.projectbuild.R;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText etUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        etUserName = findViewById(R.id.etUserName);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goMenuIntent = new Intent(LoginActivity.this,MenuActivity.class);
                String userName = etUserName.getText().toString();
                goMenuIntent.putExtra("user_name",userName);
                startActivity(goMenuIntent);
            }
        });


    }
}
