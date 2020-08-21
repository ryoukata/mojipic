package domain.repository

import java.time.LocalDateTime

import domain.entity.{PictureId, PictureProperty, TwitterId}

import scala.concurrent.Future

trait PicturePropertyRepository {
  /**
   * 画像のプロパティを保存する
   *
   * @param value 画像のプロパティの値
   * @return Future.sccessfull(PictureId) 新しく割り当てられた画像ID
   */
  def create(value: PictureProperty.Value): Future[PictureId]

  /**
   * 画像のプロパティを読み込む
   *
   * @param pictureId 画像ID
   * @return Future.successfull(PictureProperty) 読み込みに成功した
   */
  def find(pictureId: PictureId): Future[PictureProperty]

  /**
   * 画像を更新する
   *
   * @param pictureId 画像ID
   * @param value 値
   * @return Future.sccessfull(()) 更新に成功した
   */
  def update(pictureId: PictureId, value: PictureProperty.Value): Future[Unit]

  /**
   * 投稿者のTwitter IDと最後に読み込まれた作成日時から画像のプロパティを読み込む
   *
   * @param twitterId 投稿者のTwitter ID
   * @param lastCreatedTime 最後に読み込まれた作成日時
   * @return Future.successfull(Seq(pictureProperty)) 読み込みに成功した
   */
  def findAllByTwitterIdAndDateTime(twitterId: TwitterId, lastCreatedTime: LocalDateTime): Future[Seq[PictureProperty]]

  /**
   * 最後に読み込まれた作成日時から画像のプロパティを読み込む
   *
   * @param lastCreatedTime 最後に読み込まれた作成日時
   * @return Future.sccessfull(Seq(PictureProperty)) 読み込みに成功した
   */
  def findAllByDateTime(lastCreatedTime: LocalDateTime): Future[Seq[PictureProperty]]

}
