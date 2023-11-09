package com.mvptest.presentation.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mvptest.data.SharedPrefStorage
import com.mvptest.domain.ProjectsRepository
import com.mvptest.domain.RoomsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val sharedPrefStorage: SharedPrefStorage,
    private val projectsRepository: ProjectsRepository,
    private val roomsRepository: RoomsRepository
): ViewModel() {

    fun getToken(): String?{
        return sharedPrefStorage.token
    }

    fun fetchUserProjects(){
        viewModelScope.launch {

            try {
                val userId = sharedPrefStorage.userId

                if (userId != null) {
                    projectsRepository.fetchProjects(userId)
                    roomsRepository.fetchRooms(userId)
                }
            }catch (e: Exception) {
                Log.d("fetching", "e = $e")
            }

        }
    }
}