package it.habeeb.ratalyzer

final case class Entry(
  buyerId: BuyerId,
  shopId: ShopId,
  productId: ProductId,
  rating: Rating
)
