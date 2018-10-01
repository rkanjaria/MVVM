package android.test.com.mvvm.data

class FakeDatabase private constructor() {

    val quoteDao = FakeQuoteDao()

    companion object {
        @Volatile
        private var instance: FakeDatabase? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: FakeDatabase().also { instance = it }
        }
    }
}