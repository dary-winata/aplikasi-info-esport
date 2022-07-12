package dicoding.project2.tampilanandroid.data.api

import dicoding.project2.tampilanandroid.EsportTLMDatabaseItem
import retrofit2.Call
import retrofit2.http.GET

interface EsportApiService {
    @GET("api/games/e-sport/?page=1")
    fun getEsport(): Call<List<EsportTLMDatabaseItem>>
}