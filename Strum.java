public class Strum
{
    private StrumType strumType;
    private int duration;
    public Strum(StrumType strumType, int duration)
    {
        this.duration = duration;
        this.strumType = strumType;
    }
    
    public StrumType getStrumType()
    {
        return strumType;
    }
    
    public void setStrumType(StrumType strumType)
    {
        this.strumType = strumType;
    }
    
    public int getDuration()
    {
        return duration;
    }
    
    public void setDuration(int duration)
    {
        this.duration = duration;
    }
}