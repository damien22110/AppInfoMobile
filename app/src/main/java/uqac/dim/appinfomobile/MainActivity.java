package uqac.dim.appinfomobile;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yalantis.library.Koloda;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;


public class MainActivity extends AppCompatActivity {
    private SwipeAdapter adapter;
    private List<Integer> list;
    Koloda koloda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.swipe, R.id.suggestion, R.id.profil).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        bottomNavigationView.setSelectedItemId(R.id.swipe);

        koloda = findViewById(R.id.koloda);
        adapter = new SwipeAdapter(this, list);
        System.out.println("OIDZAHUIDHZAUDHAZIUDHZAUIHDZAUIHDIUZAD");
        System.out.println(adapter.toString());
        if(koloda != null) {
            koloda.setAdapter(adapter);
        } else {
            System.out.println("Oui");
        }
    }
}




