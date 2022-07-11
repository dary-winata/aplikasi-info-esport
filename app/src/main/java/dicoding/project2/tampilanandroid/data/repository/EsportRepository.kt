package dicoding.project2.tampilanandroid.data.repository

import dicoding.project2.tampilanandroid.data.api.EsportApi

class EsportRepository(private val esportApi: EsportApi) {
    fun getEsport() = esportApi.getInfo()
}