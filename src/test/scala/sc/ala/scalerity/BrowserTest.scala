package sc.ala.test

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import com.gargoylesoftware.htmlunit.BrowserVersion

import sc.ala.scalerity._

class BrowserTest extends FunSuite with ShouldMatchers with HtmlResource {
  def localFile = file("google-preferences.html")

  test("default browserVersion") {
    expect(BrowserVersion.FIREFOX_3_6) { new Browser().browserVersion }
  }

  test("goto returns self") {
    val b = new Browser
    expect(b) { b.goto(localFile) }
  }

  test("source") {
    val b = new Browser
    b.open(localFile)
    b.source should startWith("<")
  }

  test("source without url") {
    val b = new Browser
    evaluating { b.source } should produce [PageNotFound]
  }
}
