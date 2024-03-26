package ntu_61132086.cau1_appbmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class DislayResult extends AppCompatActivity {
    ImageView imgPrevI;
    TextView txtDanhGiaV, txtKqV, txtNhanXetV;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dislay_result);
        imgPrevI = findViewById(R.id.imgPrev);
        imgPrevI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DislayResult.this,MainActivity.class));
                finish();
            }
        });
    }
}