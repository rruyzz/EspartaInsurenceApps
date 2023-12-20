package com.esparta.espartainsurence.domain.usecase

import com.esparta.espartainsurence.data.repository.CepRepository
import kotlinx.coroutines.flow.Flow

class CepUseCase(private val repository: CepRepository) {
    suspend operator fun invoke(cep: String): Flow<String> {
        return repository.getCep(cep = cep)
    }
}