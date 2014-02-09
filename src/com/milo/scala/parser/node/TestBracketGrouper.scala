package com.milo.scala.parser.node

object TestBracketGrouper extends App
{

    val tree = new BracketGrouper(List("6","*","(","7","+","(","4","**","2",")",")","/","3.2"))
    println(tree.process)

  
}