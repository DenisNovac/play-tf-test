package controllers

import cats.implicits._
import cats.effect.IO
import io.chrisdavenport.log4cats.Logger
import javax.inject._
import play.api.mvc._

/** This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject() (val controllerComponents: ControllerComponents)(implicit logger: Logger[IO])
    extends BaseController {

  /** Create an Action to render an HTML page.
    *
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def index() = Action { implicit request: Request[AnyContent] =>
    // something works wrong with logger but it does not matter - it gets here through DI
    (Logger[IO].info("logger works") >> IO(println("logger works but hidden"))).unsafeRunSync()
    Ok("Ok")
  }
}
