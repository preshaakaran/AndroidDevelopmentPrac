package com.example.kotlinlist

class MyClass {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            //List
            val bList = listOf("a", "b", "c")
            val cList = listOf("d",1, "e",2.0, "f",true, listOf(1,2,3))
            val dList = mutableListOf<Any>("a", "b", "c")
            dList.add(0,"d") //Update
            dList.add("d")
            dList.add(1)
            dList.add("e")
            dList.add(true)
            val daList = mutableListOf<Any>("d","e",false)
            dList.addAll(daList)

            println(cList)
            println(dList)
            println(bList)

            //Set(

            val cSet = setOf("d",1, "e",2.0, "f",true, setOf(1,2,3))
            val dSet = mutableSetOf<Any>("a", "b", "c",false)
            dSet.add(true)

            println(cSet)
            println(dSet)

            //Map
            val bMap = mapOf("d" to 1, "e" to 2.0, "f" to "Rahul",true to "Rahul")
            val cMap = mapOf<String, Any>("d" to 1, "e" to 2.0, "f" to true)
            val dMap = mutableMapOf<String, Any>("d" to 1, "e" to 2.0, "f" to true)
            dMap["f"] = false
            dMap["g"] = 3

            val eMap = mutableMapOf<Any, Any>()
            val eAMap = mapOf("d" to 1, "e" to 2.0, "f" to true)
            eMap.putAll(eAMap)


            println(cMap)
            println(dMap)
            println(bMap)
            println(eMap)

            //Array List
            val bArray = ArrayList<String>()
            bArray.add("a")
            bArray.add("b")
            bArray.add("c")
            bArray.set(0,"d")
            bArray[1]="Raman"
            bArray.remove("c")
            bArray.removeAt(0)
            val cArray = arrayOf("d",1, "e",2.0, "f",true)
            println(bArray.toString())



        }



    }
}