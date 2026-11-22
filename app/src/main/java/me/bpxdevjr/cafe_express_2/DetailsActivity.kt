package me.bpxdevjr.cafe_express_2

import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailsActivity : AppCompatActivity() {

    private lateinit var menuItemPicture: ImageView
    private lateinit var menuItemName: TextView
    private lateinit var menuItemDescription: TextView

    private lateinit var rbTaille: RadioGroup



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val image = intent.getIntExtra("IMAGE", 0)
        val nom = intent.getStringExtra("NOM")
        val description = intent.getStringExtra("DESCRIPTION")

        menuItemName = findViewById<TextView>(R.id.menuItemName)
        menuItemDescription = findViewById<TextView>(R.id.menuItemDescription)
        menuItemPicture = findViewById<ImageView>(R.id.menuItemPicture)

        menuItemPicture.setImageResource(image)
        menuItemName.text = nom
        menuItemDescription.text = description
    }
}