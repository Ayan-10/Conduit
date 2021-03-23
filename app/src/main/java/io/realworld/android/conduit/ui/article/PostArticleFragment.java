package io.realworld.android.conduit.ui.article;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

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

}
