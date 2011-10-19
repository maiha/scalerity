package sc.ala.scalerity.browser

import be.roam.hue.doj._
import sc.ala.scalerity._

/**
 * Created by IntelliJ IDEA.
 * User: maiha
 * Date: 11/10/07
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 */


trait Hue { this: Browser =>

  def apply(key:String) = Doj.on(page).get(resolveLocator(key))

  protected def resolveLocator(key:String) = Locator.test(key) match {
    case Some(ByName(value)) => "input[name='%s']".format(value)
    case None => key
  }

}