package playground

import com.sun.source.tree.BinaryTree

import scala.annotation.tailrec

object Trees extends App {

  abstract class BinaryTree[+T] {
    def value: T // значение узла

    def leftChild: BinaryTree[T] // левый потомок

    def rightChild: BinaryTree[T] // правый потомок

    def isEmpty: Boolean
    def isLeaf: Boolean

    def collectLeaves: List[BinaryTree[T]]
  }

  case class Node[+T](override val value: T,
                      override val leftChild: BinaryTree[T],
                      override val rightChild: BinaryTree[T]
                     ) extends BinaryTree[T] {
    override def isEmpty: Boolean = false

    override def isLeaf: Boolean = leftChild.isEmpty && rightChild.isEmpty

    override def collectLeaves: List[BinaryTree[T]] = {

      @tailrec
      def loop(toInspect: List[BinaryTree[T]] = List(this), result: List[BinaryTree[T]] = List()): List[BinaryTree[T]] = {

        val current: BinaryTree[T] = toInspect.head
        val l: BinaryTree[T] = current.leftChild
        val r: BinaryTree[T] = current.rightChild

        if (current.isEmpty) result
        else if (l.isLeaf) loop(r.collectLeaves ++ l.collectLeaves, result)
        else if (r.isLeaf) loop(l.collectLeaves ++ r.collectLeaves, result)
        else loop(leftChild.collectLeaves ++ rightChild.collectLeaves, result)
      }

      loop()
    }
  }

  case object TreeEnd extends BinaryTree[Nothing] {
    override def value: Nothing = throw new NoSuchElementException

    override def leftChild: BinaryTree[Nothing] = throw new NoSuchElementException

    override def rightChild: BinaryTree[Nothing] = throw new NoSuchElementException

    override def isEmpty: Boolean = true

    override def isLeaf: Boolean = false

    override def collectLeaves: List[BinaryTree[Nothing]] = List()
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

  println {
    tree.collectLeaves
  }

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
