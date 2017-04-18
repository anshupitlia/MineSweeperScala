import org.scalatest.FlatSpec

class MineCellSpec extends FlatSpec{

  "A Mine Cell" should "be masked and show 'X'" in {
    val mineCell = MineCell("X")
    assert(mineCell.show() == "X")
  }

}

