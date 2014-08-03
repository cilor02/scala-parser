package com.milo.scala.quiz.node

class LeafVarNode (name:String) extends Node {
def value = retrieve(name).value
}