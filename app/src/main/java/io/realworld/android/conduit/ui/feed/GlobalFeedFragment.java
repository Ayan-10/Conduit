package io.realworld.android.conduit.ui.feed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import io.realworld.android.api.models.entities.Article;
import io.realworld.android.conduit.R;

public class GlobalFeedFragment extends Fragment {

    private FeedViewModel viewModel;
    ArticleFeedAdapter articleFeedAdapter;
    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewModel =
                new ViewModelProvider(this).get(FeedViewModel.class);
        View root = inflater.inflate(R.layout.fragment_feed, container, false);

        // Set the RecyclerView to its corresponding view
        recyclerView = root.findViewById(R.id.feedRecyclerView);

        // Set the layout for the RecyclerView to be a linear layout, which measures and
        // positions items within a RecyclerView into a linear list
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize the adapter and attach it to the RecyclerView
        articleFeedAdapter = new ArticleFeedAdapter(new ArticleFeedAdapter.OnArticleClickListener() {
            @Override
            public void OnItemClicked(String slug) {
                openArticle(slug);
            }
        });
        recyclerView.setAdapter(articleFeedAdapter);


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel.fetchGlobalFeed();

        viewModel.feed.observe(getViewLifecycleOwner(), new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articles) {
                articleFeedAdapter.submitList(articles);
            }
        });
    }
    void openArticle(String articleId){
        Bundle bundle = new Bundle();
        bundle.putString(getResources().getString(R.string.arg_article_id),articleId);
        Navigation.findNavController(getView()).navigate(
                R.id.action_globalfeed_openarticle, bundle);
    }
}