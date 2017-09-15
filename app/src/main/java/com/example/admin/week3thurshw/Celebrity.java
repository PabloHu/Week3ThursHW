package com.example.admin.week3thurshw;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 9/14/2017.
 */

public class Celebrity implements Parcelable {
    int ID;
    String Name;
    int Age;
    int Weight;
    int ImageID;

    public Celebrity(int ID, String name, int age, int weight, int imageID) {
        this.ID = ID;
        Name = name;
        Age = age;
        Weight = weight;
        ImageID = imageID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.ID);
        dest.writeString(this.Name);
        dest.writeInt(this.Age);
        dest.writeInt(this.Weight);
        dest.writeInt(this.ImageID);
    }

    public Celebrity() {
    }

    protected Celebrity(Parcel in) {
        this.ID = in.readInt();
        this.Name = in.readString();
        this.Age = in.readInt();
        this.Weight = in.readInt();
        this.ImageID = in.readInt();
    }

    public static final Parcelable.Creator<Celebrity> CREATOR = new Parcelable.Creator<Celebrity>() {
        @Override
        public Celebrity createFromParcel(Parcel source) {
            return new Celebrity(source);
        }

        @Override
        public Celebrity[] newArray(int size) {
            return new Celebrity[size];
        }
    };

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public int getImageID() {
        return ImageID;
    }

    public void setImageID(int imageID) {
        ImageID = imageID;
    }
}