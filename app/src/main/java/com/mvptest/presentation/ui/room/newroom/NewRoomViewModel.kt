package com.mvptest.presentation.ui.room.newroom

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvptest.data.SharedPrefStorage
import com.mvptest.domain.RoomsRepository
import com.mvptest.domain.models.HeaterType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.UUID
import javax.inject.Inject

@HiltViewModel
class NewRoomViewModel @Inject constructor(private val roomsRepository: RoomsRepository, private val sharedPrefStorage: SharedPrefStorage) :
    ViewModel() {

    var state by mutableStateOf(NewRoomViewState())

    private var roomId = ""

    private val userId = sharedPrefStorage.userId

    fun saveRoom(projectId: String) {
        viewModelScope.launch {
            if(roomId == ""){
                roomId = UUID.randomUUID().toString()
            }
            roomsRepository.saveRoom(room = state.toRoomDetails(roomId), projectId = projectId, userId = userId!!)
        }
    }

    fun initEditMode(id: String){
        viewModelScope.launch{
            roomId = id
            val room = roomsRepository.getRoomById(roomId)
            if(room != null){
                state = room.toRoomViewState(roomId)
            }
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
        roomId = ""
    }

    fun setTitle(title: String) {
        state = state.copy(title = title)
    }

    fun setSystemNumber(systemNumber: String) {
        state = state.copy(systemNumber = systemNumber)
    }

    fun setRoomVolume(roomVolume: String) {
        state = state.copy(roomVolume = roomVolume)
    }

    fun setRoomDestination(roomDestination: String) {
        state = state.copy(roomDestination = roomDestination)
    }

    fun setStartDate(startDate: String) {
        state = state.copy(startDate = startDate)
    }

    fun setAirExchangePerformance(airExchangePerformance: String) {
        state = state.copy(airExchangePerformance = airExchangePerformance)
    }

    fun setPressureLoss(pressureLoss: String) {
        state = state.copy(pressureLoss = pressureLoss)
    }

    fun setAirDuctArea(airDuctArea: String) {
        state = state.copy(airDuctArea = airDuctArea)
    }

    fun setHeaterType(heaterType: HeaterType) {
        state = state.copy(heaterType = heaterType)
    }

    fun setHeaterPerformance(heaterPerformance: String) {
        state = state.copy(heaterPerformance = heaterPerformance)
    }

    fun setIsAirConditioner(isAirConditioner: Boolean) {
        state = state.copy(isAirConditioner = isAirConditioner)
    }

    fun setAirConditionerPerformance(airConditionerPerformance: String) {
        state = state.copy(airConditionerPerformance = airConditionerPerformance)
    }

    fun setDeadLines(deadLines: String) {
        state = state.copy(deadLines = deadLines)
    }

    fun setComment(comment: String) {
        state = state.copy(comment = comment)
    }

}