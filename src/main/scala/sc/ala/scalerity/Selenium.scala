package sc.ala.scalerity

/**
 * Created by IntelliJ IDEA.
 * User: maiha
 * Date: 11/10/07
 * Time: 4:05
 * To change this template use File | Settings | File Templates.
 */

import com.gargoylesoftware.htmlunit.html.HtmlPage
import com.gargoylesoftware.htmlunit.html.HtmlElement
import com.gargoylesoftware.htmlunit.html.HtmlSelect
import com.gargoylesoftware.htmlunit.html.HtmlOption
import be.roam.hue.doj._

class ElementNotFound(msg:String) extends RuntimeException(msg)
class OptionNotFound(msg:String) extends RuntimeException(msg)

object Selenium {
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
  }

  object Conversions {
    implicit def htmlSelectToSelect(e: HtmlSelect) = Select(e)
  }
}

trait Selenium { this: Browser =>
  def apply(key:String) = Locator(key) match {
    case ById(id) => Doj.on(page).get("#" + id)
    case ByName(name) => Doj.on(page).get("input,select").withAttribute("name", name)
    case l:Locator => notImplementedYet("apply: " + l)
    case _ =>
      Doj.on(page).get(key)
  }

  def open(url:String) = goto(url)

  def select(key:String, value:String): HtmlOption = Locator(value) match {
    case ByLabel(label) =>
      val sel = select(key)
      sel.getOptionByText(label) match {
        case opt:HtmlOption =>
          sel.setSelectedAttribute(opt, true)
          opt
        case _ => optionNotFound(key + "=>" + value)
      }
    case ByValue(v) =>
      val sel = select(key)
      sel.getOptionByValue(v) match {
        case opt:HtmlOption =>
          sel.setSelectedAttribute(opt, true)
          opt
        case _ => optionNotFound(key + "=>" + value)
      }
    case l:Locator => notImplementedYet("select: " + l)
    case _ => optionNotFound(key + "=>" + value)
  }

  def select(locator:String): HtmlSelect = element(locator) match {
    case s:HtmlSelect  => s
    case e:HtmlElement =>
      elementNotFound("[%s] expected Select, but got %s".format(locator, e.getClass.getName))
  }

  def element(locator:String): HtmlElement = (Locator(locator) match {
    case ById(id)     => page.getElementById(id)
    case ByName(name) => page.getElementByName(name)
    case l:Locator => notImplementedYet("element: " + l)
  }) match {
    case e:HtmlElement => e
    case _ => elementNotFound(locator)
  }


  protected def elementNotFound(key:String) = throw new ElementNotFound(key)
  protected def optionNotFound(key:String)  = throw new OptionNotFound(key)

  //  page.getElementById()

}