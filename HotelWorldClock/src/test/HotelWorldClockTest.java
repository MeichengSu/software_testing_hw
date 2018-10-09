package test;

import org.junit.Before;
import org.junit.Test;
import system.CityClock;
import system.HotelWorldClockSystem;
import system.PhoneClock;
import static org.junit.Assert.assertEquals;

/**
 * Created by smcsvip on 2018/10/9.
 */
public class HotelWorldClockTest {
    private HotelWorldClockSystem hotelWorldClockSystem;
    private PhoneClock phoneClock;

    @Before
    public void init(){
        this.hotelWorldClockSystem = new HotelWorldClockSystem();
        this.phoneClock = new PhoneClock(8);
    }

    @Test
    public void check_if_Mexico_time_is_right(){
        CityClock Mexico = new CityClock(4);
        hotelWorldClockSystem.attach(Mexico);

        phoneClock.setHotelWorldClockSystem(hotelWorldClockSystem);
        phoneClock.setTime(10);

        assertEquals(6,Mexico.getTime());
    }

    @Test
    public void check_if_NY_time_is_right(){
        CityClock NewYork = new CityClock(-5);
        hotelWorldClockSystem.attach(NewYork);

        phoneClock.setHotelWorldClockSystem(hotelWorldClockSystem);
        phoneClock.setTime(8);

        assertEquals(19,NewYork.getTime());
    }

    @Test
    public void check_if_servant_setTime_works(){
        phoneClock.setHotelWorldClockSystem(hotelWorldClockSystem);
        phoneClock.setTime(13);

        assertEquals(13,phoneClock.getTime());
    }

    @Test
    public void check_if_phone_correction_works(){
        CityClock London = new CityClock(0);
        CityClock Beijing = new CityClock(8);
        CityClock Mexico = new CityClock(4);
        CityClock Sydney = new CityClock(10);
        CityClock NewYork = new CityClock(-5);

        hotelWorldClockSystem.attach(London);
        hotelWorldClockSystem.attach(Beijing);
        hotelWorldClockSystem.attach(Mexico);
        hotelWorldClockSystem.attach(Sydney);
        hotelWorldClockSystem.attach(NewYork);

        phoneClock.setHotelWorldClockSystem(hotelWorldClockSystem);
        phoneClock.setTime(10);

        assertEquals(2,London.getTime());
        assertEquals(10,Beijing.getTime());
        assertEquals(6,Mexico.getTime());
        assertEquals(12,Sydney.getTime());
        assertEquals(21,NewYork.getTime());
    }
}
