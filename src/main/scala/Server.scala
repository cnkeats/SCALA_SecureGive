package main.scala
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import akka.http.scaladsl.server.Directives._
import scala.concurrent.ExecutionContext

object Server extends App {

  val host = "0.0.0.0"
  val port = 9000
  implicit val system: ActorSystem = ActorSystem("helloworld")

  //Changed system.dispatcherimplicit to system.dispatcher
  implicit val executor: ExecutionContext = system.dispatcher
  val materializer: ActorMaterializer = ActorMaterializer()

  val route =
    path("hello") {
      get {
        complete("Hello, world!")
      }
    }


  //Type mismatch on route
  val bindingFuture = Http().bindAndHandle(route, host, port)

}