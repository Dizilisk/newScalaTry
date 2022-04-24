package playground

import playground.Trees.BinaryTree

import scala.annotation.tailrec


object Testing {
  @tailrec
  def loop[T](toInspect: List[BinaryTree[T]] = List(), result: List[BinaryTree[T]] = List()): List[BinaryTree[T]] = {

    val current: BinaryTree[T] = toInspect.head
    val l: BinaryTree[T] = current.leftChild
    val r: BinaryTree[T] = current.rightChild

    if (current.isEmpty) result
    else if (l.isLeaf) loop(l.collectLeaves ++ r.collectLeaves, result)
    else if (r.isLeaf) loop(l.collectLeaves ++ r.collectLeaves, result)
    else loop(l.collectLeaves ++ r.collectLeaves, result)
  }

  loop()

}