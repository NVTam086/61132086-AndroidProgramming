package ntu.vntam.quanlysinhvien.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

import java.util.Date;
import java.util.List;

import ntu.vntam.quanlysinhvien.R;
import ntu.vntam.quanlysinhvien.adapter.ClassesAdapter;
import ntu.vntam.quanlysinhvien.adapter.StudentsAdapter;
import ntu.vntam.quanlysinhvien.dialog.NewClassDialog;
import ntu.vntam.quanlysinhvien.helper.DateTimeHelper;
import ntu.vntam.quanlysinhvien.model.Classes;
import ntu.vntam.quanlysinhvien.model.Student;
import ntu.vntam.quanlysinhvien.sqlite.ClassesDao;
import ntu.vntam.quanlysinhvien.sqlite.StudentDao;

public class ManageStudentsActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etStudentId, etName, etDob;
    private Spinner spClasses;
    private List<Classes> classesList;

    private List<Student> studentList;
    private ListView lvStudents;
    private StudentsAdapter studentsAdapter;
    private boolean isEdit = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_students);
        etStudentId = findViewById(R.id.etStudentId);
        etName = findViewById(R.id.etName);
        etDob = findViewById(R.id.etDob);
        spClasses = findViewById(R.id.spClasses);

        lvStudents = findViewById(R.id.lvStudents);
        lvStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student std = studentList.get(position);
                etStudentId.setText(std.getId());
                etName.setText(std.getName());
                etDob.setText(DateTimeHelper.toString(std.getDob()));
                isEdit = true;
            }
        });

        fillClassesToSpinner();

        findViewById(R.id.btnSave).setOnClickListener(this);
        findViewById(R.id.btnDelete).setOnClickListener(this);
    }
    private void fillClassesToSpinner(){
        ClassesDao dao = new ClassesDao(this);
        classesList = dao.getAll();
        ClassesAdapter classesAdapter = new ClassesAdapter(this, classesList);
        spClasses.setAdapter(classesAdapter);

        spClasses.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                fillStudentsToListView();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void fillStudentsToListView(){
        StudentDao dao = new StudentDao(this);
        try {
            Classes cls = (Classes) spClasses.getSelectedItem();
            studentList = dao.getAllByClass(cls.getId());

            studentsAdapter = new StudentsAdapter(this, studentList);
            lvStudents.setAdapter(studentsAdapter);
        }catch (Exception ex){
            ex.printStackTrace();
            Toast.makeText(this,"Error: " + ex.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onClick(View v) {
        StudentDao dao = new StudentDao(this);
        int id = v.getId();
        if (id == R.id.btnSave) {
            try {
                Student std = new Student();
                std.setId(etStudentId.getText().toString());
                std.setName(etName.getText().toString());
                std.setDob(DateTimeHelper.toDate(etDob.getText().toString()));

                Classes cls =(Classes) spClasses.getSelectedItem();
                std.setClassId(cls.getId());
                String msg;
                if (!isEdit) {
                    dao.insert(std);
                    msg = "Sinh viên đã được lưu!";
                }else {
                    dao.update(std);
                    msg = "Sinh viên đã được cập nhật!";
                }

                Snackbar snackbar = Snackbar.make(v, msg, Snackbar.LENGTH_LONG);
                snackbar.show();
                clearInputFields();

                isEdit = false;
                fillStudentsToListView();

            }catch (Exception ex){
                ex.printStackTrace();
                Toast.makeText(this,"Error: " + ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.btnDelete) {
            if (isEdit && !etStudentId.getText().toString().equals("")){
                String it = etStudentId.getText().toString();
                dao.delete(it);

                fillStudentsToListView();
                Snackbar.make(v, "Sinh viên đã được xóa", Snackbar.LENGTH_LONG).show();

                clearInputFields();
            }
        }
    }

    private void clearInputFields() {
        etStudentId.setText("");
        etName.setText("");
        etDob.setText("");
    }
}