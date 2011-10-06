/**
 * Created by IntelliJ IDEA.
 * User: maiha
 * Date: 11/09/27
 * Time: 14:11
 * To change this template use File | Settings | File Templates.
 */


package sc.ala.scalerity.browser

import com.gargoylesoftware.htmlunit.html.HtmlPage

import sc.ala.scalerity._

trait Action { this: Browser =>
  def goto(url: String) = {
    val uri = url match {
      case u:String if u.contains("://") => u
      case u:String => "http://" + u
    }

    pagable = Some(client.getPage[HtmlPage](uri))
    this.url
  }

  // def source =
}