package it.habeeb

import eu.timepit.refined.api.Refined
import eu.timepit.refined.numeric.Interval
import eu.timepit.refined.string.MatchesRegex
import kantan.csv.ReadError

package object ratalyzer {

  /** [[BuyerId]] is a sequence of alphanumeric characters that starts with a letter, e.g. `buyer1` */
  type BuyerId = String Refined MatchesRegex["^[a-zA-Z][a-zA-Z0-9]*$"]
  /** [[ShopId]] is a sequence of alphanumeric characters that starts with a letter, e.g. `shop1` */
  type ShopId = String Refined MatchesRegex["^[a-zA-Z][a-zA-Z0-9]*$"]
  /**
   * [[ProductId]] is a sequence of alphanumeric characters and hyphens (-) that starts with a letter and ends with
   * hyphen and a numeric value, the numeric value at the end is in a range between 1 and 99, e.g. `smart-tv-01`, `patagonia-32`
   */
  type ProductId = String Refined MatchesRegex["^[a-zA-Z][a-zA-Z0-9-]*-\\d\\d$"]
  /** Th [[Rating]] is numeric value between 1 and 5 as a whole number, e.g. `3` or `5` */
  type Rating = Int Refined Interval.Closed[1, 5]

  type EntrySeq = Seq[Entry]
  type ReadErrorSeq = Seq[ReadError]

}
