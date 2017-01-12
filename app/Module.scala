import com.google.inject.AbstractModule
import models.{Person, Photograph, Tables}
import play.api.{Application, GlobalSettings, Logger}
import services._

/**
  * This class is a Guice module that tells Guice how to bind several
  * different types. This Guice module is created when the Play
  * application starts.
  *
  * Play will automatically use any class called `Module` that is in
  * the root package. You can create modules in other locations by
  * adding `play.modules.enabled` settings to the `application.conf`
  * configuration file.
  */
import com.google.inject.AbstractModule
import java.time.Clock

import services.{ApplicationTimer, AtomicCounter, Counter}

/**
  * This class is a Guice module that tells Guice how to bind several
  * different types. This Guice module is created when the Play
  * application starts.

  * Play will automatically use any class called `Module` that is in
  * the root package. You can create modules in other locations by
  * adding `play.modules.enabled` settings to the `application.conf`
  * configuration file.
  */
class Module extends AbstractModule {

  override def configure(): Unit = {

    // Use the system clock as the default implementation of Clock
    bind(classOf[Clock]).toInstance(Clock.systemDefaultZone)

    // Ask Guice to create an instance of ApplicationTimer when the application starts.
    bind(classOf[ApplicationTimer]).asEagerSingleton()

    // Set AtomicCounter as the implementation for Counter.
    bind(classOf[Counter]).to(classOf[AtomicCounter])

    // We bind the implementation to the interface (trait) as an eager singleton,
    // which means it is bound immediately when the application starts.
    bind(classOf[Say]).to(classOf[SayImpl]).asEagerSingleton()
  }
}
