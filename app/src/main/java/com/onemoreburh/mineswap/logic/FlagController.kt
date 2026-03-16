package com.onemoreburh.mineswap.logic

import androidx.lifecycle.MutableLiveData

object FlagController {
    var flagsAmount: MutableLiveData<Int> = MutableLiveData(MAX_FLAGS);



    fun isAllowedToPlaceAFlag(): Boolean{
        return (flagsAmount.value!! > 0);
    }

    fun registerFlag(){
        flagsAmount.value = flagsAmount.value?.minus(1);
    }

    fun freeFromFlag(){
        flagsAmount.value = flagsAmount.value?.plus(1);
    }

    fun reset(){
        flagsAmount.value = MAX_FLAGS;
    }

}