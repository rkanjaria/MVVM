package android.test.com.mvvm.ui.quotes

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.test.com.mvvm.data.QuoteRepository
import android.test.com.mvvm.ui.QuotesViewModel


class QuotesViewModelFactory(private val quotesRepository: QuoteRepository) : ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return QuotesViewModel(quotesRepository) as T
    }
}