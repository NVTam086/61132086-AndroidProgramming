package ntu.vntam.quanlysinhvien.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import ntu.vntam.quanlysinhvien.R;
import ntu.vntam.quanlysinhvien.adapter.ClassesAdapter;
import ntu.vntam.quanlysinhvien.model.Classes;
import ntu.vntam.quanlysinhvien.sqlite.ClassesDao;

public class ListClassesActivity extends AppCompatActivity {
    private ListView lvClasses;
    private List<Classes> list;
    private ClassesAdapter clsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_classes);

        lvClasses = findViewById(R.id.lvClasses);

        fillClassesListView();

        lvClasses.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ClassesDao dao = new ClassesDao(ListClassesActivity.this);
                Classes cls = list.get(position);
                dao.delete("" + cls.getId());
                fillClassesListView();
                return false;
            }
        });
    }

    private void fillClassesListView() {
        ClassesDao dao = new ClassesDao(this);
        list = dao.getAll();

        clsAdapter = new ClassesAdapter(this, list);
        lvClasses.setAdapter(clsAdapter);
    }
}