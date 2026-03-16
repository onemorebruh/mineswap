package com.onemoreburh.mineswap.logic

import com.onemoreburh.mineswap.logic.field.FieldController.getBoolBombByCoordinates

object GameController {
    const val BOMB_AMOUNT: Int = MAX_BOMBS;
    var squaresLeft: Int = SAFE_SQUARES; //squares on the field without bombs
    //var bombCoverage: Int = 0; //if 10 you win


    fun gameControllerOnSquareClick(x: Int, y: Int){
        squaresLeft -= 1;
        if (getBoolBombByCoordinates(x,y)) {
            TODO("notify user the game is lost")
        }
        ifWin()
    }

    private fun ifWin(){

        //check if lose
        if (squaresLeft != 0 ){
        }
//        if (bombCoverage != BOMB_AMOUNT){
//        }

        //win otherwise
        //win dialog
    }

    fun gameControllerOnBombClick(){
        //alert you lost
    }

    fun gameLost(){
        TODO("")
    }

    fun reset(){
        squaresLeft = SAFE_SQUARES;
    }
}