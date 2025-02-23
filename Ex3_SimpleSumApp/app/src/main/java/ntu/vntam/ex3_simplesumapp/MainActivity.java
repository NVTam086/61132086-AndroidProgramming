package ntu.vntam.ex3_simplesumapp;

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

    EditText edtA, edtB, edtKq;
    Button btnTong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TimDieuKhien();
    }

    private void TimDieuKhien() {
        edtA = findViewById(R.id.edtsoA);
        edtB = findViewById(R.id.edtsoB);
        edtKq = findViewById(R.id.edtkQua);
        btnTong = findViewById(R.id.btnCong);
    }

    public void XuLyCong(View view) {
        //lấy dữ liệu về ở điều khiển
        String strA = edtA.getText().toString();
        String strB = edtB.getText().toString();
        //Kiểm tra hợp lệ
        if (strA.isEmpty() || strB.isEmpty()) {
            edtKq.setText("Xin nhập đủ 2 số!");
            return;
        }
        try {
            //chuyển dữ liệu sang dạng số
            double soA = Integer.parseInt(strA);
            double soB = Integer.parseInt(strB);
            //Tính toán
            double tong = soA + soB;
            //chuyển kết quả sang dạng chuỗi
            String strTong = String.valueOf(tong);
            //Hiển thị ra màn hình
            edtKq.setText(strTong);
        } catch (NumberFormatException e) {
            edtKq.setText("Xin nhập số hợp lệ!");
        }
    }
}