package it.habeeb.ratalyzer

import eu.timepit.refined.auto._
import munit.FunSuite

class StatsSuite extends FunSuite {

  val stats = new Stats(
    Seq(
      Entry("buyer01", "shop01", "best-01", 5),
      Entry("buyer01", "shop01", "best-01", 5),
      Entry("buyer01", "shop01", "best-01", 5),
      Entry("buyer01", "shop01", "best-02", 5),
      Entry("buyer01", "shop01", "best-02", 5),
      Entry("buyer01", "shop01", "best-02", 4),
      Entry("buyer01", "shop01", "best-03", 5),
      Entry("buyer01", "shop01", "best-03", 4),
      Entry("buyer01", "shop01", "best-03", 4),

      Entry("buyer01", "shop01", "worst-01", 1),
      Entry("buyer01", "shop01", "worst-01", 1),
      Entry("buyer01", "shop01", "worst-01", 1),
      Entry("buyer01", "shop01", "worst-02", 1),
      Entry("buyer01", "shop01", "worst-02", 1),
      Entry("buyer01", "shop01", "worst-02", 2),
      Entry("buyer01", "shop01", "worst-03", 1),
      Entry("buyer01", "shop01", "worst-03", 2),
      Entry("buyer01", "shop01", "worst-03", 2),

      Entry("buyer01", "shop01", "average-01", 3),
      Entry("buyer01", "shop01", "average-01", 3),
      Entry("buyer01", "shop01", "average-01", 3),
      Entry("buyer01", "shop01", "average-01", 3),
      Entry("buyer01", "shop01", "average-01", 3),

      Entry("buyer01", "shop01", "average-02", 3),
    ),
    Seq.empty
  )

  assertEquals(stats.topThree, Seq[ProductId]("best-01", "best-02", "best-03"))
  assertEquals(stats.bottomThree, Seq[ProductId]("worst-01", "worst-02", "worst-03"))
  assertEquals(stats.mostRated, "average-01": ProductId)
  assertEquals(stats.leastRated, "average-02": ProductId)
  assertEquals(stats.entryCount, 24)
  assertEquals(stats.readErrorCount, 0)
}
