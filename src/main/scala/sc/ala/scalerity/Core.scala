/**
 * Created by IntelliJ IDEA.
 * User: maiha
 * Date: 11/10/06
 * Time: 16:06
 * To change this template use File | Settings | File Templates.
 */


package sc.ala.scalerity

import com.gargoylesoftware.htmlunit.html.HtmlPage

class PageNotFound(msg:String) extends RuntimeException(msg)

trait Core extends Setup with Accessor {

  // instance variables
  lazy val client = buildClient
  var pagable:Option[HtmlPage] = None

  def page: HtmlPage = pagable match {
    case Some(x:HtmlPage) => x
    case _ => pageNotFound
  }

  def pageNotFound: Nothing = {
    throw new PageNotFound("No pages are loaded yet")
  }

}

