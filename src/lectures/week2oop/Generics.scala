package lectures.week2oop

object Generics extends App {

  class MyList[A] // в скобках [] применяются заглавные буквы. обобщения применяются к trait, class, но не к object

  val listOfStrings = new MyList[String]
  val listOfDoubles = new MyList[Double]
  val listOfInts = new MyList[Int]

  def randomInt(items: List[Int]): Int = {
    val randomIndex = util.Random.nextInt(items.length)
    items(randomIndex)
  }

  println(randomInt(List(1, 2, 3, 4, 5)))

  def randomItem[A](items: List[A]): A = {
    val randomIndex = util.Random.nextInt(items.length)
    items(randomIndex)
  }

  println(randomItem(List("a", "bc", "def")))
  println(randomItem(List(1.5, 2.75, 3.8)))

  class Fruit
  class Apple extends Fruit
  class Banana extends Fruit

  class InvariantList[A]

  val invariantFruitList: InvariantList[Fruit] = new InvariantList[Fruit]

  class CovariantList[+A]

  val fruitList: CovariantList[Fruit] = new CovariantList[Apple]

  class ContravariantList[-A]

  val contravariantFruitList: ContravariantList[Apple] = new ContravariantList[Fruit]

  class Food[T <: Fruit](fruit: T) //верхнее ограничение
  val food = new Food(new Banana)

  class Pizza
  //val moreFood = new Food(new Pizza) //ошибка

  class Food1[T >: Fruit](fruit: T) // нижнее ограничение

  val fruit: Fruit = new Apple

 /* class List[+A] {
    def add[B >: A](element: B): List[B] = CovariantList[B]
  }*/
  //fruitList.add(new Banana) // не получится
}
