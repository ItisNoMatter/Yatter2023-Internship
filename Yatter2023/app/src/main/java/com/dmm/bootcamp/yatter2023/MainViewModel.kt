package com.dmm.bootcamp.yatter2023

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmm.bootcamp.yatter2023.di.domain.service.CheckLoginService
import com.dmm.bootcamp.yatter2023.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val checkLoginService: CheckLoginService,
) : ViewModel() {
    private val _navigateToLogin: SingleLiveEvent<Unit> = SingleLiveEvent()
    val navigateToLogin: LiveData<Unit> = _navigateToLogin

    private val _navigateToPublicTimeline: SingleLiveEvent<Unit> = SingleLiveEvent()
    val navigateToPublicTimeline: LiveData<Unit> = _navigateToPublicTimeline
    fun onCreate() {

        viewModelScope.launch {
            if (checkLoginService.execute()) {
                _navigateToPublicTimeline.value = Unit
            } else {
                _navigateToLogin.value = Unit
            }
        }
    }
}