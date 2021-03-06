package sri.web.examples.routerexample

import sri.universal.components._
import sri.web.all._
import sri.web.examples.styles.Theme

import scala.scalajs.js.{UndefOr => U, undefined}
import scala.util.Try


object ItemDetailsScreen {

  val Component = (id: Int) => {
    View(style = Theme.flexOneAndDirectionRow)(
      ItemsLeftNav(),
      View(style = Theme.flexOneAndCenter)(
        Text(style = Theme.bigText)(s"${if (id >= 0) s"Item details of :: $id" else "Item not found"}")
      )
    )
  }

  def parser(placeholder: String) = Try(placeholder.toInt).getOrElse(-1)

  def apply(id: Int) = createStatelessFunctionElement(Component, id)

}
