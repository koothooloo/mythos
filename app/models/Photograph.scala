package models

import com.github.aselab.activerecord.{ActiveRecord, ActiveRecordCompanion}

/**
  * Created by vish on 12/01/2017.
  */

case class Photograph(name: String, width: Int, height: Int) extends ActiveRecord

object Photograph extends ActiveRecordCompanion[Photograph]


