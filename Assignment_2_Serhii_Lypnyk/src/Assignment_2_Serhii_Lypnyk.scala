//import Assignment_2.week

object Assignment_2_Serhii_Lypnyk extends App {
  val week = List("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

  // Ex.1
  def PatternMatching(day: String, week :List[String]): String = day.toLowerCase() match {
    case inputed if week.map(_.toLowerCase())
                              .filter(!_.startsWith("s"))
                              .contains(inputed.toLowerCase()) => "work"
    case inputed if week.map(_.toLowerCase())
                              .filter(_.startsWith("s"))
                              .contains(inputed.toLowerCase()) => "weekend"
    case _ => "no such day"
  }
  println("PatternMatching:")
  println(PatternMatching("moNday", week))
  println(PatternMatching("saTurday", week))
  println(PatternMatching("motuRday", week))

  //Ex.2
  class BankAccount(private var balance: Double) {
    def this() {
      this(0)
    }
    def deposits(amount: Double): Unit = {
      if (amount > 0)
        balance += amount
      else
        throw new Exception("Must be higher 0")
    }
    def withdraw(amount: Double): Unit = {
      if (0 < amount && amount <= balance) {
        balance -= amount
      } else throw new Exception("Must be higher 0 and less(or equal) than balance")
    }

    def currentBalance(): Unit = println("Current balance: " + balance)
  }

  val account: BankAccount = new BankAccount()
  account.currentBalance()
  account.deposits(77.7)
  account.currentBalance()
  account.withdraw(7.7)
  account.currentBalance()
  new BankAccount(7777).currentBalance()

  //Ex.3
  case class PersonLite(var firstName: String, var lastName: String) {
    def greeting(person: PersonLite): Unit = person match {
      case PersonLite("Serhii", _) => println("Hello Serhii!")
      case PersonLite(_, "Lypnyk") => println("Good Afternoon Mr.Lypnyk")
      case PersonLite(firstN, lastN) => println(s"Nice to meet you $firstN $lastN")
    }
  }
  val Person1: PersonLite = PersonLite("Donald", "Trump")
  Person1.greeting(PersonLite("Serhii", "Surname"))
  Person1.greeting(PersonLite("Name", "Lypnyk"))
  Person1.greeting(PersonLite("Joe", "Biden"))

  //Ex.4
  def ThreeTimes(fn: Int => Int, n: Int): Int = fn(fn(fn(n)))
  println("ThreeTimes:")
  println(ThreeTimes(x => x + x * x, 2))

  //Ex.5
  abstract class Person(private val _name:String, private val _surname:String, private var _taxToPay: Double) {
    def name: String = _name
    def surname: String = _surname
    def taxToPay: Double = _taxToPay
  }

  trait Employee extends Person{
    private var _salary:Double = 100500.00

    def salary = _salary
    def salary_= (newValue: Double): Unit = {
      _salary = newValue
    }
    override def taxToPay: Double = 0.2 * _salary
  }

  trait Student extends Person{
    override def taxToPay: Double = 0.0
  }

  trait Teacher extends Employee {
    override def taxToPay: Double = 0.1 * salary
  }


  var student = new Person("Serhii", "Lypnyk", 0) with Student
  println("Student")
  println("Name: " + student.name)
  println("Surname: " + student.surname)
  println("taxToPay: " + student.taxToPay)

  var employee = new Person("Name1", "Surname1", 0) with Employee
  println("Employee")
  println("Name: " + employee.name)
  println("Surname: " + employee.surname)
  println("taxToPay: " + employee.taxToPay)

  var teacher = new Person("Name2", "Surname2", 0) with Teacher
  println("Teacher")
  println("Name: " + teacher.name)
  println("Surname: " + teacher.surname)
  teacher.salary = 7777.0
  println("taxToPay: " + teacher.taxToPay)

  val studentWorker = new Person("Name3", "Surname3", 0) with Student with Employee
  println("studentWorker")
  println("Name: " + studentWorker.name)
  println("Surname: " + studentWorker.surname)
  studentWorker.salary = 10000.0
  println("taxToPay: " + studentWorker.taxToPay)

  val workerStudent = new Person("Name4", "Name4", 0)  with Employee with Student
  println("workerStudent")
  println("Name: " + workerStudent.name)
  println("Surname: " + workerStudent.surname)
  workerStudent.salary = 13000.0
  println("taxToPay: " + workerStudent.taxToPay)

}


