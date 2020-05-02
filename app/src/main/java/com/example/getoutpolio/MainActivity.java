package com.example.getoutpolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import Fragment.AboutFragment;
import Fragment.HomeFragment;
import Fragment.SearchFragment;
import Fragment.ChangePassword;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment;
    SearchFragment searchFragment;
    AboutFragment aboutFragment;
    ChangePassword changePassword;
    private FirebaseAuth firebaseAuth;


    private NavigationView objectNavigationView;
    private DrawerLayout objectDrawerLayout;

    private Toolbar objectToolbar;
    View view;
    List<Book> lstBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        connectJAVAToXML();
        try {
            homeFragment=new HomeFragment();
            aboutFragment=new AboutFragment();
            searchFragment=new SearchFragment();
            changePassword=new ChangePassword();
            changeFragment(homeFragment);
            bottomNavigationView = findViewById(R.id.bottom_navigation);
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.nav_hame: {

                            changeFragment(homeFragment);
                            return true;
                        }
                        case R.id.nav_about: {

                            changeFragment(aboutFragment);
                            return true;
                        }
                        case R.id.nav_search: {

                            changeFragment(searchFragment);
                            return true;
                        }
                        case R.id.change_password_id:{
                            changeFragment(changePassword);
                            return true;
                        }
                        default: {
                            return false;
                        }

                    }
                }
            });
        } catch (Exception e) {
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void changeFragment(Fragment objFragment)
    {
        try {
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,objFragment);
            fragmentTransaction.commit();
        }catch (Exception e){
            Toast.makeText(this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }



    private void connectJAVAToXML()
    {
        try
        {
            objectNavigationView=findViewById(R.id.navigationView);
            objectDrawerLayout=findViewById(R.id.drawerLayout);

            objectToolbar=findViewById(R.id.toolBar);
            objectNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    if(item.getItemId()==R.id.item_home)
                    {
                        Toast.makeText(MainActivity.this, "Home is clicked", Toast.LENGTH_SHORT).show();
                        closeMyDrawer();
                        return true;
                    }
                    else if(item.getItemId()==R.id.item_profile)
                    {
                        Toast.makeText(MainActivity.this, "Profile is clicked", Toast.LENGTH_SHORT).show();
                        closeMyDrawer();
                        return true;
                    }
                    else if(item.getItemId()==R.id.item_complain)
                    {
                        Toast.makeText(MainActivity.this, "compiain is clicked", Toast.LENGTH_SHORT).show();
                        closeMyDrawer();
                        return true;
                    }
                    else if(item.getItemId()==R.id.item_aboutUs)
                    {
                        Toast.makeText(MainActivity.this, "About us is clicked", Toast.LENGTH_SHORT).show();
                        closeMyDrawer();
                        return true;
                    }
                    else if(item.getItemId()==R.id.change_password_id)
                    {
                        Toast.makeText(MainActivity.this, "change password clicked", Toast.LENGTH_SHORT).show();
                        changeFragment(changePassword);
                        closeMyDrawer();
                        return true;
                    }
                    else if(item.getItemId()==R.id.item_logout)
                    {


                             FirebaseAuth.getInstance().signOut();
                        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "logout is clicked", Toast.LENGTH_SHORT).show();
                        finish();
                        closeMyDrawer();
                        return true;
                    }

                    return false;
                }
            });

            setUpHamBurgerIcon();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "connectJAVAToXML:"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void closeMyDrawer()
    {
        objectDrawerLayout.closeDrawer(GravityCompat.START);
    }

    private void setUpHamBurgerIcon()
    {
        try
        {
            //Step 1 you will create object of ACTION BAR DRAWER TOGGLE
            //with 5 parameters
            ActionBarDrawerToggle objectActionBarDrawerToggle=
                    new ActionBarDrawerToggle(
                            this,
                            objectDrawerLayout,
                            objectToolbar,
                            R.string.open,
                            R.string.close
                    );

            //Step 2: set color for ham burger icon
            objectActionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorPrimary));

            //Step 3:
            objectActionBarDrawerToggle.syncState();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "setUpHamBurgerIcon:"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }




}
