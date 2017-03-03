package com.cardinfolink.showmoney.ui;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;

import com.cardinfolink.showmoney.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jie on 2017/2/28.
 */

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.keyboard_layout);
        ButterKnife.bind(this);
    }

    private View setTopView() {
        FrameLayout contentView = (FrameLayout) findViewById(Window.ID_ANDROID_CONTENT);
        View view = new View(this);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0));
        view.setId(R.id.temp_top_view);
        View tempView = contentView.findViewById(R.id.temp_top_view);
        if (tempView == null) {
            contentView.addView(view, 0);
        } else {
            view = tempView;
        }
        return view;
    }

    @OnClick(R.id.btn_qr_pay)
    public void onClick() {
        View view = getLayoutInflater().inflate(R.layout.test, (ViewGroup) getCurrentFocus(), false);
        view.setFitsSystemWindows(false);
        PopupWindow pop = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        pop.setOutsideTouchable(true);
        pop.setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        pop.showAsDropDown(setTopView());

    }
}
