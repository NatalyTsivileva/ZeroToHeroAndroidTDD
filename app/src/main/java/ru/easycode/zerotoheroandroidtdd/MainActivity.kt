package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val textKey = "textKey"
    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.changeButton)
        textView = findViewById<TextView>(R.id.titleTextView)

        val savedText = savedInstanceState?.getString(textKey, "")
        if (savedText?.isNotEmpty() == true) {
            textView?.text = savedText
        }

        button.setOnClickListener {
            textView?.text = getString(R.string.text_view_text_after_change)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(textKey, textView?.text.toString())
    }
}