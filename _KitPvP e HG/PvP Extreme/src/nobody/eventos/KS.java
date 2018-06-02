package nobody.eventos;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class KS implements Listener{
	
	@EventHandler
	public void ks(PlayerDeathEvent e){
		
		Player matou = e.getEntity().getKiller();
		
		if(matou instanceof Player){
		matou.setLevel(matou.getLevel() +1);
		
		
		if(matou.getLevel() == 5){
			Bukkit.getServer().broadcastMessage("§eExtreme§fKits »  §aO Player: §b" + matou.getName() + " §aConseguiu uma KillStreak de 5");
		}
		if(matou.getLevel() == 10){
			Bukkit.getServer().broadcastMessage("§eExtreme§fKits »  §aO Player: §b" + matou.getName() + " §aConseguiu uma KillStreak de 10");
	    }
		if(matou.getLevel() == 15){
			Bukkit.getServer().broadcastMessage("§eExtreme§fKits »  §aO Player: §b" + matou.getName() + " §aConseguiu uma KillStreak de 15");
		}
		if(matou.getLevel() == 20){
			Bukkit.getServer().broadcastMessage("§eExtreme§fKits »  §aO Player: §b" + matou.getName() + " §aConseguiu uma KillStreak de 20");
		}
		if(matou.getLevel() == 25){
			Bukkit.getServer().broadcastMessage("§eExtreme§fKits »  §aO Player: §b" + matou.getName() + " §aConseguiu uma KillStreak de 25");
		}
		if(matou.getLevel() == 30){
			Bukkit.getServer().broadcastMessage("§eExtreme§fKits »  §aO Player: §b" + matou.getName() + " §aConseguiu uma KillStreak de 30");
		}
		if(matou.getLevel() == 35){
			Bukkit.getServer().broadcastMessage("§eExtreme§fKits »  §aO Player: §b" + matou.getName() + " §aConseguiu uma KillStreak de 35");
		}
		if(matou.getLevel() == 40){
			Bukkit.getServer().broadcastMessage("§eExtreme§fKits »  §aO Player: §b" + matou.getName() + " §aConseguiu uma KillStreak de 45");
		}
		if(matou.getLevel() == 50){
			Bukkit.getServer().broadcastMessage("§eExtreme§fKits »  §aO Player: §b" + matou.getName() + " §aConseguiu uma KillStreak de 50");
			matou.sendMessage("§aVocê recebeu Uma  Quantidade de XP Por Conseguir uma KillStreak Elevada.");
			Money.addMoney(1000, matou);
			matou.playSound(matou.getLocation(), Sound.LEVEL_UP, 1.0F, 1.0F);
		}
	}

	}
	
}
