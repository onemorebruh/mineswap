package com.onemoreburh.mineswap.logic

import androidx.lifecycle.MutableLiveData
import com.onemoreburh.mineswap.logic.field.FieldController.getBoolBombByCoordinates

object GameController {
    const val BOMB_AMOUNT: Int = MAX_BOMBS;
    var squaresLeft: Int = SAFE_SQUARES; //squares on the field without bombs
    var bombCoverage: Int = 0; //if 10 you win
    var isGameWon: MutableLiveData<Boolean?> = MutableLiveData(null);


    fun ifWin(){

        //all bombs are marked with flags
        if (bombCoverage == BOMB_AMOUNT){
            gameWin();
        }

        if (squaresLeft == 0){
            gameWin();
        }
    }


    fun gameLost(){
        isGameWon.value = false;
    }

    fun gameWin(){
        isGameWon.value = true
    }

    fun reset(){
        squaresLeft = SAFE_SQUARES;
        bombCoverage = 0;
        isGameWon.value = null;
    }
}