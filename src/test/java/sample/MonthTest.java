package sample;

import com.nlf.calendar.Solar;
import com.nlf.calendar.SolarHalfYear;
import com.nlf.calendar.SolarMonth;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.nlf.calendar.SolarMonth.*;
import static org.junit.Assert.assertEquals;

/**
 * 月份示例
 */
public class MonthTest {
  private Object[][] data = new Object[][]{
          //强一般等价类 P73
          {6, 2000, "2000-7"},
          {6, 1996, "1996-7"},
          {6, 2002, "2002-7"},
          {6, 2000, "2000-7"},
          {6, 1996, "1996-7"},
          {6, 2002, "2002-7"},
          {6, 2000, "2000-7"},
          {6, 1996, "1996-7"},
          {6, 2002, "2002-7"},
          {6, 2000, "2000-7"},
          {6, 1996, "1996-7"},
          {6, 2002, "2002-7"},
          {7, 2000, "2000-8"},
          {7, 1996, "1996-8"},
          {7, 2002, "2002-8"},
          {7, 2000, "2000-8"},
          {7, 1996, "1996-8"},
          {7, 2002, "2002-8"},
          {7, 2000, "2000-8"},
          {7, 1996, "1996-8"},
          {7, 2002, "2002-8"},
          {7, 2000, "2000-8"},
          {7, 1996, "1996-8"},
          {7, 2002, "2002-8"},
          {2, 2000, "2000-3"},
          {2, 1996, "1996-3"},
          {2, 2002, "2002-3"},
          {2, 2000, "2000-3"},
          {2, 1996, "1996-3"},
          {2, 2002, "2002-3"},
          {2, 2000, "2000-3"},
          {2, 1996, "1996-3"},
          {2, 2002, "2002-3"},
          {2, 2000, "2000-3"},
          {2, 1996, "1996-3"},
          {2, 2002, "2002-3"},
  };
  @org.junit.Test
  public void test() {
    for (Object[] test : data) {
      SolarMonth month = new SolarMonth(Integer.parseInt(test[1].toString()), Integer.parseInt(test[0].toString()));
      assertEquals(test[2].toString(), month.next(1).toString());
    }
  }

  @Test
  public void givenNormalDateWhenSolarMonthThenSuccess(){
    String dateString = "2002-07-29";
    Date date=null;
    try {
      date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    SolarMonth month = new SolarMonth(date);
    assertEquals("2002年7月", month.toFullString());
  }

  @Test
  public void givenNormalDateWhenFromDateThenSuccess(){
    String dateString = "2002-07-29";
    Date date=null;
    try {
      date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    SolarMonth month = fromDate(date);
    assertEquals("2002-7", month.toString());
  }

  @Test
  public void givenNormalDateWhenFromCalendarThenSuccess(){
    String dateString = "2002-07-29";
    Date date=null;
    try {
      date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    SolarMonth month = fromCalendar(calendar);
    assertEquals("2002-7", month.toString());
  }

  @Test
  public void givenNormalDateWhenFromYmThenSuccess(){
    SolarMonth month = fromYm(2002,7);
    assertEquals(2002,month.getYear());
    assertEquals(7,month.getMonth());
  }

  @Test
  public void givenNormalDateWhenGetDaysThenSuccess(){
    SolarMonth month = fromYm(2002,7);
    List<Solar> l = new ArrayList<Solar>(31);
    try
    {
      l = month.getDays();
    }catch(Exception e)
    {
      e.printStackTrace();
    }
    assertEquals("2002-07-01",l.get(0).toString());
  }
}
