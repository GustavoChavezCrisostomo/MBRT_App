package mbrtechnology.com.mbrt_app.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import mbrtechnology.com.mbrt_app.R;
import mbrtechnology.com.mbrt_app.fragments.ClienteFragment;
import mbrtechnology.com.mbrt_app.fragments.ContactoFragment;
import mbrtechnology.com.mbrt_app.fragments.MenuFragment;
import mbrtechnology.com.mbrt_app.util.PreferencesManager;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.exit:
                logout();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.navigation_menu:
                                selectedFragment = MenuFragment.newInstance();
                                break;
                            case R.id.navigation_nuevaAtencion:
                                selectedFragment = ClienteFragment.newInstance();
                                break;
                            case R.id.navigation_contacto:
                                selectedFragment = ContactoFragment.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.content, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        String role = PreferencesManager.getInstance().get(PreferencesManager.PREF_ROLE);
        switch (role){
            case "ROLE_CLTE_NAT" :
                bottomNavigationView.getMenu().removeItem(R.id.navigation_nuevaAtencion);
                break;
            case  "ROLE_SUPER" :
                bottomNavigationView.getMenu().removeItem(R.id.navigation_nuevaAtencion);
                break;
            case "ROLE_TEC" :
                bottomNavigationView.getMenu().removeItem(R.id.navigation_nuevaAtencion);
                break;
            case "ROLE_ADMIN" :
                bottomNavigationView.getMenu().removeItem(R.id.navigation_nuevaAtencion);
                break;
        }

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, MenuFragment.newInstance());
        transaction.commit();

        //Used to select an item programmatically
        //bottomNavigationView.getMenu().getItem(2).setChecked(true);

    }

    public void logout(){
        PreferencesManager.getInstance().remove(PreferencesManager.PREF_ISLOGGED);
        finish();
    }

}
