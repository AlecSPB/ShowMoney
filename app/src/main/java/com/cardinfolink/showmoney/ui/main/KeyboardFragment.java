package com.cardinfolink.showmoney.ui.main;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.SuperscriptSpan;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.TextView;
import android.widget.Toast;

import com.cardinfolink.showmoney.R;
import com.cardinfolink.showmoney.base.BaseFragment;
import com.cardinfolink.showmoney.util.CustomToast;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Stack;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by jie on 2016/12/23.
 */

public class KeyboardFragment extends BaseFragment {

    @Bind(R.id.tv_amount)
    TextView tvAmount;

    private final String DEFAULT_AMOUNT = "0.00";

    private final String AMOUNT_SIGN = "€";

    private Stack<String> amountStack;
    private onQrSelectedListener mListener;
    private SpannableString ss;

    public interface onQrSelectedListener {
        public void onQrSelectedListener(String amount);
    }

    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        amountStack = new Stack<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.keyboard_layout, container, false);
        } else {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null) {
                parent.removeView(view);
            }
        }
        ButterKnife.bind(this, view);
        formatAmount();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (onQrSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement onQrSelectedListener");

        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.btn_qr_pay, R.id.btn_clear, R.id.btn_seven, R.id.btn_eight, R.id.btn_nine, R.id.btn_four, R.id.btn_five, R.id.btn_six, R.id.btn_one, R.id.btn_two, R.id.btn_three, R.id.btn_zero, R.id.btn_del})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_qr_pay:
                gotoQRPay();
                break;
            case R.id.btn_clear:
                popAll();
                break;
            case R.id.btn_seven:
                push(getString(R.string.str_key_seven));
                break;
            case R.id.btn_eight:
                push(getString(R.string.str_key_eight));
                break;
            case R.id.btn_nine:
                push(getString(R.string.str_key_nine));
                break;
            case R.id.btn_four:
                push(getString(R.string.str_key_four));
                break;
            case R.id.btn_five:
                push(getString(R.string.str_key_five));
                break;
            case R.id.btn_six:
                push(getString(R.string.str_key_six));
                break;
            case R.id.btn_one:
                push(getString(R.string.str_key_one));
                break;
            case R.id.btn_two:
                push(getString(R.string.str_key_two));
                break;
            case R.id.btn_three:
                push(getString(R.string.str_key_three));
                break;
            case R.id.btn_zero:
                push(getString(R.string.str_key_zero));
                break;
            case R.id.btn_del:
                pop();
                break;
            default:
                break;
        }
    }

    private void gotoQRPay() {
        mListener.onQrSelectedListener(ss.toString());
    }

    /**
     * 校验金额是否合法
     *
     * @return
     */
    private boolean validAndAlert() {
        String amount = getFormatAmount();
        Double d = Double.parseDouble(amount);
        if (d <= 0) {
            new CustomToast.Builder(getActivity())
                    .setGravity(Gravity.TOP | Gravity.FILL_HORIZONTAL, 0, 0)
                    .setDuration(Toast.LENGTH_SHORT)
                    .buildYellowBackground("金额不能为零")
                    .build()
                    .show();

            return false;
        }
        return true;
    }

    /**
     * 将堆栈中的字符取出并组成字符串
     *
     * @return
     */
    private String stackToString() {
        String amount = "";
        if (!amountStack.isEmpty()) {
            for (String num : amountStack) {
                amount = amount + num;
            }
        } else {
            amount = "0";
        }
        return amount;
    }

    /**
     * 输入字符装换成金额
     *
     * @return
     */
    private String getFormatAmount() {
        String s = stackToString();
        BigDecimal bigDecimal = new BigDecimal(s);
        bigDecimal = bigDecimal.divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_DOWN);
        return bigDecimal.toString();
    }

    private void pop() {
        if (!amountStack.isEmpty()) {
            amountStack.pop();
            formatAmount();
        }
    }

    private void popAll() {
        while (!amountStack.isEmpty()) {
            amountStack.pop();
        }
        formatAmount();
    }

    private void push(String num) {
        if (amountStack.size() >= 12 || ("0".equals(num) && amountStack.isEmpty())) {
            addShakeAnim();
            return;
        }
        amountStack.push(num);
        formatAmount();
    }

    /**
     * 格式化输入字符，并显示出来
     */
    private void formatAmount() {
        String amount = stackToString();
        BigDecimal bigDecimal = new BigDecimal(amount);
        bigDecimal = bigDecimal.divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_DOWN).setScale(2, BigDecimal.ROUND_HALF_DOWN);
        String format = String.format(Locale.getDefault(), "%s %s", AMOUNT_SIGN, bigDecimal.toString());
        ss = new SpannableString(format);

        int textSize, signSize;//dp
        int textColor;
        if (amountStack.size() <= 8) {
            textSize = 36;
            signSize = 20;
        } else if (amountStack.size() <= 9) {
            textSize = 34;
            signSize = 19;
        } else if (amountStack.size() <= 10) {
            textSize = 32;
            signSize = 18;
        } else if (amountStack.size() <= 11) {
            textSize = 30;
            signSize = 17;
        } else {
            textSize = 28;
            signSize = 16;
        }
        if (amountStack.isEmpty()) {
            textColor = Color.parseColor("#999999");
        } else {
            textColor = Color.BLACK;
        }
        ss.setSpan(new AbsoluteSizeSpan(signSize, true), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(new SuperscriptSpan(), 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);//上标
        ss.setSpan(new AbsoluteSizeSpan(textSize, true), 1, format.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tvAmount.setText(ss);
        tvAmount.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);
        tvAmount.setTextColor(textColor);
        if (amountStack.isEmpty()) {
            addShakeAnim();
        }
    }

    /**
     * 添加抖动动画
     */
    private void addShakeAnim() {
        AnimationSet set = new AnimationSet(true);

        Animation rotateAnim1 = new RotateAnimation(-2, 2, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnim1.setInterpolator(new CycleInterpolator(5));

        Animation rotateAnim2 = new RotateAnimation(-1, 1, Animation.RELATIVE_TO_SELF, 0.2f,
                Animation.RELATIVE_TO_SELF, 0.2f);

        Animation rotateAnim3 = new RotateAnimation(-1, 1, Animation.RELATIVE_TO_SELF, 0.8f,
                Animation.RELATIVE_TO_SELF, 0.8f);

        set.addAnimation(rotateAnim1);
//        set.addAnimation(rotateAnim2);
//        set.addAnimation(rotateAnim3);
        set.setDuration(20);
        set.setRepeatMode(Animation.REVERSE);
        set.setRepeatCount(3);

        tvAmount.clearAnimation();
        tvAmount.startAnimation(set);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (resumeObservable != null) {
            resumeObservable.update(getString(R.string.str_get_money), false);
        }
    }
}
