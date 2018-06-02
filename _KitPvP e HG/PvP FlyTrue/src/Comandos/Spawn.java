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
import me.confuser.barapi.BarAPI;

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
			p.sendMessage("§c§lFly§7§lTrue §a: §7§lAguarde emquanto e teleportado!");
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
			p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 500, 100));
			BarAPI.setMessage(p, "§c§lFly§7§lTrue §a: §b§lTeleportando aguarde 5 segundos", 5);
			Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable() {
				@Override
				public void run() {
					if (segundos.contains(p.getName())) {
					p.sendMessage("  ");	
					p.sendMessage("§c§lFly§7§lTrue §a: §7§lVoce foi teletransportado ao Spawn!");
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
				    kits = new ItemStack(Material.CHEST);
				    kitsmeta = kits.getItemMeta();
				    kitsmeta.setDisplayName("§a§lKits");
				    kits.setItemMeta(kitsmeta);
				    
				    warps = new ItemStack(Material.BOOK);
				    warpsmeta = warps.getItemMeta();
				    warpsmeta.setDisplayName("§a§lWarps");
				    warps.setItemMeta(warpsmeta);
				    
				    click = new ItemStack(Material.WOOD_SWORD);
				    clickmeta = click.getItemMeta();
				    clickmeta.setDisplayName("§a§lClick-Teste");
				    click.setItemMeta(clickmeta);
				    
				    parkour = new ItemStack(Material.NAME_TAG);
				    parkourmeta = parkour.getItemMeta();
				    parkourmeta.setDisplayName("§a§lParkour");
				    parkour.setItemMeta(parkourmeta);
				    
				    loja = new ItemStack(Material.EMERALD);
				    lojameta = parkour.getItemMeta();
				    lojameta.setDisplayName("§a§lLoja");
				    loja.setItemMeta(lojameta);
				    
				    p.getInventory().setItem(1, kits);
				    p.getInventory().setItem(2, warps);
				    p.getInventory().setItem(4, click);
				    p.getInventory().setItem(6, parkour);
				    p.getInventory().setItem(7, loja);
					}
					}
				}
			}, 5*20);
		}else {
			if (args[0].equalsIgnoreCase("set")) {
			    if (p.hasPermission("fly.set")) {
			    	Set(p, "spawn");
			    	p.sendMessage("§c§lFly§7§lTrue §a: §b§lVoce setou o Spawn!");
			}
		}
	 }
		return false;
	}
}