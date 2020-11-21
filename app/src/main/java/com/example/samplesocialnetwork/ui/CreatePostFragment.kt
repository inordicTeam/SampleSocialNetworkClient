package com.example.samplesocialnetwork.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.samplesocialnetwork.R
import com.example.samplesocialnetwork.data.MainRepository
import kotlinx.android.synthetic.main.fragment_create_post.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreatePostFragment : BaseFragment(R.layout.fragment_create_post), CoroutineScope {
    override val coroutineContext = Dispatchers.Main
    private val repository = MainRepository()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        btnPublish.setOnClickListener {
            val title = editTitle.text.toString().trim()
            val body = editBody.text.toString().trim()

            if (title.isNotEmpty() && body.isNotEmpty()) {
                launch {
                    repository.createPost(title, body)?.let{
                        Toast.makeText(
                            requireContext(),
                            "Create post with id ${it.id}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}