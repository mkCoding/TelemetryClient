package com.example.telemetryclient.repository

import com.example.telemetryclient.data.api.ApiDetails
import com.example.telemetryclient.data.api.WebHookApi
import com.example.telemetryclient.data.model.TestPayload
import javax.inject.Inject

class WebHookRepository @Inject constructor(
    private val webHookApi: WebHookApi
){
    suspend fun sendPayload(payload: TestPayload) =
        webHookApi.sendPayload(
            url = ApiDetails.BASE_URL,
            payload = payload)

}