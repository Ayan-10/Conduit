package io.realworld.android.conduit;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import io.realworld.android.api.models.entities.User;
import io.realworld.android.conduit.ui.auth.AuthViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String PREFS_FILE_AUTH = "prefs_auth";
    private static final String PREFS_KEY_TOKEN = "token";
    private static final String PREFS_KEY_USERNAME = "username";

    private AppBarConfiguration mAppBarConfiguration;
    private AuthViewModel authViewModel;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences(PREFS_FILE_AUTH, Context.MODE_PRIVATE);

        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
               R.id.nav_feed,R.id.nav_home, R.id.nav_gallery, R.id.nav_settings)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        // saving cred
        String token = sharedPreferences.getString(PREFS_KEY_TOKEN, null);
        String username =  sharedPreferences.getString(PREFS_KEY_USERNAME, null);

        authViewModel.user.observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {

                String username = null;
                if(user!=null){
                    username=user.getUsername();
                }
                Toast.makeText(MainActivity.this,"User logged "+username,Toast.LENGTH_LONG).show();

                updateMenu(username,navigationView);

                if(user == null){
                    sharedPreferences.edit().remove(PREFS_KEY_TOKEN).apply();
                    sharedPreferences.edit().remove(PREFS_KEY_USERNAME).apply();
                }else {
                    sharedPreferences.edit().putString(PREFS_KEY_TOKEN,"Token "+user.getToken()).apply();
                    sharedPreferences.edit().putString(PREFS_KEY_USERNAME, user.getUsername()).apply();
                }
                navController.navigateUp();
            }
        });

    }

    private void updateMenu(String s, NavigationView navigationView){
        if(s!=null){
            navigationView.getMenu().clear();
            navigationView.inflateMenu(R.menu.menu_main_user);
        }else{
            navigationView.getMenu().clear();
            navigationView.inflateMenu(R.menu.menu_main_guest);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.action_logout){
            authViewModel.logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}