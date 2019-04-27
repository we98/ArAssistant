package com.arassistant.arassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SelectProblemActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView usualProblems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_problem);
        usualProblems = findViewById(R.id.usualProblems);
        usualProblems.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.usualProblems:
                Intent intent = new Intent(this, UsualProblemActivity.class);
                startActivity(intent);
                break;
        }
    }
}
