package com.example.myapplication.data

import com.example.myapplication.R

object MenuData {
    val menuList = listOf(
        MenuItem(
            "1",
            "Gemboel Signature",
            38000,
            "The OG. Mie karet kenyal dengan topping ayam bumbu rahasia, pangsit goreng, dan sambal matah yang nendang.",
            R.drawable.bakmi.toString()
        ),
        MenuItem(
            "2",
            "Truffle Oil Noodle",
            55000,
            "Level up! Bakmi halus dengan aroma truffle oil yang mewah, telur setengah matang, dan beef slice premium.",
            R.drawable.bakmi.toString()
        ),
        MenuItem(
            "3",
            "Mie Kare Viral",
            42000,
            "Kuah kare kental yang gurih banget, disajikan dengan ayam krispi dan kerupuk mie yang ikonik.",
            R.drawable.bakmi.toString()
        ),
        MenuItem(
            "4",
            "Spicy Garlic Bowl",
            35000,
            "Buat pecinta pedas. Bakmi bumbu bawang putih goreng dan chili oil yang aromatik. Pedasnya juara!",
            R.drawable.bakmi.toString()
        ),
        MenuItem(
            "5",
            "Creamy Salted Egg",
            45000,
            "Bakmi dengan saus telur asin yang creamy dan gurih, ditambah topping cumi goreng tepung.",
            R.drawable.bakmi.toString()
        ),
        MenuItem(
            "6",
            "Cheesy Noodle Melt",
            48000,
            "Mie goreng dengan lelehan keju mozzarella di atasnya. Gurih, molor, dan bikin nagih!",
            R.drawable.bakmi.toString()
        ),
        MenuItem(
            "7",
            "Yamien 2.0",
            36000,
            "Classic yamien dengan twist modern. Manis gurihnya pas, disajikan dengan kuah kaldu kolagen.",
            R.drawable.bakmi.toString()
        ),
        MenuItem(
            "8",
            "Dirty Boba Milk Tea",
            25000,
            "Minuman pendamping terbaik. Brown sugar boba dengan fresh milk yang creamy banget.",
            R.drawable.bakmi.toString()
        ),
        MenuItem(
            "9",
            "Pangsit Goreng Viral",
            20000,
            "Pangsit goreng isi ayam udang yang renyah di luar, juicy di dalam. Isinya 5 pcs, cocok buat sharing.",
            R.drawable.bakmi.toString()
        ),
        MenuItem(
            "10",
            "Es Kopi Gemboel",
            22000,
            "Kopi susu gula aren andalan kami. Strong, creamy, dan bikin melek!",
            R.drawable.bakmi.toString()
        )
    )

    fun getMenuById(id: String): MenuItem? {
        return menuList.find { it.id == id }
    }
}
