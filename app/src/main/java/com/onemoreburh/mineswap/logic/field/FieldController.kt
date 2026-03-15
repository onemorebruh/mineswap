package com.onemoreburh.mineswap.logic.field

import com.onemoreburh.mineswap.logic.GameController.BOMB_AMOUNT
import kotlin.random.Random

object FieldController {

    var allSquares: List<List<Square>> = List(9){List(9){Square()}}

    private var isGameStarted: Boolean = false //for placing bombs check
    private var isGameLost: Boolean = false //to drop game


    //don't touch! in case where random bomb is placed on first turn square it prevets from errors
    private fun generateBombCoordinates(): List<Pair<Int, Int>> {

        //generates coordinates for 10 mines
        val coordinates = (0..8).flatMap { x ->
            (0..8).map { y -> x to y }
        }.shuffled(Random)

        return coordinates.take(BOMB_AMOUNT)
    }

    //x and y are coordinates where bomb must never appear
    private fun initBombs (x: Int, y: Int){
        //generate coordinates until there is no first square coordinates in it
        val bombCoordinatesArray = generateSequence { generateBombCoordinates() }
            .first { Pair(x, y) !in it }

        bombCoordinatesArray.forEach { pair ->
            allSquares[pair.second][pair.first].placeBomb();
        }
    }



    // public

    fun getBoolBombByCoordinates(x: Int, y: Int): Boolean{
        return allSquares[y][x].hasBomb();
    }

    //returns amount of bombs around the coordinates
    fun getNumberBombsByCoordinates(x: Int, y: Int): Int{

        var minesAround: Int = 0
        //bomb placement after user's first turn
        if (!isGameStarted){
            isGameStarted = true
            initBombs(x,y)
        }

        //if user have touched the mine
        if(getBoolBombByCoordinates(x,y)){
            isGameLost = true
        }

        //check for mines in neighbor squares
        for (i in (y-1)..(y+1)){
            for (j in (x-1)..(x+1)){
                if (getBoolBombByCoordinates(j,i)){
                    minesAround += 1
                }
            }
        }
        return minesAround

    }



    fun reset(){
        //reset properties
        isGameStarted = false;
        isGameLost = false;

        //enable each button in field
        for ( i in allSquares.indices ){
            for (j in allSquares[i].indices){
                allSquares[i][j].reset();
            }
        }

    }

}