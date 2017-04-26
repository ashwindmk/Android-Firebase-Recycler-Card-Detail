package com.example.ashwin.firebaserecyclercardview;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ashwin on 12/9/16.
 */

public class Person implements Parcelable {

    private String name, address, photo;

    public Person() {
    }

    public Person(String name, String address, String photoUrl) {
        this.name = name;
        this.address = address;
        this.photo = photoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoto(String photoUrl) {
        this.photo = photoUrl;
    }

    public String getPhoto() {
        return photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.address);
        dest.writeString(this.photo);
    }

    protected Person(Parcel in) {
        this.name = in.readString();
        this.address = in.readString();
        this.photo = in.readString();
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
