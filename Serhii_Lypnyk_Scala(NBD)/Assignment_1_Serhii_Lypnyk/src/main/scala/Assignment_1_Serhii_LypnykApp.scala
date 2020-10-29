import scala.Console.in
import scala.collection.IterableOnce.iterableOnceExtensionMethods
import scala.collection.View.Empty.++
import scala.collection.mutable.ListBuffer
import scala.language.postfixOps
import scala.math.BigDecimal.double2bigDecimal
import scala.math.abs
import scala.util.control.Breaks.{break, _}
object Assignment_1_Serhii_LypnykApp extends App {
  println("Hello World")
  val week = List("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

//  Ex. 1a
  def AllDaysForLoop() = {
    var days = ""
    for (
      day <- week
    ) if (day != week.last) days += s"$day, " else days += s"$day"
    days
  }
  println(AllDaysForLoop())

  //  Ex. 1b
  def AllDaysForLoopStartsWithS() = {
    var days = ""
    for (
      day <- week if day.startsWith("S")
    ) if (day != week.last) days += s"$day, " else days += s"$day"
    days
  }
  println(AllDaysForLoopStartsWithS())

  //  Ex. 1c
  def AllDaysWhileLoop() = {
    var days = ""
    var i = 0
    while (i < week.length) {
      if (week(i) != week.last) days += s"${week(i)}, " else days += s"${week(i)}"
      i += 1
    }
    days
  }
  println(AllDaysWhileLoop())

  //  Ex. 2a
  var days = ""
//  var i = 0
  def AllDaysWithRecursion(i: Int): String = {
    var newI = i
    if (week(newI) != week.last){
        days += s"${week(newI)}, "
//        print(newI)
        newI += 1
//        print(newI)
        AllDaysWithRecursion(newI)
    }
    else {
        days += s"${week(i)}"
      }

    days
  }
  println("uuuu")
  println(AllDaysWithRecursion(0))


  //  Ex. 4a
  def AllDaysFoldLeft() = {
    week.foldLeft("") { (acc, i) =>
      if (i != week.last) s"$acc$i, " else s"$acc$i"
    }
  }
  println(AllDaysFoldLeft())

  //  Ex. 4b
  def AllDaysFoldRight() = {
    week.foldRight("") { (acc, i) =>
      if (acc != week.head) s", $acc$i" else s"$acc$i"
    }
  }
  println(AllDaysFoldRight())

  //  Ex. 4c
  def AllDaysFoldLeftStartsWithS() = {
    var week_filtered = week.filter(_.startsWith("S"))
    week_filtered.foldLeft("") { (acc, i) =>
      if (i != week_filtered.last) s"$acc$i, " else s"$acc$i"
    }
  }
  println(AllDaysFoldLeftStartsWithS())

  //  Ex. 5
  def MappingReduce() = {
    val products = Map("AL" -> 15.0, "AK" -> 25.0, "AE" -> 21.0)
    val price_reduce = products.view.mapValues(_*0.9).toMap

    price_reduce

  }
  println(MappingReduce())

  //  Ex. 6
  def ListMapping() = {
    val any_list = List(1,2,3,4,5)
    any_list map (_+1)
  }
  println(ListMapping())

  //  Ex. 7
//  def ListAbsRange() = {
//    val any_list = List(1, -59.01, 11, 7.21, 17.01, 8.32, 1.57, -1.11, -3, 10, 2, 3, 4, 5)
//    var bla = -5.0 to 12.0 by 0.001
////    any_list map (n => if (bla.contains(n)) {abs(n)})
//    var tempo = new ListBuffer[Double]()
//    for (i <- -5.0 to 12.0 by 0.01) {
//      if (any_list.contains(i)) tempo += i.abs
//    }
//    val temp = temp.toList
//  }
//  println(ListAbsRange())


  //  Ex. 8
  def PrintTuple() = {
    val any_tuple = (3, "abc", 5.5)
    any_tuple.productIterator.foreach(println)
  }
  println(PrintTuple())


  //  Ex. 10
  def OptionExamples() = {
//    Example 1
    val name = Map("Serhii" -> "author",
                    "Vasyl" -> "coder"
                  )
    val x = name.get("Serhii")
    val y = name.get("Anna")
    println(x)
    println(y)

//    Example 2
    val some:Option[Int] = Some(15)
    val none:Option[Int] = None
    val xy = some.getOrElse(0)
    val yx = none.getOrElse(17)
    println(xy)
    println(yx)

//    Example 3
    val some1:Option[Int] = Some(20)
    val none1:Option[Int] = None
    val xx = some1.isEmpty
    val yy = none1.isEmpty
    println(xx)
    println(yy)
  }
  println(OptionExamples())

}