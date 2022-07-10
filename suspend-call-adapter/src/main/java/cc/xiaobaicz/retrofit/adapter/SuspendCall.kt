package cc.xiaobaicz.retrofit.adapter

interface SuspendCall<T> {

    suspend fun call(): Result<T>

}