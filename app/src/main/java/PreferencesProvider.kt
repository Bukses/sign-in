import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.provider.Settings.Global.getString
import android.provider.Settings.Secure.getString
import android.provider.Settings.System.getString
import androidx.core.content.res.TypedArrayUtils.getString

class PreferencesProvider(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("myPreferences", MODE_PRIVATE)

    fun putString(key:String, value:String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)

    }

}