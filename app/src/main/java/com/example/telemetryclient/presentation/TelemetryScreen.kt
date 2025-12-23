package com.example.telemetryclient.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TelemetryScreen(
    status:String,
    sendPost:() -> Unit
){
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding()
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // button - to execute sendPayload from VM
        Button(
            onClick = {sendPost()}
        ) {
            Text("Send Post")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Status (Text)
        Text(
            fontSize = 25.sp,
            text = status
        )

    }
}


@Preview(showBackground = true)
@Composable
fun TelemetryScreenPreview(){
    TelemetryScreen("Success", sendPost = {})
}