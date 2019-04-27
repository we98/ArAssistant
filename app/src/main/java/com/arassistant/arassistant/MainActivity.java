package com.arassistant.arassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.arassistant.arassistant.popup.PopupInMainActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView takePhoto;
    private PopupInMainActivity popupInMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        takePhoto = findViewById(R.id.takePhoto);
        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(popupInMainActivity == null){
                    popupInMainActivity = new PopupInMainActivity(MainActivity.this);
                }
                popupInMainActivity.show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(popupInMainActivity != null){
            popupInMainActivity.dismiss();
        }
    }

}
