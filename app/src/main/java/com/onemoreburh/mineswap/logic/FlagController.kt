package com.onemoreburh.mineswap.logic

import androidx.lifecycle.MutableLiveData
import com.onemoreburh.mineswap.logic.GameController.bombCoverage
import com.onemoreburh.mineswap.logic.field.Square

object FlagController {
    var flagsAmount: MutableLiveData<Int> = MutableLiveData(MAX_FLAGS);



    fun isAllowedToPlaceAFlag(): Boolean{
        return (flagsAmount.value!! > 0);
    }

    fun registerFlag(square: Square){
        flagsAmount.value = flagsAmount.value?.minus(1);
        if (square.hasBomb()){
            bombCoverage += 1;
        }
    }

    fun freeFromFlag(square: Square){
        flagsAmount.value = flagsAmount.value?.plus(1);
        if (square.hasBomb()){
            bombCoverage -= 1;

        }
    }

    fun reset(){
        flagsAmount.value = MAX_FLAGS;
    }

}