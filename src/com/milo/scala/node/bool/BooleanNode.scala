package com.milo.scala.node.bool

trait BooleanNode {
  
 def value (): Boolean
 
 def addToMap(s:String) 
 {
    BooleanNode.map.+(s->this)
 }
 
}
object BooleanNode 
{
  var map = Map[String,BooleanNode]()
  val prefix = "com.milo.BooleanPhrase"
  var nameCount = 0
  
  

}