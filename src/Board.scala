import scala.collection.mutable.ListBuffer

class Board(cells: ListBuffer[ListBuffer[Cell]]) extends Output {
  def open(x: Int, y: Int) = {
    cells(x)(y) = cells(x)(y) match {
      case MineCell("X") | MineCell("F") => {
        print("You bumped on a mine")
        print("Game over")
        System.exit(0)
        MineCell("M")
      }
      case NonMineCell("X") | NonMineCell("F") => {
        NonMineCell("O")
      }
    }
  }

  def countFlagged():Int = {
    var count = 0
    cells.foreach(row => {
      row.foreach(cell => cell match {
        case MineCell("F") | NonMineCell("F") => count = count + 1
        case _ => count
      })
    })
    return count
  }

  def countOpen():Int = {
    var count = 0
    cells.foreach(row => {
      row.foreach(cell => cell match {
        case MineCell("O") | NonMineCell("O") => count = count + 1
        case _ => count
      })
    })
    return count
  }

  def flag(x: Int, y: Int) = {
    cells(x)(y) = cells(x)(y) match {
      case MineCell(_) => {
        MineCell("F")
      }
      case NonMineCell("X") => {
        NonMineCell("F")
      }
    }
  }
  def show() = {
    cells.foreach(row => {
      row.foreach(cell => {
        print(cell.show())
      })
      println()
    })
  }

  def play(flagCount: Int, openCount: Int):Boolean ={
    (flagCount, openCount) match {
      case (2, 7) => {
        print("You won")
        true
      }
      case _ => {
        val input_read = readLine("Enter operation to be performed. \n 1. Open \n 2. Flag\n and press enter \n")
        print(input_read)
        print("enter location")
        val x = readInt()
        val y = readInt()
        print("x: " + x + "y:" + y)
        input_read match {
          case "1" => open(x, y)
          case "2" => flag(x, y)
        }
      }
        show()
        play(countFlagged(), countOpen())
    }
  }
}
