package br.com.alpha.Habilidades;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import br.com.alpha.MCAlpha;
import br.com.alpha.ENUMs.KitsEnum;
import br.com.alpha.gamemanagement.GameTime;



public class Phantom implements Listener {
	private ItemStack Cor(Material mat, Color cor) {
		ItemStack armor = new ItemStack(mat);
		LeatherArmorMeta meta = (LeatherArmorMeta) armor.getItemMeta();
		meta.setColor(cor);
		armor.setItemMeta(meta);
		return armor;
	}
	public static ArrayList<String> cooldown = new ArrayList<>();
	private HashMap<Player, ItemStack[]> armors = new HashMap<>();
	@EventHandler
	void phantom(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (MCAlpha.Status != GameTime.PREGAME) {

			if (p.getItemInHand().getType() == Material.FEATHER && KitsEnum.getKit(p) == KitsEnum.PHANTOM) {
				if (cooldown.contains(p.getName())) {
					p.sendMessage("§cVocê está em cooldown!");
					return;
				}
					if (!cooldown.contains(p)) {
						armors.put(p, p.getInventory().getArmorContents());
						p.getInventory()
						.setArmorContents(new ItemStack[] { Cor(Material.LEATHER_BOOTS, Color.WHITE),
								Cor(Material.LEATHER_LEGGINGS, Color.WHITE),
								Cor(Material.LEATHER_CHESTPLATE, Color.WHITE),
								Cor(Material.LEATHER_HELMET, Color.WHITE) });
						p.setAllowFlight(true);

						Bukkit.getScheduler().scheduleSyncDelayedTask(MCAlpha.mcAlpha, new Runnable() {
							@Override
							public void run() {
								p.setAllowFlight(false);
								cooldown.remove(p.getName());
								p.sendMessage("§cVocê já pode usar o phantom.");
							}
						}, 20 * 40);
						p.updateInventory();
						Bukkit.getScheduler().scheduleSyncDelayedTask(MCAlpha.mcAlpha, new Runnable() {
							
							@Override
							public void run() {
								p.setAllowFlight(false);
								p.sendMessage("§cAcabou!");
								armors.remove(p);
								p.getInventory().setArmorContents((ItemStack[])armors.get(p));
								cooldown.add(p.getName());
							}
						},20*5);
					}
			}
		}
	}

}
