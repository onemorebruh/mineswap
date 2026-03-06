package com.onemoreburh.mineswap.logic

import android.util.Log
import kotlin.random.Random

object FieldController {

    private var isGameStarted: Boolean = false //for placing bombs check
    private var isGameLost: Boolean = false //to drop game

    private lateinit var bombsList: List<Pair<Int, Int>>//coordinates of bombs

    private fun generateBombCoordinates(): List<Pair<Int, Int>> {

        //generates coordinates for 10 mines
        val coordinates = (0..8).flatMap { x ->
            (0..8).map { y -> x to y }
        }.shuffled(Random)

        return coordinates.take(10)
    }

    private fun initBombsArray (x: Int, y: Int): List<Pair<Int, Int>> {
        //generate coordinates until there is no first square coordinates in it
        val bombCoordinatesArray = generateSequence { generateBombCoordinates() }
            .first { Pair(x, y) !in it }

        return bombCoordinatesArray
    }


    private fun getBoolBombByCoordinates(x: Int, y: Int): Boolean{
        if (Pair(x,y) in bombsList) {
            return true
        } else {
            return false
        }
    }

    // public
    fun getNumberBombsByCoordinates(x: Int, y: Int): Int{

        var minesAround: Int = 0
        //bomb placement after user's first turn
        if (!isGameStarted){
            isGameStarted = true
            bombsList = initBombsArray(x,y)
        }

        //if user have touched the mine
        if(getBoolBombByCoordinates(x,y)){
            isGameLost = true
            TODO("notify user the game is lost")
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

}