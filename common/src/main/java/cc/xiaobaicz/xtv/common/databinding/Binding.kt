package cc.xiaobaicz.xtv.common.databinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.databinding.ViewDataBinding
import cc.xiaobaicz.xtv.common.app.DataBindingFragment

/**
 * DataBinding 工具
 */
fun <T : ViewDataBinding> ComponentActivity.bind(inflater: (LayoutInflater) -> T): Lazy<T> = lazy {
    val view = inflater(layoutInflater)
    view.lifecycleOwner = this
    return@lazy view
}

/**
 * DataBinding 工具
 */
fun <T : ViewDataBinding> DataBindingFragment.bind(inflater: (LayoutInflater, ViewGroup?, Boolean) -> T): Lazy<T> = lazy {
    val view = inflater(layoutInflater, container, false)
    view.lifecycleOwner = this
    return@lazy view
}