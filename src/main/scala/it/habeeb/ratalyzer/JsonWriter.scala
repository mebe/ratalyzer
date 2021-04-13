package it.habeeb.ratalyzer

import java.io.OutputStream

import eu.timepit.refined.auto._
import upickle.default.{ReadWriter, macroRW}

class JsonWriter(stats: Stats) {

  private object Output {
    implicit val rw: ReadWriter[Output] = macroRW
  }
  private case class Output(
    validLines: Int,
    invalidLines: Int,
    bestRatedProducts: Seq[String],
    worstRatedProducts: Seq[String],
    mostRatedProduct: String,
    lessRatedProduct: String
  )

  private val data = Output(
    stats.entryCount,
    stats.readErrorCount,
    stats.topThree.map(_.value),
    stats.bottomThree.map(_.value),
    stats.mostRated,
    stats.leastRated
  )

  def write(os: OutputStream): Unit = {
    upickle.default.writeToOutputStream(data, os, indent = 2)
  }

}
