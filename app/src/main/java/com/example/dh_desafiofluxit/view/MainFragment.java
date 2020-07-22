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

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements UserAdapter.UserAdapterListener {

    private RecyclerView recyclerView;
    private FragmentMainBinding binding;
    private MainFragmentListener listener;
    private Controller controller;
    private UserAdapter adapter;
    private LinearLayoutManager llm;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMainBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        recyclerView = binding.fragmentMainRecyclerView;
        controller = new Controller();

        adapter = new UserAdapter(new ArrayList<User>(), MainFragment.this);
        llm = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(llm);

        addUsersToList();

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                Integer posicionActualRecycler = llm.findLastVisibleItemPosition();
                Integer ultimaPosicion = llm.getItemCount();

                if(posicionActualRecycler.equals(ultimaPosicion - 4)){
                    addUsersToList();
                }
            }
        });

        return view;
    }

    private void addUsersToList() {
        if(controller.getHayMasResultados()){
            controller.getUsers(null, new ResultListener<UserResult>() {
                @Override
                public void onFinish(UserResult result) {
                    adapter.addList(result.getResults());
                    Toast.makeText(getContext(), "Cargando más resultados...", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onError() {
                    Toast.makeText(getContext(), "Fallo", Toast.LENGTH_SHORT).show();
                }
            });
        }
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
