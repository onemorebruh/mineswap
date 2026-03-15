package com.onemoreburh.mineswap.logic

object FlagController {
    var flagsAmount: Int = MAX_FLAGS;



    fun isAllowedToPlaceAFlag(): Boolean{
        return (flagsAmount > 0);
    }

    fun reset(){
        flagsAmount = MAX_FLAGS;
    }

}