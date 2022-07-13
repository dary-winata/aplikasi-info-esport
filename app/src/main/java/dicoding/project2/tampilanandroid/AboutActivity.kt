package dicoding.project2.tampilanandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class AboutActivity : AppCompatActivity() {
    private lateinit var navigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
    }

    private fun navigationHandler() {
        navigation.setOnNavigationItemSelectedListener { item ->
            if(item.itemId == R.id.nav_home) {
                val intent = Intent(this, MainActivity::class.java)
                this.startActivity(intent)
                return@setOnNavigationItemSelectedListener true
            }
            false
        }
    }
}