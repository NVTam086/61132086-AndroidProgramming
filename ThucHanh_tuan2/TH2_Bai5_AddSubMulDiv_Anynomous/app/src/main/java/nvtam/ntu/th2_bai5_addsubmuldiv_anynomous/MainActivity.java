package nvtam.ntu.th2_bai5_addsubmuldiv_anynomous;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editTextA, editTextB, editTextKq;
    Button nutCong, nutTru, nutNhan, nutChia;
    void TimDieuKhien(){
        editTextA = findViewById(R.id.edtA);
        editTextB = findViewById(R.id.edtB);
        editTextKq = findViewById(R.id.edtKq);
        nutCong = findViewById(R.id.btnCong);
        nutTru = findViewById(R.id.btnTru);
        nutNhan = findViewById(R.id.btnNhan);
        nutChia = findViewById(R.id.btnChia);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        //gắn bộ lắng nghe sự kiện và code xử lý từng nút
        nutCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextKq.setText(String.valueOf(Double.parseDouble(editTextA.getText().toString()) + Double.parseDouble(editTextB.getText().toString())));
            }
        });
        nutTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextKq.setText(String.valueOf(Double.parseDouble(editTextA.getText().toString()) - Double.parseDouble(editTextB.getText().toString())));
            }
        });
        nutNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextKq.setText(String.valueOf(Double.parseDouble(editTextA.getText().toString()) * Double.parseDouble(editTextB.getText().toString())));
            }
        });
        nutChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextKq.setText(String.valueOf(Double.parseDouble(editTextA.getText().toString()) / Double.parseDouble(editTextB.getText().toString())));
            }
        });
    }

}