package com.onemoreburh.mineswap.logic.field


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onemoreburh.mineswap.logic.DEFAULT_SQUARE_IS_ENABLED
import com.onemoreburh.mineswap.logic.DEFAULT_SQUARE_IS_FLAG_FREE
import com.onemoreburh.mineswap.logic.DEFAULT_SQUARE_TEXT
import com.onemoreburh.mineswap.logic.FlagController.freeFromFlag
import com.onemoreburh.mineswap.logic.FlagController.isAllowedToPlaceAFlag
import com.onemoreburh.mineswap.logic.FlagController.registerFlag
import com.onemoreburh.mineswap.logic.GameController.gameLost
import com.onemoreburh.mineswap.logic.field.FieldController.clickAround

class Square: ViewModel {
    var isEnabled: MutableLiveData<Boolean> = MutableLiveData(DEFAULT_SQUARE_IS_ENABLED);
    var squareText: MutableLiveData<String> = MutableLiveData(DEFAULT_SQUARE_TEXT);
    var isFlagFree: MutableLiveData<Boolean> = MutableLiveData(DEFAULT_SQUARE_IS_FLAG_FREE);
    private var hasBomb: Boolean = false;

    var x: Int? = null;//have to be set before using.
    var y: Int? = null;// using out of range values would cause more issues

    constructor(x: Int?,y: Int?){
        isEnabled = MutableLiveData(DEFAULT_SQUARE_IS_ENABLED);
        squareText = MutableLiveData(DEFAULT_SQUARE_TEXT);
        isFlagFree = MutableLiveData(DEFAULT_SQUARE_IS_FLAG_FREE);
        hasBomb = false;
    }

    fun reset(){
        this.isEnabled.value = DEFAULT_SQUARE_IS_ENABLED;
        this.squareText.value = DEFAULT_SQUARE_TEXT;
        this.isFlagFree.value = DEFAULT_SQUARE_IS_FLAG_FREE;
        this.x = null;
        this.y = null;
        this.hasBomb = false;
    }

    fun placeBomb(){
        this.hasBomb = true;
    }

    fun hasBomb(): Boolean {
        return this.hasBomb
    }

    fun openSquare(){
        if(this.isFlagFree.value!!) {

            if (this.hasBomb()){
                gameLost();
            }

            //disable button
            this.isEnabled.value = false

            //display bombs around
            this.squareText.value = FieldController.getNumberBombsByCoordinates(this.x!!, this.y!!).toString()
            //gameControllerOnSquareClick(x, y)

            //click on squares around the square with no bombs around
            if (this.squareText.value == "0") {
                clickAround(this.x!!, this.y!!);
            }
        }

    }

    fun setCoordinates(x: Int, y: Int){
        this.x = x;
        this.y = y;
    }

    fun flagSquare(){
        if (this.isFlagFree.value == true){//if already have flag on it
            if (isAllowedToPlaceAFlag()){// if have no flags
                this.isFlagFree.value = false;
                registerFlag()

            } else {
                TODO("notify user, they have no flags")
            }
        } else {

            this.isFlagFree.value = true;
            freeFromFlag();
        }
    }

}