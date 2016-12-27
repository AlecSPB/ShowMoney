package com.cardinfolink.showmoney.ui.orders;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cardinfolink.showmoney.R;
import com.cardinfolink.showmoney.adapter.OrderListAdapter;
import com.cardinfolink.showmoney.base.BaseFragment;
import com.cardinfolink.showmoney.model.Order;

import java.util.List;

/**
 * Created by jie on 2016/12/23.
 */

public class SearchFragment extends BaseFragment {

    private View view;
    private RecyclerView rvOrders;
    private List<Order> orders;
    private OrderListAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.search_order, container, false);
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
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
