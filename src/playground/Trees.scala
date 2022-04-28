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
      def loopLevel(levelInspect: Int, lvl: List[BinaryTree[T]]): List[BinaryTree[T]] = {
        if (levelInspect < 0) List()
        else if (levelInspect == 0) List(lvl.head)
        else {
          val curr = lvl.head
          val lc = curr.leftChild
          val rc = curr.rightChild

        }
      }

      loopLevel(level, List(this))
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
  }

  val tree = {
    Node(10,
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
  println(tree.nodesAtLevel(0).map(_.value).sorted)

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
