package sc.ala.scalerity


/**
 * Created by IntelliJ IDEA.
 * User: maiha
 * Date: 11/10/07
 * Time: 4:42
 * To change this template use File | Settings | File Templates.
 */

import sc.ala.scalerity.Locator.CannotResolve

sealed abstract class Locator { def value: String }
case class ById(value:String) extends Locator
case class ByName(value:String) extends Locator
case class ByLabel(value:String) extends Locator
case class ByValue(value:String) extends Locator


object Locator {

  class CannotResolve(msg:String) extends RuntimeException(msg)

  val R_ID    = """^id=(\w+)$""" r
  val R_NAME  = """^name=(\w+)$""" r
  val R_LABEL = """^label=(\w+)$""" r
  val R_VALUE = """^value=(\w+)$""" r

  def test(source:String) = source match {
    case R_ID(value) => Some(ById(value))
    case R_NAME(value) => Some(ByName(value))
    case R_LABEL(value) => Some(ByLabel(value))
    case R_VALUE(value) => Some(ByValue(value))
    case _ => None
  }

  def apply(source:String) = test(source).getOrElse{
    throw new CannotResolve(source)
  }

  // def unapply()
}