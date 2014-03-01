package com.milo.scala.parser

object TestBracketBooleanExpression extends App
{
      val builder = new BooleanTreeBuilder
    builder.parse("a+b=c or (a+b>10 and b%2=c) or (a>77 and b=2-d) and a%b=0")
 
  val phrase = "2-7 < 14 or (a+b+(c-d) = 4 and ((d*r) - 4 = b or (6*h <7)))"
  val parser: BooleanParser  = new BooleanParser(phrase)
  println(parser.getEnclosingBrackets("and"))
  
}