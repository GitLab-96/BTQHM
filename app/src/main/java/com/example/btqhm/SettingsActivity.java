package com.example.btqhm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class SettingsActivity extends AppCompatActivity {
    private CircleImageView profileImage;
    private EditText userTitle,userName,userEmail,userPhone;
    private Button saveButn;
    private String currentUerID;
    private FirebaseAuth mAuth;
    private DatabaseReference RootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        mAuth = FirebaseAuth.getInstance();
        currentUerID = mAuth.getCurrentUser().getUid();
        RootRef= FirebaseDatabase.getInstance().getReference();
        init();
        saveButn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UpdateSettings();
            }
        });
    }


    private void init() {
        profileImage = findViewById(R.id.profileImage);
        userTitle = findViewById(R.id.set_user_title);
        userName = findViewById(R.id.set_user_name);
        userEmail =  findViewById(R.id.set_user_email);
        userPhone = findViewById(R.id.set_user_phone);
        saveButn = findViewById(R.id.saveBttn);

    }
    private void UpdateSettings() {

    String setUserTitle = userTitle.getText().toString();
    String setUserName = userName.getText().toString();
    String setUserEmail = userEmail.getText().toString();
    String setUserPhone = userPhone.getText().toString();

    if (TextUtils.isEmpty(setUserTitle)){

        Toast.makeText(this, "Please write your Title....", Toast.LENGTH_SHORT).show();
         }
    if (TextUtils.isEmpty(setUserName)){

            Toast.makeText(this, "Please write your Name....", Toast.LENGTH_SHORT).show();
        }
    if (TextUtils.isEmpty(setUserEmail)){

            Toast.makeText(this, "Please write your Email....", Toast.LENGTH_SHORT).show();
        }
    if (TextUtils.isEmpty(setUserPhone)){

            Toast.makeText(this, "Please write your Phone....", Toast.LENGTH_SHORT).show();
        }
    else {

        HashMap<String,String>profileMap = new HashMap<>();
        profileMap.put("uid",currentUerID);
        profileMap.put("title",setUserTitle);
        profileMap.put("name",setUserName);
        profileMap.put("email",setUserEmail);
        profileMap.put("phone",setUserPhone);

        RootRef.child("Users").child(currentUerID).setValue(profileMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()){
                            SendUserToMainActivity();

                            Toast.makeText(SettingsActivity.this, "Profile Updated Successfully..", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            String message = task.getException().toString();
                            Toast.makeText(SettingsActivity.this, "Error :"+message, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }



    }
    private void SendUserToMainActivity() {
        Intent mainIntent = new Intent(SettingsActivity.this,MainActivity.class);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainIntent);
        fileList();
    }
}
