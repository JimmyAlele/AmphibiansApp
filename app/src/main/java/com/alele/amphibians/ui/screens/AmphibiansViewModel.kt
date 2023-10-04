package com.alele.amphibians.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.alele.amphibians.AmphibiansApplication
import com.alele.amphibians.data.AmphibiansRepository
import com.alele.amphibians.model.Amphibians
import kotlinx.coroutines.launch
import java.io.IOException

/** mutable state for the Home screen */
sealed interface AmphibiansUiState {
    data class Success(val amphibians: List<Amphibians>): AmphibiansUiState
    object Error: AmphibiansUiState
    object Loading: AmphibiansUiState
}


class AmphibiansViewModel (private val amphibiansRepository: AmphibiansRepository): ViewModel() {
    /** the mutable state that stores the status of the most recent request  */
    var amphibiansUiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
    /**
     * Call getAmphibiansData() on init so we can display status immediately.
     */
    init {
        getAmphibiansData()
    }

    /**
     * get amphibians data from the amphibiansApi retrofit service and updates the amphibiansUiState
     */
    fun getAmphibiansData() {
        viewModelScope.launch{
            amphibiansUiState = AmphibiansUiState.Loading
            amphibiansUiState = try{
                AmphibiansUiState.Success(amphibiansRepository.getAmphibiansData())
            } catch (e: IOException) {
                AmphibiansUiState.Error
            }
        }
    }
    /**
     * Factory for [AmphibiansViewModel] that takes [AmphibiansRepository] as a dependency
     */
    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AmphibiansApplication)
                val amphibiansRepository = application.container.amphibiansRepository
                AmphibiansViewModel(amphibiansRepository = amphibiansRepository)
            }
        }
    }
}