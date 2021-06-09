package com.technzone.baseapp.data.daos.remote.user

import com.technzone.baseapp.data.api.response.ResponseWrapper
import com.technzone.baseapp.data.common.NetworkConstants
import com.technzone.baseapp.data.models.auth.login.UserDetailsResponseModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserRemoteDao {

    @Headers("${NetworkConstants.SKIP_AUTHORIZATION_HEADER}:true")
    @FormUrlEncoded
    @POST("api/user/authenticate")
    suspend fun login(
        @Field("Username") userName: String,
        @Field("Password") password: String
    ): ResponseWrapper<UserDetailsResponseModel>
}