/*
package com.mynote.kano.gitHubSources.gitHUBConnect

import android.content.Context
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.cache.normalized.CacheKey
import com.apollographql.apollo.cache.normalized.CacheKeyResolver
import com.apollographql.apollo.cache.normalized.lru.EvictionPolicy
import com.apollographql.apollo.cache.normalized.lru.LruNormalizedCacheFactory
import com.apollographql.apollo.response.CustomTypeAdapter
import com.apollographql.apollo.response.CustomTypeValue
import com.apollographql.apollo.subscription.WebSocketSubscriptionTransport
import okhttp3.OkHttpClient
import java.text.ParseException
import java.text.SimpleDateFormat

private val GRAPHQL_ENDPOINT: String = "https://api.github.com/graphql"
private val SQL_CACHE_NAME = "kano"

//1. 암호화가 필요한지
//2. 프로젝트 내에 넣을 수는 없으므로, 다른 방식을 강구해보기
private val authHeader = "52420e39c861adba1cf436d142a821121d5dc32f"


class Network {
    companion object{
        lateinit var apolloClient: ApolloClient
    }
    fun setApolloClient(accessTokenId: String, context: Context){

        val authHeader = "Bearer $accessTokenId"
        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    val original = chain.request()
                    val builder = original.newBuilder().method(original.method(), original.body())
                    builder.header("Authorization", authHeader)
                    chain.proceed(builder.build())
                }
                .build()
        val dateCustomTypeAdapter = object : CustomTypeAdapter<String> {
            var ISO8601 = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSZ")
            override fun decode(value: CustomTypeValue<*>): String {
                try {
                    return ISO8601.parse(value.value.toString()).toString()
                } catch (e: ParseException) {
                    throw RuntimeException(e)
                }
            }
            override fun encode(value: String): CustomTypeValue<*> {
                return CustomTypeValue.GraphQLString(value)
            }
        }
        val apolloSqlHelper = ApolloSqlHelper(context, SQL_CACHE_NAME)
        val normalizedCacheFactory = LruNormalizedCacheFactory(EvictionPolicy.NO_EVICTION)
                .chain(SqlNormalizedCacheFactory(apolloSqlHelper))
        val cacheKeyResolver: CacheKeyResolver = object : CacheKeyResolver() {
            override fun fromFieldRecordSet(field: ResponseField, recordSet: Map<String, Any>): CacheKey {
                if (recordSet.containsKey("todos")) {
                    val id = recordSet["todos"] as String
                    return CacheKey.from(id)
                }
                return CacheKey.NO_KEY
            }
            override fun fromFieldArguments(field: ResponseField, variables: Operation.Variables): CacheKey {
                return CacheKey.NO_KEY
            }
        }
        apolloClient = ApolloClient.builder()
                .serverUrl(GRAPHQL_ENDPOINT)
                .okHttpClient(okHttpClient)
                .normalizedCache(normalizedCacheFactory, cacheKeyResolver)
                .addCustomTypeAdapter(CustomType.TIMESTAMPTZ, dateCustomTypeAdapter)
                .build()
    }
}*/
