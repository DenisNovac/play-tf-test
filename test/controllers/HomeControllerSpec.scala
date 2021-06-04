package controllers

import cats.effect.IO
import io.chrisdavenport.log4cats.Logger
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import play.api.inject.guice.GuiceInjectorBuilder
import play.api.inject.{ApplicationLifecycle, DefaultApplicationLifecycle, Injector, bind}

import scala.concurrent.ExecutionContext

/** Add your spec here.
  * You can mock out a whole application including requests, plugins etc.
  *
  * For more information, see https://www.playframework.com/documentation/latest/ScalaTestingWithScalaTest
  */
class HomeControllerSpec extends AnyFlatSpec with Matchers {

  private val application: Injector = new GuiceInjectorBuilder()
    .bindings(bind[ExecutionContext].to(ExecutionContext.global))
    .bindings(bind[ApplicationLifecycle].to[DefaultApplicationLifecycle])
    .bindings(new CatsEffectModule())
    .injector()

  "di" should "work with tf" in {
    application.instanceOf[Logger[IO]]
  }

}
