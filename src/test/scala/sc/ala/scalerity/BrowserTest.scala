package sc.ala.test

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import sc.ala.scalerity._
import sc.ala.scalerity.browser._
import com.gargoylesoftware.htmlunit.BrowserVersion

class BrowserTest extends FunSuite with ShouldMatchers {
  val google = "http://www.google.com"

  test("default browserVersion") {
    expect(BrowserVersion.FIREFOX_3_6) { new Browser().browserVersion }
  }

  test("goto returns the url") {
    expect(google) { new Browser().goto(google) }
  }

  test("html") {
    Browser(google).html should not be('empty)
  }

  test("html without url") {
    val b = new Browser
    evaluating { b.html } should produce [PageNotFound]
  }
}
