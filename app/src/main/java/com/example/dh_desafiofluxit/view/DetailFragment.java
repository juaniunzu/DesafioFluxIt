package com.example.dh_desafiofluxit.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dh_desafiofluxit.R;
import com.example.dh_desafiofluxit.databinding.FragmentDetailBinding;
import com.example.dh_desafiofluxit.model.User;
import com.example.dh_desafiofluxit.util.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDetailBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        Bundle desdeMain = getArguments();

        User userClickeado = (User) desdeMain.getSerializable(DetailActivity.ID_BUNDLE);

        setView(userClickeado);

        Utils.setFragmentBackground(getContext(), view, userClickeado.getPicture().getMedium());

        return view;
    }

    private void setView(User userClickeado) {
        binding.fragmentDetailTextViewNombre.setText(userClickeado.getName().getTitle() + " " + userClickeado.getName().getLast() + " " + userClickeado.getName().getFirst());
        binding.fragmentDetailTextViewEdad.setText(String.valueOf(userClickeado.getDob().getAge()));
        binding.fragmentDetailTextViewEmail.setText(userClickeado.getEmail());
        Glide.with(getContext())
                .setDefaultRequestOptions(Utils.requestOptionsCircularProgressBar(getContext()))
                .load(userClickeado.getPicture().getLarge())
                .into(binding.fragmentDetailImageView);
    }
}
