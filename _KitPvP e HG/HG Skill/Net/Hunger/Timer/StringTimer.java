package Net.Hunger.Timer;

public class StringTimer {
	
	public static String TimerGame(Integer i) {
	int minutes = i.intValue() / 60;
	int seconds = i.intValue() % 60;
	String disMinu = (minutes < 10 ? "" : "") + minutes; 
	String disSec = (seconds < 10 ? "0" : "") + seconds;
	String formattedTime = disMinu + ":" + disSec;
	return formattedTime;
	}
}