package com.cardinfolink.showmoney.ui.orders;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cardinfolink.showmoney.R;
import com.cardinfolink.showmoney.base.BaseFragment;
import com.cardinfolink.showmoney.model.Order;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jie on 2016/12/23.
 */

public class OrdersFragment extends BaseFragment {

    private View view;
    private RecyclerView rvOrders;
    private List<Order> orders;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.orders_layout, container, false);
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
        rvOrders = (RecyclerView) view.findViewById(R.id.rv_orders);
        getOrders();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void getOrders() {
        orders = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            Order o = new Order();
            String date, datetime, mark, type;
            if (i < 10) {
                date = "23/12/2016";
                datetime = "19：20：11";
                mark = "日统计";
            } else if (i < 40) {
                date = "25/12/2016";
                datetime = "19：22：11";
                mark = "日统计";
            } else {
                date = "26/12/2016";
                datetime = "19：23：11";
                mark = "日统计";
            }
            switch (i % 3) {
                case 0:
                    type = "收款";
                    break;
                case 1:
                    type = "退货";
                    break;
                case 2:
                    type = "撤销";
                    break;
                default:
                    type = "";
                    break;
            }
            o.setDate(date);
            o.setDatetime(datetime);
            o.setMark(mark);
            o.setAmount("10.12");
            o.setType(type);
            orders.add(o);
        }
    }
}
