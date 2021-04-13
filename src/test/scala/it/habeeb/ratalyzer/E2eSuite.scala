package it.habeeb.ratalyzer

import java.io.File
import java.nio.file.Files

import scala.util.Using

import munit.FunSuite

class E2eSuite extends FunSuite {

  val inputPath = new File(getClass.getClassLoader.getResource("input.csv").toURI).getAbsolutePath
  val expected = io.Source.fromResource("output.json").mkString

  test("Input file produces expected output file") {

    val outputPath = Files.createTempFile(null, null)

    it.habeeb.ratalyzer.Main.main(Array(
      "--input-file", inputPath,
      s"--output-file", outputPath.toAbsolutePath.toString
    ))

    assertNoDiff(Using(io.Source.fromFile(outputPath.toFile))(_.mkString).get, expected)
  }

  // TODO: Test stdin and stdout
  test("Stdin produces expected stdout".ignore) {}

}
