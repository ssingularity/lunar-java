package sample;

import com.nlf.calendar.*;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.nlf.calendar.SolarYear.*;
import static org.junit.Assert.assertEquals;

/**
 * 年份示例，我们来做一个日历吧
 */
public class YearTest {
    private Object[][] data = new Object[][]{
            {2000, "2001"},
            {1996, "1997"},
            {2002, "2003"},
    };

    @org.junit.Test
    public void test() {
        for (Object[] test : data) {
            SolarYear year = new SolarYear(Integer.parseInt(test[0].toString()));
            assertEquals(test[1].toString(), year.next(1).toString());
        }
    }

    @Test
    public void givenNormalDateWhenSolarYearThenSuccess(){
        String dateString = "2002-07-29";
        Date date=null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SolarYear year = new SolarYear(date);
        assertEquals("2002", year.toString());
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
        SolarYear year = fromDate(date);
        assertEquals("2002", year.toString());
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
        SolarYear year = fromCalendar(calendar);
        assertEquals("2002", year.toString());
    }

    @Test
    public void givenNormalDateWhenFromYearThenSuccess(){
        SolarYear year = fromYear(2002);
        assertEquals(2002,year.getYear());
    }

    @Test
    public void givenNormalDateWhenGetMonthsThenSuccess(){
        SolarYear year = fromYear(2002);
        List<SolarMonth> l = year.getMonths();
        assertEquals("2002-1",l.get(0).toString());
    }

    @Test
    public void givenNormalDateWhenToFullStringThenSuccess(){
        SolarYear year = fromYear(2002);
        assertEquals("2002年",year.toFullString());
    }

}
