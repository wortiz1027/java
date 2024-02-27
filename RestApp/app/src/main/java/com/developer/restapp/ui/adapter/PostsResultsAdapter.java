package com.developer.restapp.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.developer.restapp.R;
import com.developer.restapp.domain.Post;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class PostsResultsAdapter extends RecyclerView.Adapter<PostsResultsAdapter.ViewHolder>{

    ArrayList<Post> posts;
    Context context;

    public PostsResultsAdapter(Context context) {
        posts = new ArrayList<>();
        this.context = context;

        Log.d("ADAPTER1","posts: " + posts.size());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                                      .inflate(R.layout.item_post, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Post currentPost = posts.get(position);
        holder.setTitulo(currentPost.getTitle());
        holder.setBody(currentPost.getBody());
    }

    @Override
    public int getItemCount() {
        return posts.isEmpty() ? 0 : posts.size();
    }

    public void addItem(Post post){
        if (post == null)
            throw new NullPointerException("item no puede ser null");

        posts.add(post);
        notifyItemInserted(getItemCount() - 1);
    }

    public void addItem(Post post, int position){
        if (post == null)
            throw new NullPointerException("item no puede ser null");

        if (position < getItemCount() || position > getItemCount())
            throw new IllegalArgumentException("The position must be between 0 and lastIndex + 1");

        posts.add(position, post);
        notifyItemInserted(position);
    }

    public void addAll(List<Post> listPosts) {
        if (listPosts == null)
            throw new NullPointerException("The items cannot be null");

        this.posts.addAll(listPosts);
        notifyItemRangeInserted(getItemCount() - 1, listPosts.size());
    }

    public void replace(ArrayList<Post> listPosts){
        this.posts = listPosts;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textViewTitulo)
        TextView txtTitulo;

        @BindView(R.id.textViewBody)
        TextView txtBody;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTitulo = (TextView) itemView.findViewById(R.id.textViewTitulo);
            txtBody = (TextView) itemView.findViewById(R.id.textViewBody);
            Log.d("ADAPTER2","posts: " + posts.size() + txtTitulo.getText());
        }

        public void setTitulo(String titulo){
            txtTitulo.setText(titulo);
        }

        public void setBody(String body){
            txtBody.setText(body);
        }
    }

}