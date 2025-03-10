package ntu.vntam.ex7_intentlogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {
    EditText edtTendn, edtPass;
    private void TimDieuKhien(){
        edtTendn = findViewById(R.id.edtTendn);
        edtPass = findViewById(R.id.edtPass);
        btnOk = findViewById(R.id.btnOK);
    }
    Button btnOk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        TimDieuKhien();

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenDn = edtTendn.getText().toString();
                String pass = edtPass.getText().toString();

                if (tenDn.equals("vantam") && pass.equals("123")){
                    Intent iQuiz = new Intent(LoginActivity.this,HomeActivity.class);
                    iQuiz.putExtra("tendn",tenDn);
                    startActivity(iQuiz);
                }else{
                    Toast.makeText(getApplicationContext(),"Tên đăng nhập hoặc mật khẩu không đúng!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}