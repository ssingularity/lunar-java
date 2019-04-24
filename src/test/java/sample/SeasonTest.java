package sample;

import com.nlf.calendar.Solar;
import com.nlf.calendar.SolarHalfYear;
import com.nlf.calendar.SolarMonth;
import com.nlf.calendar.SolarSeason;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.nlf.calendar.SolarSeason.*;
import static com.nlf.calendar.SolarSeason.fromYm;
import static org.junit.Assert.assertEquals;

/**
 * 季度示例
 */
public class SeasonTest {
  private Object[][] data = new Object[][]{
          //强一般等价类 P73
          {6, 2000, "2000.3"},
          {6, 1996, "1996.3"},
          {6, 2002, "2002.3"},
          {6, 2000, "2000.3"},
          {6, 1996, "1996.3"},
          {6, 2002, "2002.3"},
          {6, 2000, "2000.3"},
          {6, 1996, "1996.3"},
          {6, 2002, "2002.3"},
          {6, 2000, "2000.3"},
          {6, 1996, "1996.3"},
          {6, 2002, "2002.3"},
          {7, 2000, "2000.4"},
          {7, 1996, "1996.4"},
          {7, 2002, "2002.4"},
          {7, 2000, "2000.4"},
          {7, 1996, "1996.4"},
          {7, 2002, "2002.4"},
          {7, 2000, "2000.4"},
          {7, 1996, "1996.4"},
          {7, 2002, "2002.4"},
          {7, 2000, "2000.4"},
          {7, 1996, "1996.4"},
          {7, 2002, "2002.4"},
          {2, 2000, "2000.2"},
          {2, 1996, "1996.2"},
          {2, 2002, "2002.2"},
          {2, 2000, "2000.2"},
          {2, 1996, "1996.2"},
          {2, 2002, "2002.2"},
          {2, 2000, "2000.2"},
          {2, 1996, "1996.2"},
          {2, 2002, "2002.2"},
          {2, 2000, "2000.2"},
          {2, 1996, "1996.2"},
          {2, 2002, "2002.2"},
  };
  @org.junit.Test
  public void test(){
    for (Object[] test : data) {
      SolarSeason season = new SolarSeason(Integer.parseInt(test[1].toString()), Integer.parseInt(test[0].toString()));
      assertEquals(test[2].toString(), season.next(1).toString());
    }
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
    SolarSeason  season= fromDate(date);
    assertEquals("2002年3季度", season.toFullString());
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
    SolarSeason  season = fromCalendar(calendar);
    assertEquals("2002.3", season.toString());
  }

  @Test
  public void givenNormalDateWhenFromYmThenSuccess(){
    SolarSeason  season = fromYm(2002,7);
    assertEquals(2002,season.next(0).getYear());
    assertEquals(7,season.getMonth());
  }

  @Test
  public void givenNormalDateWhenGetMonthsThenSuccess(){
    SolarSeason  season = fromYm(2002,7);
    List<SolarMonth> l = new ArrayList<SolarMonth>(31);
    try
    {
      l = season.getMonths();
    }catch(Exception e)
    {
      e.printStackTrace();
    }
    assertEquals("2002-7",l.get(0).toString());
  }
}
