package io.realworld.android.conduit.ui.article;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.google.android.material.button.MaterialButton;

import io.realworld.android.conduit.R;
import io.realworld.android.conduit.ui.auth.AuthViewModel;

public class PostArticleFragment extends Fragment {
    private ArticleViewModel authViewModel ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        authViewModel =
                new ViewModelProvider(requireActivity()).get(ArticleViewModel.class);


        View root = inflater.inflate(R.layout.fragment_post_article, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText titlePostEdit = view.findViewById(R.id.titlePost);
        EditText desPostEdit = view.findViewById(R.id.descriptionPost);
        EditText bodyPostEdit = view.findViewById(R.id.bodyPost);
        MaterialButton updateButton = view.findViewById(R.id.publishArticle);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleText = titlePostEdit.getText().toString();
                String desText = desPostEdit.getText().toString();
                String bodyText = bodyPostEdit.getText().toString();

                authViewModel.publishArticle(titleText,desText,bodyText);
                Navigation.findNavController(getView()).navigate(R.id.action_nav_post_write_to_nav_feed);
            }
        });
    }
}
