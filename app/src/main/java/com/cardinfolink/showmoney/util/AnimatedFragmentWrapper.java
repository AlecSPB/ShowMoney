package com.cardinfolink.showmoney.util;

import android.support.annotation.AnimRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by jie on 2016/12/27.
 */

public class AnimatedFragmentWrapper {

    private FragmentTransaction transaction;

    public AnimatedFragmentWrapper(@NonNull FragmentTransaction transaction) {
        this.transaction = transaction;
    }

    public AnimatedFragmentWrapper add(Fragment fragment, String tag) {
        transaction.add(fragment, tag);
        return this;
    }

    public AnimatedFragmentWrapper add(int containerId, Fragment fragment) {
        transaction.add(containerId, fragment);
        return this;
    }

    public AnimatedFragmentWrapper add(int containerId, Fragment fragment, String tag) {
        transaction.add(containerId, fragment, tag);
        return this;
    }

    public AnimatedFragmentWrapper replace(int containerId, Fragment fragment) {
        transaction.replace(containerId, fragment);
        return this;
    }

    public AnimatedFragmentWrapper replace(int containerId, Fragment fragment, String tag) {
        transaction.replace(containerId, fragment, tag);
        return this;
    }

    public AnimatedFragmentWrapper hide(Fragment fragment) {
        transaction.hide(fragment);
        return this;
    }

    public AnimatedFragmentWrapper show(Fragment fragment) {
        transaction.show(fragment);
        return this;
    }

    public AnimatedFragmentWrapper setCustomAnims(@AnimRes int enterAnim, @AnimRes int exitAnim) {
        transaction.setCustomAnimations(enterAnim, exitAnim);
        return this;
    }

    public AnimatedFragmentWrapper setCustomAnims(@AnimRes int enterAnim, @AnimRes int exitAnim, @AnimRes int popEnter, @AnimRes int popExit) {
        transaction.setCustomAnimations(enterAnim, exitAnim, popEnter, popExit);
        return this;
    }

    public void commit() {
        transaction.commit();
    }

    public AnimatedFragmentWrapper addToBackStack(String tag) {
        transaction.addToBackStack(tag);
        return this;
    }


}
