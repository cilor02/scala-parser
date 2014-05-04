package com.milo.scala.parser

import com.milo.scala.node.bool.BooleanNode
import scala.collection.immutable.Map

class BooleanTermNode (name:String, map: Map[String, BooleanNode])extends BooleanNode
{
   def value = map.get(name).get.value
}