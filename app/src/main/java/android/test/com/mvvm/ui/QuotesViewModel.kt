package android.test.com.mvvm.ui

import android.arch.lifecycle.ViewModel
import android.test.com.mvvm.data.Quote
import android.test.com.mvvm.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository) : ViewModel() {
    fun getQuotes() = quoteRepository.getQuotes()
    fun addQuotes(quote: Quote) = quoteRepository.addQuote(quote)
}