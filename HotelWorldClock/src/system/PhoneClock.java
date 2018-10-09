package system;

/**
 * Created by smcsvip on 2018/10/9.
 */
public class PhoneClock extends Clock {
    private int time;
    private HotelWorldClockSystem hotelWorldClockSystem;

    public PhoneClock(int utcOffset){
        super.utcOffset = utcOffset;
    }
    public void setTime(int time){
        this.time = time;
        for(CityClock cityClock : hotelWorldClockSystem.getClocks()){
            cityClock.setUtcZeroTime(time - super.utcOffset);
        }
    }
    public void setHotelWorldClockSystem(HotelWorldClockSystem hotelWorldClockSystem){
        this.hotelWorldClockSystem = hotelWorldClockSystem;
    }

    @Override
    public int getTime() {
        return this.time;
    }
}
