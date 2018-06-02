package me.rafael.vinagre.KomboPvP.Listeners;


import me.rafael.vinagre.KomboPvP.Main;

public class Strings {

	{
	}
	public static String NomeServer = Main.getInstance().getConfig().getString("NomeServer").replace("&", "§");
	public static String Motd = Main.getInstance().getConfig().getString("Motd").replace("&", "§");
	public static String Site = Main.getInstance().getConfig().getString("Site").replace("&", "§");
	public static String Formulario = Main.getInstance().getConfig().getString("Formulario").replace("&", "§");
	public static String Msg1 = Main.getInstance().getConfig().getString("Msg1").replace("&", "§");
	public static String Msg2 = Main.getInstance().getConfig().getString("Msg2").replace("&", "§");
	public static String Msg3 = Main.getInstance().getConfig().getString("Msg3").replace("&", "§");
	public static String Msg4 = Main.getInstance().getConfig().getString("Msg4").replace("&", "§");
	public static String Msg5 = Main.getInstance().getConfig().getString("Msg5").replace("&", "§");
	public static String Ip = Main.getInstance().getConfig().getString("Ip").replace("&", "§");
	public static String Simbolo = Main.getInstance().getConfig().getString("Simbolo").replace("&", "§");
	public static String MsgSpam = Main.getInstance().getConfig().getString("MsgSpam").replace("&", "§");
	public static String Dono = Main.getInstance().getConfig().getString("Dono").replace("&", "§");
}