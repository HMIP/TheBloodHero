package com.example.mybloodhero;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class Appointment extends AppCompatActivity {
    private String name, icNo, DOB, occupation, hpNo, email, appointmentDate, appointmentTime;
    //private EditText
    Button buttonNext;
    EditText etName, etIC, etDOB, etOccupation, etHpno, etEmail, etdAppointmentDate, etAppointmentTime;
    //Spinner

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centre);

        //Spinner or gender
        Spinner genderSpinner = findViewById(R.id.spinner_gender);
        ArrayAdapter<CharSequence> genderAdapter = ArrayAdapter.createFromResource(this, R.array.gender, R.layout.spinner_layout);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);

        //Spinner for blood type
        Spinner bloodSpinner = findViewById(R.id.spinner_blood);
        ArrayAdapter<CharSequence> bloodAdapter = ArrayAdapter.createFromResource(this, R.array.blood, R.layout.spinner_layout);
        bloodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodSpinner.setAdapter(bloodAdapter);

        //Spinner for ethnicity
        Spinner ethnicitySpinner = findViewById(R.id.spinner_race);
        ArrayAdapter<CharSequence> ethnicityAdapter = ArrayAdapter.createFromResource(this, R.array.race, R.layout.spinner_layout);
        ethnicityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ethnicitySpinner.setAdapter(ethnicityAdapter);

        //Spinner for marital status
        Spinner maritalSpinner = findViewById(R.id.m_state);
        ArrayAdapter<CharSequence> maritalAdapter = ArrayAdapter.createFromResource(this, R.array.mstatus, R.layout.spinner_layout);
        maritalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        maritalSpinner.setAdapter(maritalAdapter);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Appointment");

        buttonNext = findViewById(R.id.btnNext);
        etName = findViewById(R.id.type_name);
        etIC = findViewById(R.id.type_ic);
        etDOB = findViewById(R.id.text_datebd);
        etOccupation = findViewById(R.id.edit_occupation);
        etHpno = findViewById(R.id.edit_no);
        etEmail = findViewById(R.id.edit_email);
        etdAppointmentDate = findViewById(R.id.edit_date);
        etAppointmentTime = findViewById(R.id.edit_time_appoint);

        buttonNext.setOnClickListener(v -> {
            name = etName.getText().toString();
            icNo = etIC.getText().toString();
            DOB = etDOB.getText().toString();
            occupation = etOccupation.getText().toString();
            hpNo = etHpno.getText().toString();
            email = etEmail.getText().toString();
            appointmentDate = etdAppointmentDate.getText().toString();
            appointmentTime = etAppointmentTime.getText().toString();



            if ((findViewById(R.id.type_name) == null) & (findViewById(R.id.type_ic) == null) & (findViewById(R.id.text_datebd) == null) &
                    (findViewById(R.id.edit_occupation) == null) & (findViewById(R.id.edit_no) == null) &
                    (findViewById(R.id.edit_email) == null) & (findViewById(R.id.dateTime) == null) & (findViewById(R.id.edit_time_appoint) == null)) {
                Toast.makeText(Appointment.this, "Form not complete",Toast.LENGTH_SHORT).show();
            } else {
                Intent intent_confirm = new Intent(Appointment.this, Confirm.class);
                intent_confirm.putExtra("Name", name);
                intent_confirm.putExtra("IC", icNo);
                intent_confirm.putExtra("Date of Birth",DOB);
                intent_confirm.putExtra("Occupation", occupation);
                intent_confirm.putExtra("Phone no", hpNo);
                intent_confirm.putExtra("Email", email);
                intent_confirm.putExtra("Appointment Date", appointmentDate);
                intent_confirm.putExtra("Appointment Time", appointmentTime);
                startActivity(intent_confirm);
            }

        });
    }

    public void choice_bd(View view) {
        DialogFragment newFragment = new choice_bd();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    @SuppressLint("SetTextI18n")
    public void choice_bdResult(int year, int month, int day) {
        String month_bd = Integer.toString(month+1);
        String day_bd = Integer.toString(day);
        String year_bd = Integer.toString(year);
        etDOB = findViewById(R.id.text_datebd);
        etDOB.setText(day_bd + "/" + month_bd + "/" + year_bd);
    }

    public void choice_dt(View view) {
        DialogFragment newFragment = new choice_dt();
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }

    @SuppressLint("SetTextI18n")
    public void choice_dtResult(int yeardt, int monthdt, int daydt) {
        String month_dt = Integer.toString(monthdt +1);
        String day_dt = Integer.toString(daydt);
        String year_dt = Integer.toString(yeardt);
        etdAppointmentDate = findViewById(R.id.edit_date);
        etdAppointmentDate.setText(day_dt + "/" + month_dt + "/" + year_dt);
    }
}