package com.milo.scala.parser

object TestBooleanTreeBuilder extends App 
{

  val builder = new BooleanTreeBuilder
  builder.parse("a+b=c or (a+b>10 and b%2=c) or (a>77 and b=2-d) and a%b=0")
  
}