package com.onemoreburh.mineswap.logic.bottomBar

import com.onemoreburh.mineswap.logic.field.FieldController
import com.onemoreburh.mineswap.logic.FlagController
import com.onemoreburh.mineswap.logic.GameController

object ResetController {
    fun resetGame(){
        GameController.reset();
        FlagController.reset();
        FieldController.reset();
    }
}