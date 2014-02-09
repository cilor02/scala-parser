package com.milo.scala.parser

import com.milo.scala.node.bool.BooleanNode

class BooleanTermNode (name:String)extends BooleanNode
{
   def value = BooleanNode.getNode(name).value
}