package app.murauchi.mirerun.data_save

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //DataStoreという名前でインスタンスを生成
        val dataStore: SharedPreferences = getSharedPreferences("DataStore", Context.MODE_PRIVATE)
        saveButton.setOnClickListener {
            //テキストを取得
            val stringText = editText.text.toString()
            saveText.text = stringText
            //入力文字列を"Input"に書き込む
            val editor = dataStore.edit()
            editor.putString("Input", stringText)

            editor.apply()
        }
        readButton.setOnClickListener {
            //Inputから読み出す
            val str = dataStore.getString("Input","NoData")
            readText.text = str

        }
    }
}