package sc.ala.test

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfterEach
import org.scalatest.matchers.ShouldMatchers

import sc.ala.scalerity.Browser
import sc.ala.scalerity.Selenium.Conversions._


class SeleniumTest extends FunSuite with ShouldMatchers with HtmlResource
with BeforeAndAfterEach {
  private var page:Browser = _

  override def beforeEach() {
    page = open("google-preferences.html")
  }

  def forms = page.page.getForms
  def form = forms.get(0)             // HtmlForm
  def request = form.getWebRequest(firstSubmittable)

  import com.gargoylesoftware.htmlunit.html.SubmittableElement
  def firstSubmittable = page("form input,select").getElement(0) match {
    case e:SubmittableElement => e
    case _ => sys.error("no submittable elements")
  }

  //////////////////////////////////////////////////
  // INPUT HIDDEN form
  // <input type="hidden" value="0_339" name="sig">

  test("get hidden value by selenium") {
    expect("0_339") { page("name=sig").value }
  }

  //////////////////////////////////////////////////
  // SELECT form
  // <select name="hl">
  /*
    [English  ]
    ┌─────────┐
    │Afrikaans│
    │English  │
    │Japanese │
    │Korean   │
    └─────────┘
  */

  test("get selected value by selenium") {
    expect("en") { page.select("name=hl").value }
  }

  test("get selected label by selenium") {
    expect("English") { page.select("name=hl").label }
  }

  test("set selected value by selenium with label") {
    expect("ja") {
      page.select("name=hl", "label=Japanese")
      page.select("name=hl").value
    }
  }

  test("set selected value by selenium with value") {
    expect("ja") {
      page.select("name=hl", "value=ja")
      page.select("name=hl").value
    }
  }

}
