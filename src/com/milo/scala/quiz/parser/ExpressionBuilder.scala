package com.milo.scala.parser.node

import com.milo.scala.parser.ExpressionTreeBuilder

class ExpressionBuilder (exp:List[String])
{
  def processBrackets(expression:List[String]):List[String] =
  {
        val endBracket = expression.indexOf(")")
       if( endBracket > -1) 
       {
    val startBracket = expression.lastIndexOf("(", endBracket)
    val expTree = new ExpressionTreeBuilder(expression.slice(startBracket + 1,endBracket))
    expTree.process
 processBrackets ((expression splitAt (startBracket)_1):::expTree.newList:::((expression splitAt (startBracket)_2).drop(endBracket - (startBracket -1)))) 
       }
       else
         expression
  }
  def process():List[String] = 
  {    
     processBrackets(exp)
  }  
  
  
}