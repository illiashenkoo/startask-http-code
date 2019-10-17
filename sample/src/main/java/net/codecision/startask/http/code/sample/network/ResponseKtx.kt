package net.codecision.startask.http.code.sample.network

import net.codecision.startask.http.code.HttpStatusCode
import retrofit2.Response

fun <T> Response<T>.toHttpStatusCode(): HttpStatusCode {
    return HttpStatusCode.fromValue(code())
}