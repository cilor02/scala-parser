package com.milo.scala.parser


import scala.collection.mutable.Map

class BooleanTreeBuilder 
{
  
  val map:Map[String, String] = Map[String, String ]()
    
  var boolOps = List("and","or")
  val prefix = "com.milo.BooleanPhrase"
  var nameCount = 0
  
  def nextName():String =
  {
    nameCount+=1
    prefix.+(nameCount)
  }
  
  def parse (s:String):String =
  {
    var workString = spaceOutBooleanOperators(s)
    for (op <- boolOps)
    {
     var startingFrom = 0
     while (startingFrom > -1)
     {
     {
      var opIndex = workString.indexOf( op, startingFrom)
      val bracketrange = findEnclosingBrackets(workString,op,startingFrom)
      val bracket1 = bracketrange._1
      val bracket2 = bracketrange._2
      
      if(bracketrange._1 > -1  && bracketrange._2 > -1)
      {        
        val name = nextName
        val subPhrase = workString.substring(bracket1 + 1, bracket2)
        println(name + " : " +subPhrase)
        map.+=(name -> parse(subPhrase))
        workString = workString.take(bracket1 ) + name + workString.drop(bracket2 + 1)        
      }
      startingFrom = workString.indexOf( op, opIndex + op.length());     
    }
    }
   }
    println("no bracket phrase : "+ workString)
    workString
  }
  

  
  def findEnclosingBrackets(s:String,op:String,from:Int):Tuple2[Int,Int] =
  {
    (findOddLeftBracket(s, op,from),findOddRightBracket(s, op,from))
  }
  
  def findOddRightBracket(s:String,op:String,from:Int):Int =
    {
      var posOp = s.indexOf(op,from)
      var oddRightBracketCount = 0
      
      while(oddRightBracketCount<1 && posOp < s.length() - 1)
      {
        posOp += 1
        s.charAt(posOp) match 
        {
        
          case ')' => oddRightBracketCount.+=(1)
          case '(' => oddRightBracketCount.-=(1)

          case _ => 
          
        }
      }
      if(oddRightBracketCount !=1)-1 else posOp
      
    }
  
    def findOddLeftBracket(s:String,op:String,from:Int):Int =
    {
      var posOp = s.indexOf(op,from)
      var oddLeftBracketCount = 0
      
      while(oddLeftBracketCount<1 && posOp >0)   
      {
        posOp -= 1
        s.charAt(posOp) match 
        {
        
          case ')' => oddLeftBracketCount.-=(1)
          case '(' => oddLeftBracketCount.+=(1)

          case _ => 
          
        }
      }    

      if(oddLeftBracketCount !=1)-1 else posOp
      
    }
  
  
    
def spaceOutBooleanOperators (s:String):String =
{
      
       // val s:String = new String("ftc and(hxjc)or kck or(gvk)and(vvhl)and ablbl org) andblglg or andlglbglb ")
 // println(tokens)
 def replaceOp (op:String):String =
 {
    op.replaceAllLiterally(")", ") ").replaceAllLiterally("(", " (")   
 }
  val leftSide  = List( ' ', ')')
  val rightSide = List( ' ', '(')
  val ops = List("or","and")
  var nwStr = s
  for( 
      l <- leftSide;
      r <- rightSide;
      op <- ops
  )
  {
    val inSituOp = ((new String()+l)+op)+r
        
    nwStr = nwStr.replaceAllLiterally(inSituOp, replaceOp(inSituOp))
    //println(nwStr)
  }
  
 //var nwStr = s.replaceAllLiterally(op, replaceOp(op))()
 
 
      nwStr
    }
    
    
    
    
    
}