package services

import javax.inject._

import models.{Person, Photograph, Tables}
import play.api.Logger
import play.api.inject.ApplicationLifecycle

import scala.concurrent.Future

trait Say {
  def hello(): Unit
  def goodbye(): Unit
}

@Singleton
class SayImpl @Inject() (appLifecycle: ApplicationLifecycle) extends Say {
  override def hello(): Unit = println("Hello!")
  override def goodbye(): Unit = println("Goodbye!")

  def start(): Unit = {
    hello()

    Logger.info("Application has started")
    Tables.initialize

    Person("person1", 25).save
    Person("person2", 18).save
    Person("person3", 40).save
    Person("person4", 18).save

    Photograph("Snake Charmer", 640, 480).save

    Tables.cleanup
    Logger.info("Tables finished...")

  }

  // When the application starts, register a stop hook with the
  // ApplicationLifecycle object. The code inside the stop hook will
  // be run when the application stops.
  appLifecycle.addStopHook { () =>
    goodbye()
    Future.successful(())
  }

  // Called when this singleton is constructed (could be replaced by `hello()`)
  start()
}
