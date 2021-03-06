package com.example.fintech1_android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fintech1_android.Transaction.TransactionItem

class FintechViewModel : ViewModel() {

    private var _transactionItems = MutableLiveData(listOf<TransactionItem>())
    val transactonItems: LiveData<List<TransactionItem>> = _transactionItems

    fun addTransactionItem(item: TransactionItem) {
        _transactionItems.value = _transactionItems.value!! + listOf(item)
    }

    fun removeTransactionItem(item: TransactionItem) {
        _transactionItems.value = _transactionItems.value!!.toMutableList().also {
            it.remove(item)
        }
    }
}