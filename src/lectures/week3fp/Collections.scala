package lectures.week3fp

object Collections extends App {

  /* Set */

  val emptySet: Set[Int] = Set()
  val aSet = Set(10, 20, 30, 40)
  val anotherSet = Set(30, 40, 50, 60)

  aSet.isEmpty // false
  emptySet.isEmpty  //true

  aSet.head // 10
  aSet.tail // Set(20, 30, 40)

  aSet.min // 10
  aSet.max // 40

  aSet.intersect(anotherSet) // Set(30, 40)
  aSet.&(anotherSet) // Set(30, 40)

  aSet.++(anotherSet) // HashSet(10, 20, 60, 50, 40 30)
  aSet ++ anotherSet // HashSet(10, 20, 60, 50, 40 30)

  /* Seq */

  val aSequence = Seq(1, 3, 2, 4)

  println(aSequence) // List(1, 3, 2, 4)

  aSequence.length // 4

  aSequence ++ Seq(6, 7, 5) // List(1, 3, 2, 4, 6, 7, 5)

  aSequence.reverse // List(4, 2, 3, 1)
  aSequence.sorted // List(1, 2, 3, 4)

  aSequence(1) // 3 - получает элемент по индексу
  aSequence.search(3) // Found(1) - возвращает индекс найденного элемента

  /* Map */

  val aMap: Map[String, Int] = Map()

  val colors: Map[String, String] =
    Map(("black", "#000000"), "blue" -> "#0d1ad1", ("Blue", "#161d96")).withDefaultValue("na")

  println(colors)

  println(colors.contains("black")) // true
  println(colors("black")) // #000000 // возврат значения по ключу

  val color: (String, String) = "green" -> "#339616"
  val newColor: Map[String, String] = colors + color
  println(newColor)

  println(colors.toList)
  println(List(("White", "#ffffff")).toMap)

  /* Array */

  val anArray: Array[String] = Array("h", "e", "l", "l", "o", ".")
  anArray(5) = "!" // == anArray.update(5, "!")
  println(anArray.mkString("-"))

val twoElements: Array[Boolean] = Array.ofDim[Boolean](2)
  twoElements.foreach(println) // false false

  val numberSeq: Seq[String] = anArray
  println(numberSeq)

  /* Tuple */

  val aTuple: (Int, String) = (100, "Scala")

  val sameTuple: (Int, String) = Tuple2(100, "Scala")

  println(aTuple)

  aTuple._1 // 100
  aTuple._2 // Scala

  val copy: (Int, String) = aTuple.copy(_2 = "Python") // 100, Python

  aTuple.swap // (Scala, 100)

  /* Range */

  val aRange: Seq[Int] = 1 until 3
  aRange.foreach(print) // 12

  (1 to 3).foreach(x => print("Hello")) // HelloHelloHello

  val aRangeToVector: Vector[Int] = (1 to 5).toVector
  println(aRangeToVector)

  /* foreach */

  val list = List(1, 2, 3)

  list.foreach(print) // 123 == for { n <- list } print(n)

  /* map */

  val fruits = List("apple", "banana")

  val mapResult = fruits.map(_.toUpperCase)
  val flatResult = fruits.flatMap(_.toUpperCase)

  println(mapResult) // List(APPLE, BANANA)
  println(flatResult) // List(A, P, P, L, E, B, A, N, A, N, A)

  val s = "Hello"
  val newStr: String = s.flatMap(c => (c + "."))
  println(newStr) //H.e.l.l.o.

  println(s.map(c => (c + ".")))

  val list1 = List(1, 2)
  val list2 = List("a", "b")

  val combinations = list1.flatMap(n => list2.map(c => c + n))
  println(combinations)

  val forCombination = for {
    n <- list1
    c <- list2
  } yield c + n

  list1.filter(_ > 1).flatMap(n => list2.map(c => c + n))

  val forFilterCombination = for {
    n <- list1 if n > 1
    c <- list2
  } yield c + n

  val progLanguages = List("java", "scala", "python")
  val lngAbbrev = List("JA", "SCA", "PY")

  for {
    lng <- progLanguages
    abrv <- lngAbbrev
  } yield (lng, abrv)

  progLanguages.flatMap(lng => lngAbbrev.map(abrv => (abrv, lng)))

  val out = progLanguages.flatMap(lng => lngAbbrev.map(abrv => (abrv, lng)))

  val out3 = for {
    lng <- progLanguages
    abrv <- lngAbbrev
  } yield (lng, abrv)
  //  println(out)
  //  println(out3)
  println
  println

  val out4 = progLanguages.flatMap(x => lngAbbrev.map(y => (progLanguages.find(_ => true), y.find(_ => true))))
 val out6 = {
   progLanguages.map(lng => (lngAbbrev.find(abrv => ({abrv.take(2).toLowerCase == lng.take(2)})), lng)).take(3)
 }
  val out7 = lngAbbrev.zip(progLanguages)
  println(out6)
  println(out7)

  val sampleTuple = new Tuple2(2, "Hello, World")

  println(sampleTuple.copy(_2 = "Scala").swap._1 + 5)
}
