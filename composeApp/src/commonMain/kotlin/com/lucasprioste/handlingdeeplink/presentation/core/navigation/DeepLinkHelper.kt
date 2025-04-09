package com.lucasprioste.handlingdeeplink.presentation.core.navigation

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class DeepLinkHelper(
    dispatcher: CoroutineDispatcher,
) {
    private val scope = CoroutineScope(dispatcher)
    private val _navigationEvents = MutableSharedFlow<String>(replay = 1)
    val navigationEvents: Flow<String> = _navigationEvents.asSharedFlow()

    fun handle(url: String) {
        scope.launch {
            _navigationEvents.emit(url)
        }
    }
}