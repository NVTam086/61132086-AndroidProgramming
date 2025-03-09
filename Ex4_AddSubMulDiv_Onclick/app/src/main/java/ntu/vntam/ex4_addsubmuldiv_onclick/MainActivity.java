package ntu.vntam.ex4_addsubmuldiv_onclick;

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
    Button btnCong, btnTru, btnNhan, btnChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Timdieukhien();
    }

    private void Timdieukhien() {
        edtsoA = findViewById(R.id.edtA);
        edtsoB = findViewById(R.id.edtB);
        edtKqua = findViewById(R.id.edtKq);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
    }

    public void XuLyCong(View v){
        String strsoA = edtsoA.getText().toString();
        String strsoB = edtsoB.getText().toString();

        if(strsoA.isEmpty() || strsoB.isEmpty()){
            edtKqua.setText("Hãy nhập đủ 2 số!");
            return;
        }
        try{
            float soA = Float.parseFloat(strsoA);
            float soB = Float.parseFloat(strsoB);

            float tong = soA + soB;

            String strTong = String.valueOf(tong);

            edtKqua.setText(strTong);
        }catch (NumberFormatException e){
            edtKqua.setText("Hãy nhập số hợp lệ");
        }

    }
    public void XuLyTru(View v){
        String strsoA = edtsoA.getText().toString();
        String strsoB = edtsoB.getText().toString();

        if(strsoA.isEmpty() || strsoB.isEmpty()){
            edtKqua.setText("Hãy nhập đủ 2 số!");
            return;
        }
        try{
            float soA = Float.parseFloat(strsoA);
            float soB = Float.parseFloat(strsoB);

            float tong = soA - soB;

            String strTong = String.valueOf(tong);

            edtKqua.setText(strTong);
        }catch (NumberFormatException e){
            edtKqua.setText("Hãy nhập số hợp lệ");
        }
    }
    public void XuLyNhan(View v){
        String strsoA = edtsoA.getText().toString();
        String strsoB = edtsoB.getText().toString();

        if(strsoA.isEmpty() || strsoB.isEmpty()){
            edtKqua.setText("Hãy nhập đủ 2 số!");
            return;
        }
        try{
            float soA = Float.parseFloat(strsoA);
            float soB = Float.parseFloat(strsoB);

            float tong = soA * soB;

            String strTong = String.valueOf(tong);

            edtKqua.setText(strTong);
        }catch (NumberFormatException e){
            edtKqua.setText("Hãy nhập số hợp lệ");
        }
    }
    public void XuLyChia(View v){
        String strsoA = edtsoA.getText().toString();
        String strsoB = edtsoB.getText().toString();

        if(strsoA.isEmpty() || strsoB.isEmpty()){
            edtKqua.setText("Hãy nhập đủ 2 số!");
            return;
        } else if (strsoB.equals("0")){
            edtKqua.setText("Số b phải khác 0!");
            return;
        }
        try{
            float soA = Float.parseFloat(strsoA);
            float soB = Float.parseFloat(strsoB);

            float tong = soA / soB;

            String strTong = String.valueOf(tong);

            edtKqua.setText(strTong);
        }catch (NumberFormatException e){
            edtKqua.setText("Hãy nhập số hợp lệ!");
        }
    }
}