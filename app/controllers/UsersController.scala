package controllers

import java.time.LocalDateTime
import javax.inject.{Inject, Singleton}

import domain.entity.TwitterId
import domain.repository.PicturePropertyRepository
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}

@Singleton
class UsersController @Inject()(
                               cc: ControllerComponents,
                               picturePropertyRepository: PicturePropertyRepository
                               ) extends AbstractController(cc) {

  implicit val ec = cc.executionContext

  def getProperties(twitterId: Long, lastCreatedTime: Option[String]) = Action.async {
    val localDateTime = lastCreatedTime.map(LocalDateTime.parse).getOrElse(LocalDateTime.parse("0000-01-01T00:00:00"))
    picturePropertyRepository.findAllByTwitterIdAndDateTime(TwitterId(twitterId), localDateTime).map(properties => {
      Ok(Json.toJson(properties)).as("application/json")
    })
  }

}
