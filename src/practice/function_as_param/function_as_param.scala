package practice.function_as_param
//Passing function as arguments
object function_as_param extends App {
  /**
    *
    * @param func --> Function as param to perform desired operation
    * @param lowLimit --> Starting Number
    * @param upLimit --> Ending Number
    * @return --> Addition of range according to function
    *         We pass range of numbers and a function to this function
    *         This param decides how to add each number
    */
  def sum(func: Int => Int, lowLimit: Int, upLimit: Int): Int = {
    var total = 0
    for (i <- lowLimit to upLimit) {
      total += func(i)
    }
    total
  }

  /**
    *
    * @param num
    * @return --> Number
    */
  def simpleNum(num: Int) = num

  /**
    *
    * @param num
    * @return --> Square of number
    */
  def squareNum(num: Int) = num * num

  /**
    *
    * @param num
    * @return --> Cube of number
    */
  def cubeNum(num: Int) = num * num * num

  /**
    *
    * @param num
    * @return --> Number multiplied by 2
    */
  def doubleNum(num: Int) = num * 2

  println("Sum of range between numbers:"+sum(simpleNum,1,10)) //Addition of numbers
  println("Sum of squares of range between numbers:"+sum(squareNum,1,10)) //Addition of squares of numbers
  println("Sum of cubes of range between numbers:"+sum(cubeNum,1,10)) //Addition of cubes of numbers
  println("Sum of doubles of range between numbers:"+sum(doubleNum,1,10)) //Addition of doubles of numbers

}
