package sc.ala.scalerity

import com.gargoylesoftware.htmlunit.html.HtmlPage
import com.gargoylesoftware.htmlunit.html.HtmlSelect


/**
 * Created by IntelliJ IDEA.
 * User: maiha
 * Date: 11/10/25
 * Time: 15:28
 * To change this template use File | Settings | File Templates.
 */

object Conversions {
  implicit def htmlSelectToSelect(e: HtmlSelect) = Select(e)


  case class Page(element: HtmlPage) {
    def foo = 1

  }
  implicit def htmlPageToPage(p: HtmlPage) = Page(p)
}