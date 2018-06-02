package neero.demon.eventos;
import org.bukkit.entity.Player;

public class Ranks {
	
	public static String getRank(Player p) {
		Integer money = Dinheiro.getMoney(p);
		String rank = "";
		rank = "§aUNRANKED";
		if (money >= 2002) {
			rank = "§aNOOB";
		}
		if (money >= 4000) {
			rank = "§aPRIMARY";
		}
		if (money >= 6000) {
			rank = "§aINTERMEDIARY";
		}
		if (money >= 8000) {
			rank = "§aADVANCE";
		}
		if (money >= 10000) {
			rank = "§aEXPERT";
		}
		if (money >= 12000) {
			rank = "§aBRONZE";
		}
		if (money >= 14000) {
			rank = "§aSILVER";
		}
		if (money >= 16000) {
			rank = "§aDIAMOND";
		}
		if (money >= 18000) {
			rank = "§aKING";
		}
		if (money >= 20000) {
			rank = "§aLEGENDARY";
		}
		return rank;
	}

	public static String getRankChat(Player p) {
		Integer money = Dinheiro.getMoney(p);
		String rank = "";
		rank = "§7(§f-§7)";
		if (money >= 500) {
			rank = "§7(§f=§7)";
		}
		if (money >= 2000) {
			rank = "§7(§f˜°§7)";
		}
		if (money >= 6000) {
			rank = "§7(§e˜±§7)";
		}
		if (money >= 8000) {
			rank = "§7(§e˜³§7)";
		}
		if (money >= 10000) {
			rank = "§7(§e˜·§7)";
		}
		if (money >= 12000) {
			rank = "§7(§6œ¶§7)";
		}
		if (money >= 14000) {
			rank = "§7(§6œ·§7)";
		}
		if (money >= 16000) {
			rank = "§7(§cœ¹§7)";
		}
		if (money >= 18000) {
			rank = "§7(§cœ«§7)";
		}
		if (money >= 20000) {
			rank = "§7(§4œª§7)";
		}
		return rank;
	}
}

