package com.tq.thingsmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.ibotta.android.support.pickerdialogs.SupportedDatePickerDialog;
import com.tq.thingsmanager.view.model.tile.CategoryGroupViewModel;
import com.tq.thingsmanager.view.model.tile.CategoryViewModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class EditActivity extends AppCompatActivity {

    private SupportedDatePickerDialog.OnDateSetListener listner = new SupportedDatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

        }
    };
    private CategoryGroupViewModel categoryGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        categoryGroup = (CategoryGroupViewModel) getIntent().getExtras().get("group");

        setGroupNameView();
        setCategorySpinner();

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

    private void setCategorySpinner() {
        List<String> categories = new ArrayList<>();
        for(CategoryViewModel categoryViewModel : categoryGroup.getPurchaseCategoryList() ) {
            categories.add(categoryViewModel.getName());
        }

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories));
    }

    private void prepareDate() {

    }


    private void setGroupNameView() {
        TextView textView = findViewById(R.id.groupName);
        textView.setText(categoryGroup.getText());
    }

}
