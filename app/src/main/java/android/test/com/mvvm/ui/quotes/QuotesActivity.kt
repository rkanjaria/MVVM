package android.test.com.mvvm.ui.quotes

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.test.com.mvvm.R
import android.test.com.mvvm.data.Quote
import android.test.com.mvvm.di.InjectorUtils
import android.test.com.mvvm.ui.QuotesViewModel
import kotlinx.android.synthetic.main.activity_quotes.*

class QuotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initUi()
    }

    private fun initUi() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory).get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes?.forEach { quote -> stringBuilder.append("$quote\n\n") }
            displayQuotes.text = stringBuilder.toString()
        })

        addQuote.setOnClickListener {
            val quote = Quote(enterQuote.text.toString(), enterAuthor.text.toString())
            viewModel.addQuotes(quote)
            enterQuote.setText("")
            enterAuthor.setText("")
        }
    }
}
