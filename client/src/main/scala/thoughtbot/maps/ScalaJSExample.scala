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
    val graphHeight = 450
    val barWidth = 80
    val barSeparation = 10
    val maxData = 50
    val horizontalBarDistance = barWidth + barSeparation
    val barHeightMultiplier = graphHeight / maxData;
    dom.document.getElementById("scalajsShoutOut").textContent = SharedMessages.itWorks
    //Color for start
    val c = d3.rgb("DarkSlateBlue")

    val rectXFun = (d: Int, i: Int) => i * horizontalBarDistance
    val rectYFun = (d: Int) => graphHeight - d * barHeightMultiplier
    val rectHeightFun = (d: Int) => d * barHeightMultiplier
    val rectColorFun = (d: Int, i: Int) => c.brighter(i * 0.5).toString

    val svg = d3.select("body").append("svg").attr("width", "100%").attr("height", "450px")
    val sel = svg.selectAll("rect").data(js.Array(8, 22, 31, 36, 48, 17, 25))
    sel.enter()
      .append("rect")
      .attr("x", rectXFun)
      .attr("y", rectYFun)
      .attr("width", barWidth)
      .attr("height", rectHeightFun)
      .style("fill", rectColorFun)
  }
}
