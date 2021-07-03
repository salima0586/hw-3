package com.example.homework_3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class SecondFragment extends Fragment {


    private EditText name,username;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_second, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        name = view.findViewById(R.id.ed_name);
        username = view.findViewById(R.id.ed_username);

        view.findViewById(R.id.btn_save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = name.getText().toString();
                String text2 = username.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("text",text1);
                bundle.putString("text1",text2);
                getParentFragmentManager().setFragmentResult("rk_task",bundle);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                FirstFragment transaction = new FirstFragment();
                ft.replace(R.id.fr_container,transaction);
                ft.commit();

//                NavController navController = Navigation.findNavController(requireActivity(),R.id.nav_host_fragment);
//                navController.navigateUp();
            }
        });
    }
}