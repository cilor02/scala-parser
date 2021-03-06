package com.milo.scala.parser

import scala.collection.mutable.ListBuffer

class Tokeniser (phrase:String)
{

  val ops = List('*','+','-','*','/',')','(')
  var pos:Int = 0
  var tokens:ListBuffer[String] = ListBuffer[String]()
  def getNext = { }
  
  def possiblePower(s:String) =
  {
    if (s.length > 1 && s.tail.head == '*')
      {
      tokens+="**" 
        s.tail.tail
      }
    else
    {
      tokens+="*"
      s.tail
    }
  }
  
  def extractOp(str:String) :String =
  str match 
  {
    case x if str.head == '*' => tokenise(possiblePower(str))
    case x if ops.contains(str.head) =>tokens+=str.take(1); tokenise(str.tail)
  }
  
    def extractVar(str:String) :String =
  {
    val variable:String = str.tail.takeWhile(_.isLetterOrDigit)
    val wholeVar = str.head + variable
    tokens += wholeVar 
    tokenise(str.splitAt(wholeVar.length())._2)
  }
  
  def extractNumber(str:String) :String =
  {
    val wholeNum:String = str.takeWhile(_.isDigit)
    val rest = str.splitAt(wholeNum.length())._2
    if (!rest.isEmpty && rest.head == '.')
    {
      val decimal = rest.tail.takeWhile(_.isDigit)
      val decimalNumber = wholeNum + "." + decimal
      tokens+= decimalNumber
      tokenise(str.splitAt(decimalNumber.length())._2)
      
    }
    else
    {
      tokens+= wholeNum 
      tokenise(rest)
    }
    
  }
  
  def startTokenising
  {
    tokenise(phrase)
  }
  
  def tokenise(s:String):String =
  {
    if(!s.isEmpty())
    {
    var ch = s.head
    ch match 
    {
      case x if (ch.isDigit) => extractNumber(s)
      case x if (ch.isLetter) => extractVar(s)
      case x if (ops.contains(ch)) => extractOp(s)
      case _ => "error"
    }
    }
    else
    {
      "end"
    }
    
  }
  
}

object Tokeniser extends App{
  val t = new Tokeniser("a+b-(c/yu)**(3.4345)")
  t.startTokenising
  println(t.tokens)
  
}