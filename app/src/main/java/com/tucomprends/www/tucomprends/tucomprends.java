package com.tucomprends.www.tucomprends;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;


public class tucomprends extends AppCompatActivity {

    private ActionBar toolbar;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {

                case R.id.navigation_translate_text:
                    toolbar.setTitle("Tu Comprends: Text");
                    fragment = new Translate_Text_Fragment();
                    loadFragment(fragment, false);
                    return true;
                case R.id.navigation_translate_voice:
                    toolbar.setTitle("Tu Comprends: Voice");
                    fragment = new Translate_Voice_Fragment();
                    loadFragment(fragment, false);
                    return true;
                case R.id.navigation_translate_image:
                    toolbar.setTitle("Tu Comprends: Image");
                    fragment = new Translate_Image_Fragment();
                    loadFragment(fragment, false);
                    return true;


            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tucomprends);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        navigation.setSelectedItemId(R.id.navigation_translate_text);

        loadFragment(new SelectLanguages(), true);
    }

    private void loadFragment(Fragment fragment, boolean useSelectLanguagesContainer) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(useSelectLanguagesContainer){
            transaction.replace(R.id.selectLanguages_container, fragment);
        }else {
            transaction.replace(R.id.frame_container, fragment);
        }
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
