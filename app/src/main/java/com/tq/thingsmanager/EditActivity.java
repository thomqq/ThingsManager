package com.tq.thingsmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        prapareGroupName();
        prepareCalendar();
    }

    private void prepareCalendar() {
        Calendar calendar = Calendar.getInstance();
        int maxDay = calendar.getMaximum(Calendar.DAY_OF_MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        Spinner spinnerDay = findViewById(R.id.spinerDay);
        List<String> days = new ArrayList<>();
        for( int i = 1 ; i <= maxDay; ++i) {
            days.add("" + i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, days);
        spinnerDay.setAdapter(adapter);
        spinnerDay.setSelection(day - 1);

    }

    private void prapareGroupName() {
        TextView textView = findViewById(R.id.groupName);
        Bundle bundle = getIntent().getExtras();
        String idName = bundle.getString("id");
        textView.setText(idName);
    }

}
