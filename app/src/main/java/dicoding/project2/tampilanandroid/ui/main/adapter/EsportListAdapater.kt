package dicoding.project2.tampilanandroid.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import dicoding.project2.tampilanandroid.EsportTLMDatabaseItem
import dicoding.project2.tampilanandroid.R

class EsportListAdapater(
    private val esportTLMDatabase: List<EsportTLMDatabaseItem>
): RecyclerView.Adapter<EsportListAdapater.holderEsportNewsAdapter>() {
    lateinit var listener: ListenerRecycleView

    class holderEsportNewsAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitleEsport: TextView = itemView.findViewById(R.id.tvTitleEsport)
        val tvDescEsport: TextView = itemView.findViewById(R.id.tvDescriptionEsport)
        val ivImageEsport: ImageView = itemView.findViewById(R.id.ivImageEsport)

        fun bindItem(esportTLMDatabaseItem: EsportTLMDatabaseItem) {
            tvTitleEsport.text = esportTLMDatabaseItem.title
            tvDescEsport.text = esportTLMDatabaseItem.desc
            ivImageEsport.load(esportTLMDatabaseItem.thumb)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holderEsportNewsAdapter {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return holderEsportNewsAdapter(view)
    }

    override fun onBindViewHolder(holder: holderEsportNewsAdapter, position: Int) {
        holder.bindItem(esportTLMDatabase[position])

        holder.itemView.setOnClickListener {
            listener.onItemClick(it, esportTLMDatabase[position])
        }
    }

    override fun getItemCount(): Int = esportTLMDatabase.size
}