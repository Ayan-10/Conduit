package io.realworld.android.conduit.ui.auth;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import io.realworld.android.api.models.entities.User;
import io.realworld.android.conduit.MainActivity;
import io.realworld.android.conduit.R;

public class SignupFragment extends Fragment {
    private AuthViewModel authViewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        authViewModel =
                new ViewModelProvider(requireActivity()).get(AuthViewModel.class);

        View root = inflater.inflate(R.layout.fragment_login_signup, container, false);

        // Inflate the layout for this fragment
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MaterialButton loginButton = view.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText eEditText = view.findViewById(R.id.emailEditText);
                EditText pEditText = view.findViewById(R.id.passwordEditText);
                EditText uEditText = view.findViewById(R.id.usernameEditText);

                String usernameEditText = uEditText.getText().toString();
                String emailEditText = eEditText.getText().toString();
                String passwordEditText = pEditText.getText().toString();
                authViewModel.signup(usernameEditText,emailEditText,passwordEditText);
            }
        });
    }
}