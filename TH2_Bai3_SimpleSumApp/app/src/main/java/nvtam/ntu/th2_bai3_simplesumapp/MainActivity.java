package nvtam.ntu.th2_bai3_simplesumapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }
    public void XuLyCong(View view){
        //tìm, tham chiếu đến các điều khiển
        EditText editTextSoA = findViewById(R.id.edtA);
        EditText editTextSoB = findViewById(R.id.edtB);
        EditText editTextKq = findViewById(R.id.edtKq);
        //lấy dữ liệu
        String strA = editTextSoA.getText().toString();
        String strB = editTextSoB.getText().toString();
        //chuyển dữ liệu sang dạng số
        double soA = Double.parseDouble(strA);
        double soB = Double.parseDouble(strB);
        //Tính tổng
        double ketQua = soA + soB;
        //hiện ra màn hình
        editTextKq.setText(String.valueOf(ketQua));
    }

}