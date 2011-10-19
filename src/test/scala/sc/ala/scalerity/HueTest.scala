package sc.ala.test

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class HueTest extends FunSuite with ShouldMatchers with HtmlResource {
  def page = open("google-preferences.html")

  test("get hidden value") {
    expect("0_339") { page("input").withName("sig").value }
  }

}
