package com.example.basicui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.buttonThree) {
            TextView txt = findViewById(R.id.txtObs);
            txt.setText("You clicked button three!");
        }
    }

    public void onButtonOneClicked(View view) {
        TextView txt = findViewById(R.id.txtObs);
        txt.setText("You clicked button one!");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTwo = findViewById(R.id.buttonTwo);
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txt = findViewById(R.id.txtObs);
                txt.setText("You clicked button two!");
            }
        });


        Button btnThree = findViewById(R.id.buttonThree);
        btnThree.setOnClickListener(this);

        RadioGroup rgColors;
        rgColors = findViewById(R.id.rgColors);
        rgColors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                String color;
                if (checkedId == R.id.rbBlue) color = "blue";
                else if (checkedId == R.id.rbRed) color = "red";
                else color = "yellow";

                Toast.makeText(MainActivity.this,
                        "You choose " + color,
                        Toast.LENGTH_SHORT).show();
            }
        });

        CheckBox cbApple, cbBanana;
        cbApple = findViewById(R.id.cbApple);
        cbBanana = findViewById(R.id.cbBanana);
        CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cbApple.isChecked() && cbBanana.isChecked())
                    Toast.makeText(MainActivity.this,
                            "You like both fruits.",
                            Toast.LENGTH_SHORT).show();
                else if (cbApple.isChecked())
                    Toast.makeText(MainActivity.this,
                            "You like apples.",
                            Toast.LENGTH_SHORT).show();
                else if (cbBanana.isChecked())
                    Toast.makeText(MainActivity.this,
                            "You like bananas.",
                            Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,
                            "You should eat more fruits.",
                            Toast.LENGTH_SHORT).show();
            }
        };
        cbBanana.setOnCheckedChangeListener(listener);
        cbApple.setOnCheckedChangeListener(listener);

        Switch switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, (isChecked ? "Checked" : "Not Checked"), Toast.LENGTH_SHORT).show();
            }
        });

        ProgressBar progressBar = findViewById(R.id.progressbar);

        progressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int progress = progressBar.getProgress();
                progressBar.setProgress((progress + 17) % 100);
            }
        });

        Spinner dropdown = findViewById(R.id.spinner);
        String[] items = new String[]{"Choose one...", "Car","Plane","Boat"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position != 0)
                Toast.makeText(MainActivity.this,"You choose " + items[position],Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}