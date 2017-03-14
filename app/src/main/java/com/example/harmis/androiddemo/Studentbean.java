package com.example.harmis.androiddemo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Harmis on 06/03/17.
 */

public class Studentbean implements Parcelable{

    String studentID=null;
    String studentName=null;
    Resultbean resultbean=null;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Studentbean (String studentID, String studentName)
    {
        this.studentID=studentID;
        this.studentName=studentName;
    }


    protected Studentbean(Parcel in) {
        studentID = in.readString();
        studentName = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(studentID);
        dest.writeString(studentName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Studentbean> CREATOR = new Creator<Studentbean>() {
        @Override
        public Studentbean createFromParcel(Parcel in) {
            return new Studentbean(in);
        }

        @Override
        public Studentbean[] newArray(int size) {
            return new Studentbean[size];
        }
    };
}
