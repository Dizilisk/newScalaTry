package playground

import scala.annotation.tailrec

object Trees extends App {

  abstract class BinaryTree[+T] {
    def value: T // значение узла

    def leftChild: BinaryTree[T] // левый потомок

    def rightChild: BinaryTree[T] // правый потомок

    def isEmpty: Boolean
    def isLeaf: Boolean

    def collectLeaves: List[BinaryTree[T]]
    def countLeaves: Int

    def nodesAtLevel(level: Int): List[BinaryTree[T]]

    def collectNodes(): List[T]
  }

  case class Node[+T](override val value: T,
                      override val leftChild: BinaryTree[T],
                      override val rightChild: BinaryTree[T]
                     ) extends BinaryTree[T] {
    override def isEmpty: Boolean = false

    override def isLeaf: Boolean = leftChild.isEmpty && rightChild.isEmpty

    override def collectLeaves: List[BinaryTree[T]] = {

      @tailrec
      def loop(toInspect: List[BinaryTree[T]], result: List[BinaryTree[T]]): List[BinaryTree[T]] = {

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

      if (isLeaf) List(this) else
        loop(List(this), List())

    }

    override def countLeaves: Int = collectLeaves.size

    override def nodesAtLevel(level: Int): List[BinaryTree[T]] = {

      @tailrec
      def loop2(toIns: List[(Int, BinaryTree[T])], res: List[BinaryTree[T]], check: Int): List[BinaryTree[T]] = {

        if (toIns.isEmpty) res
        else {
          val curr = toIns.head
          val chk = curr._1
          val lst = curr._2
          if (chk > check) List()
          else if (chk == check) loop2(toIns.tail, res :+ lst, check)
          else {
            val leftList: List[(Int, BinaryTree[T])] = if (lst.leftChild.isEmpty) List() else List((chk + 1, lst.leftChild))
            val rightList: List[(Int, BinaryTree[T])] = if (lst.rightChild.isEmpty) List() else List((chk + 1, lst.rightChild))
            loop2(toIns.tail ++ leftList ++ rightList, res, check)
          }
        }
      }
      loop2(List((0, this)), List(), level)
    }

    override def collectNodes(): List[T] = {

      val z = List(this.value)
      @tailrec
      def loop3(inspect: List[BinaryTree[T]], result: List[BinaryTree[T]]): List[T] = {

        if (inspect.isEmpty) result.map(_.value) ++ z
        else {
          val collect: BinaryTree[T] = inspect.head

          val left: BinaryTree[T] = collect.leftChild
          val right: BinaryTree[T] = collect.rightChild
          val l1 = if (left.isEmpty) List() else List(left)
          val r1 = if (right.isEmpty) List() else List(right)
          loop3(inspect.tail ++ l1 ++ r1, result ++ l1 ++ r1)
        }
      }
      loop3(List(this), List())
    }
  }

  case object TreeEnd extends BinaryTree[Nothing] {
    override def value: Nothing = throw new NoSuchElementException

    override def leftChild: BinaryTree[Nothing] = throw new NoSuchElementException

    override def rightChild: BinaryTree[Nothing] = throw new NoSuchElementException

    override def isEmpty: Boolean = true

    override def isLeaf: Boolean = false

    override def collectLeaves: List[BinaryTree[Nothing]] = List()

    override def countLeaves: Int = 0

    override def nodesAtLevel(level: Int) = List()

    override def collectNodes(): List[Nothing] = List()
  }

  val tree = {
    Node(1,
      Node(2,
        Node(4,
          TreeEnd,
          TreeEnd),
        Node(5,
          TreeEnd,
          Node(8,
            TreeEnd,
            TreeEnd))),
      Node(3,
        Node(6,
          TreeEnd,
          TreeEnd),
        Node(7,
          TreeEnd,
          TreeEnd)))
  }

  val tree1 = Node(1, TreeEnd, TreeEnd)
  println(tree1.collectLeaves.map(_.value))
  println(tree.collectLeaves.map(_.value).sorted)
  println(tree.nodesAtLevel(2).map(_.value).sorted)
  println(tree.collectNodes().sorted)

  class GrandParents
  class Parents extends GrandParents

  class Child extends Parents

//  class Family[+T]

//  val covariantFamily: Family[Parents] = new Family[Child]
//  val someFamily: Family[Parents] = new Family[GrandParents] // ошибка

//  class Family[-T]

//  val contravariantFamily: Family[Parents] = new Family[GrandParents]
//  val someFamily: Family[Parents] = new Family[Child] // ошибка
}
