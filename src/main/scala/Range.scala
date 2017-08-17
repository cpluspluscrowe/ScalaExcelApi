import org.apache.poi.hssf.util.CellReference
import org.apache.poi.xssf.usermodel.XSSFSheet

class Sheet extends XSSFSheet(){
  private var Range:_Range = _;
  def Range(address:String): _Range ={
    val cellReference:CellReference = new CellReference(address);
    this.Range = new _Range(cellReference);
    return this.Range;
  }
  def Range(row:Int,column:Int): _Range ={
    val cellReference:CellReference = new CellReference(row,column);
    this.Range = new _Range(cellReference);
    return this.Range;
  }
}

class _Range() {
  var Value:String = _;
  var Address:String = _;
  var Column:Int = _;
  var Row:Int = _;
  def this(cellReference: CellReference){
    this();
  }
}
