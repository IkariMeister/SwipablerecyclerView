package com.test.kotlinspring.common

/**
 * Created by jcgarcia on 31/05/2017.
 */
class Bean2(var name:String = "nombre", var id:Long = 1) {
    fun print() = print("name: $name, id: $id")
}