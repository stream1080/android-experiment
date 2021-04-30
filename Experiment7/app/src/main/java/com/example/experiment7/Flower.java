package com.example.experiment7;

import android.os.Parcel;
import android.os.Parcelable;

public class Flower implements Parcelable {
    private String title;
    private int imageId,titleIcon;

    public Flower(String title, int titleIcon, int imageId) {
        this.title = title;
        this.imageId = imageId;
        this.titleIcon = titleIcon;
    }

    protected Flower(Parcel in) {
        title = in.readString();
        imageId = in.readInt();
        titleIcon = in.readInt();
    }

    public static final Creator<Flower> CREATOR = new Creator<Flower>() {
        @Override
        public Flower createFromParcel(Parcel in) {
            return new Flower(in);
        }

        @Override
        public Flower[] newArray(int size) {
            return new Flower[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public int getImageId() {
        return imageId;
    }

    public int getTitleIcon() {
        return titleIcon;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeInt(imageId);
        dest.writeInt(titleIcon);
    }
}
