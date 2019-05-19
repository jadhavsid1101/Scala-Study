package practice.recursion

import scala.annotation.tailrec

object tail_recursive_examples extends App {

  //A common pattern used to make a recursive function that “accumulates a result” into a tail-recursive function is to follow a series of simple steps:
  //  1.Keep the original function signature the same.
  //  2.Create a second function by
  //      (a) copying the original function,
  //      (b) giving it a new name,
  //      (c) making it private,
  //      (d) giving it a new “accumulator” input parameter, and
  //      (e) adding the @tailrec annotation to it.
  //  3.Modify the second function’s algorithm so it uses the new accumulator.
  //  4.Call the second function from inside the first function.
  //  When you do this you give the second function’s accumulator parameter a “seed” value.

  // recursive function to return sum of all elements of a list
  def sum(list: List[Int]): Int = {
    @tailrec
    def sumRec(list: List[Int], currentSum: Int): Int = {
      if (list == Nil) currentSum // empty list == Nil
      else sumRec(list.tail, currentSum + list.head) // recursive call
    }

    sumRec(list, 0)
  }

  println("Sum using TailRec" + tail_recursive_examples.sum(List.range(1, 10000)))

  // similar to above function using switch case
  def sumSwitch(list: List[Int]): Int = {

    @tailrec
    def sumSwitchRec(list: List[Int], currentSum: Int): Int = {
      list match {
        case Nil => currentSum
        case head :: tail => sumSwitchRec(tail, currentSum + head)
      }
    }

    sumSwitchRec(list, 0)
  }

  println("Sum using TailRec" + tail_recursive_examples.sum(List.range(1, 10000)))

  // recursive function to return multiplication of all elements of a list
  def product(list: List[Int]): Int = {

    @tailrec
    def productRec(list: List[Int], currentProduct: Int): Int = {
      if (list == Nil) currentProduct else productRec(list.tail, currentProduct * list.head)
    }

    productRec(list, 1)
  }

  println("Product of list using tail rec" + product(List.range(1, 10)))

  // recursive function to return maximum of all elements of a list
  def max(list: List[Int]): Int = {

    def maxRec(list: List[Int],currentMax:Int): Int = {
    if (list == Nil) currentMax
    else if (list.tail == Nil){ if(list.head> currentMax) list.head else currentMax}
    else {
      maxRec((if (list.head > list.tail.head) list.head
      else list.tail.head) :: list.tail.tail, currentMax)
    }
  }
  maxRec(list,0)
  }

  println("Max of list using tail rec" + max(List.range(1, 10)))

}
