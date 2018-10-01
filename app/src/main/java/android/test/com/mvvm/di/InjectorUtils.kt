package android.test.com.mvvm.di

import android.test.com.mvvm.data.FakeDatabase
import android.test.com.mvvm.data.QuoteRepository
import android.test.com.mvvm.ui.quotes.QuotesViewModelFactory

object InjectorUtils {
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}