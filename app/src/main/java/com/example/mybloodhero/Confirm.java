package com.example.mybloodhero;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Confirm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Confirm");

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String icNo = intent.getStringExtra("IC");
        //String DOB = intent.getStringExtra("Date Of Birth");
        //String occupation = intent.getStringExtra("Occupation");
        String hpNo = intent.getStringExtra("Phone No");
        String hospital = intent.getStringExtra("Hospital");
        //String email = intent.getStringExtra("Email");
        String appointmentDate = intent.getStringExtra("Appointment Date");
        String appointmentTime = intent.getStringExtra("Appointment Time");

        TextView tvName = findViewById(R.id.name_edit_text);
        tvName.setText(name);
        TextView tvICNo = findViewById(R.id.edit_ic_text);
        tvICNo.setText(icNo);
        TextView tvHPNo = findViewById(R.id.edit_phoneno_text);
        tvHPNo.setText(hpNo);
        TextView tvHospital = findViewById(R.id.edit_hospital_appointment_text);
        tvHospital.setText(hospital);
        TextView tvAppointmentDate = findViewById(R.id.edit_date_text);
        tvAppointmentDate.setText(appointmentDate);
        TextView tvAppointmentTime = findViewById(R.id.edit_time_text);
        tvAppointmentTime.setText(appointmentTime);
        /*Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        int ic = intent.getIntExtra("IC", 0);
        int no = intent.getIntExtra("PhoneNo", 0);
        String hospital = intent.getStringExtra("Hospital");
        String date = intent.getStringExtra("Date");
        String time = intent.getStringExtra("Time");

        mTV = findViewById(R.id.name_edit_text);
        mTV.setText(name);
        mTV = findViewById(R.id.edit_ic_text);
        mTV.setText(ic);
        mTV = findViewById(R.id.edit_phoneno_text);
        mTV.setText(no);
        mTV = findViewById(R.id.edit_hospital_appointment_text);
        mTV.setText(hospital);
        mTV = findViewById(R.id.edit_date_text);
        mTV.setText(date);
        mTV = findViewById(R.id.edit_time_text);
        mTV.setText(time);*/
    }

    public void back_home(View view) {
        Intent home = new Intent(this, Home.class);
        startActivity(home);
    }
}