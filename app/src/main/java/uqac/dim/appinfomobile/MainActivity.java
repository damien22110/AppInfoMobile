package uqac.dim.appinfomobile;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.yalantis.library.Koloda;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private SwipeAdapter adapter;
    private List<Integer> list;

    FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

    Koloda koloda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        koloda = findViewById(R.id.koloda);
        list = new ArrayList<>();

        adapter = new SwipeAdapter(this, list);
        koloda.setAdapter(adapter);
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
}
