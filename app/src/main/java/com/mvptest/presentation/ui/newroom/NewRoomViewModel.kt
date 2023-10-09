package com.mvptest.presentation.ui.newroom

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvptest.domain.RoomsRepository
import com.mvptest.domain.models.HeaterType
import com.mvptest.domain.models.RoomDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewRoomViewModel @Inject constructor(private val roomsRepository: RoomsRepository) :
    ViewModel() {

    var state by mutableStateOf(NewRoomViewState())

    fun saveRoom(projectId: String) {
        viewModelScope.launch {
            roomsRepository.saveRoom(room = state.toRoomDetails(), projectId = projectId)
        }
    }

    fun clearState(){
        state = state.copy(
            id = null,
            title = null,
            systemNumber = null,
            roomVolume = null,
            roomDestination = null,
            startDate = null,
            airExchangePerformance = null,
            pressureLoss = null,
            airDuctArea = null,
            heaterType = null,
            heaterPerformance = null,
            isAirConditioner = null,
            airConditionerPerformance = null,
            deadLines = null,
            comment = null
        )
    }

    fun setTitle(title: String) {
        state = state.copy(title = title)
    }

    fun setSystemNumber(systemNumber: String) {
        state = state.copy(systemNumber = systemNumber)
    }

    fun setRoomVolume(roomVolume: Int) {
        state = state.copy(roomVolume = roomVolume)
    }

    fun setRoomDestination(roomDestination: String) {
        state = state.copy(roomDestination = roomDestination)
    }

    fun setStartDate(startDate: String) {
        state = state.copy(startDate = startDate)
    }

    fun setAirExchangePerformance(airExchangePerformance: Int) {
        state = state.copy(airExchangePerformance = airExchangePerformance)
    }

    fun setPressureLoss(pressureLoss: Int) {
        state = state.copy(pressureLoss = pressureLoss)
    }

    fun setAirDuctArea(airDuctArea: Int) {
        state = state.copy(airDuctArea = airDuctArea)
    }

    fun setHeaterType(heaterType: HeaterType) {
        state = state.copy(heaterType = heaterType)
    }

    fun setHeaterPerformance(heaterPerformance: Int) {
        state = state.copy(heaterPerformance = heaterPerformance)
    }

    fun setIsAirConditioner(isAirConditioner: Boolean) {
        state = state.copy(isAirConditioner = isAirConditioner)
    }

    fun setAirConditionerPerformance(airConditionerPerformance: Int) {
        state = state.copy(airConditionerPerformance = airConditionerPerformance)
    }

    fun setDeadLines(deadLines: String) {
        state = state.copy(deadLines = deadLines)
    }

    fun setComment(comment: String) {
        state = state.copy(comment = comment)
    }

}