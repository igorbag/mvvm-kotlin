package net.igor.mvvmposts.base

import android.arch.lifecycle.ViewModel
import net.igor.mvvmposts.injection.component.DaggerViewModelInjector
import net.igor.mvvmposts.injection.component.ViewModelInjector
import net.igor.mvvmposts.injection.module.NetworkModule
import net.igor.mvvmposts.ui.post.PostListViewModel
import net.igor.mvvmposts.ui.post.PostViewModel

abstract class BaseViewModel:ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)
            is PostViewModel -> injector.inject(this)
        }
    }
}