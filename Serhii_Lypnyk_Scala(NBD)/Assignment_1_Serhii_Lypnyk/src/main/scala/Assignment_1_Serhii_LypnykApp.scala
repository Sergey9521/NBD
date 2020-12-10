import scala.Console.in
import scala.annotation.tailrec
import scala.collection.IterableOnce.iterableOnceExtensionMethods
import scala.collection.View.Empty.++
import scala.collection.mutable.ListBuffer
import scala.language.postfixOps
import scala.math.BigDecimal.double2bigDecimal
import scala.math.abs
import scala.util.control.Breaks.{break, _}
object Assignment_1_Serhii_LypnykApp extends App {
  println("Hello World")
  var week = List("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
//  var days = ""

  
  //  Ex. 1a
  def AllDaysForLoop(weeks :List[String]) = {
    var days = ""
    for (day <- weeks)
      if (day != weeks.last)
        days += s"$day, "
      else
        days += s"$day"
    days
  }
  println(AllDaysForLoop(week))


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


  //  Ex. 2b
  def AllDaysWithRecursionFromLast(strList: List[String]): String = {
    if (strList.isEmpty) ""
    else strList.last + ", " + rec2(strList.splitAt(strList.length-1)._1)  //разрезаем на два списка в предпоследнем и берем первый список
  }
  println(AllDaysWithRecursionFromLast(week))


  //  Ex. 3
  def AllDaysWithTailRecursion(strList: List[String]): String = {
    @tailrec
    def step( str: List[String], result: String): String = {
      if (str.isEmpty) result
      else step(str.splitAt(1)._2, result + str.head + ", ")
    }
    step(strList, "")
  }
  println(AllDaysWithTailRecursion(week))


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
  val any_list = List(1, -59.01, 11, 7.21, 17.01, 8.32, 1.57, -1.11, -3, 10, 2, 3, 4, 5)
  def ListAbsRange( lis: List[Double]): List[Double] = {
    lis.filter(_ <= 12 ).filter(_ >= -5).map(x => abs(x))
   }
  println(ListAbsRange(any_list))


  //  Ex. 8
  def PrintTuple() = {
    val any_tuple = (3, "abc", 5.5)
    any_tuple.productIterator.foreach(println)
  }
  println(PrintTuple())


  //  Ex.9
  val nums = List( 0, 1, 2, 5, 7, 100, 21, 22, 24, 30, 77 )
  val zero = no_zeros(nums)
  def no_zeros( lis: List[Int]): List[Int] = {
    if( lis.isEmpty ) List()
    else if( lis.head != 0 ) List(lis.head) ::: no_zeros(lis.tail)
    else no_zeros(lis.tail)
  }
  println(zero)


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