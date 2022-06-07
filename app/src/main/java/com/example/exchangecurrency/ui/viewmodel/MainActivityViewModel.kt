package com.example.exchangecurrency.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.exchangecurrency.data.local.BaseRepo
import com.example.exchangecurrency.data.local.BaseRepoImpl
import io.reactivex.rxjava3.disposables.CompositeDisposable

class MainActivityViewModel : MainActivityViewModelContract.ViewModel() {

    private val repo: BaseRepo = BaseRepoImpl()

    override val data: MutableLiveData<String> = MutableLiveData<String>()

    //request list of data
    override fun getData(){
        val repoData =repo.provideData()
        //put our data to LiveData
        data.postValue(repoData)
    }

    //для отписки
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}