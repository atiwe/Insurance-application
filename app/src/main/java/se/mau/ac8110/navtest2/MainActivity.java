package se.mau.ac8110.navtest2;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity{
    private DrawerLayout drawer;
    private StartFragment startFragment;
    private PaymentsFragment paymentsFragment;
    private InjuryFragment injuryFragment;
    private DocumentsFragment documentsFragment;
    private ProfileFragment profileFragment;
    private BottomNavigationView navigation;

    private boolean loadFragment(Fragment fragment, boolean addToBackstack) {
        if(fragment!=null){
            final FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            transaction.replace(R.id.container, fragment);

            //if (addToBackstack) {
            //    transaction.addToBackStack(null);
            //}
            transaction.commit();
            return true;
        }
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeFragments();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //loading the default fragment
        loadFragment(new StartFragment(), false);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimaryDark)));

        //getting bottom navigation view and attaching the listener
        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationViewListener());
    }

    private void initializeFragments(){
        startFragment = new StartFragment();
        paymentsFragment = new PaymentsFragment();
        injuryFragment = new InjuryFragment();
        documentsFragment = new DocumentsFragment();
        profileFragment = new ProfileFragment();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private class BottomNavigationViewListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return loadFragment(startFragment, false);
                case R.id.navigation_documents:
                    return loadFragment(documentsFragment, true);
                case R.id.navigation_injury:
                    return loadFragment(injuryFragment, true);
                case R.id.navigation_profile:
                    return loadFragment(profileFragment, true);
                case R.id.navigation_payments:
                    return loadFragment(paymentsFragment, true);
            }
            return loadFragment(startFragment, false);
        }
    }
}