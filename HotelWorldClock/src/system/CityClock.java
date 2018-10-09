package system;

/**
 * Created by smcsvip on 2018/10/9.
 */
public class CityClock extends Clock {
    private int utcZeroTime;
    public CityClock(int utcOffset){
        super.utcOffset = utcOffset;
    }

    @Override
    public int getTime() {
        return (24 + utcZeroTime + super.utcOffset)%24;    //24小时制
    }

    public void setUtcZeroTime(int utcZeroTime){
        this.utcZeroTime = utcZeroTime;
    }
}
