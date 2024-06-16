package com.msa.componentcompose.ui.voiceToText


import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import java.util.*

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.speech.SpeechRecognizer.RESULTS_RECOGNITION
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

@Composable
fun VoiceToTextComponent() {
    var text by remember { mutableStateOf("") }
    var listening by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "تبدیل گفتار به متن")

        Button(
            onClick = {
                if (!listening) {
                    startListening(context)
                } else {
                    stopListening()
                }
                listening = !listening
            },
            enabled = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == ConnectionResult.SUCCESS
        ) {
            Text(text = if (listening) "توقف شنیدن" else "شروع شنیدن")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = text)
    }
}

private var recognizer: SpeechRecognizer? = null

private fun startListening(context: ComponentActivity) {
    val speechRecognizer = SpeechRecognizerDelegate.create(context)
    recognizer = speechRecognizer

    val intent = android.content.Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
        putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
        putExtra(RecognizerIntent.EXTRA_LANGUAGE, "fa-IR") // زبان فارسی
        putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true)
    }

    speechRecognizer.startListening(intent)
    speechRecognizer.setRecognitionListener(object : RecognitionListener {
        override fun onReadyForSpeech(params: Bundle?) {}
        override fun onBeginningOfSpeech() {}
        override fun onRmsChanged(rmsdB: Float) {}
        override fun onBufferReceived(buffer: ByteArray?) {}
        override fun onEndOfSpeech() {}
        override fun onError(error: Int) {}
        override fun onResults(results: Bundle?) {
            val matches = results?.getStringArrayList(RESULTS_RECOGNITION)
            matches?.let {
                val result = it[0]
                GlobalScope.launch(Dispatchers.Main) {
                    // Update UI with the recognized text
                    text = result
                }
            }
        }
        override fun onPartialResults(partialResults: Bundle?) {}
        override fun onEvent(eventType: Int, params: Bundle?) {}
    })
}

private fun stopListening() {
    recognizer?.stopListening()
    recognizer?.destroy()
}

@Preview(showBackground = true)
@Composable
fun PreviewVoiceToTextComponent() {
    VoiceToTextComponent()
}

