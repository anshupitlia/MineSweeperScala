import org.scalatest.FlatSpec

import scala.collection.mutable.ListBuffer

trait MockOutput extends Output {
  var messages: String = ""


  override def print(s: String) = messages = s
}
class BoardSpec extends FlatSpec {
  "A Board" should "be masked and show 'X'" in {
    val board = new Board(ListBuffer(ListBuffer(MineCell("X")))) with MockOutput
    board.show()
    assert(board.messages.equals("X"))
  }

  "A Board" should "open the non mine cell at a position" in {
    val board = new Board(ListBuffer(ListBuffer(MineCell("X"), NonMineCell("X"))))
    board.show()
    board.open(0, 1)
    board.show()
  }
  "A Board" should "flag the corresponding cells at a position" in {
    val board = new Board(ListBuffer(ListBuffer(MineCell("X"), NonMineCell("X"))))
    board.show()
    board.flag(0, 1)
    board.show()
  }
  "A Board" should "tell the number of cells flagged" in {
    val board = new Board(ListBuffer(ListBuffer(MineCell("X"), NonMineCell("X"), NonMineCell("X"))))
    board.show()
    board.flag(0, 1)
    board.flag(0, 2)
    assert(board.countFlagged().equals(2))
  }
}
