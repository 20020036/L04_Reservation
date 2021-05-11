package sg.edu.rp.c346.id20020036.l04_reservation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button btnReserve, btnReset;
    TextView textViewName, textViewPhNo, textViewGrpSize;
    EditText editTextName, editTextPhoneNo, editTextNumber;
    CheckBox checkBoxSmoking;
    DatePicker dp;
    TimePicker tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnReserve = findViewById(R.id.btnReserve);
        btnReset = findViewById(R.id.btnReset);
        textViewName = findViewById(R.id.textViewName);
        textViewPhNo = findViewById(R.id.textViewPhNo);
        textViewGrpSize = findViewById(R.id.textViewGrpSize);
        editTextName = findViewById(R.id.editTextName);
        editTextPhoneNo = findViewById(R.id.editTextPhoneNo);
        editTextNumber = findViewById(R.id.editTextNumber);
        checkBoxSmoking = findViewById(R.id.checkBoxSmoking);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextName.getText().toString().trim().length() != 0 && editTextPhoneNo.getText().toString().trim().length() != 0 && editTextNumber.getText().toString().trim().length() != 0)
                {
                    String date = dp.getDayOfMonth() + "/" + (dp.getMonth() + 1) + "/" + dp.getYear();
                    String todayDate = "11/5/2021";
                    if(date == todayDate)
                    {
                        Toast.makeText(MainActivity.this, "Today's date cannot be the booking date.", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        if(checkBoxSmoking.isChecked()) {
                            String date1 = "Date: " + dp.getDayOfMonth() + "/" + (dp.getMonth() + 1) + "/" + dp.getYear();
                            String name = "Name: " + editTextName.getText();
                            String phone = "Phone No.: " + editTextPhoneNo.getText();
                            String size = "Size: " + editTextNumber.getText();
                            String smoking = "Smoking Area booked.";
                            String info = name + " " + phone + " " + size + " " + date + " " + smoking;
                            Toast.makeText(MainActivity.this, info, Toast.LENGTH_LONG).show();
                        }
                        else
                        {
                            String date1 = "Date: " + dp.getDayOfMonth() + "/" + (dp.getMonth() + 1) + "/" + dp.getYear();
                            String name = "Name: " + editTextName.getText();
                            String phone = "Phone No.: " + editTextPhoneNo.getText();
                            String size = "Size: " + editTextNumber.getText();
                            String smoking = "Non-Smoking Area booked.";
                            String info = name + " " + phone + " " + size + " " + date1 + " " + smoking;
                            Toast.makeText(MainActivity.this, info, Toast.LENGTH_LONG).show();
                        }
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Please fill in ALL the fields", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextName.setText("");
                editTextPhoneNo.setText("");
                editTextNumber.setText("");
                checkBoxSmoking.setChecked(false);
                dp.updateDate(2021, 05, 01);
                tp.setCurrentMinute(30);
                tp.setCurrentHour(19);
            }
        });

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                if(tp.getCurrentHour() > 8 || tp.getCurrentHour() < 8)
                {
                    tp.setCurrentHour(8);
                }
            }
        });
    }
}