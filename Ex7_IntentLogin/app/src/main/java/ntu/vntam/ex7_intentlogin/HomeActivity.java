package ntu.vntam.ex7_intentlogin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {
    TextView tvTen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        tvTen = findViewById(R.id.txtName);
        //lấy Intent về
        Intent iTuDN = getIntent();
        //lọc ra lấy dữ liệu chuỗi
        String tenHthi = iTuDN.getStringExtra("tendn");
        //gán vào điều khiển
        tvTen.setText(tenHthi);
    }
}