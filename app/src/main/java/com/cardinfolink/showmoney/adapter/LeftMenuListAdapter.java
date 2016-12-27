package com.cardinfolink.showmoney.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cardinfolink.showmoney.R;
import com.cardinfolink.showmoney.listener.OnItemClickListener;

import java.util.List;

/**
 * Created by jie on 2016/12/25.
 */

public class LeftMenuListAdapter extends RecyclerView.Adapter<LeftMenuListAdapter.ViewHolder> {

    private List<String> menuItems;
    private LayoutInflater inflater;

    OnItemClickListener onItemClickListener;
    private int selection = -1;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public LeftMenuListAdapter(Context context, List<String> menuItems) {
        this.inflater = LayoutInflater.from(context);
        this.menuItems = menuItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.memu_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        boolean selectable = selection != -1 && position == selection;
        holder.tvItem.setSelected(selectable);
        holder.ivItem.setSelected(selectable);
        holder.tvItem.setText(menuItems.get(position));
    }

    @Override
    public int getItemCount() {
        return menuItems == null ? 0 : menuItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvItem;
        ImageView ivItem;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvItem = (TextView) itemView.findViewById(R.id.tv_item);
            ivItem = (ImageView) itemView.findViewById(R.id.iv_icon);
        }

        @Override
        public void onClick(View view) {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClicked(view, getAdapterPosition());
            }
        }
    }

    /**
     * 设置选中项
     *
     * @param position
     */
    public void setSelectable(int position) {
        this.selection = position;
        notifyDataSetChanged();
    }
}
