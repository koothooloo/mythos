package models

import com.github.aselab.activerecord.{ActiveRecord, ActiveRecordCompanion}

case class Person(name: String, age: Int) extends ActiveRecord

object Person extends ActiveRecordCompanion[Person]
