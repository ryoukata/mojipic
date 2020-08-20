package domain.repository

import domain.entity.{PictureId, PictureProperty}
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

}
