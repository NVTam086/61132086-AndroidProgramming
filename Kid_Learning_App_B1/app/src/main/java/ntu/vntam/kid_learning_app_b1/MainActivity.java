package ntu.vntam.kid_learning_app_b1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView landing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    landing = findViewById(R.id.imageView);
    landing.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent  = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);

        }
    });
    }
}