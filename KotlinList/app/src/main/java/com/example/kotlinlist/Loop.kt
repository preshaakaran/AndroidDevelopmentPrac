package com.example.kotlinlist

class Loop {
    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            var num = 0
            val arrNo = ArrayList<Int>()
            arrNo.add(1)
            arrNo.add(2)
            arrNo.add(3)

            //For Loop
            for (i in 0..10 step 3) {
                println("Number is:${num++}")
            }

            for (i in 0 until 10) {
                println("Number is:${num++}")
            }

            for (i in 10 downTo 0 step 2) {
                println("Number is:${num++}")
            }

            for (i in arrNo) {
                println("Number is:$i")
            }

            //While Loop
            while (num < 20) {
                println("Number is:${num++}")
            }

            //Do While Loop
            do {
                println("Number is:${num++}")
            } while (num < 30)


            //Pair and Triple
            val(a,b)=Pair("A",2)
            val name=Pair("Raman",Pair("Ramanujan",Pair("A",1)))

            println("$a $b")
            println("${name.first}${name.second.second.first}")



            val(c,d,e)=Triple("Raman",true,3)
            val name1=Triple("Raman",true,Triple("Ramanujan",1,Triple("Ramanujan",false,1)))

            println("$c $d $e")
            println("${name1.first}${name1.third.third.first}")






        }
    }
}