package com.example.btqhm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PrincipalActivity extends AppCompatActivity {
    private CardView admssionCV,transectionCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        admssionCV = findViewById(R.id.admissionCV);
        transectionCV = findViewById(R.id.transectionCV);

        transectionCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(PrincipalActivity.this,TransectionActivity.class));
            }
        });

        admssionCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(PrincipalActivity.this,AdmissionActivity.class));
            }
        });
    }
}
