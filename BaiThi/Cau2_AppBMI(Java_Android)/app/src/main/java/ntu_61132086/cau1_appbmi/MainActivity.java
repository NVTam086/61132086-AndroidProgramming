package ntu_61132086.cau1_appbmi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView txtViewChieuCao, txtViewCanNang, txtViewTuoi;
    ImageView giamCanNangI, giamTuoiI, tangCanNangI, tangTuoiI;
    SeekBar seekBarS;
    LinearLayout maleL, femaleL;
    Button btnTinhB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

    }
}