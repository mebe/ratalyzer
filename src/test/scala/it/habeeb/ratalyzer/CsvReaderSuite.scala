package it.habeeb.ratalyzer

import munit.FunSuite

class CsvReaderSuite extends FunSuite {

  val input = getClass.getClassLoader.getResourceAsStream("input.csv")

  test("Reads input") {
    val reader = new CsvReader(input)
    assertEquals(reader.entries.length, 48)
    assertEquals(reader.readErrors.length, 2) // Header line and one line with rating 8
  }

}
