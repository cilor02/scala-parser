package com.milo.scala.parser.node

class LeafVarNode (name:String) extends Node {
def value = retrieve(name).value
}