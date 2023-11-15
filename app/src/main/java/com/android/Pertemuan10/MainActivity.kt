package com.android.Pertemuan10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.Pertemuan10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var adapterBuah = BuahAdapter(generateBuahData()) { buah ->
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("buah_name", buah.name)
            intent.putExtra("buah_description", buah.description)
            intent.putExtra("buah_price", buah.price)
            intent.putExtra("buah_pict", buah.img)
            startActivity(intent)
        }

        with(binding) {
            rycItem.apply {
                adapter = adapterBuah
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }
    }
    fun generateBuahData(): List<Buah> {
        return listOf(
            Buah(name = "Apel", price = "Rp 10.000", img = R.drawable.apel, description = "Apel adalah buah kecil berwarna hijau yang memiliki rasa asam segar. Biasanya digunakan untuk memberi rasa pada makanan dan minuman."),
            Buah(name = "Buah Naga", price = "Rp 15.000", img = R.drawable.`buah_naga`, description = "Buah naga adalah buah yang biasanya digunakan dalam salad dan memiliki rasa segar dan renyah."),
            Buah(name = "Delima", price = "Rp 12.000", img = R.drawable.delima, description = "Delima adalah buah eksotis dengan kulit berkerut yang harus dikupas. Dagingnya manis dan sedikit berair."),
            Buah(name = "Markisa", price = "Rp 18.000", img = R.drawable.markisa, description = "Markisa, juga dikenal sebagai belimbing, memiliki bentuk bintang dan rasa manis dengan rasa asam yang ringan."),
            Buah(name = "Pepaya", price = "Rp 22.000", img = R.drawable.pepaya, description = "Pepaya memiliki kulit berduri dengan daging berwarna putih atau merah. Rasanya manis dan segar."),
            Buah(name = "Pir", price = "Rp 25.000", img = R.drawable.pir, description = "Pir adalah buah musim panas yang besar, berwarna merah dengan daging merah yang manis dan berair."),
            Buah(name = "Pisang", price = "Rp 20.000", img = R.drawable.pisang, description = "Pisang adalah buah yang sangat umum dan memiliki rasa manis atau asam tergantung pada jenisnya."),
            Buah(name = "Strawberry", price = "Rp 30.000", img = R.drawable.satrawberry, description = "Strawberry adalah buah kecil berwarna biru yang kaya akan antioksidan dan memiliki rasa manis."),
            Buah(name = "Semangka", price = "Rp 18.000", img = R.drawable.semangka, description = "Semangka adalah buah yang memiliki daging oranye atau hijau dengan rasa manis dan segar."),
            Buah(name = "Kiwi", price = "Rp 28.000", img = R.drawable.kiwi, description = "Kiwi adalah buah kecil berkulit berbulu dengan daging hijau yang manis dan asam."),
            Buah(name = "Lemon", price = "Rp 10.000", img = R.drawable.lemon, description = "Lemon adalah buah berwarna kuning dengan rasa asam yang kuat, sering digunakan dalam minuman dan hidangan."),
            Buah(name = "Nanas", price = "Rp 14.000", img = R.drawable.nanas, description = "Nanas adalah buah tropis dengan rasa manis dan asam, sering digunakan dalam salad dan hidangan lainnya."),
            Buah(name = "Jeruk", price = "Rp 10.000", img = R.drawable.jeruk, description = "Jeruk adalah buah berkulit tebal berwarna oranye dengan rasa manis dan asam."),
            Buah(name = "Alpukat", price = "Rp 18.000", img = R.drawable.alpukat, description = "Alpukat adalah buah yang berkulit hijau dengan daging lembut dan kaya lemak.")
        )
    }


}