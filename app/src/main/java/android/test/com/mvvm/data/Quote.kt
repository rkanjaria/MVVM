package android.test.com.mvvm.data

data class Quote(
        val quoteText: String,
        val author: String) {

    override fun toString() = "$quoteText - $author"
}