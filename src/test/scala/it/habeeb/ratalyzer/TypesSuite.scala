package it.habeeb.ratalyzer

import eu.timepit.refined.api.RefType
import munit.FunSuite

class TypesSuite extends FunSuite {
  test("Valid BuyerId") {
    RefType.applyRef[BuyerId]("buyerid1") match {
      case Left(e) => fail(e)
      case Right(_) =>
    }
  }

  test("Valid ShopId") {
    RefType.applyRef[ShopId]("shop1") match {
      case Left(e) => fail(e)
      case Right(_) =>
    }
  }


  test("Valid ProductId") {
    RefType.applyRef[ProductId]("product1-01") match {
      case Left(e) => fail(e)
      case Right(_) =>
    }
    RefType.applyRef[ProductId]("product-1-01") match {
      case Left(e) => fail(e)
      case Right(_) =>
    }

  }

  test("Valid Rating") {
    RefType.applyRef[Rating](3) match {
      case Left(e) => fail(e)
      case Right(_) =>
    }
  }

  test("Invalid BuyerId") {
    RefType.applyRef[BuyerId]("1buyer1") match {
      case Left(e) if e.startsWith("Predicate failed") =>
      case Left(e) => fail(e)
      case Right(_) => fail("Invalid input 1buyer1 for BuyerId passed")
    }

    RefType.applyRef[BuyerId]("buyer-1") match {
      case Left(e) if e.startsWith("Predicate failed") =>
      case Left(e) => fail(e)
      case Right(_) => fail("Invalid input buyer-1 for BuyerId passed")
    }

    RefType.applyRef[BuyerId]("buyer_1") match {
      case Left(e) if e.startsWith("Predicate failed") =>
      case Left(e) => fail(e)
      case Right(_) => fail("Invalid input buyer_1 for BuyerId passed")
    }
  }

  test("Invalid ShopId") {
    RefType.applyRef[ShopId]("1shop1") match {
      case Left(e) if e.startsWith("Predicate failed") =>
      case Left(e) => fail(e)
      case Right(_) => fail("Invalid input 1shop1 for ShopId passed")
    }

    RefType.applyRef[ShopId]("shop-1") match {
      case Left(e) if e.startsWith("Predicate failed") =>
      case Left(e) => fail(e)
      case Right(_) => fail("Invalid input shop-1 for ShopId passed")
    }

    RefType.applyRef[ShopId]("shop_1") match {
      case Left(e) if e.startsWith("Predicate failed") =>
      case Left(e) => fail(e)
      case Right(_) => fail("Invalid input shop_1 for ShopId passed")
    }
  }


  test("Invalid ProductId") {
    RefType.applyRef[ProductId]("foobarbaz") match {
      case Left(e) if e.startsWith("Predicate failed") =>
      case Left(e) => fail(e)
      case Right(_) => fail("Invalid input foobarbaz for ProductId passed")
    }

    RefType.applyRef[ProductId]("1product1-01") match {
      case Left(e) if e.startsWith("Predicate failed") =>
      case Left(e) => fail(e)
      case Right(_) => fail("Invalid input 1product1-01 for ProductId passed")
    }

    RefType.applyRef[ProductId]("-product1-01") match {
      case Left(e) if e.startsWith("Predicate failed") =>
      case Left(e) => fail(e)
      case Right(_) => fail("Invalid input -product1-01 for ProductId passed")
    }

  }

  test("Invalid Rating") {
    RefType.applyRef[Rating](-1) match {
      case Left(e) if e.startsWith("Left predicate of") =>
      case Left(e) => fail(e)
      case Right(_) => fail("Invalid input -1 for Rating passed")
    }

    RefType.applyRef[Rating](10) match {
      case Left(e) if e.startsWith("Right predicate of") =>
      case Left(e) => fail(e)
      case Right(_) => fail("Invalid input 10 for Rating passed")
    }
  }
}
