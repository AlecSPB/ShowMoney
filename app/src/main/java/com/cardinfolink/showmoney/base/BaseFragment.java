package com.cardinfolink.showmoney.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.cardinfolink.showmoney.listener.OnFragmentResumeObservable;
import com.cardinfolink.showmoney.listener.OnFragmentToActivityObservable;

/**
 * Created by jie on 2016/12/23.
 */

public abstract class BaseFragment extends Fragment {
    protected OnFragmentToActivityObservable observable;
    protected OnFragmentResumeObservable resumeObservable;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity() instanceof OnFragmentToActivityObservable) {
            observable = (OnFragmentToActivityObservable) getActivity();
        }
        if (getActivity() instanceof OnFragmentResumeObservable) {
            resumeObservable = (OnFragmentResumeObservable) getActivity();
        }
    }
}
