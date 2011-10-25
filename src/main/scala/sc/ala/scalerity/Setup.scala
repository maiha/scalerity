/**
 * Created by IntelliJ IDEA.
 * User: maiha
 * Date: 11/09/27
 * Time: 14:17
 * To change this template use File | Settings | File Templates.
 */



package sc.ala.scalerity

import com.gargoylesoftware.htmlunit.html.HtmlPage
import com.gargoylesoftware.htmlunit.{WebClient, BrowserVersion}

trait Setup { this: Core =>

  def browser : String

  def browserVersion = browser match {
    case ("firefox"|"ff") => BrowserVersion.FIREFOX_3_6
    case ("internet_explore"|"ie") => BrowserVersion.INTERNET_EXPLORER_7
    case "ie6" => BrowserVersion.INTERNET_EXPLORER_6
    case "ie7" => BrowserVersion.INTERNET_EXPLORER_7
    case "ie8" => BrowserVersion.INTERNET_EXPLORER_8
    case _ => BrowserVersion.FIREFOX_3_6
  }

  protected def buildClient = {
    val wc = new WebClient(browserVersion)
    setupClient(wc)
    wc
  }

  protected def setupClient(wc: WebClient) {
    wc.setJavaScriptEnabled(true)
  }
}