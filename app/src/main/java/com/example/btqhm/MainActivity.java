package com.example.btqhm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import de.hdodenhof.circleimageview.CircleImageView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Button principalBtn,teacherBtn,studentBtn;
    private TextView userTitle,userName,userEmail,userPhone,entryKeyTV;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    private FirebaseUser currentUser;
    private FirebaseAuth mAuth;
    private DatabaseReference RootRef;
    private CircleImageView profileImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();
        RootRef = FirebaseDatabase.getInstance().getReference();
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Bismillah Ta'limul Quran Madrasah");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawarOpen,R.string.drawarClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);

        principalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog();
            }
        });

        teacherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog();
            }
        });

        studentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialog();
            }
        });


    }




    private void init() {
        teacherBtn = findViewById(R.id.TeacherBtn);
        studentBtn = findViewById(R.id.StudentBtn);
        principalBtn = findViewById(R.id.principalBtn);
        drawerLayout = findViewById(R.id.drawar);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationView);
        userTitle = findViewById(R.id.headerVicePrincipal);
        userName = findViewById(R.id.headername);
        userEmail = findViewById(R.id.headeremail);
        userPhone = findViewById(R.id.headerphoneNo);
        profileImage = findViewById(R.id.get_profile_image);
        entryKeyTV = findViewById(R.id.EntryKeyTV);

    }
    private void openDialog() {

        MyDialogFragment myDialogFragment = new MyDialogFragment();
        myDialogFragment.show(getSupportFragmentManager(),"Example dialog");


    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){

            case R.id.mapitem:

                break;

            case R.id.aboutitem:
                Toast.makeText(this, "this is about", Toast.LENGTH_SHORT).show();
                break;

            case R.id.contactitem:
                Toast.makeText(this, "this is contact", Toast.LENGTH_SHORT).show();
                break;

            case R.id.weatheritem:
                Toast.makeText(this, "this is weather", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }

    @Override
    protected void onStart() {

        super.onStart();
        if (currentUser == null){
            SendUserToLoginActivity();
        }
        else {


        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

       super.onOptionsItemSelected(item);
       if (item.getItemId() == R.id.main_logout_options){

           mAuth.signOut();
           SendUserToLoginActivity();
       }
        if (item.getItemId() == R.id.main_user_settings){

            SendUserToSettingActivity();
        }

       return true;
    }


    private void SendUserToSettingActivity() {
        Intent settingIntent = new Intent(MainActivity.this,SettingsActivity.class);
        settingIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(settingIntent);
        finish();

    }

    private void SendUserToLoginActivity() {

        Intent logingIntent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(logingIntent);
    }

}