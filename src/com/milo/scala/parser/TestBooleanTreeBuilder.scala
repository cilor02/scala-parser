package com.milo.scala.parser

object TestBooleanTreeBuilder  
{

  
  def main(args:Array[String]):Unit =
  {
    val builder = new BooleanTreeBuilder
    //builder.parse("a+b=c or (a+b>10 and b%2=c) or (a>77 and b=2-d) and a%b=0")
    //builder.parse("((a+b=c  or  a-b>10)  and   b%2=c)  or  a>7 and  (b=2-d  and  a%b=0)")
    //builder.parse("a+b=c  or  ((a-b>10  and   b%2=c)  or  a>7 and  b=2-d)  and  a%b=0");
    
    var s = "a+b=c  or(a-b>10  and(b%2=c  or  (3 = y or a>7 and  b=2-d or 4<m)))and  a%b=0"
      
    builder.parse(s);
    println(builder.map)
    
    builder.buildNodes(List("a+b=c","or","6>y*7","and","w*w = d"), List("and","or"))
    println(builder.nodeMap)
  }
  
}