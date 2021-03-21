package io.realworld.android.conduit.ui.settings;

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
                new ViewModelProvider(requireActivity()).get(AuthViewModel.class);


        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText image = view.findViewById(R.id.imageEditText);
        EditText username = view.findViewById(R.id.usernameSetEditText);
        EditText bio = view.findViewById(R.id.bioEditText);
        EditText email = view.findViewById(R.id.emailSetEditText);
        EditText password = view.findViewById(R.id.passwordSetEditText);

        authViewModel.user.observe(getViewLifecycleOwner(), new Observer<User>() {
            @Override
            public void onChanged(User user) {
                image.setText(user.getImage());
                username.setText(user.getUsername());
                bio.setText(user.getBio());
                email.setText(user.getEmail());
            }
        });

        MaterialButton updateButton = view.findViewById(R.id.UpdateButtonSet);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imageText = image.getText().toString();
                String bioText = bio.getText().toString();
                String emailText = email.getText().toString();
                String passwordText = password.getText().toString();
                String usernameText = username.getText().toString();

                if(passwordText.isEmpty()){
                    passwordText = null;
                }
                if(emailText.isEmpty()){
                    emailText = null;
                }
                if(usernameText.isEmpty()){
                    usernameText = null;
                }


                authViewModel.updateUser(imageText,bioText,emailText,passwordText,usernameText);
            }
        });
    }
}