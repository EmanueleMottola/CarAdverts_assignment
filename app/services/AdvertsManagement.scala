package services

import org.mongodb.scala.bson.BsonDocument


object AdvertsManagement{
  private val mongoutility = MongoUtility

  /** Queries MongoDB and returns the list
   *  ordered according to the field.
   *
   * @param field the field according which to order the list.
   * @return a List of Car ordered according to field.
   */
  def getAdverts(field: String): Seq[BsonDocument] = {

    val response = field match {
      case "id" => mongoutility.getEntireCollectionSorted("_id")
      case "title" => mongoutility.getEntireCollectionSorted("title")
      case "fuel" => mongoutility.getEntireCollectionSorted("fuel")
      case "price" => mongoutility.getEntireCollectionSorted("price")
      case "isNew" => mongoutility.getEntireCollectionSorted("isNew")
      case "mileage" => mongoutility.getEntireCollectionSorted("mileage")
      case "firstRegistration" => mongoutility.getEntireCollectionSorted("firstRegistration")
      case _ => mongoutility.getEntireCollectionSorted("_id")
    }

    response
  }

  def getAdvertByID(id: String): BsonDocument = {
    mongoutility.getAdvertById(id)
  }


/*
  def updateAdvertByID(json: JsValue): Unit = {

    val car: Car = Car.jsValueToCar(json)
    val doc: Document = Car.carToDocument(car)
    mongoutility.modifyAdvert(doc)
  }



  def deleteAdvert(id: String): Unit = {
    mongoutility.removeAdvert(id)
  }



  def createAdvert(json: JsValue): Unit = {

    val car: Car = Car.jsValueToCar(json)
    val doc: Document = Car.carToDocument(car)
    mongoutility.insertAdvert(doc)

  }*/
}



