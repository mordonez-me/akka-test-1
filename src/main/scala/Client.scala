import akka.actor.Actor

/**
 * Created by mordonez on 3/12/14.
 * mordonez.me@gmail.com
 */

case class AddClient(name:String) extends Work
case class CreateClient() extends Work


class Client(id:Int) extends Actor {
  println(s"A Client is being instantiated $id")
  def receive = {
    case c:CreateClient => println(s"Client added $c , id: $id")
  }
}