package me.bpxdevjr.cafe_express_2

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar

class DetailsActivity : AppCompatActivity() {

    private lateinit var menuItemPicture: ImageView
    private lateinit var menuItemName: TextView
    private lateinit var menuItemDescription: TextView

    private lateinit var rgTaille: RadioGroup

    private lateinit var cbCreme: CheckBox
    private lateinit var swAEmporter: SwitchCompat

    private lateinit var outputText: TextView

    private lateinit var btnCalculer: Button
    private lateinit var btnAjouterAuPanier: Button


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
        val prix = intent.getStringExtra("PRIX")

        var menuItemPrix = prix?.removeSuffix(" DH")?.toInt() ?: 0

        menuItemName = findViewById(R.id.menuItemName)
        menuItemDescription = findViewById(R.id.menuItemDescription)
        menuItemPicture = findViewById(R.id.menuItemPicture)
        rgTaille = findViewById(R.id.rgTaille)

        swAEmporter = findViewById(R.id.swEmporter)
        cbCreme = findViewById(R.id.cbCreme)

        outputText = findViewById(R.id.txtResult)

        btnAjouterAuPanier = findViewById(R.id.btnAjouterAuPanier)
        btnCalculer = findViewById(R.id.btnCalculer)

        menuItemPicture.setImageResource(image)
        menuItemName.text = nom
        menuItemDescription.text = description

        val toolbar: MaterialToolbar = findViewById(R.id.customPageBar)
        toolbar.setNavigationOnClickListener {
            finish()
        }


        btnCalculer.setOnClickListener {
            var prixTaille = 0

            when (rgTaille.checkedRadioButtonId) {
                R.id.rbPetit -> prixTaille = menuItemPrix - 2
                R.id.rbMoyen -> prixTaille = menuItemPrix
                R.id.rbGrand -> prixTaille = menuItemPrix + 2
            }

            var aEmporte = 0
            if (swAEmporter.isChecked) {
                aEmporte = 2
            }

            var avecCreme = 0
            if (cbCreme.isChecked) {
                avecCreme = 2
            }

            var total = avecCreme + aEmporte + prixTaille
            outputText.text = getString(R.string.recap_total, total)
        }

        btnAjouterAuPanier.setOnClickListener {  }
    }
}