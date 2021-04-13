package it.habeeb.ratalyzer

import java.io.{File, FileInputStream, FileOutputStream}

import scala.util.Using

import org.rogach.scallop.ScallopConf

object Main extends App {

  //noinspection TypeAnnotation
  class Conf(args: Array[String]) extends ScallopConf(args) {
    val inputFile = opt[File]()
    val outputFile = opt[File]()
    validateFileExists(inputFile)
    verify()
  }

  val conf = new Conf(args)

  Using.Manager { use =>
    val is = conf.inputFile.toOption match {
      case Some(file) => use(new FileInputStream(file))
      case None => System.in
    }

    val os = conf.outputFile.toOption match {
      case Some(file) => use(new FileOutputStream(file))
      case None => System.out
    }

    val input = new CsvReader(is)
    val stats = new Stats(input.entries, input.readErrors)
    new JsonWriter(stats).write(os)
  }

}
