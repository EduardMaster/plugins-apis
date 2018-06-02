package Minigames;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import Utils.KitAPI;


public class Minigames implements Listener
{
	
	public static void joinMinigame(Player p, ListGames minigame) {
		
			
			if (minigame == ListGames.voidChallenge) {
				new voidChallenge(p);
			}
			
			if (minigame == ListGames.refillTest) {
				new refillTest(p);
			}
			
		}
		
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		if (KitAPI.voidChallenge.contains(e.getPlayer().getName())) {
			KitAPI.voidChallenge.remove(e.getPlayer().getName());
			KitAPI.voidChallengeTime.remove(e.getPlayer().getName());
		}
		
		if (KitAPI.refillTest.contains(e.getPlayer().getName())) {
			KitAPI.refillTest.remove(e.getPlayer().getName());
			KitAPI.refillTestTime.remove(e.getPlayer().getName());
		}
	}
	
}