package practice.compound_types

/*> Compound types are used to specify dependencies as a sub - type of more than one types.
> Sometimes it is necessary to express that the type of an object is a subtype of several other types.*/

object example_1 extends App {

  def cloneAndReset(obj: Cloneable with Resetable): Cloneable = {
    val cloned = obj.clone()
    obj.reset
    cloned
  }

  val s1 = new Student(18, "Siddhesh")
  val s2 = cloneAndReset(s1)

  println(s1.printStudentInfo())
  println(s2.asInstanceOf[Student].printStudentInfo())
  println(s1.printStudentInfo())

}


class Student(number: Int, name: String) extends Cloneable with Resetable {
  def printStudentInfo(): Unit = {
    println("Number is:" + number + " " + "Name is:" + name)
  }
}


trait Cloneable extends java.lang.Cloneable {
  override def clone(): Cloneable = {
    super.clone().asInstanceOf[Cloneable]
  }
}

trait Resetable {
  def reset(): Unit = {
    Unit
  }
}


