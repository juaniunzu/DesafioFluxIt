package com.example.dh_desafiofluxit.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.dh_desafiofluxit.R;
import com.example.dh_desafiofluxit.controller.Controller;
import com.example.dh_desafiofluxit.databinding.FragmentMainBinding;
import com.example.dh_desafiofluxit.model.User;
import com.example.dh_desafiofluxit.model.UserResult;
import com.example.dh_desafiofluxit.util.ResultListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements UserAdapter.UserAdapterListener {

    private RecyclerView recyclerView;
    private FragmentMainBinding binding;
    public static final String SEED = "asd";
    public static final int CANTIDAD_PAGINAS = 10;
    private int paginaActual = 1;
    private MainFragmentListener listener;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMainBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        recyclerView = binding.fragmentMainRecyclerView;
        Controller controller = new Controller();
        controller.getUsers(20, null, 1, SEED, new ResultListener<UserResult>() {
            @Override
            public void onFinish(UserResult result) {
                UserAdapter adapter = new UserAdapter(result.getResults(), MainFragment.this);
                LinearLayoutManager llm = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(llm);
                Toast.makeText(getContext(), "Exito", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError() {
                Toast.makeText(getContext(), "Fallo", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

    @Override
    public void onClickUserAdapter(User user) {
        listener.onClickMainFragment(user);
    }

    public interface MainFragmentListener{
        void onClickMainFragment(User user);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (MainFragmentListener) context;
    }
}
