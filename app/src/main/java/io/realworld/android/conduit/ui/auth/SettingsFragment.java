package io.realworld.android.conduit.ui.auth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.button.MaterialButton;

import io.realworld.android.api.models.entities.User;
import io.realworld.android.conduit.MainActivity;
import io.realworld.android.conduit.R;
import io.realworld.android.conduit.ui.auth.AuthViewModel;

public class SettingsFragment extends Fragment {

    private AuthViewModel authViewModel ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        authViewModel =
                new ViewModelProvider(this).get(AuthViewModel.class);


        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText username = view.findViewById(R.id.usernameSetEditText);
        authViewModel.user.observe(getViewLifecycleOwner(), new Observer<User>() {
            @Override
            public void onChanged(User user) {
                username.setText(user.getUsername());
                Log.d("username","username");
            }
        });
    }
}