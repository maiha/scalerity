package sc.ala.test

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import com.gargoylesoftware.htmlunit.BrowserVersion

import sc.ala.scalerity.Locator
import sc.ala.scalerity.Locator._

class LocatorTest extends FunSuite with ShouldMatchers {
  test("by id")    { expect("foo") { Locator("id=foo").value } }
  test("by name")  { expect("foo") { Locator("name=foo").value } }
  test("by label") { expect("foo") { Locator("label=foo").value } }
  test("by value") { expect("foo") { Locator("value=foo").value } }

  test("cannot resolve") {
    evaluating { Locator("foo=id") } should produce [CannotResolve]
  }
}
