
public class time {
	public int hour;
	private int min;
	private int sec;
	
	public time(){
		this(0,0,0);
	}
	public time(int h){
		this(h,0,0);
	}
	public time(int h,int m){
		this(h,m,0);
	}
	public time(int h,int m,int s){
		setTime(h,m,s);
	}
	public void setTime(int h,int m,int s)
	{
		hour=((h>=0 && h<24)?h:0);
		min=((m>=0 && m<24)?m:0);
		sec=((s>=0 && s<24)?s:0);
	}
	public String getTime(){
		return String.format("%02d:%02d:%02d",hour,min,sec);
	}
}
