package com.milo.scala.quiz.test

import com.milo.scala.quiz.parser.RuleBuilder

object TestRuleBuilder  
{

  
  def main(args:Array[String]):Unit =
  {
    val builder = new RuleBuilder
    //builder.parse("a+b=c or (a+b>10 and b%2=c) or (a>77 and b=2-d) and a%b=0")
    //builder.parse("((a+b=c  or  a-b>10)  and   b%2=c)  or  a>7 and  (b=2-d  and  a%b=0)")
    //builder.parse("a+b=c  or  ((a-b>10  and   b%2=c)  or  a>7 and  b=2-d)  and  a%b=0");
    
    var s = "a+b=c  or(a-b>10  and(b%2=c  or  (3 = y or a>7 and  b=2-d or 4<m)))and  a%b=0"
    //println(builder.parse(s))
    builder.buildNodes(builder.parse(s), List("and","or"));
    //println(builder.map)
    
    //builder.buildNodes(List("a+b=c","or","6>y*7","and","w*w = d"), List("and","or"))
    //println(builder.nodeMap)
  }
  
}