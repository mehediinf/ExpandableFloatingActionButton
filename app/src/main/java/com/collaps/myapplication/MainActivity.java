package com.collaps.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton addAlarmFab, addPersonFab;
    ExtendedFloatingActionButton addActionFab;
    TextView addAlarmText, addPersonText;

    // to check whether sub FAB's are visible or not
    Boolean isAllFABVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addAlarmFab = findViewById(R.id.add_alarm_Id);
        addPersonFab = findViewById(R.id.add_person_Id);
        addActionFab = findViewById(R.id.add_fab_id);

        addAlarmText = findViewById(R.id.add_alarm_txt_id);
        addPersonText = findViewById(R.id.add_person_txt_id);

        // Initially hide the FABs and Texts
        addAlarmFab.setVisibility(View.GONE);
        addPersonFab.setVisibility(View.GONE);
        addAlarmText.setVisibility(View.GONE);
        addPersonText.setVisibility(View.GONE);

        // Set initial state of FAB visibility
        isAllFABVisible = false;

        // Click listener for the main Ex FAB
        addActionFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!isAllFABVisible) {
                    // Show sub FABs and texts
                    addAlarmFab.show();
                    addPersonFab.show();
                    addAlarmText.setVisibility(View.VISIBLE);
                    addPersonText.setVisibility(View.VISIBLE);

                    // Extend the Ex FAB
                    addActionFab.extend();

                    isAllFABVisible = true;

                } else {
                    // Hide sub FABs and texts
                    addAlarmFab.hide();
                    addPersonFab.hide();
                    addAlarmText.setVisibility(View.GONE);
                    addPersonText.setVisibility(View.GONE);

                    // Shrink the Ex FAB
                    addActionFab.shrink();

                    isAllFABVisible = false;
                }
            }
        });

        // Click listener for the Person FAB
        addPersonFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Person Added", Toast.LENGTH_SHORT).show();
            }
        });

        // Click listener for the Alarm FAB
        addAlarmFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Alarm Added", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
