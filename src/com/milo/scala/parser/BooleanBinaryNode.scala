package com.milo.scala.parser

import com.milo.scala.node.bool.BooleanNode
import scala.collection.immutable.Map

class BooleanBinaryNode (op:String, left:BooleanNode,right:BooleanNode)extends BooleanNode
{
   
   def value = 
   {
     op match
     {
     
       case "or"  => left.value || right.value
       case "and" => left.value && right.value
       
     }
   }
   
}