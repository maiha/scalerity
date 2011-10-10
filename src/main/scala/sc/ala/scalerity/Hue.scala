package sc.ala.scalerity.browser

import be.roam.hue.doj._
import sc.ala.scalerity.Browser

/**
 * Created by IntelliJ IDEA.
 * User: maiha
 * Date: 11/10/07
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 */


trait Hue { this: Browser =>

  def apply(key:String) = Doj.on(page).get(key)

}