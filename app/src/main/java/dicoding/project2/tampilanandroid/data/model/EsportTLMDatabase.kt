package dicoding.project2.tampilanandroid

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

//data class EsportTLMDatabase(
//
//	@field:SerializedName("EsportTLMDatabase")
//	val esportTLMDatabase: List<EsportTLMDatabaseItem>
//)
@Parcelize
data class EsportTLMDatabaseItem(

	@field:SerializedName("thumb")
	val thumb: String? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("tag")
	val tag: String? = null,

	@field:SerializedName("time")
	val time: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("key")
	val key: String? = null,

	@field:SerializedName("desc")
	val desc: String? = null
): Parcelable
