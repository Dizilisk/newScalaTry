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
  /*
  * Tuple(1, btree) target = 5
  *  lvl == 1
  * toIns: false
  *  curr = (1, node2)
  * chk = 1
  * lst = node2
  * if (1 == 2) false
  * else
  * aList = List(2 , node2.node3), (2 , node2.node4)
  *loop2(aList ++ toIns.tail, res, check)
  *
  * */
  @tailrec
  def loop2[T](toIns: List[(Int, BinaryTree[T])], res: List[BinaryTree[T]], check: Int): List[BinaryTree[T]] = {

    if (toIns.isEmpty) res
    else {
      val curr = toIns.head
      val chk = curr._1
      val lst = curr._2
      if (chk == check) loop2(toIns.tail, res :+ lst, check)
      else {
        val aList: List[(Int, BinaryTree[T])] = List((chk + 1, lst.leftChild), (chk + 1, lst.rightChild))
        loop2(aList ++ toIns.tail, res, check)
      }
    }
  }

  @tailrec
  def loop3[T](inspect: List[BinaryTree[T]], result: List[BinaryTree[T]]): List[T] = {

    if (inspect.isEmpty) result.map(_.value)
    else {
      val collect: BinaryTree[T] = inspect.head
      val left: BinaryTree[T] = collect.leftChild
      val right: BinaryTree[T] = collect.rightChild
      val l1 = if (left.isLeaf) List(left) else List()
      val r1 = if (right.isLeaf) List(right) else List()
      val l2 = if (left.isEmpty) List() else List(left)
      val r2 = if (right.isEmpty) List() else List(right)
      loop3(inspect.tail ++ l1 ++ r1, result ++ l2 ++ r2)
    }
  }
  loop3(List(), List())
}