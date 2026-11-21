package me.bpxdevjr.cafe_express_2

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import me.bpxdevjr.cafe_express_2.adapters.MenuAdapter
import me.bpxdevjr.cafe_express_2.data.Boisson

class MenuActivity : AppCompatActivity() {

    private lateinit var lvMenu: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lvMenu = findViewById<ListView>(R.id.lvMenu)

        val boissons: List<Boisson> = listOf(
            Boisson(
                "Espresso",
                "Court et intense",
                "10 DH",
                R.drawable.espresso
            ),
            Boisson(
                "Café crème",
                "Espresso et lait chaud",
                "12 DH",
                R.drawable.cafe_creme
            ),
            Boisson(
                "Américano",
                "Espresso allongé d'eau chaude",
                "12 DH",
                R.drawable.americano
            ),
            Boisson(
                "Cappuccino",
                "Mousse de lait onctueuse",
                "15 DH",
                R.drawable.cappuccino
            ),
            Boisson(
                "Latte",
                "Beaucoup de lait, doux",
                "15 DH",
                R.drawable.latte
            ),
            Boisson(
                "Moka",
                "Café et chocolat",
                "17 DH",
                R.drawable.moka
            ),
            Boisson(
                "Thé à la menthe",
                "Thé vert, menthe fraîche",
                "8 DH",
                R.drawable.the_a_la_menthe
            ),
            Boisson(
                "Thé vert",
                "Nature, sans sucre",
                "9 DH",
                R.drawable.the_vert
            ),
            Boisson(
                "Chocolat chaud",
                "Cacao et lait",
                "14 DH",
                R.drawable.chocolat_chaud
            ),
            Boisson(
                "Jus d'orange",
                "Pressé minute",
                "12 DH",
                R.drawable.jus_orange
            ),
            Boisson(
                "Smoothie fraise",
                "Fraise, banane, yaourt",
                "18 DH",
                R.drawable.smoothie_fraise
            ),
            Boisson(
                "Eau minérale",
                "50 cl",
                "5 DH",
                R.drawable.eau_minerale
            )
        )

        lvMenu.adapter = MenuAdapter(this, boissons)

        lvMenu.setOnItemClickListener { _, _, position, _ ->
            val boisson = boissons[position]
            val intent = Intent(this, DetailsActivity::class.java)

            intent.putExtra("nom", boisson.nom)
            intent.putExtra("description", boisson.description)
            intent.putExtra("prix", boisson.prix)
            intent.putExtra("image", boisson.image)

            startActivity(intent)
        }
    }
}