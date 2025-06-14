package ntu.vntam.quanlysinhvien;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import ntu.vntam.quanlysinhvien.activity.ListClassesActivity;
import ntu.vntam.quanlysinhvien.activity.LoginActivity;
import ntu.vntam.quanlysinhvien.activity.ManageStudentsActivity;
import ntu.vntam.quanlysinhvien.dialog.NewClassDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnNewClass).setOnClickListener(this);
        findViewById(R.id.btnListClasses).setOnClickListener(this);
        findViewById(R.id.btnManageStudents).setOnClickListener(this);
        findViewById(R.id.btnLogout).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnNewClass) {
            NewClassDialog dialog = new NewClassDialog(this);
            dialog.show();
        } else if (id == R.id.btnListClasses) {
            Intent intent = new Intent(this, ListClassesActivity.class);
            startActivity(intent);

        } else if (id == R.id.btnManageStudents) {
            Intent mngIntent = new Intent(this, ManageStudentsActivity.class);
            startActivity(mngIntent);

        } else if (id == R.id.btnLogout) {
            clearAutologin();
            Intent loginIntent = new Intent(this, LoginActivity.class);
            startActivity(loginIntent);
            finish();
        }
    }
    private void clearAutologin() {
        SharedPreferences preferences = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        editor.clear();
        editor.commit();
    }

}