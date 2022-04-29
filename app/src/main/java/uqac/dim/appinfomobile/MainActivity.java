package uqac.dim.appinfomobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yalantis.library.Koloda;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {
    private SwipeAdapter adapter;
    private List<Integer> list;

    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
    Integer currentFragmentID = R.id.swipe;
    Fragment selectedFragment = null;
    Koloda koloda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        koloda = findViewById(R.id.koloda);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);

        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment_activity_main, new Swipe()).commit();



        adapter = new SwipeAdapter(list);
        //koloda.setAdapter(adapter);


    }

    @Override
    protected void onStart() {

        super.onStart();

        if(currentUser == null) {
            sendToLoginActivity();
        }
    }

    private void sendToLoginActivity() {
        Intent intent  = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.swipe:
                    if(currentFragmentID != R.id.swipe) {
                        selectedFragment = new Swipe();
                        currentFragmentID = R.id.swipe;
                    }
                    break;
                case R.id.suggestion:
                    if(currentFragmentID != R.id.suggestion) {
                        selectedFragment = new Suggestion();
                        currentFragmentID = R.id.suggestion;
                    }
                    break;
                case R.id.profil:
                    if(currentFragmentID != R.id.profil) {
                    selectedFragment = new Profil();
                    currentFragmentID = R.id.profil;
                    }
                    break;
            }
            // It will help to replace the
            // one fragment to other.
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment_activity_main, selectedFragment)
                    .commit();
            return true;
        }
    };

}




