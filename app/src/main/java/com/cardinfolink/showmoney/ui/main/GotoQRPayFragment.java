package com.cardinfolink.showmoney.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cardinfolink.showmoney.R;
import com.cardinfolink.showmoney.base.BaseFragment;
import com.cardinfolink.showmoney.util.Constants;

/**
 * Created by jie on 2016/12/25.
 */
public class GotoQRPayFragment extends BaseFragment {

    private String amount;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        amount = getArguments().getString(Constants.AMOUNT);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.goto_payment, container, false);
        TextView tvAmount = (TextView) view.findViewById(R.id.tv_amount);
        tvAmount.setText(amount);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (resumeObservable != null) {
            resumeObservable.update(getString(R.string.str_qr_payment), true);
        }
    }
}
