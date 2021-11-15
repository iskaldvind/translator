package io.iskaldvind.translator.model.repository

interface Repository<T> {

    suspend fun getData(word: String): T
}
