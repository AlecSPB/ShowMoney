package com.cardinfolink.showmoney.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cardinfolink.showmoney.R;
import com.cardinfolink.showmoney.base.BaseFragment;


/**
 * Created by jie on 2016/12/25.
 */

public class RightMenuFragment extends BaseFragment {

    private int maxWidth;

    private ImageView headerIcon;
    private TextView tvStoreId, tvAssistId;
    private View view;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int w_screen = dm.widthPixels;
        maxWidth = (int) (w_screen * 1.0f * 0.75);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.nav_right_part, container, false);
            initView();
        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
        }
        return view;
    }

    private void initView() {
        ViewGroup.LayoutParams params = view.getLayoutParams();
        params.width = maxWidth;
        view.setLayoutParams(params);
        headerIcon = (ImageView) view.findViewById(R.id.iv_user_icon);
        tvStoreId = (TextView) view.findViewById(R.id.tv_store_id);
        tvAssistId = (TextView) view.findViewById(R.id.tv_assist_id);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
