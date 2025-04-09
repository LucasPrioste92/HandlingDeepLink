package com.lucasprioste.handlingdeeplink.di

import com.lucasprioste.handlingdeeplink.presentation.core.navigation.DeepLinkHelper
import kotlinx.coroutines.Dispatchers
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

val helpersModule = module {
    single<DeepLinkHelper> { DeepLinkHelper(dispatcher = Dispatchers.Main) }
}

object InitDI {
    fun doInit(config: KoinAppDeclaration? = null) {
        startKoin {
            config?.invoke(this)
            modules(
                helpersModule,
            )
        }
    }
}

class DIHelper: KoinComponent {
    fun getDeepLinkHelper(): DeepLinkHelper = get()
}