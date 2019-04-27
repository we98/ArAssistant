package com.arassistant.arassistant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.arassistant.arassistant.popup.PopupInOperationListActivity;

public class OperationListActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView operationList;

    private PopupInOperationListActivity popupInOperationListActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_list);
        operationList = findViewById(R.id.operationList);
        operationList.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.operationList:
                showPopupWindow();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(popupInOperationListActivity != null){
            popupInOperationListActivity.dismiss();
        }
    }

    private void showPopupWindow(){
        if(popupInOperationListActivity == null){
            popupInOperationListActivity = new PopupInOperationListActivity(this);
        }
        popupInOperationListActivity.show();
    }


}
