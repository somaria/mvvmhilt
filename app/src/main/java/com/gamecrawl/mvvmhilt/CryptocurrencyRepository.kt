package com.gamecrawl.mvvmhilt

interface CryptocurrencyRepository {
    suspend fun getCryptoCurrency(): List<Cryptocurrency>
}