package io.iskaldvind.repository

interface DataSource<T> {

    suspend fun getData(word: String): T
}
