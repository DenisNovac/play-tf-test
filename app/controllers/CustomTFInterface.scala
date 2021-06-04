package controllers

import cats.effect.IO

trait CustomTFInterface[F[_]] {
  def unit: F[Unit]
}

class CustomTFInterfaceImpl extends CustomTFInterface[IO] {
  override def unit: IO[Unit] = IO.unit
}
