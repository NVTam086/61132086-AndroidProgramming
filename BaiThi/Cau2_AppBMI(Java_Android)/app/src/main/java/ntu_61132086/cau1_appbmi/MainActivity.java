package ntu_61132086.cau1_appbmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    TextView txtChieuCaoV, txtCanNangV, txtTuoiV;
    ImageView giamCanNangI, giamTuoiI, tangCanNangI, tangTuoiI;
    SeekBar seekBarS;
    LinearLayout maleL, femaleL;
    Button btnTinhB;
    String gtinh;
    int cnang, tuoi;

    void TimDieuKhien(){
        txtChieuCaoV = findViewById(R.id.txtChieucao);
        txtCanNangV = findViewById(R.id.txtCanNang);
        txtTuoiV = findViewById(R.id.txtTuoi);
        giamCanNangI = findViewById(R.id.imgGiamCanNang);
        giamTuoiI = findViewById(R.id.imgGiamTuoi);
        tangCanNangI = findViewById(R.id.imgTangCanNang);
        tangTuoiI = findViewById(R.id.imgTangTuoi);
        seekBarS = findViewById(R.id.seekBar);
        maleL = findViewById(R.id.male);
        femaleL = findViewById(R.id.female);
        btnTinhB = findViewById(R.id.btnTinh);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TimDieuKhien();

        maleL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                maleL.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.focus));
                femaleL.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.notfocus));
                gtinh = "Nam";
            }
        });
        femaleL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                femaleL.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.focus));
                maleL.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.notfocus));
                gtinh = "Nữ";
            }
        });

        seekBarS.setMax(300);
        seekBarS.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                txtChieuCaoV.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        giamCanNangI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnang = cnang - 1;
                txtCanNangV.setText(String.valueOf(cnang));
            }
        });
        giamCanNangI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnang = cnang - 1;
                txtCanNangV.setText(String.valueOf(cnang));
            }
        });
        tangCanNangI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cnang = cnang + 1;
                txtCanNangV.setText(String.valueOf(cnang));
            }
        });
        giamTuoiI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tuoi = tuoi - 1;
                txtTuoiV.setText(String.valueOf(tuoi));
            }
        });
        tangTuoiI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tuoi = tuoi + 1;
                txtTuoiV.setText(String.valueOf(tuoi));
            }
        });
        btnTinhB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DislayResult.class));
            }
        });
    }
}