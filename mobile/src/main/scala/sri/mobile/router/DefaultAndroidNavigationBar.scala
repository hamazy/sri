package sri.mobile.router

import sri.core.ElementFactory._
import sri.core.ReactComponent
import sri.mobile._
import sri.mobile.apis.android.BackAndroid
import sri.mobile.components._
import sri.mobile.components.android.ToolbarAndroid
import sri.mobile.styles.MobileStyleSheet

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined


object DefaultAndroidNavigationBar {

  var rctrl: MobileRouterCtrl = _

  BackAndroid.addEventListener("hardwareBackPress", () => {
    if (rctrl != null && rctrl.navigator.getCurrentRoutes().length > 1) {
      rctrl.navigator.pop()
      true
    } else false
  })

  @ScalaJSDefined
  class Component extends MobileRouterComponent[Props, Unit] {
    def render() = {
      val androidback : js.UndefOr[ImageSource] = if (showBackButton()) ImageSource.fromJson(js.Dynamic.global.require("image!android_back_white")) else js.undefined
      ToolbarAndroid(
        style = props.style.toolbar,
        actions = Seq(),
        navIcon = androidback,
        onIconClicked = () => navigateBack(),
        titleColor = "white",
        title = props.route.title.toString)()
    }

    override def componentDidMount(): Unit = {
      rctrl = getRouterCtrl()
    }
  }

  /**
   * style for navigation bar
   */
  trait Style extends MobileStyleSheet {

    def toolbar = style(
      height := 56,
      backgroundColor := "#a9a9a9"
    )

  }

  object DefaultTheme extends Style {

    override val toolbar = super.toolbar

  }

  case class Props(route: NavigatorRoute, style: Style)

  js.constructorOf[Component].contextTypes = router.routerContextTypes

  val factory = getComponentFactory(js.constructorOf[Component], classOf[Component])

  def apply(route: NavigatorRoute, style: Style = DefaultTheme, key: U[String] = js.undefined, ref: js.Function1[Component,_] = null) = createElement(factory, props = Props(route, style), key = key, ref = ref)

}