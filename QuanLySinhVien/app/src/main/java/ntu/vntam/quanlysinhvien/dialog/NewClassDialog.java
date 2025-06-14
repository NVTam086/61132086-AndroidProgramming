package ntu.vntam.quanlysinhvien.dialog;

import static ntu.vntam.quanlysinhvien.R.*;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import ntu.vntam.quanlysinhvien.R;
import ntu.vntam.quanlysinhvien.model.Classes;
import ntu.vntam.quanlysinhvien.sqlite.ClassesDao;

public class NewClassDialog extends Dialog implements View.OnClickListener {
    private Context context;
    private EditText etClassId, etName;
    public NewClassDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_new_class);

        etClassId = findViewById(R.id.etClassId);
        etName = findViewById(R.id.etName);

        findViewById(R.id.btnSave).setOnClickListener(this);
        findViewById(R.id.btnClose).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnSave) {
            Classes cls = new Classes();
            cls.setName(etName.getText().toString());
            ClassesDao dao = new ClassesDao(context);
            dao.insert(cls);

            Toast.makeText(context, "Lớp đã được lưu", Toast.LENGTH_SHORT).show();

            dismiss();
        } else if (id == R.id.btnClose) {
            dismiss();
        }
    }
}
