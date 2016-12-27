package com.cardinfolink.showmoney.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jie on 2016/12/27.
 */
public class Order implements Parcelable {

    private int icon;
    private String date;
    private String mark;
    private String datetime;
    private String type;
    private String amount;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Order() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.icon);
        dest.writeString(this.date);
        dest.writeString(this.datetime);
        dest.writeString(this.type);
        dest.writeString(this.amount);
    }

    protected Order(Parcel in) {
        this.icon = in.readInt();
        this.date = in.readString();
        this.datetime = in.readString();
        this.type = in.readString();
        this.amount = in.readString();
    }

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel source) {
            return new Order(source);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };
}
