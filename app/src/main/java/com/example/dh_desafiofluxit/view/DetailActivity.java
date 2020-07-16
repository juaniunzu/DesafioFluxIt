package com.example.dh_desafiofluxit.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.dh_desafiofluxit.R;
import com.example.dh_desafiofluxit.model.User;

import android.content.Intent;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    public static final String ID_BUNDLE = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent desdeMain = getIntent();
        Bundle bundle = desdeMain.getExtras();

        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setArguments(bundle);

        setFragmentInicial(detailFragment);

    }

    private void setFragmentInicial(DetailFragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.activityDetailFragmentContainer, fragment);
        fragmentTransaction.commit();
    }

}
