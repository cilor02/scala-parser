package com.milo.scala.parser

object TestBooleanTreeBuilder  
{

  
  def main(args:Array[String]):Unit =
  {
    val builder = new BooleanTreeBuilder
    //builder.parse("a+b=c or (a+b>10 and b%2=c) or (a>77 and b=2-d) and a%b=0")
    //builder.parse("((a+b=c  or  a-b>10)  and   b%2=c)  or  a>7 and  (b=2-d  and  a%b=0)")
    //builder.parse("a+b=c  or  ((a-b>10  and   b%2=c)  or  a>7 and  b=2-d)  and  a%b=0");
    
    var s = "a+b=c  or(a-b>10  and(b%2=c  or  (a>7 and  b=2-d)))and  a%b=0"
      
    builder.parse(s);
    println(builder.map)
    
  }
  
}