package sc.ala.scalerity


/**
 * Created by IntelliJ IDEA.
 * User: maiha
 * Date: 11/10/07
 * Time: 4:42
 * To change this template use File | Settings | File Templates.
 */

import sc.ala.scalerity.Locator.CannotResolve


object Locator {
  trait Value { def value: String }
  case class ById(value:String) extends Value
  case class ByName(value:String) extends Value
  case class ByLabel(value:String) extends Value
  case class ByValue(value:String) extends Value

  class CannotResolve(msg:String) extends RuntimeException(msg)

  val R_ID    = """^id=(\w+)$""" r
  val R_NAME  = """^name=(\w+)$""" r
  val R_LABEL = """^label=(\w+)$""" r
  val R_VALUE = """^value=(\w+)$""" r

  def apply(source:String) = source match {
    case R_ID(value) => ById(value)
    case R_NAME(value) => ByName(value)
    case R_LABEL(value) => ByLabel(value)
    case R_VALUE(value) => ByValue(value)
    case _ => throw new CannotResolve(source)
  }

  // def unapply()
}