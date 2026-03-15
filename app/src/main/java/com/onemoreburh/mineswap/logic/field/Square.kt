package com.onemoreburh.mineswap.logic.field


import com.onemoreburh.mineswap.logic.DEFAULT_SQUARE_IS_ENABLED
import com.onemoreburh.mineswap.logic.DEFAULT_SQUARE_IS_FLAG_FREE
import com.onemoreburh.mineswap.logic.DEFAULT_SQUARE_TEXT

class Square {
    var isEnabled: Boolean = DEFAULT_SQUARE_IS_ENABLED;
    var squareText: String = DEFAULT_SQUARE_TEXT;
    var isFlagFree: Boolean = DEFAULT_SQUARE_IS_FLAG_FREE;
    private var hasBomb: Boolean = false;

    var x: Int? = null;//have to be set before using.
    var y: Int? = null;// using out of range values would cause more issues

    fun reset(){
        isEnabled = DEFAULT_SQUARE_IS_ENABLED;
        squareText = DEFAULT_SQUARE_TEXT;
        isFlagFree = DEFAULT_SQUARE_IS_FLAG_FREE;
        x = null;
        y = null;
        hasBomb = false;
    }

    fun placeBomb(){
        this.hasBomb = true;
    }

    fun hasBomb(): Boolean {
        return this.hasBomb
    }

    fun openSquare(){
        if(this.isFlagFree) {

            //disable button
            this.isEnabled = false

            //display bombs around
            this.squareText = FieldController.getNumberBombsByCoordinates(this.x!!, this.y!!).toString()
            //gameControllerOnSquareClick(x, y)

            //TODO click on squares around the square with no bombs around
            if (this.squareText == "0") {
                //open squares around
                //clickAround(x, y); TODO QOL
            }
        }

    }

    fun setCoordinates(x: Int, y: Int){
        this.x = x;
        this.y = y;
    }

    fun flagSquare(){
        this.isFlagFree = !this.isFlagFree;
    }

}