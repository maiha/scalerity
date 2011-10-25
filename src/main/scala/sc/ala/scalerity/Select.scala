package sc.ala.scalerity

import com.gargoylesoftware.htmlunit.html.HtmlSelect

/**
 * Created by IntelliJ IDEA.
 * User: maiha
 * Date: 11/10/25
 * Time: 15:33
 * To change this template use File | Settings | File Templates.
 */

object Select {
  def default = ""
}

case class Select(element: HtmlSelect) {
  def value = {
    val options = element.getSelectedOptions
    options.size match {
      case 0 => Select.default
      case _ => options.get(0).getValueAttribute
    }
  }

  def text = {
    val options = element.getSelectedOptions
    options.size match {
      case 0 => Select.default
      case _ => options.get(0).getText
    }
  }
  def label = text
}

