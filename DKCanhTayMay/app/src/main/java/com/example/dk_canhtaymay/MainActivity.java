package com.example.dk_canhtaymay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView chedo = findViewById(R.id.textView3);
        TextView trangthai = findViewById(R.id.textView);

        EditText gocservo = findViewById(R.id.gocservo);
        gocservo.setFilters(new InputFilter[]{ new MinMaxFilter("0","180")});

        EditText servo1 = findViewById(R.id.nhapsv);
        EditText servo2 = findViewById(R.id.nhapsv1);
        EditText servo3 = findViewById(R.id.nhapsv2);
        EditText servo4 = findViewById(R.id.nhapsv3);
        EditText servo5 = findViewById(R.id.nhapsv4);

        servo1.setFilters(new InputFilter[]{ new MinMaxFilter("0","180")});
        servo2.setFilters(new InputFilter[]{ new MinMaxFilter("0","180")});
        servo3.setFilters(new InputFilter[]{ new MinMaxFilter("0","180")});
        servo4.setFilters(new InputFilter[]{ new MinMaxFilter("0","180")});
        servo5.setFilters(new InputFilter[]{ new MinMaxFilter("0","90")});

        Button pushs1 = findViewById(R.id.pushs1);
        Button pushs2 = findViewById(R.id.pushs2);
        Button pushs3 = findViewById(R.id.pushs3);
        Button pushs4 = findViewById(R.id.pushs4);
        Button pushs5 = findViewById(R.id.pushs5);

        Button m30 = findViewById(R.id.button4);
        Button m31 = findViewById(R.id.button2);
        Button m32 = findViewById(R.id.button3);
        Button m33 = findViewById(R.id.button5);
        Button m34 = findViewById(R.id.button6);

        FirebaseDatabase.getInstance().getReference("Mode").addValueEventListener(new ValueEventListener(){
            @SuppressLint("SetTextI18n")
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                long state = dataSnapshot.child("State").getValue(long.class);
                if (state == 0){
                    chedo.setText("Chế Độ Tự Động");
                    chedo.setTextColor(Color.parseColor("#00ff00"));
                    trangthai.setText("Đang Đợi Hàng Hóa");
                    trangthai.setTextColor(Color.parseColor("#ff5050"));


                    for (Button button : Arrays.asList(pushs1, pushs2, pushs3, pushs4, pushs5, m30, m31, m32, m33, m34)) {
                        button.setVisibility(View.GONE);
                    }
                    gocservo.setVisibility(View.GONE);
                    for (EditText editText : Arrays.asList(servo1, servo2, servo3, servo4, servo5)) {
                        editText.setVisibility(View.GONE);
                    }
                }
                else if (state == 1){
                    chedo.setText("Chế Độ Tự Động");
                    chedo.setTextColor(Color.parseColor("#00ff00"));
                    trangthai.setText("Phát hiện hàng hóa: " + dataSnapshot.child("QR-Data").getValue());
                    trangthai.setTextColor(Color.parseColor("#00ff00"));

                    for (Button button : Arrays.asList(pushs1, pushs2, pushs3, pushs4, pushs5, m30, m31, m32, m33, m34)) {
                        button.setVisibility(View.GONE);
                    }
                    gocservo.setVisibility(View.GONE);
                    for (EditText editText : Arrays.asList(servo1, servo2, servo3, servo4, servo5)) {
                        editText.setVisibility(View.GONE);
                    }
                }
                else if (state == 2){
                    chedo.setText("Chế Độ Thủ Công");
                    chedo.setTextColor(Color.parseColor("#ff00ff"));
                    trangthai.setText("Đang Đợi Lệnh");
                    trangthai.setTextColor(Color.parseColor("#ff5050"));

                    for (Button button : Arrays.asList(pushs1, pushs2, pushs3, pushs4, pushs5)) {
                        button.setVisibility(View.VISIBLE);
                    }
                    gocservo.setVisibility(View.VISIBLE);
                    for (Button button : Arrays.asList(m30, m31, m32, m33, m34)) {
                        button.setVisibility(View.GONE);
                    }
                    for (EditText editText : Arrays.asList(servo1, servo2, servo3, servo4, servo5)) {
                        editText.setVisibility(View.GONE);
                    }
                }
                else if (state == 22){
                    chedo.setText("Chế Độ Thủ Công");
                    chedo.setTextColor(Color.parseColor("#ff00ff"));
                    trangthai.setText("Đang Thực Thi");
                    trangthai.setTextColor(Color.parseColor("#00ff00"));

                    for (Button button : Arrays.asList(pushs1, pushs2, pushs3, pushs4, pushs5)) {
                        button.setVisibility(View.VISIBLE);
                    }
                    gocservo.setVisibility(View.VISIBLE);
                    for (Button button : Arrays.asList(m30, m31, m32, m33, m34)) {
                        button.setVisibility(View.GONE);
                    }
                    for (EditText editText : Arrays.asList(servo1, servo2, servo3, servo4, servo5)) {
                        editText.setVisibility(View.GONE);
                    }
                }
                else if (state == 3){
                    chedo.setText("Chế Độ Lưu Vị Trí");
                    chedo.setTextColor(Color.parseColor("#ffff00"));
                    trangthai.setText("Đang Đợi Dữ Liệu Vị Trí");
                    trangthai.setTextColor(Color.parseColor("#ff5050"));
                    for (Button button : Arrays.asList(pushs1, pushs2, pushs3, pushs4, pushs5)) {
                        button.setVisibility(View.GONE);
                    }
                    gocservo.setVisibility(View.GONE);
                    for (Button button : Arrays.asList(m30, m31, m32, m33, m34)) {
                        button.setVisibility(View.VISIBLE);
                    }
                    for (EditText editText : Arrays.asList(servo1, servo2, servo3, servo4, servo5)) {
                        editText.setVisibility(View.VISIBLE);
                    }
                }
                else if (state == 33){
                    chedo.setText("Chế Độ Lưu Vị Trí");
                    chedo.setTextColor(Color.parseColor("#ffff00"));
                    trangthai.setText("Đang Lưu Dữ Liệu Vị Trí");
                    trangthai.setTextColor(Color.parseColor("#00ff00"));
                    for (Button button : Arrays.asList(pushs1, pushs2, pushs3, pushs4, pushs5)) {
                        button.setVisibility(View.GONE);
                    }
                    gocservo.setVisibility(View.GONE);
                    for (Button button : Arrays.asList(m30, m31, m32, m33, m34)) {
                        button.setVisibility(View.VISIBLE);
                    }
                    for (EditText editText : Arrays.asList(servo1, servo2, servo3, servo4, servo5)) {
                        editText.setVisibility(View.VISIBLE);
                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
    public void ps1(View view) {
        EditText servo = findViewById(R.id.gocservo);
        String androidip = servo.getText().toString();
        if (!androidip.equals("")) {
            FirebaseDatabase.getInstance().getReference("Mobile").child("Servo").setValue(1);
            FirebaseDatabase.getInstance().getReference("Mobile").child("Angle").setValue(Integer.parseInt(androidip));
            FirebaseDatabase.getInstance().getReference("Mode").child("State").setValue(22);
        }
    }
    public void ps2(View view) {
        EditText servo = findViewById(R.id.gocservo);
        String androidip = servo.getText().toString();
        if (!androidip.equals("")) {
            FirebaseDatabase.getInstance().getReference("Mobile").child("Servo").setValue(2);
            FirebaseDatabase.getInstance().getReference("Mobile").child("Angle").setValue(Integer.parseInt(androidip));
            FirebaseDatabase.getInstance().getReference("Mode").child("State").setValue(22);
        }
    }
    public void ps3(View view) {
        EditText servo = findViewById(R.id.gocservo);
        String androidip = servo.getText().toString();
        if (!androidip.equals("")) {
            FirebaseDatabase.getInstance().getReference("Mobile").child("Servo").setValue(3);
            FirebaseDatabase.getInstance().getReference("Mobile").child("Angle").setValue(Integer.parseInt(androidip));
            FirebaseDatabase.getInstance().getReference("Mode").child("State").setValue(22);
        }
    }
    public void ps4(View view) {
        EditText servo = findViewById(R.id.gocservo);
        String androidip = servo.getText().toString();
        if (!androidip.equals("")) {
            FirebaseDatabase.getInstance().getReference("Mobile").child("Servo").setValue(4);
            FirebaseDatabase.getInstance().getReference("Mobile").child("Angle").setValue(Integer.parseInt(androidip));
            FirebaseDatabase.getInstance().getReference("Mode").child("State").setValue(22);
        }
    }
    public void ps5(View view) {
        EditText servo = findViewById(R.id.gocservo);
        String androidip = servo.getText().toString();
        if (!androidip.equals("") && Integer.parseInt(androidip) >= 0 && Integer.parseInt(androidip) <= 90) {
            FirebaseDatabase.getInstance().getReference("Mobile").child("Servo").setValue(5);
            FirebaseDatabase.getInstance().getReference("Mobile").child("Angle").setValue(Integer.parseInt(androidip));
            FirebaseDatabase.getInstance().getReference("Mode").child("State").setValue(22);
        }
    }
    public void switchmode(View view) {
        FirebaseDatabase.getInstance().getReference("Mode").child("State").get().addOnCompleteListener(task -> {
            long state = Long.parseLong(String.valueOf(task.getResult().getValue()));
            if (state == 0){
                FirebaseDatabase.getInstance().getReference("Mode").child("State").setValue(2);
            } else if (state == 2) {
                FirebaseDatabase.getInstance().getReference("Mode").child("State").setValue(3);
            } else if (state == 3) {
                FirebaseDatabase.getInstance().getReference("Mode").child("State").setValue(0);
            }
        });
    }

    public void nhapvtgaphang(View view) {
        EditText servo1 = findViewById(R.id.nhapsv);
        EditText servo2 = findViewById(R.id.nhapsv1);
        EditText servo3 = findViewById(R.id.nhapsv2);
        EditText servo4 = findViewById(R.id.nhapsv3);
        EditText servo5 = findViewById(R.id.nhapsv4);

        String androidip1 = servo1.getText().toString();
        String androidip2 = servo2.getText().toString();
        String androidip3 = servo3.getText().toString();
        String androidip4 = servo4.getText().toString();
        String androidip5 = servo5.getText().toString();

        if (!androidip1.equals("") && !androidip2.equals("") && !androidip3.equals("") && !androidip4.equals("") &&!androidip5.equals("")) {
            FirebaseDatabase.getInstance().getReference("GocQuay").child("0").child("servo1").setValue(Integer.parseInt(androidip1));
            FirebaseDatabase.getInstance().getReference("GocQuay").child("0").child("servo2").setValue(Integer.parseInt(androidip2));
            FirebaseDatabase.getInstance().getReference("GocQuay").child("0").child("servo3").setValue(Integer.parseInt(androidip3));
            FirebaseDatabase.getInstance().getReference("GocQuay").child("0").child("servo4").setValue(Integer.parseInt(androidip4));
            FirebaseDatabase.getInstance().getReference("GocQuay").child("0").child("servo5").setValue(Integer.parseInt(androidip5));
            FirebaseDatabase.getInstance().getReference("Mode").child("State").setValue(33);
        }
    }

    public void sp1(View view) {
        EditText servo1 = findViewById(R.id.nhapsv);
        EditText servo2 = findViewById(R.id.nhapsv1);
        EditText servo3 = findViewById(R.id.nhapsv2);
        EditText servo4 = findViewById(R.id.nhapsv3);
        EditText servo5 = findViewById(R.id.nhapsv4);

        String androidip1 = servo1.getText().toString();
        String androidip2 = servo2.getText().toString();
        String androidip3 = servo3.getText().toString();
        String androidip4 = servo4.getText().toString();
        String androidip5 = servo5.getText().toString();

        if (!androidip1.equals("") && !androidip2.equals("") && !androidip3.equals("") && !androidip4.equals("") &&!androidip5.equals("")) {
            FirebaseDatabase.getInstance().getReference("GocQuay").child("1").child("servo1").setValue(Integer.parseInt(androidip1));
            FirebaseDatabase.getInstance().getReference("GocQuay").child("1").child("servo2").setValue(Integer.parseInt(androidip2));
            FirebaseDatabase.getInstance().getReference("GocQuay").child("1").child("servo3").setValue(Integer.parseInt(androidip3));
            FirebaseDatabase.getInstance().getReference("GocQuay").child("1").child("servo4").setValue(Integer.parseInt(androidip4));
            FirebaseDatabase.getInstance().getReference("GocQuay").child("1").child("servo5").setValue(Integer.parseInt(androidip5));
            FirebaseDatabase.getInstance().getReference("Mode").child("State").setValue(33);
        }
    }

    public void sp2(View view) {
        EditText servo1 = findViewById(R.id.nhapsv);
        EditText servo2 = findViewById(R.id.nhapsv1);
        EditText servo3 = findViewById(R.id.nhapsv2);
        EditText servo4 = findViewById(R.id.nhapsv3);
        EditText servo5 = findViewById(R.id.nhapsv4);

        String androidip1 = servo1.getText().toString();
        String androidip2 = servo2.getText().toString();
        String androidip3 = servo3.getText().toString();
        String androidip4 = servo4.getText().toString();
        String androidip5 = servo5.getText().toString();

        if (!androidip1.equals("") && !androidip2.equals("") && !androidip3.equals("") && !androidip4.equals("") &&!androidip5.equals("")) {
            FirebaseDatabase.getInstance().getReference("GocQuay").child("2").child("servo1").setValue(Integer.parseInt(androidip1));
            FirebaseDatabase.getInstance().getReference("GocQuay").child("2").child("servo2").setValue(Integer.parseInt(androidip2));
            FirebaseDatabase.getInstance().getReference("GocQuay").child("2").child("servo3").setValue(Integer.parseInt(androidip3));
            FirebaseDatabase.getInstance().getReference("GocQuay").child("2").child("servo4").setValue(Integer.parseInt(androidip4));
            FirebaseDatabase.getInstance().getReference("GocQuay").child("2").child("servo5").setValue(Integer.parseInt(androidip5));
            FirebaseDatabase.getInstance().getReference("Mode").child("State").setValue(33);
        }
    }

    public void sp3(View view) {
        EditText servo1 = findViewById(R.id.nhapsv);
        EditText servo2 = findViewById(R.id.nhapsv1);
        EditText servo3 = findViewById(R.id.nhapsv2);
        EditText servo4 = findViewById(R.id.nhapsv3);
        EditText servo5 = findViewById(R.id.nhapsv4);

        String androidip1 = servo1.getText().toString();
        String androidip2 = servo2.getText().toString();
        String androidip3 = servo3.getText().toString();
        String androidip4 = servo4.getText().toString();
        String androidip5 = servo5.getText().toString();

        if (!androidip1.equals("") && !androidip2.equals("") && !androidip3.equals("") && !androidip4.equals("") &&!androidip5.equals("")) {
            FirebaseDatabase.getInstance().getReference("GocQuay").child("3").child("servo1").setValue(Integer.parseInt(androidip1));
            FirebaseDatabase.getInstance().getReference("GocQuay").child("3").child("servo2").setValue(Integer.parseInt(androidip2));
            FirebaseDatabase.getInstance().getReference("GocQuay").child("3").child("servo3").setValue(Integer.parseInt(androidip3));
            FirebaseDatabase.getInstance().getReference("GocQuay").child("3").child("servo4").setValue(Integer.parseInt(androidip4));
            FirebaseDatabase.getInstance().getReference("GocQuay").child("3").child("servo5").setValue(Integer.parseInt(androidip5));
            FirebaseDatabase.getInstance().getReference("Mode").child("State").setValue(33);
        }
    }

    public void khongthepl(View view) {
        EditText servo1 = findViewById(R.id.nhapsv);
        EditText servo2 = findViewById(R.id.nhapsv1);
        EditText servo3 = findViewById(R.id.nhapsv2);
        EditText servo4 = findViewById(R.id.nhapsv3);
        EditText servo5 = findViewById(R.id.nhapsv4);

        String androidip1 = servo1.getText().toString();
        String androidip2 = servo2.getText().toString();
        String androidip3 = servo3.getText().toString();
        String androidip4 = servo4.getText().toString();
        String androidip5 = servo5.getText().toString();

        if (!androidip1.equals("") && !androidip2.equals("") && !androidip3.equals("") && !androidip4.equals("") &&!androidip5.equals("")) {
            FirebaseDatabase.getInstance().getReference("GocQuay").child("4").child("servo1").setValue(Integer.parseInt(androidip1));
            FirebaseDatabase.getInstance().getReference("GocQuay").child("4").child("servo2").setValue(Integer.parseInt(androidip2));
            FirebaseDatabase.getInstance().getReference("GocQuay").child("4").child("servo3").setValue(Integer.parseInt(androidip3));
            FirebaseDatabase.getInstance().getReference("GocQuay").child("4").child("servo4").setValue(Integer.parseInt(androidip4));
            FirebaseDatabase.getInstance().getReference("GocQuay").child("4").child("servo5").setValue(Integer.parseInt(androidip5));
            FirebaseDatabase.getInstance().getReference("Mode").child("State").setValue(33);
        }
    }
}