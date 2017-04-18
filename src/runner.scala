import scala.collection.mutable.ListBuffer

object runner {
  def main(args: Array[String]): Unit = {
    val board = new Board(ListBuffer(
      ListBuffer(NonMineCell("X"), NonMineCell("X"), NonMineCell("X")),
      ListBuffer(NonMineCell("X"), MineCell("X"), NonMineCell("X")),
      ListBuffer(NonMineCell("X"), NonMineCell("X"), MineCell("X"))
    ))

    board.play(0, 0)
  }
}