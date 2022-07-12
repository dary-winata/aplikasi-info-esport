package dicoding.project2.tampilanandroid.ui.main.adapter

import android.view.View
import dicoding.project2.tampilanandroid.EsportTLMDatabaseItem

interface ListenerRecycleView {
    fun onItemClick(view: View, esportTLMDatabaseItem: EsportTLMDatabaseItem)
}