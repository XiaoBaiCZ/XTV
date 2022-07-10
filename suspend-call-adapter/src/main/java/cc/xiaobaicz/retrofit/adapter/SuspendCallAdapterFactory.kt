package cc.xiaobaicz.retrofit.adapter

import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import retrofit2.SkipCallbackExecutor
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * 可挂起请求适配器
 */
class SuspendCallAdapterFactory : CallAdapter.Factory() {

    override fun get(returnType: Type, annotations: Array<out Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
        if (hasSkipCallbackExecutor(annotations))
            return null
        if (isSuspendCall(returnType))
            return null
        return SuspendCallAdapter(getParameterUpperBound(0, returnType as ParameterizedType))
    }

    private fun hasSkipCallbackExecutor(annotations: Array<out Annotation>): Boolean {
        for (annotation in annotations) {
            if (annotation is SkipCallbackExecutor)
                return true
        }
        return false
    }

    private fun isSuspendCall(returnType: Type): Boolean = getRawType(returnType) != SuspendCall::class.java

    class SuspendCallAdapter(private val type: Type) : CallAdapter<Any, SuspendCall<Any>> {
        override fun responseType(): Type {
            return type
        }

        override fun adapt(call: Call<Any>): SuspendCall<Any> {
            return SuspendCallImpl(call)
        }
    }

}