package com.example.myapplication.data

import android.content.Context
import android.content.SharedPreferences

class ProfileRepository(private val context: Context) {
    // Changed preference name and keys to force refresh to Bakmi Gemboel theme
    private val prefs: SharedPreferences =
        context.getSharedPreferences("bakmi_gemboel_prefs", Context.MODE_PRIVATE)

    fun getRestaurantName(): String = prefs.getString("brand_name", "Bakmi Gemboel") ?: "Bakmi Gemboel"
    
    fun getAddress(): String = prefs.getString("brand_address", "Senopati District, South Jakarta") ?: "Senopati District, South Jakarta"
    
    fun getDescription(): String = prefs.getString("brand_description", "Bakmi Gemboel adalah destinasi kuliner modern yang membawa level baru dalam menikmati bakmi. Mengusung konsep Urban Street Food, kami menyajikan bakmi dengan cita rasa autentik namun dalam kemasan yang trendy dan kekinian.") ?: "Bakmi Gemboel adalah destinasi kuliner modern yang membawa level baru dalam menikmati bakmi. Mengusung konsep Urban Street Food, kami menyajikan bakmi dengan cita rasa autentik namun dalam kemasan yang trendy dan kekinian."
    
    fun getOpenHours(): String = prefs.getString("brand_hours", "10:00 AM - 10:00 PM") ?: "10:00 AM - 10:00 PM"

    fun saveProfile(name: String, address: String, description: String, openHours: String) {
        prefs.edit().apply {
            putString("brand_name", name)
            putString("brand_address", address)
            putString("brand_description", description)
            putString("brand_hours", openHours)
            apply()
        }
    }
}
