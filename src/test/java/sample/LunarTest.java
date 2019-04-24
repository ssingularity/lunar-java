package sample;

import com.nlf.calendar.Lunar;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * 农历示例
 */
public class LunarTest {
    @Test
    public void givenLunarAndLunarSolarInSameYearWhenConvertToSolarThenEquals() {
      Lunar date = new Lunar(1986, 4, 21);
      assertEquals("1986-05-29", date.getSolar().toString());
    }

    @Test
    public void givenLunarWhenLunarThenEquals() {
        String dateString = "1986-04-21";
        Date date=null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Lunar lunar = new Lunar(date);
        assertEquals("1986-04-21", lunar.getSolar().toString());
        lunar = Lunar.fromDate(date);
        assertEquals("1986-04-21", lunar.getSolar().toString());
        lunar = Lunar.fromYmd(1986,4,21);
        assertEquals(1986,lunar.getYear());
        assertEquals(4,lunar.getMonth());
        assertEquals(21, lunar.getDay());
        assertEquals("1986-05-29", lunar.getSolar().toString());
    }

    @Test
    public void givenLunarAndLunarSolarNotInSameYearWhenConvertToSolarThenEquals() {
        Lunar date = new Lunar(1986, 12, 3);
        assertEquals("1987-01-02", date.getSolar().toString());
    }

    @Test
    public void givenNormalLunarDateWhenToStringThenSuccess(){
        Lunar date = new Lunar(2000, 3, 29);
        assertEquals("庚辰年叁月廿九", date.toString());
    }

    @Test(expected = Exception.class)
    public void givenNegativeMonthWhenInitializeThenThrowException(){
      Lunar date = new Lunar(2000, -1, 20);
    }


    @Test(expected = Exception.class)
    public void givenNegativeYearWhenInitializeThenThrowException(){
      Lunar date = new Lunar(-1, 10, 20);
    }

    @Test(expected = Exception.class)
    public void givenNegativeDayWhenToStringThenThrowException(){
      Lunar date = new Lunar(2000, 1, -1);
      date.toString();
    }

    @Test
    public void givenLunarDateWithoutFestivalWhenToFullStringThenSuccess(){
        Lunar date = new Lunar(2018, 1, 19);
        Assert.assertEquals("戊戌年正月十九 狗年 南方朱雀 氐土貉", date.toFullString());
}

    @Test
    public void givenLunarDateWithFestivalWhenToFullStringThenSuccess(){
      Lunar date = new Lunar(2018, 2, 2);
      Assert.assertEquals("戊戌年贰月初二 狗年 (龙头节) 西方白虎 娄金狗", date.toFullString());
    }

}
