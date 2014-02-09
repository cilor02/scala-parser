package com.milo.scala.parser

class BooleanParser (phrase:String) 
{

  var boolOps = List("and","or")
  
  
  
  def separateBrackets():Unit =
  {
    //boolOpsPhrase.indexOf(str)
     }
  def getEnclosingBrackets(op:String):Tuple2[Int,Int] =
  {
    findEnclosingBrackets(phrase,op)
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
 
      def findOddBrackets(s:String,op:String,f1: =>Int,f2: =>Boolean):Int =
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
        
      posOp
      
    }
    
    
    
}

object BooleanParser
{
  val prefix = "com.milo.BooleanPhrase"
  var nameCount = 0  
  var map = Map[String,String]()
  def nextName():String =
  {
    nameCount+=1
    prefix.+(nameCount)
  }
  
}