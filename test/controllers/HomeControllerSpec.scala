package controllers

import cats.effect.IO
import com.google.inject.AbstractModule
import io.chrisdavenport.log4cats.Logger
import io.chrisdavenport.log4cats.slf4j.Slf4jLogger
import net.codingwell.scalaguice.ScalaModule
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import play.api.inject.guice.GuiceInjectorBuilder
import play.api.inject.{ApplicationLifecycle, DefaultApplicationLifecycle, Injector, bind}

import scala.concurrent.ExecutionContext

class WorkingModule extends AbstractModule with ScalaModule {

  override def configure(): Unit =
    bind[CustomTFInterface[IO]].toInstance(new CustomTFInterfaceImpl)
}

class HomeControllerSpec extends AnyFlatSpec with Matchers {

  private val application: Injector = new GuiceInjectorBuilder()
    .bindings(bind[ExecutionContext].to(ExecutionContext.global))
    .bindings(bind[ApplicationLifecycle].to[DefaultApplicationLifecycle])
    .bindings(bind[CustomTFInterface[IO]].toInstance(new CustomTFInterfaceImpl)) // fails with it
    //.bindings(new WorkingModule()) // works with it
    .bindings(new CatsEffectModule())
    .injector()

  "di" should "work with tf" in {
    // all the dependencies are provided in CatsEffectModule
    application.instanceOf[InjecableWithTfDependencies]
  }

}
