package com.example.lab10_demo_navigation_drawer_et_fragments;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mainDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mainToolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(mainToolbar);

        mainDrawerLayout = findViewById(R.id.drawer_container);
        NavigationView navigationMenu = findViewById(R.id.side_nav_view);
        navigationMenu.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggleAction = new ActionBarDrawerToggle(
                this, mainDrawerLayout, mainToolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mainDrawerLayout.addDrawerListener(toggleAction);
        toggleAction.syncState();

        // Affichage du fragment par défaut au démarrage
        if (savedInstanceState == null) {
            loadFragment(new HomeContentFragment());
            navigationMenu.setCheckedItem(R.id.menu_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
        int selectedId = item.getItemId();

        if (selectedId == R.id.menu_home) {
            selectedFragment = new HomeContentFragment();
        } else if (selectedId == R.id.menu_settings) {
            selectedFragment = new SettingsContentFragment();
        } else if (selectedId == R.id.menu_summary) {
            selectedFragment = new SummaryListFragment();
        }

        if (selectedFragment != null) {
            loadFragment(selectedFragment);
        }

        mainDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_placeholder, fragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (mainDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mainDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}