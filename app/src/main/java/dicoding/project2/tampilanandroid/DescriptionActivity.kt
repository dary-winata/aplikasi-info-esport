package dicoding.project2.tampilanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import coil.load

class DescriptionActivity : AppCompatActivity() {
    private var dataEsport: EsportTLMDatabaseItem? = null
    private lateinit var imageEsport: ImageView
    private lateinit var tvTitle: TextView
    private lateinit var tvDescription: TextView
    private lateinit var tvAuthor: TextView
    private lateinit var tvTime: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_description)

        try {
            dataEsport = intent?.getParcelableExtra("data")
        }catch(ClassCastException: ClassCastException){
            Toast.makeText(this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show()
        }

        imageEsport = findViewById(R.id.ivImageThumbnail)
        imageEsport.load(dataEsport?.thumb)

        tvTitle = findViewById(R.id.tvTitle)
        tvTitle.text = dataEsport?.title

        tvDescription = findViewById(R.id.tvDescription)
        tvDescription.text = dataEsport?.desc

        tvAuthor = findViewById(R.id.tvAuthor)
        tvAuthor.text = "author: " + dataEsport?.author

        tvTime = findViewById(R.id.tvDate)
        tvAuthor.text = "time : " + dataEsport?.time
    }
}