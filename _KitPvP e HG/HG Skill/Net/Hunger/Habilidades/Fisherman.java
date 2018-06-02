package Net.Hunger.Habilidades;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

import Net.Hunger.Comandos.CMDKit;
import Net.Hunger.Manager.Habilidade;

public class Fisherman implements Listener {
	
  @EventHandler
  public void onPlayerHitFishingrodscorpion(PlayerFishEvent event) {
    Player player = event.getPlayer();
    if ((event.getCaught() instanceof Player)) {
      Player caught = (Player)event.getCaught();
  	if((Habilidade.getAbility(player).equalsIgnoreCase("fisherman")) && (player.getItemInHand().getType() == Material.FISHING_ROD)) {
        caught.teleport(player.getLocation());
        player.sendMessage("§7[§a!§7] Voce puxou o jogador §a" + caught.getName());
        caught.sendMessage("§7[§a!§7] §7Voce foi puxado por §a" + player.getName());
      }
    }
  }
}
