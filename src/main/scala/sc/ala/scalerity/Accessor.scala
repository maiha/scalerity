package sc.ala.scalerity

/**
 * Created by IntelliJ IDEA.
 * User: maiha
 * Date: 11/10/06
 * Time: 16:08
 * To change this template use File | Settings | File Templates.
 */


trait Accessor { this: Core =>

  def source = page.asXml.toString
  def url = page.getUrl

}

