package com.data.repo

import com.data.model.recipes.RecipesResponse
import com.data.service.FoodRecipeService
import com.util.Resource
import javax.inject.Inject

class Repository
@Inject constructor(
    private val service: FoodRecipeService
) {

    suspend fun getRandomRecipes(): Resource<RecipesResponse> {
        return try {
            val response = service.getRandomRecipes()
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Error*1", null)
            } else {
                Resource.error("Error*2", null)
            }
        } catch (e: Exception) {
            Resource.error("$e", null)
        }
    }
}