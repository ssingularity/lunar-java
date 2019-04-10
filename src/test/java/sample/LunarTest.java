package sample;

import com.nlf.calendar.Lunar;
import org.junit.Test;

/**
 * 农历示例
 */
public class LunarTest {
  @Test(expected = Exception.class)
  public void givenNegativeDayWhenToStringThenThrowException(){
      Lunar date = new Lunar(2000, 1, -1);
      date.toString();
  }

  @Test(expected = Exception.class)
  public void givenNegativeMonthWhenInitializeThenThrowException(){
      Lunar date = new Lunar(2000, -1, 20);
  }

  @Test(expected = Exception.class)
  public void givenNegativeYearWhenInitializeThenThrowException(){
      Lunar date = new Lunar(-1, 10, 20);
  }
}
