package com.example.pff.segundoentregable;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        RecetasFragment.NotificadorReceta {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private RecetasFragment recetasFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragmentACargar = null;
        switch (item.getItemId()){
            case R.id.recetas_item_menu:
                fragmentACargar = new RecetasFragment();
                break;
            case R.id.aboutus_item_menu:
                fragmentACargar = new AboutUsFragment();
                break;
        }
        cargarFragment(fragmentACargar);
        drawerLayout.closeDrawers();
        return true;

    }
    public void cargarFragment (Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.replace(R.id.container_fragment, fragment).commit();

    }

    @Override
    public void notificar(Receta receta) {

        DetalleRecetaFragment detalleRecetaFragment = new DetalleRecetaFragment();
        Bundle unBundle = new Bundle();
        unBundle.putSerializable(DetalleRecetaFragment.RECETA_CLAVE,receta);
        detalleRecetaFragment.setArguments(unBundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment, detalleRecetaFragment);
        fragmentTransaction.addToBackStack(detalleRecetaFragment.getClass().getName());
        fragmentTransaction.commit();

        }


}

