package ntu.vntam.quanlysinhvien.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import ntu.vntam.quanlysinhvien.helper.DateTimeHelper;
import ntu.vntam.quanlysinhvien.model.Classes;
import ntu.vntam.quanlysinhvien.model.Student;

public class StudentDao {
    private SQLiteDatabase db;
    public StudentDao(Context context){
        DbHelper helper = new DbHelper(context);

        this.db = helper.getWritableDatabase();
    }
    public long insert(Student emp){
        ContentValues values = new ContentValues();
        values.put("id", emp.getId());
        values.put("name", emp.getName());
        values.put("dob", DateTimeHelper.toString(emp.getDob()));
        values.put("classid", emp.getClassId());

        return db.insert("students", null, values);
    }
    public long update(Student emp){
        ContentValues values = new ContentValues();
        values.put("name", emp.getName());
        values.put("dob", DateTimeHelper.toString(emp.getDob()));
        values.put("classid", emp.getClassId());

        return db.update("students",values, " id = ?", new String[]{emp.getId()});
    }
    public long delete(String id){

        return db.delete("students", " id = ?", new String[]{id});
    }
    @SuppressLint("Range")
    public List<Student> get(String sql, String ... selectArgs) throws ParseException {
        List<Student> list = new ArrayList<>();

        Cursor cursor = db.rawQuery(sql, selectArgs);

        while (cursor.moveToNext()){
            Student cls = new Student();
            cls.setId(cursor.getString(cursor.getColumnIndex("id")));
            cls.setName(cursor.getString(cursor.getColumnIndex("name")));
            cls.setDob(DateTimeHelper.toDate(cursor.getString(cursor.getColumnIndex("dob"))));
            cls.setClassId(cursor.getInt(cursor.getColumnIndex("classid")));
            list.add(cls);
        }
        return list;
    }
    public  List<Student> getAll() throws ParseException {
        String sql = "SELECT * FROM students";

        return get(sql);
    }
    public  List<Student> getAllByClass( Integer classId) throws ParseException {
        String sql = "SELECT * FROM students WHERE classid = ?";

        return get(sql, "" + classId);
    }
}
