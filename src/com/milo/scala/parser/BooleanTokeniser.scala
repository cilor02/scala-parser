package com.milo.scala.parser

class BooleanTokeniser (phrase:String)
{
  
  def tokenise2(s:String)
  {
    var wString1 = new String()
/*
    wString1 = s.takeWhile(checkAndOr)
    var remString:String = s.dropRight(wString1.length())
    var wOp = new String()
    if(wString1.last = ')' || wString1.last = ' ')
    {
      
      remString head match
      {
        
        case 'a' => 
        case 'o' =>
        case _   => wString1.
        
       }
       
    }
    */

  }
  
  def tokenise(s:String):List[String] =
  {
   
    val iter = s.iterator
    while(iter.hasNext)
    {
      iter.next match
      {
//        case ' ' => checkOr
//        case ')'|'O' => checkOr()
//        case 'a'|'A' => checkAnd()
        case _ =>
      }
      
    }
         List[String]()
 
        
         
  }
  
  def checkOr (it:Iterator[String]) =
  {
  //  it.next match
  }
  
  def checkAndOr (c:Char):Boolean =
  {
    
    c match 
    {
      case 'o'|'a' => true
      case _ => false
    }
    
  }

}