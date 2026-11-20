package me.bpxdevjr.cafe_express_2

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
            Boisson("Espresso", "Court et intense", 10, R.drawable.espresso),
            Boisson("Café crème", "Espresso et lait chaud", 12, R.drawable.cafe_creme),
            Boisson("Américano", "Espresso allongé d'eau chaude", 12, R.drawable.americano),
            Boisson("Cappuccino", "Mousse de lait onctueuse", 15, R.drawable.cappuccino),
            Boisson("Latte", "Beaucoup de lait, doux", 15, R.drawable.latte),
            Boisson("Moka", "Café et chocolat", 17, R.drawable.moka),
            Boisson("Thé à la menthe", "Thé vert, menthe fraîche", 8, R.drawable.the_a_la_menthe),
            Boisson("Thé vert", "Nature, sans sucre", 9, R.drawable.the_vert),
            Boisson("Chocolat chaud", "Cacao et lait", 14, R.drawable.chocolat_chaud),
            Boisson("Jus d'orange", "Pressé minute", 12, R.drawable.jus_orange),
            Boisson("Smoothie fraise", "Fraise, banane, yaourt", 18, R.drawable.smoothie_fraise),
            Boisson("Eau minérale", "50 cl", 5, R.drawable.eau_minerale)
        )

        lvMenu.adapter = MenuAdapter(this, boissons)
    }
}