package com.tq.thingsmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ibotta.android.support.pickerdialogs.SupportedDatePickerDialog;
import com.ibotta.android.support.pickerdialogs.SupportedTimePickerDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EditActivity extends AppCompatActivity {

    private SupportedDatePickerDialog.OnDateSetListener listner = new SupportedDatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        prapareGroupName();

        View view = findViewById(R.id.btnDate);
        view.setOnClickListener(new View.OnClickListener() {
            private DatePickerDialog.OnDateSetListener dateListner = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                }
            };

            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day  = cal.get(Calendar.DAY_OF_MONTH);

                SupportedDatePickerDialog dialog = new SupportedDatePickerDialog(EditActivity.this, R.style.SpinnerDatePickerDialogTheme, listner, year, month, day);
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        prepareDate();

    }

    private void prepareDate() {

    }


    private void prapareGroupName() {
        TextView textView = findViewById(R.id.groupName);
        Bundle bundle = getIntent().getExtras();
        String idName = bundle.getString("id");
        textView.setText(idName);
    }

}
