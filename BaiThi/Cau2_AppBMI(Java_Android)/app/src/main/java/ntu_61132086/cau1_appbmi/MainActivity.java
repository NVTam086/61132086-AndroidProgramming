package ntu_61132086.cau1_appbmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {
    TextView txtChieuCaoV, txtCanNangV;
    SeekBar seekBarCcaoS, seekBarCnS;
    LinearLayout maleL, femaleL;
    Button btnTinhB;
    String gtinh = "0";
    float chieucao, cnang, bmi;

    void TimDieuKhien(){
        txtChieuCaoV = findViewById(R.id.txtCcao);
        txtCanNangV = findViewById(R.id.txtCnang);
        seekBarCcaoS = findViewById(R.id.seekBarCcao);
        seekBarCnS = findViewById(R.id.seekBarCnang);
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

        seekBarCcaoS.setMax(250);
        seekBarCcaoS.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                chieucao = progress;
                txtChieuCaoV.setText(String.valueOf(chieucao));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarCnS.setMax(200);
        seekBarCnS.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                cnang = progress;
                txtCanNangV.setText(String.valueOf(cnang));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnTinhB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strccao = txtChieuCaoV.getText().toString();
                String strcnang = txtCanNangV.getText().toString();
                if(gtinh.equals("0")){
                    Toast.makeText(getApplicationContext(),"Hãy chọn giới tính",Toast.LENGTH_SHORT).show();
                } else if (chieucao == 0) {
                    Toast.makeText(getApplicationContext(),"Chiều cao không đúng",Toast.LENGTH_SHORT).show();
                } else if (cnang == 0 ) {
                    Toast.makeText(getApplicationContext(),"Cân nặng không đúng",Toast.LENGTH_SHORT).show();
                }else{
                    chieucao = Float.parseFloat(strccao);
                    cnang = Float.parseFloat(strcnang);
                    chieucao = chieucao/100;
                    bmi = cnang/(chieucao*chieucao);
                    Intent intent =new Intent(MainActivity.this, DislayResult.class);
                    intent.putExtra("bmi",bmi);
                    startActivity(intent);
                }

            }
        });
    }
}