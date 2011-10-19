package sc.ala.test

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class SeleniumTest extends FunSuite with ShouldMatchers with HtmlResource {
  def page = open("google-preferences.html")

  test("get hidden value by selenium") {
    expect("0_339") { page("name=sig").value }
  }

  test("get selected value by selenium") {
    import sc.ala.scalerity.Selenium.Conversions._
    expect("en") { page("name=hl").value }
  }
}
