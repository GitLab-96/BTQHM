package com.example.btqhm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AdmissionActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admission);


       init();


    }

    private void init() {

        BottomNavigationView bottomNavigationView= findViewById(R.id.admissionbottom_nav);
        bottomNavigationView .setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.studentItem:
                        FragmentManager fragmentManager1 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                        fragmentTransaction1.replace(R.id.frameLayout,new StudentAdmissionFramlayout());
                        fragmentTransaction1.commit();
                        return true;

                    case R.id.techerItem:
                        FragmentManager fragmentManager2 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                        fragmentTransaction2.replace(R.id.frameLayout,new TeacherJoiningForm());
                        fragmentTransaction2.commit();
                        return true;

                    case R.id.moreItem:
                        FragmentManager fragmentManager3 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                        fragmentTransaction3.replace(R.id.frameLayout,new MoreJoiningFragment());
                        fragmentTransaction3.commit();
                        return true;
                }
                return false;
            }
        });
    }

}
