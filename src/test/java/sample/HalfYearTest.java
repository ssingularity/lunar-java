package sample;

import com.nlf.calendar.*;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.nlf.calendar.SolarHalfYear.*;
import static com.nlf.calendar.SolarHalfYear.fromYm;
import static org.junit.Assert.assertEquals;

/**
 * 半年示例
 */
public class HalfYearTest {
    private Object[][] data = new Object[][]{
            //强一般等价类 P73
            {6, 2000, "2000.2"},
            {6, 1996, "1996.2"},
            {6, 2002, "2002.2"},
            {6, 2000, "2000.2"},
            {6, 1996, "1996.2"},
            {6, 2002, "2002.2"},
            {6, 2000, "2000.2"},
            {6, 1996, "1996.2"},
            {6, 2002, "2002.2"},
            {6, 2000, "2000.2"},
            {6, 1996, "1996.2"},
            {6, 2002, "2002.2"},
            {7, 2000, "2001.1"},
            {7, 1996, "1997.1"},
            {7, 2002, "2003.1"},
            {7, 2000, "2001.1"},
            {7, 1996, "1997.1"},
            {7, 2002, "2003.1"},
            {7, 2000, "2001.1"},
            {7, 1996, "1997.1"},
            {7, 2002, "2003.1"},
            {7, 2000, "2001.1"},
            {7, 1996, "1997.1"},
            {7, 2002, "2003.1"},
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
    public void test() {

        for (Object[] test : data) {
            SolarHalfYear halfYear = new SolarHalfYear(Integer.parseInt(test[1].toString()), Integer.parseInt(test[0].toString()));
            assertEquals(test[2].toString(), halfYear.next(1).toString());
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
        SolarHalfYear  halfYear= fromDate(date);
        assertEquals("2002年下半年", halfYear.toFullString());
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
        SolarHalfYear  halfYear= fromCalendar(calendar);
        assertEquals("2002.2", halfYear.toString());
    }

    @Test
    public void givenNormalDateWhenFromYmThenSuccess(){
        SolarHalfYear  halfYear = fromYm(2002,7);
        assertEquals(2002,halfYear.next(0).getYear());
        assertEquals(7,halfYear.getMonth());
    }

    @Test
    public void givenNormalDateWhenGetMonthsThenSuccess(){
        SolarHalfYear  halfYear = fromYm(2002,7);
        List<SolarMonth> l = new ArrayList<SolarMonth>(31);
        try
        {
            l = halfYear.getMonths();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        assertEquals("2002-7",l.get(0).toString());
    }

}
