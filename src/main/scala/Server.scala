package main.scala

object Server extends App {

  val host = "0.0.0.0"
  val port = 9000
  implicit val system: ActorSystem = ActorSystem("helloworld")
  implicit val executor: ExecutionContext = system.dispatcherimplicit
  val materializer: ActorMaterializer = ActorMaterializer()

  def route = path("hello") {
    get {
      complete("Hello, World!")
    }
  }

  Http().bindAndHandle(route, host, port)

}