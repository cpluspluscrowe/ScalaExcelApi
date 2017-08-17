import org.apache.poi.hssf.util.CellReference
import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.xssf.usermodel.{XSSFCell, XSSFSheet}

class Sheet extends XSSFSheet(){
  protected var Range:_Range = _;
  def Range(address:String): _Range ={
    val cellReference:CellReference = new CellReference(address);
    this.Range = new _Range(this,cellReference);
    return this.Range;
  }
  def Range(row:Int,column:Int): _Range ={
    val cellReference:CellReference = new CellReference(row,column);
    this.Range = new _Range(this,cellReference);
    return this.Range;
  }
}

class _Range(parent:Sheet,cellReference: CellReference) {
  protected val formatter = new DataFormatter;
  protected val Row = parent.getRow(cellReference.getRow);
  if(Row == null){
    parent.createRow(cellReference.getRow);
  }
  protected var _Cell:XSSFCell = Row.getCell(cellReference.getCol);
  if(_Cell == null){
    _Cell = Row.createCell(cellReference.getCol);
  }

  def Address(): String ={
    val address:String = _Cell.getAddress.formatAsString();
    return address;
  }
  def SetValue(newValue:String): Unit ={
    _Cell.setCellValue(newValue);
  }
  def SetValue(newValue:Double): Unit ={
    _Cell.setCellValue(newValue);
  }
  def ValueString(): String ={
    val formattedCellValue = formatter.formatCellValue(_Cell)
    val value:String = formattedCellValue;
    return value;
  }
  def ValueNumber(): Double = {
    val value:Double = _Cell.getNumericCellValue;
    return value;
  }
}
