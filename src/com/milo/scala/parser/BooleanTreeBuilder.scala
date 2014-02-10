package com.milo.scala.parser

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
    var workString = s

    for (op <- boolOps)
    {
     while (workString.indexOf( op) > -1)
     {
      val bracketrange = findEnclosingBrackets(workString,op)
      val bracket1 = bracketrange._1
      val bracket2 = bracketrange._2
      
      if(bracketrange._1 > -1  && bracketrange._2 > -1)
      {
        val leftPhrase = workString.substring(bracket1 + 1, workString.indexOf(op))
        val rightPhrase = workString.substring(workString.indexOf(op) + op.length(),bracket2 - 1)
        val name = nextName
        map.+(name -> parse(workString.substring(bracket1, bracket2)))
        workString = workString.take(bracket1 + 1) + name + workString.drop(bracket2 + 1)
        
      }
      
    }
   }
    println(workString)
    workString
  }
  

  
  def findEnclosingBrackets(s:String,op:String):Tuple2[Int,Int] =
  {
    (findOddLeftBracket(s, op),findOddRightBracket(s, op))
  }
  
  def findOddRightBracket(s:String,op:String):Int =
    {
      var posOp = s.indexOf(op)
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
  
    def findOddLeftBracket(s:String,op:String):Int =
    {
      var posOp = s.indexOf(op)
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
  
  
}