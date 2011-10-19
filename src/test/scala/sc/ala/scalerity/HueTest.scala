package sc.ala.test

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class HueTest extends FunSuite with ShouldMatchers with HtmlResource {
  def page = open("google-preferences.html")

  test("get hidden value by hue") {
    expect("0_339") { page.doj.get("input").withName("sig").value }
  }

  test("get hidden value by css") {
    pending
//    expect("0_339") { page("input[name=sig]").value }
  }

  test("get selected value by hue") {
    pending
    // following code returns null. Hue bug?
    // expect("en") { page.doj.get("select").withName("hl").value }
  }
}
