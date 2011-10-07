package sc.ala.test

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import com.gargoylesoftware.htmlunit.BrowserVersion

import sc.ala.scalerity.Browser
import sc.ala.scalerity.browser.PageNotFound

class BrowserTest extends FunSuite with ShouldMatchers {
  val google = "http://www.google.com"

  test("default browserVersion") {
    expect(BrowserVersion.FIREFOX_3_6) { new Browser().browserVersion }
  }

  test("goto returns an url") {
    val b = new Browser
    // don't check url strictly to avoid localized url redirection
    b.goto(google).toString should include("google")
  }

  test("source") {
    Browser(google).source should startWith("<")
  }

  test("source without url") {
    val b = new Browser
    evaluating { b.source } should produce [PageNotFound]
  }
}
