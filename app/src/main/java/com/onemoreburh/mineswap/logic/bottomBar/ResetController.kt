package com.onemoreburh.mineswap.logic.bottomBar

import com.onemoreburh.mineswap.logic.FieldController
import com.onemoreburh.mineswap.logic.FlagController
import com.onemoreburh.mineswap.logic.GameController
import com.onemoreburh.mineswap.logic.MAX_FLAGS

object ResetController {
    fun resetGame(){
        GameController.reset();
        FlagController.reset();
        FieldController.reset();
    }
}