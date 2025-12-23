package com.example.telemetryclient.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.telemetryclient.data.model.TestPayload
import com.example.telemetryclient.repository.WebHookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TelemetryViewModel @Inject  constructor(
    private  val repository: WebHookRepository
): ViewModel() {
    // variable to populate the data and to be shared in UI
    private val _status = MutableStateFlow("Idle")
    val status: StateFlow<String> = _status


    // send data method
    fun sendPost(){
        viewModelScope.launch {
            try {
                val payload = TestPayload(
                    message = "Hello from Android",
                    timestamp = System.currentTimeMillis()
                )
                // Send payload
                repository.sendPayload(payload)

                // only present the status of payload to UI
                _status.value = "Payload Successfully Sent"

            }catch (e:Exception){
                // display error message to ui on failure
                _status.value = "Failed ${e.message}"
            }

        }
    }

}