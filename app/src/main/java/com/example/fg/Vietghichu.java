package com.example.fg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class Vietghichu extends AppCompatActivity {

    TextView datalist;
    EditText nhapten;
    EditText nhapnoidung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vietghichu);
        datalist = (TextView) findViewById(R.id.txtData);
        nhapten = (EditText) findViewById(R.id.studentid);
        nhapnoidung = (EditText) findViewById(R.id.studentname);
    }

    public void addStudent(View view) {
        DataHandler dbHandler = new DataHandler(this, null, null, 1);
        //nhận id
        String id = nhapten.getText().toString();
        //nhận name
        String name = nhapnoidung.getText().toString();
        //gán id và name đến đối tượng Student
        BangGhiChu student = new BangGhiChu(id, name);
        //thêm đối tượng Student đến bảng dữ liệu
        if (nhapten.length() == 0){
            nhapten.setHint("Hãy nhập nội dung");
        }
        if (nhapnoidung.length() == 0){
            nhapnoidung.setHint("Hãy nhập tên");
        }
        else dbHandler.addDataHandler(student);
        //xóa sạch các PlainText
        nhapten.setText("");
        nhapnoidung.setText("");
        loadStudents(view);
    }

    public void loadStudents(View view) {
        //khởi tạo đối tượng xử lý dữ liệu
        DataHandler dbHandler = new DataHandler(this, null, null, 1);
        //hiển thị dữ liệu
        datalist.setText(dbHandler.loadDataHandler());
        //xóa sạch các PlainText
        nhapten.setText("");
        nhapnoidung.setText("");
    }

    public void deleteStudent(View view) {
        DataHandler dbHandler = new DataHandler(this, null, null, 1);
        boolean result = dbHandler.deleteDataHandler(nhapten.getText().toString());
        if (result) {
            nhapten.setText("");
            nhapnoidung.setText("");
            datalist.setHint("Đã xóa ghi chú");
        } else
            nhapten.setHint("Không tìm thấy bản ghi chú");
        loadStudents(view);
    }


    public void findAllStudent(View view) {
        DataHandler dbHandler = new DataHandler(this, null, null, 1);
        List<BangGhiChu> lst =
                dbHandler.findAllDataHandler
                        (nhapnoidung.getText().toString());
        String studentsList = "";
        if (!lst.isEmpty()) {
            for(BangGhiChu st:lst)
            {
                studentsList += st.getStudentName()
                        + ": " + st.getStudentID()
                        + System.getProperty("line.separator");
                nhapten.setText("");
                nhapnoidung.setText("");
            }
            datalist.setText(studentsList);
        } else {
            datalist.setHint("Không tìm thấy ghi chú");
            nhapten.setText("");
            nhapnoidung.setText("");
        }
    }
}