package cc.xiaobaicz.xtv.common.lang

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

object Storage {

    /**
     * App配置存储
     */
    val Context.configDataStore by preferencesDataStore("app_config")

}