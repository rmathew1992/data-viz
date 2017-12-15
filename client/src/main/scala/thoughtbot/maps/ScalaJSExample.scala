package thoughtbot.maps

import thoughtbot.maps.shared.SharedMessages
import org.scalajs.dom
import scala.scalajs.js
import org.scalajs.dom
import org.singlespaced.d3js.d3
import org.singlespaced.d3js.Ops._
import org.singlespaced.d3js.Ops._
import org.singlespaced.d3js.d3

object ScalaJSExample extends js.JSApp {

  def main(): Unit = {
    val data = js.Array(30,40, 90)
    val scale = d3.scale.linear()
      .domain(js.Array(0, 365))
      .range(js.Array(0, 300))
    val chart = dom.document.getElementById("chart")
    d3.select(chart)
      .selectAll("div")
      .data(data)
      .enter()
      .append("div")
      .style("float", "left")
      .style("height", (d: Int) =>  scale(d) + "px")
      .style("margin", "2px")
      .style("background-color", "blue")
      .text((d: Int) =>  d.toString)
  }
}
