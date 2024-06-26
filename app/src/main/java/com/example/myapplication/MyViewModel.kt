package com.example.myapplication


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MyViewModel : ViewModel() {
    private val _items = MutableStateFlow<List<String>>(emptyList())
    val items: StateFlow<List<String>> = _items

    init {
        viewModelScope.launch {
            val loadedItems = listOf("Item 1", "Item 2", "Item 3")
            _items.value = loadedItems
        }
    }

    fun addItem(item: String) {
        _items.value = _items.value + item
    }
}
