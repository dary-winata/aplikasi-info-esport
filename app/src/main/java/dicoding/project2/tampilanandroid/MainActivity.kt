package dicoding.project2.tampilanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dicoding.project2.tampilanandroid.data.api.RetrofitBuilder
import dicoding.project2.tampilanandroid.ui.main.adapter.EsportListAdapater
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<EsportTLMDatabaseItem>()
    private lateinit var tv: TextView
    private lateinit var rvPost: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.tvText)
        rvPost = findViewById(R.id.rvPost)

        RetrofitBuilder.apiService.getEsport().enqueue(object : retrofit2.Callback<EsportTLMDatabase> {
            override fun onResponse(
                call: Call<EsportTLMDatabase>,
                response: Response<EsportTLMDatabase>
            ) {
                val value: EsportTLMDatabase? = response.body() ?: null
                value?.let { list.addAll(it.esportTLMDatabase) }
                val adapter = EsportListAdapater(list)
            }

            override fun onFailure(call: Call<EsportTLMDatabase>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}