package sample;

import com.nlf.calendar.Lunar;
import com.nlf.calendar.Solar;
import com.nlf.calendar.SolarWeek;
import com.nlf.calendar.util.SolarUtil;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.nlf.calendar.SolarWeek.*;
import static org.junit.Assert.assertEquals;

/**
 * 周示例
 */
public class WeekTest {
    private Object[][] data = new Object[][]{
            {6, 14, 2000, "2000.6.4"},
            {6, 14, 1996, "1996.6.4"},
            {6, 14, 2002, "2002.6.4"},
            {6, 29, 2000, "2000.7.2"},
            {6, 29, 1996, "1996.7.1"},
            {6, 29, 2002, "2002.7.1"},
            {6, 30, 2000, "2000.7.2"},
            {6, 30, 1996, "1996.7.1"},
            {6, 30, 2002, "2002.7.1"},
            {6, 31, 2000, "2000.7.2"},
            {6, 31, 1996, "1996.7.2"},
            {6, 31, 2002, "2002.7.2"},
            {7, 14, 2000, "2000.7.4"},
            {7, 14, 1996, "1996.7.3"},
            {7, 14, 2002, "2002.7.3"},
            {7, 29, 2000, "2000.8.1"},
            {7, 29, 1996, "1996.8.2"},
            {7, 29, 2002, "2002.8.2"},
    };

    @org.junit.Test
    public void test() {
        for (Object[] test : data) {
            SolarWeek week = new SolarWeek(Integer.parseInt(test[2].toString()), Integer.parseInt(test[0].toString()), Integer.parseInt(test[1].toString()), 1);
            assertEquals(test[3].toString(), week.next(1, false).toString());
        }
    }

    @Test
    public void givenNormalDateWhenSolarWeekThenSuccess(){
        String dateString = "2002-07-29";
        Date date=null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SolarWeek week = new SolarWeek(date,1);
        assertEquals("2002.7.5", week.toString());
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
        SolarWeek week = fromDate(date,1);
        assertEquals("2002.7.5", week.toString());
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
        SolarWeek week = fromCalendar(calendar,1);
        assertEquals("2002.7.5", week.toString());
    }

    @Test
    public void givenNormalDateWhenFromYmdThenSuccess(){
        SolarWeek week = fromYmd(2002,7,29,1);
        assertEquals("2002.7.5", week.toString());
        assertEquals(2002,week.getYear());
        assertEquals(7,week.getMonth());
        assertEquals(29,week.getDay());
        assertEquals(1,week.getStart());
    }

    @Test
    public void givenNormalDateWhenNextThenSuccess(){
        SolarWeek week = fromYmd(2002,7,29,1);
        assertEquals("2002.7.5", week.next(0,true).toString());
        assertEquals("2002.9.3", week.next(8, true).toString());
        assertEquals("2002.4.4", week.next(-16, true).toString());
        week = fromYmd(2002,7,29,7);
        assertEquals("2002.7.4", week.next(0,true).toString());
        assertEquals("2002.9.3", week.next(8, true).toString());
        assertEquals("2002.4.4", week.next(-16, true).toString());
    }

    @Test
    public void givenNormalDateWhenGetFirstDayInMonthThenSuccess(){
        SolarWeek week = fromYmd(2002,7,29,1);
        assertEquals("2002-07-29", week.getFirstDayInMonth().toString());
    }

    @Test
    public void givenNormalDateWhenGetDaysInMonthThenSuccess(){
        SolarWeek week = fromYmd(2002,7,29,1);
        List<Solar> l = week.getDaysInMonth();
        assertEquals("2002-07-29", l.get(0).toString());
        assertEquals("2002-07-30", l.get(1).toString());
        assertEquals("2002-07-31", l.get(2).toString());
    }

    @Test
    public void givenNormalDateWhenToFullStringThenSuccess(){
        SolarWeek week = fromYmd(2002,7,29,1);
        assertEquals("2002年7月第5周", week.toFullString());
    }
}
