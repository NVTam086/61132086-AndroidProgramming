package ntu_61132086.cau1_appbmi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class DislayResult extends AppCompatActivity {
    ImageView imgPrevI;
    TextView txtDanhGiaV, txtKqV, txtNhanXetV;
    float bmi;
    String bmiS;
    void TimDieuKhien(){

        imgPrevI = findViewById(R.id.imgPrev);
        txtDanhGiaV = findViewById(R.id.txtDanhGia);
        txtKqV = findViewById(R.id.txtKq);
        txtNhanXetV = findViewById(R.id.txtNhanXet);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dislay_result);

        TimDieuKhien();
        bmi = getIntent().getFloatExtra("bmi",0);
        bmiS = Float.toString(bmi);
        txtKqV.setText(bmiS);

        if(bmi < 16){
            txtDanhGiaV.setText("Thiếu cân");
            txtDanhGiaV.setTextColor(Color.parseColor("#FF0989CD"));
            txtNhanXetV.setText("BMI cho thấy bạn Gầy độ 3");
        }
        else if (bmi < 17) {
            txtDanhGiaV.setText("Thiếu cân");
            txtDanhGiaV.setTextColor(Color.parseColor("#FF0989CD"));
            txtNhanXetV.setText("BMI cho thấy bạn Gầy độ 2");
        }
        else if (bmi < 18.5) {
            txtDanhGiaV.setText("Thiếu cân");
            txtDanhGiaV.setTextColor(Color.parseColor("#FF0989CD"));
            txtNhanXetV.setText("BMI cho thấy bạn Gầy độ 1");
        }
        else if (bmi < 25) {
            txtDanhGiaV.setText("Bình thường");
            txtDanhGiaV.setTextColor(Color.parseColor("#FF15D61D"));
            txtNhanXetV.setText("BMI cho thấy bạn Bình thường");
        }
        else if (bmi < 30) {
            txtDanhGiaV.setText("Thừa cân");
            txtDanhGiaV.setTextColor(Color.parseColor("#FFFF5722"));
            txtNhanXetV.setText("BMI cho thấy bạn Thừa cân");
        }
        else if (bmi < 35) {
            txtDanhGiaV.setText("Béo phì");
            txtDanhGiaV.setTextColor(Color.parseColor("#FFE91E1E"));
            txtNhanXetV.setText("BMI cho thấy bạn Béo phì độ 1");
        }
        else if (bmi < 40) {
            txtDanhGiaV.setText("Béo phì nguy hiểm");
            txtDanhGiaV.setTextColor(Color.parseColor("#FF9C27B0"));
            txtNhanXetV.setText("BMI cho thấy bạn Béo phì độ 2");
        }
        else {
            txtDanhGiaV.setText("Béo phì nguy hiểm");
            txtDanhGiaV.setTextColor(Color.parseColor("#FF9C27B0"));
            txtNhanXetV.setText("BMI cho thấy bạn Béo phì độ 3");
        }
        imgPrevI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DislayResult.this,MainActivity.class));
                finish();
            }
        });
    }
}