package com.example.fg;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class TinhBMI extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_tinhbmi,container,false);
        final EditText ten = (EditText) view.findViewById(R.id.hoten);
        final EditText ngaydo = (EditText) view.findViewById(R.id.ngaydo);
        final EditText tuoi = (EditText) view.findViewById(R.id.tuoi);
        Button btntinh = (Button) view.findViewById(R.id.tinh);
        final EditText chieucao = (EditText) view.findViewById(R.id.chieucao);
        final EditText cannang = (EditText) view.findViewById(R.id.cannang);
        final EditText bmi = (EditText) view.findViewById(R.id.bmi);
        final TextView khuyen = (TextView) view.findViewById(R.id.loikhuyen);
        final TextView canphai = (TextView) view.findViewById(R.id.need);

        btntinh.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            public void onClick(View v) {
                String msg;
                if (ten.length() == 0)
                    ten.setHint("nhập tên");
                if (ngaydo.length() == 0)
                    ngaydo.setHint("nhập ngày đo");
                if (tuoi.length() == 0)
                    tuoi.setHint("nhập tuổi");
                if (chieucao.length() == 0) {
                    chieucao.setHint("nhập chiều cao");
                }
                if (cannang.length() == 0) {
                    cannang.setHint("nhập cân nặng");
                }
                if (ten.length() != 0 && ngaydo.length() != 0 && tuoi.length() != 0 && chieucao.length() != 0 && cannang.length() != 0) {
                    String ccao = chieucao.getText().toString();
                    double a = Integer.parseInt(ccao);
                    double a1 = a / 100;

                    String cnang = cannang.getText().toString();
                    double b = Integer.parseInt(cnang);

                    double tinh = b / (a1 * a1);
                    double tinh1 = Math.round(tinh * 100.0) / 100.0;
                    DecimalFormat df = new DecimalFormat("###.##");

                    String s = String.valueOf(df.format(tinh));
                    bmi.setText(s);

                    if (tinh1 < 18.5) {
                        khuyen.setText("Bạn thuộc dạng gầy, thiếu cân\n" +
                                "- Dễ bị mắc nhiều chứng bệnh.\n" +
                                "- Cơ thể lỏng lẻo, mềm yếu.\n" +
                                "- Tóc bị khô, xác xơ, dễ rụng");
                        canphai.setText("Cần phải bổ sung thêm nhiều dinh dưỡng.\n" +
                                "- Luyện tập thể dục thể thao thường xuyên." +
                                "- Giữ tinh thần luôn vui vẻ, hạn chế stress.");
                    } else if (tinh1 >= 18.5 || tinh1 <= 24.9) {
                        khuyen.setText("Bạn thuộc dạng cân đối: " +
                                "\n-Khi có một chỉ số BMI lý tưởng, " +
                                "với cân nặng và chiều cao cân đối, " +
                                "cơ thể bạn sẽ ít nguy cơ bệnh tật, " +
                                "khỏe mạnh và năng động hơn. ");
                        canphai.setText("Bạn cần phải tập luyện, ăn uống điều độ để duy trì trạng thái này.");
                    }

                    if (tinh1 >= 25.0) {
                        khuyen.setText("Bạn thuộc dạng thừa cân:\n" +
                                "- Dễ mắc những chứng bệnh về tim mạch.\n" +
                                "- Giảm khả năng điều hòa mức độ đường huyết.\n" +
                                "- Giảm chức năng hô hấp.\n" +
                                "- Mắc các bệnh về hô hấp.\n" +
                                "- Dễ mắc hội chứng đa năng, khó thụ thai, dễ sẩy thai.");
                        canphai.setText("Muốn giảm cân, bạn cần có chế độ ăn thấp năng lượng, " +
                                "cân đối, ít đường, đủ đạm, vitamin, nhiều rau quả. " +
                                "Hãy từng bước giảm năng lượng khẩu phần ăn cho đến khi đạt năng lượng tương ứng với BMI.");
                    }
                }
            }
        });
        return view;
    }
}