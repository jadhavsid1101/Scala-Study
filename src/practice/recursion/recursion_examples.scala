package practice.recursion

import java.math.BigInteger

object recursion_examples extends App {

  // recursive function to return sum of all elements of a list
  def sum(list: List[Int]): Int = {
    if (list == Nil) 0 // empty list == Nil
    else list.head + sum(list.tail) // recursive call
  }

  // similar to above function using switch case
  def sumSwitch(list: List[Int]): Int = {
    list match {
      case Nil => 0
      case head :: tail => head + sum(tail)
    }
  }

  // recursive function to return multiplication of all elements of a list
  def product(list: List[Int]): Int = {
    if (list == Nil) 1 else list.head * product(list.tail)
  }

  // recursive function to return maximum of all elements of a list
  def max(list: List[Int]): Int = {
    if (list == Nil) 0
    else if (list.tail == Nil) list.head
    else {
      max((if (list.head > list.tail.head) list.head
      else list.tail.head) :: list.tail.tail)
    }
  }

  // similar to above function using switch case
  def maxSwitch(list: List[Int]): Int = {
    list match {
      case Nil => 0
      case head :: Nil => head
      case head :: second :: restTail => max(((if (head > second) head else second) :: restTail))
    }
  }

  // recursive function to return fibonacci series
  def fibonacci(first: Int, second: Int): Int = {
    val next = first + second
    print(next + ",")
    if (next > 100000) System.exit(0)
    fibonacci(second, next)
  }

  // recursive function to return factorial of a number
  def factorial(number: Int): Int = {
    if (number > 1) number * factorial(number - 1)
    else 1
  }


  //println(sum(List.range(1, 100000000)))
  //println(factorial(10))

  println(product(List.range(1,10)))

}
