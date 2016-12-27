package com.cardinfolink.showmoney.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jie on 2016/12/25.
 */

public class User implements Parcelable {

    private String userStoreId;
    private String storeAssistId;
    private String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUserStoreId() {
        return userStoreId;
    }

    public void setUserStoreId(String userStoreId) {
        this.userStoreId = userStoreId;
    }

    public String getStoreAssistId() {
        return storeAssistId;
    }

    public void setStoreAssistId(String storeAssistId) {
        this.storeAssistId = storeAssistId;
    }

    public User() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.userStoreId);
        dest.writeString(this.storeAssistId);
        dest.writeString(this.icon);
    }

    protected User(Parcel in) {
        this.userStoreId = in.readString();
        this.storeAssistId = in.readString();
        this.icon = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
