package ntu.vntam.ex5_addsubmuldiv_anynomous;

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
    EditText edtsoA, edtsoB, edtKqua;
    Button btnphepCong, btnphepTru,btnphepNhan,btnphepChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TimDieuKhien();

        btnphepCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strA = edtsoA.getText().toString();
                String strB = edtsoB.getText().toString();
                if (strA.isEmpty() || strB.isEmpty()){
                    edtKqua.setText("Hãy nhập đủ 2 số!");
                    return;
                }
                try {

                    float soA = Float.parseFloat(strA);
                    float soB = Float.parseFloat(strB);
                    float tong = soA + soB;
                    String strTong = String.valueOf(tong);
                    edtKqua.setText(strTong);
                }catch (NumberFormatException e){
                    edtKqua.setText("Hãy nhập số hợp lệ!");
                }

            }
        });
        btnphepTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strA = edtsoA.getText().toString();
                String strB = edtsoB.getText().toString();
                if (strA.isEmpty() || strB.isEmpty()){
                    edtKqua.setText("Hãy nhập đủ 2 số!");
                    return;
                }
                try {

                    float soA = Float.parseFloat(strA);
                    float soB = Float.parseFloat(strB);
                    float tong = soA - soB;
                    String strTong = String.valueOf(tong);
                    edtKqua.setText(strTong);
                }catch (NumberFormatException e){
                    edtKqua.setText("Hãy nhập số hợp lệ!");
                }

            }
        });
        btnphepNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strA = edtsoA.getText().toString();
                String strB = edtsoB.getText().toString();
                if (strA.isEmpty() || strB.isEmpty()){
                    edtKqua.setText("Hãy nhập đủ 2 số!");
                    return;
                } else if (strB.equals("0")) {
                    edtKqua.setText("Số b không được bằng!");
                    return;
                }
                try {

                    float soA = Float.parseFloat(strA);
                    float soB = Float.parseFloat(strB);
                    float tong = soA * soB;
                    String strTong = String.valueOf(tong);
                    edtKqua.setText(strTong);
                }catch (NumberFormatException e){
                    edtKqua.setText("Hãy nhập số hợp lệ!");
                }

            }
        });
        btnphepChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strA = edtsoA.getText().toString();
                String strB = edtsoB.getText().toString();
                if (strA.isEmpty() || strB.isEmpty()){
                    edtKqua.setText("Hãy nhập đủ 2 số!");
                    return;
                } else if (strB.equals("0")) {
                    edtKqua.setText("Số b không được bằng!");
                    return;
                }
                try {

                    float soA = Float.parseFloat(strA);
                    float soB = Float.parseFloat(strB);
                    float tong = soA / soB;
                    String strTong = String.valueOf(tong);
                    edtKqua.setText(strTong);
                }catch (NumberFormatException e){
                    edtKqua.setText("Hãy nhập số hợp lệ!");
                }

            }
        });

    }

    private void TimDieuKhien() {
        edtsoA = findViewById(R.id.edtA);
        edtsoB = findViewById(R.id.edtB);
        edtKqua = findViewById(R.id.edtKq);
        btnphepCong = findViewById(R.id.btnCong);
        btnphepTru = findViewById(R.id.btnTru);
        btnphepNhan = findViewById(R.id.btnNhan);
        btnphepChia = findViewById(R.id.btnChia);
    }


}