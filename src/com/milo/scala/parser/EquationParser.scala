package com.milo.scala.parser

class EquationParser (equation:String)
{
  val relOps = List("=",">","<","%","factorof","multipleof")
  
 relOps.foreach(split(_))
 
 def split(op:String):Tuple2[String,String]=
  {
    val eqn1 = equation.take(equation.indexOf(op))
    val eqn2 = equation.drop(equation.indexOf(op) + op.length())
    (eqn1,eqn2)
  }

}