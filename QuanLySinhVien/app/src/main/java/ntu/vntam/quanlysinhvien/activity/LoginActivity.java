package ntu.vntam.quanlysinhvien.activity;

import static ntu.vntam.quanlysinhvien.R.id.chkAutoLogin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import ntu.vntam.quanlysinhvien.MainActivity;
import ntu.vntam.quanlysinhvien.R;
import ntu.vntam.quanlysinhvien.dialog.NewClassDialog;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etUsername, etPassword;
    private CheckBox chkAutoLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btnExit).setOnClickListener(this);

        etUsername = findViewById(R.id.etUsetname);
        etPassword = findViewById(R.id.edtPassword);
        chkAutoLogin= findViewById(R.id.chkAutoLogin);

        readAutoLogin();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnLogin) {
            if (etUsername.getText().toString().equals("admin") && etPassword.getText().toString().equals("admin")){
                if (chkAutoLogin.isChecked()){
                    saveAutoLogin();
                }else {
                    clearAutologin();
                }
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
            }else {
                Snackbar.make(v, "Tên đăng nhập hay mật khẩu sai", Snackbar.LENGTH_LONG).show();
            }

        } else if (id == R.id.btnExit) {
            finish();
        }
    }

    private void clearAutologin() {
        SharedPreferences preferences = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.clear();
        editor.commit();
    }

    private void saveAutoLogin(){
        SharedPreferences preferences = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("username", etUsername.getText().toString());
        editor.putString("password", etPassword.getText().toString());

        editor.commit();
    }
    private boolean readAutoLogin(){
        SharedPreferences preferences = getSharedPreferences("Login", MODE_PRIVATE);
        String username = preferences.getString("username","");

        if (username != null && !username.equals("")){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return false;
    }
}