package com.example.roomdata;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

        @PrimaryKey(autoGenerate = true)
        public int userId;

        @ColumnInfo(name="First_Name")
        public String FirstName;

        @ColumnInfo(name="Last_Name")
        public String LastName;

        public User(){
                this.FirstName=FirstName;
                this.LastName=LastName;
        }

}