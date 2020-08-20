package infrastructure.actor

import akka.actor.Actor
import com.google.inject.Inject
import com.redis.RedisClient
import domain.repository.PicturePropertyRepository
import play.api.Configuration

sealed abstract trait ConvertPictureActorMessage

case object ConvertPictureMessage extends ConvertPictureActorMessage

class ConvertPictureActor @Inject()(
                                   redisClient: RedisClient,
                                   picturePropertyRepository: PicturePropertyRepository,
                                   configuration: Configuration
                                   ) extends Actor {

  override def receive = {

    case ConvertPictureMessage => {
      // TODO 画像変換処理の実装
      println("画像変換処理を実行")
    }

  }

}
