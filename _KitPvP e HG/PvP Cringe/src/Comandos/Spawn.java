package Comandos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Main.Main;
import Outros.ScoreBoard;
import Utils.KitAPI;
import Utils.WarpsAPI;

public class Spawn extends WarpsAPI implements CommandExecutor {
	
	public static ItemStack kits;
	public static ItemMeta kitsmeta;
	public static ItemStack warps;
	public static ItemMeta warpsmeta;
	public static ItemStack click;
	public static ItemMeta clickmeta;
	public static ItemStack parkour;
	public static ItemMeta parkourmeta;
	public static ItemStack loja;
	public static ItemMeta lojameta;

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§bPrecisa ser um Player para usar esse comando");
			return true;
		}
		final Player p = (Player)sender;
		if (args.length == 0) {
			segundos.add(p.getName());
			p.sendMessage("§a§lSPAWN §fVoce esta indo para o spawn...");
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
			p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 500, 100));
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable() {
				@Override
				public void run() {
					if (segundos.contains(p.getName())) {
					p.sendMessage("  ");	
					p.sendMessage("§a§lSPAWN §fVoce foi §B§LTELEPORTADO ao Spawn!");
					p.sendMessage("  ");	
					ir(p, "spawn");
					p.setLevel(0);
					segundos.remove(p.getName());
		            KitAPI.KitDelay.remove(p.getName());
					KitAPI.RemoveKit(p);
					p.getInventory().clear();
					p.getInventory().setHelmet(new ItemStack(Material.AIR));
					p.getInventory().setChestplate(new ItemStack(Material.AIR));
					p.getInventory().setLeggings(new ItemStack(Material.AIR));
					p.getInventory().setBoots(new ItemStack(Material.AIR));
					ScoreBoard.UpdateScore(p);
			        for (PotionEffect effect : p.getActivePotionEffects()) {
 		                 p.removePotionEffect(effect.getType());
					p.setHealth(20);
				    kits = new ItemStack(Material.STORAGE_MINECART);
				    kitsmeta = kits.getItemMeta();
				    kitsmeta.setDisplayName("§b§lKITS");
				    kits.setItemMeta(kitsmeta);
				    
				    warps = new ItemStack(Material.COMPASS);
				    warpsmeta = warps.getItemMeta();
				    warpsmeta.setDisplayName("§6§lWARPS");
				    warps.setItemMeta(warpsmeta);
				    
				    click = new ItemStack(Material.DIAMOND_SWORD);
				    clickmeta = click.getItemMeta();
				    clickmeta.setDisplayName("§9§lCLICK-TESTE");
				    click.setItemMeta(clickmeta);
				    
				    loja = new ItemStack(Material.DIAMOND);
				    lojameta = parkour.getItemMeta();
				    lojameta.setDisplayName("§3§lLOJA");
				    loja.setItemMeta(lojameta);
				    
				    p.getInventory().setItem(0, kits);
				    p.getInventory().setItem(2, warps);
				    p.getInventory().setItem(6, click);
				    p.getInventory().setItem(8, loja);
				    p.updateInventory();
					}
					}
				}
			}, 5*20);
		}else {
			if (args[0].equalsIgnoreCase("set")) {
			    if (p.hasPermission("cmd.dono")) {
			    	Set(p, "spawn");
			    	p.sendMessage("§a§lSPAWN §fVoce marcou o §a§lSPAWN!");
			}
		}
	 }
		return false;
	}
}