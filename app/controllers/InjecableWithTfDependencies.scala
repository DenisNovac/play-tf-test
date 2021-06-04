package controllers

import cats.effect.IO
import io.chrisdavenport.log4cats.Logger

import javax.inject.{Inject, Singleton}

@Singleton
class InjecableWithTfDependencies @Inject() (
    custom: CustomTFInterface[IO]
)(implicit
    logger: Logger[IO]
) {}
