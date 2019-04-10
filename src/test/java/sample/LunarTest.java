package sample;

import com.nlf.calendar.Lunar;
import org.junit.Assert;
import org.junit.Test;

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
    public void givenLunarAndLunarSolarNotInSameYearWhenConvertToSolarThenEquals() {
        Lunar date = new Lunar(1986, 12, 3);
        assertEquals("1987-01-02", date.getSolar().toString());
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
    public void givenLunarDateWhenToFullStringThenSuccess(){
      Lunar date = new Lunar(2018, 2, 2);
      Assert.assertEquals("戊戌年贰月初二 狗年 (龙头节) 西方白虎 娄金狗", date.toFullString());
    }

}
