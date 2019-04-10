package sample;

import com.nlf.calendar.Lunar;
import com.nlf.calendar.Solar;
import org.junit.Test;


import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * 阳历示例
 */

public class SolarTest {
    private Object[][] data = new Object[][]{
            //强一般等价类 P73
            {6, 14, 2000, "2000-06-15"},
            {6, 14, 1996, "1996-06-15"},
            {6, 14, 2002, "2002-06-15"},
            {6, 29, 2000, "2000-06-30"},
            {6, 29, 1996, "1996-06-30"},
            {6, 29, 2002, "2002-06-30"},
            {6, 30, 2000, "2000-07-01"},
            {6, 30, 1996, "1996-07-01"},
            {6, 30, 2002, "2002-07-01"},
            {7, 14, 2000, "2000-07-15"},
            {7, 14, 1996, "1996-07-15"},
            {7, 14, 2002, "2002-07-15"},
            {7, 29, 2000, "2000-07-30"},
            {7, 29, 1996, "1996-07-30"},
            {7, 29, 2002, "2002-07-30"},
            {7, 30, 2000, "2000-07-31"},
            {7, 30, 1996, "1996-07-31"},
            {7, 30, 2002, "2002-07-31"},
            {7, 31, 2000, "2000-08-01"},
            {7, 31, 1996, "1996-08-01"},
            {7, 31, 2002, "2002-08-01"},
            {2, 14, 2000, "2000-02-15"},
            {2, 14, 1996, "1996-02-15"},
            {2, 14, 2002, "2002-02-15"},
    };

    @Test
    public void givenDifferentDateWhenNextThenReturnNextDate() throws Exception{
        for (Object[] test : data) {
            Solar date = new Solar(Integer.parseInt(test[2].toString()), Integer.parseInt(test[0].toString()), Integer.parseInt(test[1].toString()));
            assertEquals(test[3].toString(), date.next(1).toString());
        }
    }

    @Test(expected = Exception.class)
    public void givenNegativeYearWhenInitializeThenThrowException() throws Exception{
        Solar date = new Solar(-1, 1, 20);
    }

    @Test(expected = Exception.class)
    public void givenNegativeMonthWhenInitializeThenThrowException() throws Exception{
        Solar date = new Solar(2000, -1, 20);
    }

    @Test(expected = Exception.class)
    public void givenNegativeDayWhenInitializeThenThrowException() throws Exception{
        Solar date = new Solar(2000, 2, -1);
    }

    @Test(expected = Exception.class)
    public void givenOverflowMonthWhenInitializeThenThrowException() throws Exception{
        Solar date = new Solar(2000, 13, 2);
    }

    @Test(expected = Exception.class)
    public void givenOverflowDayAndMonthIsNotFebAndIsBigMonthWhenInitializeThenThrowException() throws Exception{
        Solar date = new Solar(2000, 3, 32);
    }

    @Test(expected = Exception.class)
    public void givenOverflowDayAndMonthIsNotFebAndIsSmallMonthWhenInitializeThenThrowException() throws Exception{
        Solar date = new Solar(2000, 4, 31);
    }

    @Test
    public void givenNormalDayAndMonthIsFebAndIsYeapYearWhenInitializeThenSuccess() throws Exception{
        Solar date = new Solar(1996, 2, 29);
        assertEquals("1996-02-29", date.toString());
    }

    @Test(expected = Exception.class)
    public void givenOverFlowDayAndMonthIsFebAndIsYeapYearWhenInitializeThenThrowException() throws Exception{
        Solar date = new Solar(1996, 2, 30);
    }

    @Test(expected = Exception.class)
    public void givenOverFlowDayAndMonthIsFebAndIsNotYeapYearWhenInitializeThenThrowException() throws Exception{
        Solar date = new Solar(2001, 2, 29);
    }

    @Test
    public void givenNormalLunarDateWhenToStringThenSuccess() throws Exception{
        Solar date = new Solar(2001, 3, 28);
        assertEquals("2001-03-28", date.toString());
    }


    @Test
    public void givenSolarAndLunarSolarInSameYearWhenConvertToLunarThenSuccess() throws Exception{
        Solar date = new Solar(2019, 3, 5);
        assertEquals("己亥年正月廿九", date.getLunar().toString());
    }

    @Test
    public void givenSolarAndLunarSolarNotInSameYearWhenConvertToLunarThenSuccess() throws Exception{
        Solar date = new Solar(2019, 2, 3);
        assertEquals("戊戌年腊月廿九", date.getLunar().toString());
    }

    @Test
    public void givenNormalSolarWhenToFullStringThenSuccess() throws Exception{
        Solar date = new Solar(2019, 1, 19);
        assertEquals("2019-01-19 星期六 摩羯座", date.toFullString());
    }

    @Test
    public void givenSolarWithDayFixedFestivalWhenToFullStringThenSuccess() throws Exception{
        Solar date = new Solar(2019, 3, 15);
        assertEquals("2019-03-15 星期五 (消费者权益日) 双鱼座", date.toFullString());
    }

    @Test
    public void givenSolarWithNotDayFixedFestivalWhenToFullStringThenSuccess() throws Exception{
        Solar date = new Solar(2019, 5, 12);
        assertEquals("2019-05-12 星期日 (母亲节) 金牛座", date.toFullString());
    }

    @Test
    public void givenSolarWithTwoFestivalWhenGetFestivalSizeThenReturnTwo() throws Exception{
        Solar date = new Solar(2019, 1, 1);
        assertEquals(2, date.getFestivals().size());
    }

}
