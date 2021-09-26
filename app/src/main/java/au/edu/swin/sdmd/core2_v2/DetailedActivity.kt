package au.edu.swin.sdmd.core2_v2

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

class DetailedActivity : AppCompatActivity() {
    var car: Car? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        car = intent.getParcelableExtra<Car>("car")

        car?.let{
            findViewById<EditText>(R.id.name).setText(it.name)
            findViewById<EditText>(R.id.location).setText(it.location)
            findViewById<RatingBar>(R.id.ratingBar).rating = it.rating
            findViewById<EditText>(R.id.year).setText(it.year)
            findViewById<ImageView>(R.id.car).setImageResource(it.carImage)
        }
    }

    override fun onBackPressed() {
        car?.name = findViewById<EditText>(R.id.name).getText().toString()
        car?.location = findViewById<EditText>(R.id.location).getText().toString()
        car?.rating = findViewById<RatingBar>(R.id.ratingBar).rating.toFloat()
        val date = findViewById<EditText>(R.id.year).getText().toString()
        if(date.matches("\\d{4}-\\d{2}-\\d{2}".toRegex())){
            car?.year = date
            Log.i("Matching?", "matches regex")
            val i = intent.apply {
                putExtra("car", car)
            }
            Toast.makeText(applicationContext, "${car?.name} updated", Toast.LENGTH_SHORT).show()
            setResult(Activity.RESULT_OK, i)
            finish()
        }else{
            Log.i("Matching?", "doesnt match regex")
            findViewById<EditText>(R.id.year).setError("Date format incorrect")
        }
    }
}