package com.mvptest.presentation.ui.room.roomdetails

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvptest.domain.RoomsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomDetailsViewModel @Inject constructor(private val roomsRepository: RoomsRepository) :
    ViewModel() {

    var state = mutableStateOf(RoomDetailsViewState())

    fun getRoomById(roomId: String) {
        viewModelScope.launch {
            val room = roomsRepository.getRoomById(roomId)
            Log.d("getRoomById", "room = $room")
            state.value = state.value.copy(roomDetails = room)
        }
    }

    fun deleteRoom(roomId: String){
        viewModelScope.launch {
            roomsRepository.deleteRoom(roomId)
        }
    }

    fun clearState() {
        state.value = state.value.copy(roomDetails = null)
    }

}