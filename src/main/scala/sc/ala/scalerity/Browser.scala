package sc.ala.scalerity

import com.gargoylesoftware.htmlunit.WebClient
import com.gargoylesoftware.htmlunit.html.{HtmlPage,HtmlElement}
import com.gargoylesoftware.htmlunit.BrowserVersion

import sc.ala.scalerity.browser._

class Browser extends Core with Action with Selenium with Hue with TODO {
  // configurable options
  def browser = "firefox"
}

object Browser {
  def apply(url: String) = start(url)

  def start(url: String) = {
    val browser = new Browser()
    browser.goto(url)
    browser
  }

  // For debug
  def google = apply("http://www.google.com")
}

