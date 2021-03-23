package io.realworld.android.conduit.ui.article;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import io.realworld.android.api.models.entities.Article;
import io.realworld.android.conduit.R;
import io.realworld.android.conduit.ui.feed.ArticleFeedAdapter;
import io.realworld.android.conduit.ui.feed.FeedViewModel;

public class ArticleFragment extends Fragment {
    private ArticleViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewModel =
                new ViewModelProvider(this).get(ArticleViewModel.class);
        View root = inflater.inflate(R.layout.fragment_article, container, false);

        viewModel.fetchArticle(getArguments().getString(getResources().getString(R.string.arg_article_id)));
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView titleView = (TextView) view.findViewById(R.id.artTitleTextView);
        TextView usernameView = (TextView) view.findViewById(R.id.artusernameTextView);
        TextView dateView = (TextView) view.findViewById(R.id.artdateTextView);
        TextView bodyView = (TextView) view.findViewById(R.id.bodyTextView);
        ImageView avatarView = (ImageView) view.findViewById(R.id.artavatarImageView);

        viewModel.article.observe(getViewLifecycleOwner(), new Observer<Article>() {
            @Override
            public void onChanged(Article article) {
                titleView.setText(article.getTitle());
                usernameView.setText(article.getAuthor().getUsername());
                bodyView.setText(article.getBody());
                titleView.setText(article.getTitle());
                //date
                SimpleDateFormat isoDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
                SimpleDateFormat appDateFormat = new SimpleDateFormat("MMMM dd, yyyy",Locale.getDefault());
                Date date = null;
                try {
                    date = isoDateFormat.parse(article.getCreatedAt());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                String formattedDate = appDateFormat.format(date);
                dateView.setText(formattedDate);
                Log.d("Image is","This"+article.getAuthor().getImage());
                Glide.with(avatarView).load(article.getAuthor().getImage()).circleCrop().into(avatarView);
            }
        });
    }
}
