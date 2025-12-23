package com.example.telemetryclient.data.api

import com.example.telemetryclient.data.model.TestPayload
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface WebHookApi {

    @POST
    suspend fun sendPayload(
        @Url url: String,
        @Body payload: TestPayload
    ): Response<Unit>
}