package Zey.PvP.Essencial;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class HorarioAPI {
	
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    public static Calendar ca = new GregorianCalendar(TimeZone.getTimeZone("America/Sao_Paulo"));
	  
    public static String getHorario() {
	TimeZone tz = TimeZone.getTimeZone("America/Sao_Paulo");
	Calendar calendar = GregorianCalendar.getInstance(tz);
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
	return sdf.format(calendar.getTime());
    }
}
