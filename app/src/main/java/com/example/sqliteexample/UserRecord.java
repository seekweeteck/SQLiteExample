package com.example.sqliteexample;

import com.example.sqliteexample.UserContract.User;

public class UserRecord {
    private String phone;
    private String name;
    private String email;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  User.COLUMN_PHONE + ":" + this.phone + "," + User.COLUMN_NAME + ":" + this.name +
                "," + User.COLUMN_EMAIL + ":" + this.email;
    }

}
