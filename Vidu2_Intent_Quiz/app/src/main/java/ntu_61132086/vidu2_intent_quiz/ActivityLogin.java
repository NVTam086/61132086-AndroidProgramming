package ntu_61132086.vidu2_intent_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityLogin extends AppCompatActivity {
    EditText edtUsername, edtPass, edtMail;
    Button btnOk;
    TextView tvThongbao;
    void TimDieuKhien(){
        edtUsername = findViewById(R.id.edtUsername);
        edtPass = findViewById(R.id.edtPass);
        edtMail = findViewById(R.id.edtEmail);
        btnOk = findViewById(R.id.btnOK);
        tvThongbao = findViewById(R.id.txtThongbao);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        TimDieuKhien();
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUser = edtUsername.getText().toString();
                String strPass = edtPass.getText().toString();
                String strMail = edtMail.getText().toString();
                if(strUser.equals("63cntt2") && strPass.equals("123456")){
                    Intent iQuiz = new Intent(ActivityLogin.this, ActivityHome.class);
                    if(strMail.length() == 0){
                        Toast.makeText(getApplicationContext(),"Tên hiển thị không được để trống.",Toast.LENGTH_SHORT).show();
                    }else {
                    iQuiz.putExtra("user",strMail);
                    startActivity(iQuiz);}
                }else {
                    Toast.makeText(getApplicationContext(),"Sai thông tin đăng nhập",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}