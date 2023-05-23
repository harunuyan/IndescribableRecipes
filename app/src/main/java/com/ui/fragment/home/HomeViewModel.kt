package com.ui.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.data.model.recipes.RecipesResponse
import com.data.repo.Repository
import com.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _recipes = MediatorLiveData<Resource<RecipesResponse>>()
    val recipes: LiveData<Resource<RecipesResponse>> = _recipes

    fun getRandomRecipes() {
        viewModelScope.launch(Dispatchers.IO) {
            _recipes.postValue(Resource.loading(null))
            val result = repository.getRandomRecipes()
            _recipes.postValue(result)
        }
    }
}