package com.example.dh_desafiofluxit.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dh_desafiofluxit.R;
import com.example.dh_desafiofluxit.databinding.ActivityMainBinding;
import com.example.dh_desafiofluxit.model.User;

public class MainActivity extends AppCompatActivity implements MainFragment.MainFragmentListener {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setFragmentInicial(new MainFragment());

    }

    private void setFragmentInicial(MainFragment mainFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.activityMainFragmentContainer, mainFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onClickMainFragment(User user) {
        Intent mainADetail = new Intent(this, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(DetailActivity.ID_BUNDLE, user);
        mainADetail.putExtras(bundle);
        startActivity(mainADetail);
    }
}
