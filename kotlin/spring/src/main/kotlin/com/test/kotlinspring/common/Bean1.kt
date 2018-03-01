package com.test.kotlinspring.common

import org.springframework.beans.factory.annotation.Autowired

/**
 * Created by jcgarcia on 31/05/2017.
 */

class Bean1 @Autowired constructor(var name:String, var bean2: Bean2) {
    fun print() {
        print(name)
        bean2.print()
    }
}