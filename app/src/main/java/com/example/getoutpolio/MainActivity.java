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
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

import Fragment.AboutFragment;
import Fragment.HomeFragment;
import Fragment.SearchFragment;
import Fragment.ChangePassword;
import Fragment.DashboardFragment;
import Fragment.MapsFragment;
import Fragment.ComplainFragment;
import Fragment.ContactUsFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment;
    SearchFragment searchFragment;
    AboutFragment aboutFragment;
    ChangePassword changePassword;
    DashboardFragment dashboardFragment;
    MapsFragment mapsFragment;
    ComplainFragment complainFragment;
    ContactUsFragment contactUsFragment;
    private FirebaseAuth firebaseAuth;
    private NavigationView objectNavigationView;
    private DrawerLayout objectDrawerLayout;
    private Toolbar objectToolbar;
    View view;
    List<Book> lstBook;


    ImageView objMaps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objMaps=findViewById(R.id.maps_item_id);





        connectJAVAToXML();
        try {
            homeFragment=new HomeFragment();
            dashboardFragment=new DashboardFragment();
            aboutFragment=new AboutFragment();
            searchFragment=new SearchFragment();
            changePassword=new ChangePassword();
            mapsFragment=new MapsFragment();
            changeFragment(dashboardFragment);
            complainFragment=new ComplainFragment();
            contactUsFragment =new ContactUsFragment();
            bottomNavigationView = findViewById(R.id.bottom_navigation);

            objMaps=findViewById(R.id.maps_item_id);
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.nav_hame: {

                            changeFragment(dashboardFragment);
                            return true;
                        }
                        case R.id.item_home:
                        {
                            changeFragment(dashboardFragment);
                            return true;
                        }

                        case R.id.maps_item_id: {

                            changeFragment(aboutFragment);
                            return true;
                        }
                        case R.id.nav_about: {

                            changeFragment(aboutFragment);
                            return true;
                        }
//                        case R.id.nav_search: {
//
//                            changeFragment(searchFragment);
//                            return true;
//                        }
                        case R.id.change_password_id:{
                            changeFragment(changePassword);
                            return true;
                        }
                        case R.id.item_complain:{
                            changeFragment(complainFragment);
                        }
                        case R.id.item_ContactUs:{
                            changeFragment(contactUsFragment);
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
                        changeFragment(dashboardFragment);

                        closeMyDrawer();
                        return true;
                    }
//                    else if(item.getItemId()==R.id.item_profile)
//                    {
//                        Toast.makeText(MainActivity.this, "Profile is clicked", Toast.LENGTH_SHORT).show();
//                        closeMyDrawer();
//                        return true;
//                    }
                    else if(item.getItemId()==R.id.item_complain)
                    {
                        changeFragment(complainFragment);
                        closeMyDrawer();
                        return true;
                    }
                    else if(item.getItemId()==R.id.item_ContactUs)
                    {
                        changeFragment(contactUsFragment);
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
            ActionBarDrawerToggle objectActionBarDrawerToggle=
                    new ActionBarDrawerToggle(
                            this,
                            objectDrawerLayout,
                            objectToolbar,
                            R.string.open,
                            R.string.close
                    );

            objectActionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorPrimary));


            objectActionBarDrawerToggle.syncState();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "setUpHamBurgerIcon:"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }





}
