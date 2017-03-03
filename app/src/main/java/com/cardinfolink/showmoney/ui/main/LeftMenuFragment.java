package com.cardinfolink.showmoney.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cardinfolink.showmoney.R;
import com.cardinfolink.showmoney.adapter.LeftMenuListAdapter;
import com.cardinfolink.showmoney.base.BaseFragment;
import com.cardinfolink.showmoney.listener.OnItemClickListener;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by jie on 2016/12/25.
 * 左侧菜单
 */

public class LeftMenuFragment extends BaseFragment {

    private int maxWidth;

    private RecyclerView rvSelections;

    private List<String> menuItems;
    private View view;
    private LeftMenuListAdapter adapter;

    private static final int DEFAULT_SELECTION = 0;

    public interface OnLeftMenuSelectedListener {
        void onMenuItemSelected(View view, int position);
    }

    OnLeftMenuSelectedListener onLeftMenuSelectedListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int w_screen = dm.widthPixels;
        maxWidth = (int) (w_screen * 1.0f * 0.75);

        if (getActivity() instanceof OnLeftMenuSelectedListener) {
            onLeftMenuSelectedListener = (OnLeftMenuSelectedListener) getActivity();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.left_menu, container, false);
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
        rvSelections = (RecyclerView) view.findViewById(R.id.rv_selections);
        menuItems = new LinkedList<>();
        menuItems.add(getString(R.string.str_get_money));
        menuItems.add(getString(R.string.str_reund));
        menuItems.add(getString(R.string.str_orders));
        menuItems.add(getString(R.string.str_settings));
        menuItems.add(getString(R.string.str_about));
        adapter = new LeftMenuListAdapter(getActivity(), menuItems);
        rvSelections.setAdapter(adapter);
        rvSelections.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClicked(View v, int position) {
                if (onLeftMenuSelectedListener != null) {
                    onLeftMenuSelectedListener.onMenuItemSelected(v, position);
                }
                adapter.setSelectable(position);
            }
        });
        //设置创建时的默认UI
        if (onLeftMenuSelectedListener != null) {
            adapter.setSelectable(DEFAULT_SELECTION);
            onLeftMenuSelectedListener.onMenuItemSelected(rvSelections, DEFAULT_SELECTION);
        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
