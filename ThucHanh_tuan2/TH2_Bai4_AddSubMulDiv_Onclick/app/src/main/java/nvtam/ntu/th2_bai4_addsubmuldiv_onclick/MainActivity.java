package nvtam.ntu.th2_bai4_addsubmuldiv_onclick;

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
    EditText editTextA;
    EditText editTextB;
    EditText editTextKQ;
    Button nutCong, nutTru, nutNhan, nutChia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
    }
    void TimDieuKhien(){
        editTextA= findViewById(R.id.edtA);
        editTextB = findViewById(R.id.edtB);
        editTextKQ = findViewById(R.id.edtKq);
        nutCong = findViewById(R.id.btnCong);
        nutTru = findViewById(R.id.btnTru);
        nutNhan = findViewById(R.id.btnNhan);
        nutChia = findViewById(R.id.btnChia);
    }
    public void XuLyCong(View v){
        //lấy dữ liệu
        String strA = editTextA.getText().toString();
        String strB = editTextB.getText().toString();
        //chuyển dữ liệu sang dạng số
        Double sothu1 = Double.parseDouble(strA);
        Double sothu2 = Double.parseDouble(strB);
        //Tính toán
        Double kqua = sothu1 + sothu2;
        //hiển thị ra màn hình
        editTextKQ.setText(String.valueOf(kqua));
    }
    public void XuLyTru(View v){
        //lấy dữ liệu
        String strA = editTextA.getText().toString();
        String strB = editTextB.getText().toString();
        //chuyển dữ liệu sang dạng số
        Double sothu1 = Double.parseDouble(strA);
        Double sothu2 = Double.parseDouble(strB);
        //Tính toán
        Double kqua = sothu1 - sothu2;
        //hiển thị ra màn hình
        editTextKQ.setText(String.valueOf(kqua));
    }
    public void XuLyNhan(View v){
        //lấy dữ liệu
        String strA = editTextA.getText().toString();
        String strB = editTextB.getText().toString();
        //chuyển dữ liệu sang dạng số
        Double sothu1 = Double.parseDouble(strA);
        Double sothu2 = Double.parseDouble(strB);
        //Tính toán
        Double kqua = sothu1 * sothu2;
        //hiển thị ra màn hình
        editTextKQ.setText(String.valueOf(kqua));
    }
    public void XuLyChia(View v){
        //lấy dữ liệu
        String strA = editTextA.getText().toString();
        String strB = editTextB.getText().toString();
        //chuyển dữ liệu sang dạng số
        Double sothu1 = Double.parseDouble(strA);
        Double sothu2 = Double.parseDouble(strB);
        //Tính toán
        Double kqua = sothu1 / sothu2;
        //hiển thị ra màn hình
        editTextKQ.setText(String.valueOf(kqua));
    }
}