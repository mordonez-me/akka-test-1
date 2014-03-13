import akka.actor.{Terminated, Props, Actor}
import akka.routing.{RoundRobinRoutingLogic, Router, ActorRefRoutee}
import scala.util.Random

/**
 * Created by mordonez on 3/12/14.
 * mordonez.me@gmail.com
 */
class ClientSupervisor extends Actor {

  var router = {
    val routees = Vector.fill(5) {
      val r = context.actorOf(Props(classOf[Client], new Random().nextInt()))
      context watch r
      ActorRefRoutee(r)
    }
    Router(RoundRobinRoutingLogic(), routees)
  }

  def receive:Actor.Receive = {
    case w:Work =>
      println("ClientSupervisor:CreateClient")
      router.route(w, sender())

    case Terminated(a) =>
      router = router.removeRoutee(a)
      val r = context.actorOf(Props[Client])
      context watch r
      router = router.addRoutee(r)
  }

}
