package Minigames;

public class Stringtimer {

	public static String timerChecker(int i) {
		int minutes = i / 60;
		int seconds = i % 60;
		String disMinu = (minutes < 10 ? "" : "") + minutes;
		String disSec;
		if (seconds <= 9) 
			disSec = (seconds < 10 ? "" : "") + seconds;
		else 
			disSec = (seconds < 10 ? "0" : "") + seconds;
		
		String formattedTime;
		if (minutes != 0)
			formattedTime = disMinu + ":" + disSec;
		else
			formattedTime = disSec + "s";
		return formattedTime;
	}

	public static String timerBunito(Integer i) {
		int minutes = i.intValue() / 60;
		int seconds = i.intValue() % 60;
		String disMinu = (minutes < 10 ? "" : "") + minutes;
		String disSec = (seconds < 10 ? "0" : "") + seconds;
		String formattedTime = disMinu + "m " + disSec + "s";
		return formattedTime;
	}

	public static String timerFeio(int i) {
		int minutes = i / 60;
		int seconds = i % 60;
		String disMinu = (minutes < 10 ? "" : "") + minutes;
		String disSec = (seconds < 10 ? "0" : "") + seconds;
		String formattedTime = disMinu + ":" + disSec;
		return formattedTime;
	}

}
