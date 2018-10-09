package system;

/**
 * Created by smcsvip on 2018/10/9.
 */
public abstract class Clock {
    protected int utcOffset;
    public abstract int getTime();
}
