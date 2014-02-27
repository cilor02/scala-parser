package com.milo.scala.parser.node

import scala.collection.mutable.ListBuffer

object TestFix
{
  var ops = List(" and "," or ")
  var list = ListBuffer[String]()

    def split2(s:String, ops:List[String]): Unit =
  {
      if (ops.isEmpty)
      {
        println(s)
        list.+=(s)
        return
      }
    
    val op = ops.head
    s match 
     {
       case x if (s.indexOf(op) < 0) => split2(s,ops.tail) 
       case x if(s.startsWith(op)) => val tuple = s.splitAt(op.length) ; println(tuple._1);list.+=(tuple._1); split2(tuple._2,ops)
       case _ => val i = s.indexOf(op); val tuple = s.splitAt(i) ; split2(tuple._1,ops.tail); split2(tuple._2,ops)
     }    
  }
  
  def main (args:Array[String]):Unit =
  {
  split2("qwewr or hsh and kytt or fjf and hglglh or fff",ops)
  println(list)
  }
}