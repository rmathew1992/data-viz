package thoughtbot.maps.controllers

import javax.inject._
import scala.concurrent.ExecutionContext
import scala.io.Source
import akka.stream.scaladsl.{Source => AkkaSource, Sink}
import akka.util.ByteString
import akka.stream.Materializer
import akka.stream.alpakka.csv.scaladsl.{CsvParsing, CsvToMap}

import thoughtbot.maps.shared.SharedMessages
import play.api.mvc._

@Singleton
class Application @Inject()(cc: ControllerComponents)(implicit m: Materializer, ec: ExecutionContext) extends AbstractController(cc) {
  def index() = Action {
    val url  = "https://raw.githubusercontent.com/zygmuntz/goodbooks-10k/master/ratings.csv"
    val bufferedSource = Source.fromURL(url)
    for {
      dataMap <- AkkaSource
        .single(bufferedSource)
        .via(CsvParsing.lineScanner())
        .via(CsvToMap.toMap())
        .runWith(Sink.head)
    } yield {
      println("Data Map", dataMap)
    }
    Ok(views.html.index(SharedMessages.itWorks))
  }
}

// AkkaSource.single(ByteString("eins,zwei,drei\n"))
//   .via(CsvParsing.lineScanner())
//   .runWith(Sink.head)
// Import file and print
// val filename = "/Users/rachelmathew/ratings.csv"
// val bufferedSource = Source.fromFile(filename)
// for (line <- Source.fromFile(filename).getLines) {
//     println(line)
// }
