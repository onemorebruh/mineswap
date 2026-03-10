package com.onemoreburh.mineswap.logic

object FlagController {
    var flagsAmount: Int = 10;



    fun isAllowedToPlaceAFlag(): Boolean{
        return (flagsAmount > 0);
    }


}