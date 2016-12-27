package com.cardinfolink.showmoney.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.cardinfolink.showmoney.R;
import com.cardinfolink.showmoney.base.BaseActivity;
import com.cardinfolink.showmoney.util.Constants;

/**
 * Created by jie on 2016/12/25.
 */
public class GotoQRPayActivity extends BaseActivity {

    private String amount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goto_payment);
        amount = getIntent().getStringExtra(Constants.AMOUNT);
        TextView tvAmount = (TextView) findViewById(R.id.tv_amount);
        tvAmount.setText(amount);
        setActionBar(getString(R.string.str_qr_payment), true);
    }


}
