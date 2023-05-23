package com.data.service

import com.data.model.recipes.RecipesResponse
import com.util.Constant.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FoodRecipeService {

    @GET("recipes/random")
    suspend fun getRandomRecipes(
        @Query("apiKey")
        apiKey: String = API_KEY,
        @Query("number")
        number: Int = 10,
        @Query("limitLicense")
        limitLicense: Boolean = true
    ): Response<RecipesResponse>
}