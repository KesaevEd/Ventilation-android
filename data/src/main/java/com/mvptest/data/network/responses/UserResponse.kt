package com.mvptest.data.network.responses

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerializedName("token")
    val token: String
)
