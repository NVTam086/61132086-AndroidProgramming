package ntu.vntam.listview_listbaihat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvDsbaihat;
    ArrayList<String> dsBaihat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Ánh xạ
        lvDsbaihat = findViewById(R.id.lvDsbaihat);
        //chuẩn bị danh sách bài hát
        dsBaihat = new ArrayList<>();
        dsBaihat.add("1. Sóng gió - Jack");
        dsBaihat.add("2. Nơi tình yêu kết thúc - Hoài Lâm");
        dsBaihat.add("3. Nơi ấy con tìm về - Hồ Quan Hiếu");
        dsBaihat.add("4. Lạc trôi - Sơn Tùng MTP");
        dsBaihat.add("5. Thiên lý ơi - J97");
        //tạo array adapter để hiển thị danh sách
        ArrayAdapter<String> adapterBhat = new ArrayAdapter<String>(this,
                                                                android.R.layout.simple_list_item_1,
                                                                dsBaihat);
        //gắn adapter vào listview
        lvDsbaihat.setAdapter(adapterBhat);
        //xử lý sự kiện
        lvDsbaihat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String chonBhat = dsBaihat.get(position);
                //hiển thị thông báo bài hát được chọn
                Toast.makeText(MainActivity.this, "Bạn chọn: " + chonBhat, Toast.LENGTH_SHORT).show();
            }
        });
    }
}