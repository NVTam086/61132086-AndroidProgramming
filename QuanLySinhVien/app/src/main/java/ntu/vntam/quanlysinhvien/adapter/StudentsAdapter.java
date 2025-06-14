package ntu.vntam.quanlysinhvien.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import ntu.vntam.quanlysinhvien.R;
import ntu.vntam.quanlysinhvien.helper.DateTimeHelper;
import ntu.vntam.quanlysinhvien.model.Student;

public class StudentsAdapter extends BaseAdapter {
    private Context context;
    private List<Student> list;

    public StudentsAdapter(Context context, List<Student> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.layout_student_item, null);
        }

        TextView tvStudentId = view.findViewById(R.id.tvStudentId);
        TextView tvName = view. findViewById(R.id.tvName);
        TextView tvDob = view. findViewById(R.id.tbDob);

        Student std =list.get(position);
        tvStudentId.setText(std.getId());
        tvName.setText(std.getName());
        tvDob.setText(DateTimeHelper.toString(std.getDob()));
        return view;
    }
}
