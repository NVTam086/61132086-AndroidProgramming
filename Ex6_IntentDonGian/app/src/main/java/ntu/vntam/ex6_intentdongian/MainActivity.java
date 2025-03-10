package ntu.vntam.ex6_intentdongian;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button nutMh2, nutMh3;
    private void TimdieuKhien(){
        nutMh2 = findViewById(R.id.btnMh2);
        nutMh3 = findViewById(R.id.btnMh3);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TimdieuKhien();

        nutMh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Tao intent 2 tham so: man hinh hien tai.this, man hinh chuyen toi.class
                Intent intentMh2 = new Intent(MainActivity.this, Mh2Activity.class);

                //Gui
                startActivity(intentMh2);
            }
        });
        nutMh3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMh3 = new Intent(MainActivity.this, Mh3Activity.class);
                startActivity(intentMh3);
            }
        });
    }
}