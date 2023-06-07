package com.example.roomdata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewUserActivity extends AppCompatActivity {
    EditText firstname;
    EditText lastname;
     Button saveButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNewUser(firstname.getText().toString(), lastname.getText().toString());
            }
        });
    }
    private void saveNewUser(String firstname, String lastname) {
        AppDatabase db = AppDatabase.getDbInstance((this.getApplicationContext()));

        User user = new User();
        user.FirstName = firstname;
        user.LastName = lastname;
        db.userDao().insertUser(user);

        finish();
    }
}