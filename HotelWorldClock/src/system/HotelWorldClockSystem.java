package system;

import java.util.ArrayList;

/**
 * Created by smcsvip on 2018/10/9.
 */
public class HotelWorldClockSystem {
    private ArrayList<CityClock> cityClocks = new ArrayList<>();

    public void attach(CityClock cityClock){
        this.cityClocks.add(cityClock);
    }
    public ArrayList<CityClock> getClocks(){
        return this.cityClocks;
    }
}
