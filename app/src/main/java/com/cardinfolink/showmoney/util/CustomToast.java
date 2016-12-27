package com.cardinfolink.showmoney.util;

import android.content.Context;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cardinfolink.showmoney.R;

import java.lang.ref.WeakReference;

/**
 * Created by jie on 2016/12/25.
 */

public class CustomToast {
    private int background;
    private static Toast toast;


    public static class Builder {
        private static WeakReference<Context> reference;

        public Builder(Context context) {
            toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
            reference = new WeakReference<Context>(context);
        }

        public Builder setBackground(View background) {
            toast.setView(background);
            return this;
        }

        public Builder setMessage(CharSequence cs) {
            toast.setText(cs);
            return this;
        }

        public Builder setMessage(@StringRes int resId) {
            toast.setText(resId);
            return this;
        }

        public Builder setDuration(int duration) {
            toast.setDuration(duration);
            return this;
        }

        public Builder setGravity(int gravity, int xOffset, int yOffset) {
            toast.setGravity(gravity, xOffset, yOffset);
            return this;
        }

        public Builder buildYellowBackground(String s) {
            View view = LayoutInflater.from(reference.get()).inflate(R.layout.custom_toast, null);
            TextView tvMsg = (TextView) view.findViewById(R.id.tv_msg);
            tvMsg.setText(s);
            toast.setView(view);
            return this;
        }

        public CustomToast build() {
            return new CustomToast();
        }
    }

    public void show() {
        toast.show();
    }
}
