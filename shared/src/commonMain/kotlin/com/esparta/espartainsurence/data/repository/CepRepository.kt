package com.esparta.espartainsurence.data.repository

import kotlinx.coroutines.flow.Flow


interface CepRepository {
    suspend fun getCep(cep: String) : Flow<String>
}