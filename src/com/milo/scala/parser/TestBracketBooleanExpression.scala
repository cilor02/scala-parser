package com.milo.scala.parser

object TestBracketBooleanExpression extends App
{
 
  val phrase = "2-7 < 14 or (a+b+(c-d) = 4 and ((d*r) - 4 = b or (6*h <7)))"
  val parser: BooleanParser  = new BooleanParser(phrase)
  println(parser.getEnclosingBrackets("and"))
  
}