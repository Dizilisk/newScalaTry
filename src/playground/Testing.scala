package playground

import playground.Trees.BinaryTree

import scala.annotation.tailrec


object Testing {
  @tailrec
  def loop[T](toInspect: List[BinaryTree[T]] = List(), result: List[BinaryTree[T]] = List()): List[BinaryTree[T]] = {

    if (toInspect.isEmpty) result
    else {
      val current: BinaryTree[T] = toInspect.head
      val l: BinaryTree[T] = current.leftChild
      val r: BinaryTree[T] = current.rightChild
      val x = if (l.isLeaf) List(l) else List()
      val y = if (r.isLeaf) List(r) else List()
      val lToInspect = if (l.isEmpty) List() else List(l)
      val rToInspect = if (r.isEmpty) List() else List(r)
      loop(toInspect.tail ++ lToInspect ++ rToInspect, result ++ x ++ y)
    }
  }
    loop(List(), List())

}