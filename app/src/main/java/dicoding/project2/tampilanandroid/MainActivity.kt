package dicoding.project2.tampilanandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dicoding.project2.tampilanandroid.data.api.RetrofitBuilder
import dicoding.project2.tampilanandroid.ui.main.adapter.EsportListAdapater
import dicoding.project2.tampilanandroid.ui.main.adapter.ListenerRecycleView
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity(), ListenerRecycleView {
    private val list = ArrayList<EsportTLMDatabaseItem>()
    private lateinit var tv: TextView
    private lateinit var rvPost: RecyclerView
    private lateinit var adapter: EsportListAdapater

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvPost = findViewById(R.id.rvPost)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        rvPost.layoutManager = layoutManager

        RetrofitBuilder.apiService.getEsport().enqueue(
            object : retrofit2.Callback<List<EsportTLMDatabaseItem>> {
            override fun onResponse(
                call: Call<List<EsportTLMDatabaseItem>>,
                response: Response<List<EsportTLMDatabaseItem>>
            ) {
                val value: List<EsportTLMDatabaseItem>? = response.body()
                value?.let {
                    list.addAll(it)
                    adapter = EsportListAdapater(value)
                    adapter.listener = this@MainActivity
                    rvPost.adapter = adapter
                }
                Log.d("value: ", value.toString())
            }

            override fun onFailure(call: Call<List<EsportTLMDatabaseItem>>, t: Throwable) {
                Log.e("Error", t.message!!)
            }
        })
    }

    override fun onItemClick(view: View, esportTLMDatabaseItem: EsportTLMDatabaseItem) {
        val intent =Intent(this@MainActivity, DescriptionActivity::class.java)
        intent.putExtra("data", esportTLMDatabaseItem)
        this.startActivity(intent)
    }
}