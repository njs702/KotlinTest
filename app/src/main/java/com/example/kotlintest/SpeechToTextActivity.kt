package com.example.kotlintest

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.jar.Manifest

class SpeechToTextActivity : AppCompatActivity() {

    private lateinit var speechRecognizer: SpeechRecognizer
    private lateinit var recognitionListener: RecognitionListener
    //layout 변수 할당
    lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speech_to_text)
        val btnStartRecord: Button = findViewById(R.id.activity_speech_to_text_btn1)
        resultText = findViewById(R.id.activity_speech_to_text_tv1)
        // 접근 권한 설정 실행
        requestPermisson()

        // 음성 녹음 start
        var intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, packageName)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ko-KR")

        // 음성인식 설정
        setListener()

        // 버튼 클릭 event
        btnStartRecord.setOnClickListener {
            speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)
            speechRecognizer.setRecognitionListener(recognitionListener)
            // intent를 통해 음성 인식 시작하게 된다.(시작 부분) -> setListener의 onResult에서 끝나게 됨
            speechRecognizer.startListening(intent)
        }

    }

    // 접근 권한을 설정하는 함수
    private fun requestPermisson(){
        // 안드로이드 RECORD_AUDIO를 사용하기 위한 접근 권한 설정
        if(Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(this,android.Manifest.permission.RECORD_AUDIO)
            != PackageManager.PERMISSION_GRANTED){
            // 한 번만 승인되면 이후로 자동으로 허용
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.RECORD_AUDIO),0)
        }
    }

    // 음성인식 설정하는 함수
    private fun setListener(){
        recognitionListener = object : RecognitionListener{

            // 음성 인식 시작 준비
            override fun onReadyForSpeech(p0: Bundle?) {
                Toast.makeText(applicationContext,"음성 인식 시작",Toast.LENGTH_SHORT).show()
            }

            // 음성 인식 시작
            override fun onBeginningOfSpeech() {
            }

            // The sound level in the audio stream has changed.
            override fun onRmsChanged(p0: Float) {
            }

            // More sound has been received.
            override fun onBufferReceived(p0: ByteArray?) {
            }

            // Called after the user stops speaking.
            override fun onEndOfSpeech() {
            }
            // 에러 발생한 경우
            override fun onError(p0: Int) {
                Toast.makeText(applicationContext,"에러 발생",Toast.LENGTH_SHORT).show()
            }

            // Called after the user stops speaking.
            // 사용자가 말을 끝냈을 때 실행된다 -> 음성 녹음 된 것을 TextView에 띄워주는 로직 구성
            // 끝나고 나서의 사후처리 로직 관리하면 됨
            override fun onResults(p0: Bundle?) {
                var myRecord: ArrayList<String> = p0?.getStringArrayList(
                    SpeechRecognizer.RESULTS_RECOGNITION
                ) as ArrayList<String>

                for(i in 0 until myRecord.size){
                    resultText.text = myRecord[i]
                }
            }

            override fun onPartialResults(p0: Bundle?) {
                TODO("Not yet implemented")
            }

            override fun onEvent(p0: Int, p1: Bundle?) {
                TODO("Not yet implemented")
            }

        }
    }

}