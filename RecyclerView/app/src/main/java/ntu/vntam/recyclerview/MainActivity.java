package ntu.vntam.recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recycleViewDatas;
    RecyclerView recyclerViewLandScape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //3
        recycleViewDatas = getDataForRecyclerView();
        //4
        recyclerViewLandScape = findViewById(R.id.recyclerLand);
        //5
        RecyclerView.LayoutManager layoutlinear = new LinearLayoutManager(this);
        recyclerViewLandScape.setLayoutManager(layoutlinear);
        //6
        landScapeAdapter = new LandScapeAdapter(this, recycleViewDatas);
        //7
        recyclerViewLandScape.setAdapter(landScapeAdapter);

    }

    ArrayList<LandScape> getDataForRecyclerView(){
        ArrayList<LandScape> dsDulieu = new ArrayList<LandScape>();
        LandScape landScape1 = new LandScape("codohue.png","Cố đô Huế");
        dsDulieu.add(landScape1);
        dsDulieu.add(new LandScape("daophuquoc_kiengiang.png","Đảo Phú Quốc - Kiên Giang"));
        dsDulieu.add(new LandScape("dinhfansipan_sapa_laocai.png","Đỉnh Fansipan - Sapa - Lào cai"));
        dsDulieu.add(new LandScape("halongbay_quangninh.png","Vịnh Hạ Long - Quảng Ninh"));
        dsDulieu.add(new LandScape("phocohoian_quangnam.png","Phố cổ Hội An - Quảng Nam"));
        dsDulieu.add(new LandScape("phongnhakebang_quangbinh.png","Phong nha kẻ bàng - Quảng Bình"));
        return dsDulieu;
    }
}