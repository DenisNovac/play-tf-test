package controllers

import cats.effect.IO
import com.google.inject.AbstractModule
import io.chrisdavenport.log4cats.Logger
import io.chrisdavenport.log4cats.slf4j.Slf4jLogger
import net.codingwell.scalaguice.ScalaModule

class CatsEffectModule extends AbstractModule with ScalaModule {

  override def configure(): Unit =
    bind[Logger[IO]].toInstance(Slf4jLogger.getLogger[IO])

}
