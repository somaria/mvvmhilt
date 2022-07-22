package com.debduttapanda.androiddiwithhilt

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gamecrawl.mvvmhilt.Cryptocurrency
import com.gamecrawl.mvvmhilt.CryptocurrencyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val cryptocurrencyRepository: CryptocurrencyRepository
)
    : ViewModel() {

    private val _list = mutableStateListOf<Cryptocurrency>()
    val list: SnapshotStateList<Cryptocurrency> = _list

    init {
        loadCryptocurrency()
    }

    private fun loadCryptocurrency() {
        viewModelScope.launch {
            val fetchedList = cryptocurrencyRepository.getCryptoCurrency()
            Log.d("MainViewModel 75493", "Fetched list: $fetchedList")
            _list.addAll(fetchedList)
        }
    }
}