package com.example.kotlinconditions

class MyClass {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var num = 11
            var msg = ""
            msg = if(num>100) "Greater than 100" else "Less than 100"
            println(msg)
//            if(num>100){
//                println("Greater than 100")
//            }
//            else{
//                println("Less than 100")
//            }

            if(num>100){
                println("Greater than 100")
            }
            else if(num>50){
                println("Between 50 and 100")
            }
            else if(num>0){
                println("Between 0 and 50")
            }
            else{
                println("Less than 0")
            }

            when(num){
                in 1..100 -> println("Between 1 and 100")
                in 101..200 -> println("Between 101 and 200")
                else -> println("Greater than 200")
            }

            when(num){
                1 -> {println("One")}
                2 -> println("Two")
                3 -> println("Three")
                else -> println("Greater than 3")
            }

            when{
                num>100 -> println("Greater than 100")
                num>50 -> println("Between 50 and 100")
                num>0 -> println("Between 0 and 50")
                else -> println("Less than 0")
            }


            println("Hello World!")
        }
    }
}