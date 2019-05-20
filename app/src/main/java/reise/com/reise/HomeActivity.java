package reise.com.reise;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerBar;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        drawerBar = (DrawerLayout) findViewById(R.id.DrawerBar);
        //mToolbar = (Toolbar)  findViewById(R.id.nav_action);                                                                                    //very important part...
        navigationView = (NavigationView) findViewById(R.id.navigationView);                     //this shows how to link to a textView of navigation view.
        View headerView = navigationView.getHeaderView(0);                            //first link navigationView and then create a view that gets header of navigation view
        //and then link the textView of the navigation view to the view.

       mToolbar = (Toolbar)findViewById(R.id.toolbarHome);
        setSupportActionBar(mToolbar);

        navigationView.setNavigationItemSelectedListener(this);

        drawerToggle = new ActionBarDrawerToggle(this, drawerBar, R.string.open, R.string.close);//create a string in values.string as open and close.. that'll work
        //logoutButton = (Button) findViewById(R.id.logout_button);


        drawerBar.addDrawerListener(drawerToggle);
        drawerToggle.syncState();


        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CurrentTripFragment()).commit();
            navigationView.setCheckedItem(R.id.currentTrip);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//show the home button


        drawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.currentTrip:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CurrentTripFragment()).commit();
                Toast.makeText(HomeActivity.this, "Current trip ", Toast.LENGTH_SHORT).show();
                navigationView.setCheckedItem(R.id.currentTrip);
                break;

            case R.id.location:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LocationFragment()).commit();
                Toast.makeText(HomeActivity.this, "Location", Toast.LENGTH_SHORT).show();
                navigationView.setCheckedItem(R.id.location);
                break;

            case R.id.calls:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CallFragment()).commit();
                Toast.makeText(HomeActivity.this, "Calls", Toast.LENGTH_SHORT).show();
                navigationView.setCheckedItem(R.id.calls);
                break;

            case R.id.settings:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
                Toast.makeText(HomeActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                navigationView.setCheckedItem(R.id.settings);
                break;

            case R.id.logout:
                logoutSession();
                Toast.makeText(HomeActivity.this, "Logout", Toast.LENGTH_SHORT).show();
                navigationView.setCheckedItem(R.id.logout);
                break;


        }
        drawerBar.closeDrawer(GravityCompat.START);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){
        if (drawerBar.isDrawerOpen(GravityCompat.START)) {
            drawerBar.closeDrawer(GravityCompat.START);
        }else
            logoutSession();
    }

    public void logoutSession(){
        AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
        builder.setMessage("Are you sure you want to logout?");
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
