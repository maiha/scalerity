package sc.ala.test

import sc.ala.scalerity.Browser

trait HtmlResource {
  def file(path:String) = "file://%s/%s".format(dir, path)
  def open(path:String) = (new Browser).open(file(path))
  private def root = System.getProperty("user.dir")
  private def dir  = "%s/src/test/resources/html".format(root)
}
