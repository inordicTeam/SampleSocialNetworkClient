package com.example.samplesocialnetwork.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.samplesocialnetwork.R
import com.example.samplesocialnetwork.data.Post
import kotlinx.android.synthetic.main.item_post.view.*

class PostsAdapter : RecyclerView.Adapter<PostsAdapter.PostViewHolder>() {

    private var posts = emptyList<Post>()

    fun updatePosts(posts: List<Post>) {
        this.posts = posts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount() = posts.size


    class PostViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(post: Post) = itemView.apply {
            postTitle.text = post.title
            postBody.text = post.body
        }
    }
}
