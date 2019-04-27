package com.arassistant.arassistant.popup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

import com.arassistant.arassistant.R;
import com.arassistant.arassistant.SelectProblemActivity;

public class PopupInMainActivity extends PopupWindow implements View.OnClickListener {

    private Context context;
    private Button confirm;
    private Button reRecongnize;

    public PopupInMainActivity(Context context) {
        super(context);
        this.context = context;
        initalize();
    }

    private void initalize(){
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.popupwindow_activity_main, null);
        setContentView(view);
        confirm = view.findViewById(R.id.confirm);
        confirm.setOnClickListener(this);
        reRecongnize = view.findViewById(R.id.reRecongnize);
        reRecongnize.setOnClickListener(this);
        initWindow();
    }

    private int height;
    private void initWindow() {
        WindowManager manager = ((Activity)context).getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        int width = outMetrics.widthPixels;
        height = outMetrics.heightPixels;
        this.setWidth((int)(width*0.7));
        this.setHeight(width);
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        this.update();
        ColorDrawable dw = new ColorDrawable(0x00000000);
        this.setBackgroundDrawable(dw);
        this.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                setBackgroundAlpha((Activity)context, 1f);
            }
        });
    }

    //设置添加屏幕的背景透明度
    private void setBackgroundAlpha(Activity context, float bgAlpha) {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        context.getWindow().setAttributes(lp);
    }

    public void show() {
        setBackgroundAlpha((Activity)context, 0.8f);
        setAnimationStyle(R.style.window_in_activity_main_pop_animation);
        View currentView = ((Activity)context).getWindow().getDecorView();
        showAtLocation(currentView, Gravity.BOTTOM, 0, height >> 2);//有偏差
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.confirm:
                Intent intent = new Intent(context, SelectProblemActivity.class);
                context.startActivity(intent);
                break;
            case R.id.reRecongnize:
                break;
        }
    }



}
