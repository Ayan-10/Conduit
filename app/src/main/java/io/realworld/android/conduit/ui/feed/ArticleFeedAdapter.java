package io.realworld.android.conduit.ui.feed;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import io.realworld.android.api.models.entities.Article;
import io.realworld.android.api.models.entities.Profile;
import io.realworld.android.conduit.R;

public class ArticleFeedAdapter extends ListAdapter<Article,ArticleFeedAdapter.ArticleViewHolder>  {

    protected ArticleFeedAdapter() {
        super(DIFF_CALLBACK);
    }


    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_article, parent, false);
        view.setFocusable(true);

        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {

        Article article = getItem(position) ;

        holder.authorView.setText(article.getAuthor().getUsername());
        holder.titleView.setText(article.getTitle());
        holder.bodysnippetView.setText(article.getBody());
    }
    private static final DiffUtil.ItemCallback<Article> DIFF_CALLBACK = new ArticleDiffCallback();
    public static class ArticleDiffCallback extends DiffUtil.ItemCallback<Article>{

    @Override
    public boolean areItemsTheSame(@NonNull Article oldItem, @NonNull Article newItem) {
        return oldItem==newItem;
    }

    @Override
    public boolean areContentsTheSame(@NonNull Article oldItem, @NonNull Article newItem) {
        Profile old = oldItem.getAuthor();
        Profile newe = newItem.getAuthor();
        return ((oldItem.isFavorited()==newItem.isFavorited())&&
                (oldItem.getTagList().equals(newItem.getTagList()))&&
                (oldItem.getSlug().equals(newItem.getSlug()))&&
                (oldItem.getBody().equals(newItem.getBody()))&&
                (oldItem.getCreatedAt().equals(newItem.getCreatedAt()))&&
                (oldItem.getDescription().equals(newItem.getDescription()))&&
                (oldItem.getFavoritesCount()==newItem.getFavoritesCount())&&
                (oldItem.getTitle().equals(newItem.getTitle()))&&
                (oldItem.getUpdatedAt().equals(newItem.getUpdatedAt()))&&
                ((old.getBio().equals(newe.getBio()))&&(old.isFollowing()==newe.isFollowing())&&(old.getImage().equals(newe.getUsername()))&&(old.getUsername().equals(newe.getUsername()))));
    }
}

    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        TextView authorView;
        TextView titleView;
        TextView bodysnippetView;


        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);


            authorView = (TextView) itemView.findViewById(R.id.authortextview);
            titleView = (TextView) itemView.findViewById(R.id.titletextview);
            bodysnippetView = (TextView) itemView.findViewById(R.id.bodysnippettextview);


        }
    }
}