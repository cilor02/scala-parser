package com.milo.scala.parser.node

object TestCuury
{
 def curry1(c:Char)(f:Int=>Int):Unit =
 {
   println("in method")
   println (f (c match
   {
     case 'a' => 1
     case 'b' => 2
     case 'c' => 3
     case 'd' => 4
     case _ => 100
   }))
 }
 
 def main(args:Array[String]):Unit =
 { 
    println("b4 method")

    curry1('c')
    {
      r => r
    }
    
    println("after method")

 }
  
}