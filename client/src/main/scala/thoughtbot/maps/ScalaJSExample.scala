package thoughtbot.maps

import thoughtbot.maps.shared.SharedMessages
import org.scalajs.dom
import scala.scalajs.js
import org.scalajs.dom
import org.singlespaced.d3js.d3
import org.singlespaced.d3js.Ops._

object ScalaJSExample extends js.JSApp {

  def main() = {
    dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
    println("Scala JS is working")
  }
}
