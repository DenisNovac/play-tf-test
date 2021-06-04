package controllers

import cats.effect.IO
import com.google.inject.AbstractModule
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

  it should "test1" in {
    val application: Injector = new GuiceInjectorBuilder()
      .bindings(bind[ExecutionContext].to(ExecutionContext.global))
      .bindings(bind[ApplicationLifecycle].to[DefaultApplicationLifecycle])
      .bindings(bind[CustomTFInterface[IO]].toInstance(new CustomTFInterfaceImpl))
      .bindings(new CatsEffectModule())
      .injector()

    application.instanceOf[CustomTFInterface[IO]] // works
    //application.instanceOf[InjecableWithTfDependencies] // fails

  }

  it should "test2" in {
    val application: Injector = new GuiceInjectorBuilder()
      .bindings(bind[ExecutionContext].to(ExecutionContext.global))
      .bindings(bind[ApplicationLifecycle].to[DefaultApplicationLifecycle])
      .bindings(new WorkingModule()) // works with it
      .bindings(new CatsEffectModule())
      .injector()

    //application.instanceOf[CustomTFInterface[IO]] // fails
    application.instanceOf[InjecableWithTfDependencies] // works
  }

}
