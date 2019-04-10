package sample;

import com.nlf.calendar.Lunar;

import static org.junit.Assert.assertEquals;

/**
 * 农历示例
 */
public class LunarTest {

    private Object[][] data = new Object[][]{
            {1986, 4, 21, "1986-05-30"}
    };

  @Test
  public void givenLunarWhenConverToSolarThenEquals() {
      Lunar date = new Lunar(Integer.parseInt(data[0][0].toString()), Integer.parseInt(data[0][1].toString()), Integer.parseInt(data[0][2].toString()));
      assertEquals(data[0][3].toString(), date.getSolar().next(1).toString());
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

}
