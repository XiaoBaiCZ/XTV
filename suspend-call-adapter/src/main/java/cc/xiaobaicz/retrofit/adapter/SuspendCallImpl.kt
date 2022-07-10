package cc.xiaobaicz.retrofit.adapter

import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume

internal class SuspendCallImpl<T>(private val call: Call<T>) : SuspendCall<T> {

    override suspend fun call(): Result<T> = suspendCancellableCoroutine {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                it.resume(Result(response.body()))
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                it.resume(Result(throwable = t))
            }
        })
    }

}