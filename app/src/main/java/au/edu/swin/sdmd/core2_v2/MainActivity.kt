package au.edu.swin.sdmd.core2_v2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private var mercedesObject = Car("Mercedes Benz W113", "Stuttgart", "1963-01-01", 5F, R.drawable.mercedes_benz_w113)
    private var bmwObject = Car("BMW E30", "Munich", "1982-01-01", 4F, R.drawable.bmw_e30)
    private var porscheObject = Car("Porsche 911", "Stuttgart", "1963-01-01", 4.5F, R.drawable.porsche_911)
    private var vwObject = Car("Volkswagen Golf", "Wolfsburg", "1974-01-01", 2.5F, R.drawable.vw_golf)

    //Mercedes image ID = 2131165305
    //BMW image ID = 2131165272
    //Porsche image ID = 2131165329
    //VW image ID = 2131165333

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startForResult =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result->
                when(result.resultCode){
                    RESULT_OK -> {
                        val data = result.data
                        val car = data?.getParcelableExtra<Car>("car")
                        when (car?.carImage) {
                            2131165305 -> {
                                car?.let {
                                    findViewById<TextView>(R.id.mercedes_txt).text = car?.name.toString()
                                    findViewById<TextView>(R.id.mercedes_rating).text = car?.rating.toString()
                                    mercedesObject.name = car?.name.toString()
                                    mercedesObject.location = car?.location.toString()
                                    mercedesObject.rating = car?.rating
                                    mercedesObject.year = car?.year.toString()
                                }
                            }
                            2131165272 -> {
                                car?.let {
                                    findViewById<TextView>(R.id.bmw_txt).text = car?.name.toString()
                                    findViewById<TextView>(R.id.bmw_rating).text = car?.rating.toString()
                                    bmwObject.name = car?.name.toString()
                                    bmwObject.location = car?.location.toString()
                                    bmwObject.rating = car?.rating
                                    bmwObject.year = car?.year.toString()
                                }
                            }
                            2131165329 -> {
                                car?.let {
                                    findViewById<TextView>(R.id.porsche_txt).text = car?.name.toString()
                                    findViewById<TextView>(R.id.porsche_rating).text = car?.rating.toString()
                                    porscheObject.name = car?.name.toString()
                                    porscheObject.location = car?.location.toString()
                                    porscheObject.rating = car?.rating
                                    porscheObject.year = car?.year.toString()
                                }
                            }
                            2131165333 -> {
                                car?.let {
                                    findViewById<TextView>(R.id.vw_txt).text = car?.name.toString()
                                    findViewById<TextView>(R.id.vw_rating).text = car?.rating.toString()
                                    vwObject.name = car?.name.toString()
                                    vwObject.location = car?.location.toString()
                                    vwObject.rating = car?.rating
                                    vwObject.year = car?.year.toString()
                                }
                            }
                        }
                        //Log.i("FromMain", mercedesObject.name)
                    }
                }
                //Log.i("FromMain", "testingFromMain")
                Log.i("Result", "returned ${result.data.toString()}")
            }

        // Set Mercedes information
        val mercedesName = findViewById<TextView>(R.id.mercedes_txt)
        mercedesName.text = mercedesObject.name
        val mercedesRtg = findViewById<TextView>(R.id.mercedes_rating)
        mercedesRtg.text = mercedesObject.rating.toString()

        val mercedes = findViewById<ImageView>(R.id.mercedes)
        mercedes.setOnClickListener {
            val intent = Intent(this, DetailedActivity::class.java)
            intent.putExtra("car", mercedesObject)
            startForResult.launch(intent)
        }

        // Set BMW information
        val bmwName = findViewById<TextView>(R.id.bmw_txt)
        bmwName.text = bmwObject.name
        val bmwRtg = findViewById<TextView>(R.id.bmw_rating)
        bmwRtg.text = bmwObject.rating.toString()

        val bmw = findViewById<ImageView>(R.id.bmw)
        bmw.setOnClickListener {
            val intent = Intent(this, DetailedActivity::class.java)
            intent.putExtra("car", bmwObject)
            startForResult.launch(intent)
        }

        // Set Porsche information
        val porscheName = findViewById<TextView>(R.id.porsche_txt)
        porscheName.text = porscheObject.name
        val porscheRtg = findViewById<TextView>(R.id.porsche_rating)
        porscheRtg.text = porscheObject.rating.toString()

        val porsche = findViewById<ImageView>(R.id.porsche)
        porsche.setOnClickListener {
            val intent = Intent(this, DetailedActivity::class.java)
            intent.putExtra("car", porscheObject)
            startForResult.launch(intent)
        }

        // Set VW information
        val vwName = findViewById<TextView>(R.id.vw_txt)
        vwName.text = vwObject.name
        val vwRtg = findViewById<TextView>(R.id.vw_rating)
        vwRtg.text = vwObject.rating.toString()

        val vw = findViewById<ImageView>(R.id.vw)
        vw.setOnClickListener {
            val intent = Intent(this, DetailedActivity::class.java)
            intent.putExtra("car", vwObject)
            startForResult.launch(intent)
        }
    }
}