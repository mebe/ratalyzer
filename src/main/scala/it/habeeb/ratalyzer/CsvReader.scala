package it.habeeb.ratalyzer

import java.io.InputStream

import kantan.csv.CsvConfiguration.{Header, QuotePolicy}
import kantan.csv._
import kantan.csv.generic._
import kantan.csv.ops._
import kantan.csv.refined._

class CsvReader(input: InputStream) {

  private val RatingCsvConfig = new CsvConfiguration(
    ',',
    '"',
    QuotePolicy.WhenNeeded,
    Header.None
  )

  private val reader = input.asCsvReader[Entry](RatingCsvConfig)

  // CsvReader / ResourceIterator doesn't implement `partition`, so we need to split the entries manually
  val (readErrors, entries) =
    reader.foldLeft((List[ReadError](), List[Entry]())) { (acc, entry) =>
      entry match {
        case Left(invalid) => (invalid :: acc._1, acc._2)
        case Right(entry) => (acc._1, entry :: acc._2)
      }
    }

}
