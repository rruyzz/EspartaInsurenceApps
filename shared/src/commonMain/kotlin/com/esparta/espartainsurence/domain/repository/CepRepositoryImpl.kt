package com.esparta.espartainsurence.domain.repository

import com.esparta.espartainsurence.data.repository.CepRepository
import com.esparta.espartainsurence.data.api.CepDataSource
import kotlinx.coroutines.flow.Flow

class CepRepositoryImpl(private val dataSource: CepDataSource): CepRepository {
    override suspend fun getCep(cep: String): Flow<String> {
        return dataSource.getCep(cep)
    }
}