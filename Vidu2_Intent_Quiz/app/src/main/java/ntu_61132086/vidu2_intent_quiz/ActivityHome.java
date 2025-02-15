package ntu_61132086.vidu2_intent_quiz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityHome extends AppCompatActivity {
    TextView tvUsername;
    Button btnq1, btnq2;
    void TimDieuKhien(){
        tvUsername = findViewById(R.id.tvUsername);
        btnq1 = findViewById(R.id.btnqu1);
        btnq2 = findViewById(R.id.btnq2);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        TimDieuKhien();
        tvUsername.setText(getIntent().getStringExtra("user"));
    }
}