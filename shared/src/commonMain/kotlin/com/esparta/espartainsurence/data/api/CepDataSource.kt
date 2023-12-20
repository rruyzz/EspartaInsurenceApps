package com.esparta.espartainsurence.data.api

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CepDataSource {

    suspend fun getCep(cep: String): Flow<String> {
        delay(3000)
        return flow {
            emit("Meu endereco")
        }
    }
}