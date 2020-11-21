package com.example.samplesocialnetwork.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.samplesocialnetwork.R
import com.example.samplesocialnetwork.data.MainRepository
import kotlinx.android.synthetic.main.fragment_feed.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedFragment : BaseFragment(R.layout.fragment_feed), CoroutineScope {
    override val coroutineContext = Dispatchers.Main
    private val repository = MainRepository()
    private val adapter = PostsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        postsList.adapter = adapter

        btnCreate.setOnClickListener {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.navHost, CreatePostFragment())
                ?.addToBackStack(null)
                ?.commit()
        }


        launch {
            repository.getPosts()?.let {
                Log.i("DataFromApi", it.toString())
                adapter.updatePosts(it)
            }
        }

    }
}