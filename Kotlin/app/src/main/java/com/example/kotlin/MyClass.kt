package com.example.kotlin

public class MyClass:ClassA(),ClassB{ //colon means Inheritance
    companion object {
        @JvmStatic  //public static void main(String[] args)
        fun main(args: Array<String>) {
            var a = 11
            var b = "Hello"
            b = "World!"
            println("Hello World! $a")
            println("The sum is ${add(5,6)}")
            println("The sum is ${add(5,6,7)}")
        }

        fun add(a: Int, b: Int):Any{ //colon means return type
            return a+b

        }

        fun add(a: Int, b: Int,c: Int):Int{ //colon means return type
            return a+b+c

        }
    }


}

