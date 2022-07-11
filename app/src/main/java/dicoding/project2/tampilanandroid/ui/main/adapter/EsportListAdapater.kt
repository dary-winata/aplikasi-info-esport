package dicoding.project2.tampilanandroid.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dicoding.project2.tampilanandroid.EsportTLMDatabase
import dicoding.project2.tampilanandroid.EsportTLMDatabaseItem
import dicoding.project2.tampilanandroid.R

class EsportListAdapater(
    private val esportTLMDatabase: List<EsportTLMDatabaseItem>
): RecyclerView.Adapter<EsportListAdapater.holderEsportNewsAdapter>() {

    class holderEsportNewsAdapter(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(esportTLMDatabaseItem: EsportTLMDatabaseItem) {
//            with(itemView) {
                val testing_text = "title: ${esportTLMDatabaseItem.title}"
                val text = itemView.findViewById(R.id.tvText) as TextView
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): holderEsportNewsAdapter {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return holderEsportNewsAdapter(view)
    }

    override fun onBindViewHolder(holder: holderEsportNewsAdapter, position: Int) {
        holder.bindItem(esportTLMDatabase[position])
    }

    override fun getItemCount(): Int = esportTLMDatabase.size
}