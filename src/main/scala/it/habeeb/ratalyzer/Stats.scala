package it.habeeb.ratalyzer

class Stats(entries: EntrySeq, readErrors: ReadErrorSeq) {

  private lazy val ratingsByProduct = entries.groupMap(_.productId)(_.rating.value)
  private lazy val averagesByProduct = ratingsByProduct.view.mapValues(ratings => ratings.sum.toDouble / ratings.length)
  private lazy val sortedProducts = averagesByProduct.toList.sortBy(_._2).map(_._1)

  lazy val entryCount: Int = entries.length
  lazy val readErrorCount: Int = readErrors.length
  lazy val topThree: Seq[ProductId] = sortedProducts.takeRight(3).reverse
  lazy val bottomThree: Seq[ProductId] = sortedProducts.take(3)
  lazy val mostRated: ProductId = ratingsByProduct.iterator.maxBy(_._2.length)._1
  lazy val leastRated: ProductId = ratingsByProduct.iterator.minBy(_._2.length)._1

}
