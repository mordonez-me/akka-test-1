import akka.actor.{Props, ActorSystem}

/**
 * Created by mordonez on 3/12/14.
 * mordonez.me@gmail.com
 */

object Main {
  def main(args:Array[String]) = {

    val system = ActorSystem("systemclient1")

    val clientSupervisor =
      system.actorOf(Props[ClientSupervisor], "ClientSupervisor")

    clientSupervisor ! CreateClient()
    clientSupervisor ! CreateClient()
    clientSupervisor ! CreateClient()
    clientSupervisor ! CreateClient()
    clientSupervisor ! CreateClient()
    clientSupervisor ! CreateClient()
    clientSupervisor ! CreateClient()
    clientSupervisor ! CreateClient()

  }
}
