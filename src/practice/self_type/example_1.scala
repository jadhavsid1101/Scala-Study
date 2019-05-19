package practice.self_type

/*
>Self-types are a way to declare that a trait must be mixed into another trait, even though it doesn’t directly extend it.
>That makes the members of the dependency available without imports.
>Self type annotations/references allow you to redefine this and is a way to declare the dependencies required by a component.
>Using a trait mixin, you can inject various implementations of dependencies.
>In simple terms, self type annotations/references are to ensure that the class cannot be instantiated
  without mixing in the trait explicitly specified in the notation, and its members can be used in the class exactly
  like extending/mixing in a trait.
*/

object example_1 extends App {

  val realBeyoncé = new VerifiedTweet("Beyoncé")
  realBeyoncé.tweet("Just spilled my glass of lemonade")


  trait User {
    def username: String
  }

  trait Tweeter {
    this: User =>
    def tweet(tweetText: String) = println(s"$username: $tweetText")
  }

  class VerifiedTweet(val userName_ : String) extends Tweeter with User {
    def username = s"real $userName_"
  }

}