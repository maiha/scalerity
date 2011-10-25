package sc.ala.scalerity

/**
 * Created by IntelliJ IDEA.
 * User: maiha
 * Date: 11/10/10
 * Time: 9:32
 * To change this template use File | Settings | File Templates.
 */

trait TODO {

  // not implemented yet
  def clickAndWait = notImplementedYet("clickAndWait")

  def notImplementedYet(name:String) =
    sys.error("[%s] is not implemented yet".format(name))
}
