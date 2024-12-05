package com.example.simplecomposeapicall

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simplecomposeapicall.data.ApiResponse
import com.example.simplecomposeapicall.data.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {

    private val _posts = MutableStateFlow<List<ApiResponse>>(emptyList())
    val posts: StateFlow<List<ApiResponse>> = _posts

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            val response = RetrofitInstance.api.getPosts()
            _posts.value = response
        }
    }
}