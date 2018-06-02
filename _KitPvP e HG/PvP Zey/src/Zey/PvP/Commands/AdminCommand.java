package Zey.PvP.Commands;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Zey.PvP.Essencial.KitAPI;
import Zey.PvP.Eventos.Habilidade;
import Zey.PvP.Main.Main;
import Zey.PvP.Utils.Proteção;
import net.minecraft.util.com.google.common.collect.Maps;

@SuppressWarnings({ "deprecation" })
public class AdminCommand implements CommandExecutor {
	
	public Main main;
	public Map<String, ItemStack[]> inv = Maps.newHashMap();
	public Map<String, ItemStack[]> armor = Maps.newHashMap();
	
	public AdminCommand(Main main) {
		this.main = main;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (!(sender instanceof Player)) {
            sender.sendMessage(String.valueOf(Main.prefix) + " §7» §cApenas jogadores podem usar isso.");
			return true;
		}
		
		Player p = (Player) sender;
		
		if (label.equalsIgnoreCase("admin")) {
			if (p.hasPermission("zey.pvp.admin")) {
				if (!Main.admins.contains(p.getName())) {
					Main.admins.add(p.getName());
					
					for (Player players : Bukkit.getOnlinePlayers()) {
						if (!players.hasPermission("zey.pvp.admin.ver")) {
							players.hidePlayer(p);
						}
					}
					
			        KitAPI.remove(p);
			        Habilidade.removeAbility(p);
			        KitAPI.removeAbility(p);
			        
			        Zey.PvP.APIs.WarpAPI.setWarp(p, "Nenhuma");
					
                    p.getInventory().setBoots((ItemStack)null);
                    p.getInventory().setChestplate((ItemStack)null);
                    p.getInventory().setLeggings((ItemStack)null);
                    p.getInventory().setHelmet((ItemStack)null);
                    p.getInventory().clear();
                    
                    p.setExp(0.0f);
                    p.setHealthScale(20.0);
                    p.setExhaustion(20.0f);
                    p.setFireTicks(0);
                    p.setFoodLevel(20000);
                    p.setHealth(20.0);
            		
					p.setGameMode(GameMode.CREATIVE);
					BuildCommand.embuild.add(p);
					
            		Proteção.setImortal(p, false);
            		Proteção.isImortal(p);
					
					p.getInventory().clear();
					p.getInventory().setArmorContents(null);
					
					ItemStack c = new ItemStack(Material.PAPER);
					ItemMeta cm = c.getItemMeta();
					cm.setDisplayName("§cInformações §7(Clique No Player)");
					c.setItemMeta(cm);
					
					ItemStack a = new ItemStack(Material.BEDROCK);
					ItemMeta am = a.getItemMeta();
					am.setDisplayName("§cPrisão §7(Clique No Player)");
					a.setItemMeta(am);
					
					ItemStack f = new ItemStack(Material.SLIME_BALL);
					ItemMeta fm = f.getItemMeta();
					fm.setDisplayName("§cTroca-Rapida §7(Clique)");
					f.setItemMeta(fm);
					
					ItemStack k = new ItemStack(Material.STICK);
					ItemMeta km = k.getItemMeta();
					km.setDisplayName("§cKnock-Back §7(Bata No Player)");
					km.addEnchant(Enchantment.KNOCKBACK, 10, true);
					k.setItemMeta(km);
					
					ItemStack s = new ItemStack(Material.DIAMOND_SWORD);
					ItemMeta sm = s.getItemMeta();
					sm.setDisplayName("§cEspada-PvP §7(Bata No Player)");
					sm.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
					s.setItemMeta(sm);
					
					p.getInventory().setItem(8, c);
					p.getInventory().setItem(3, a);
					p.getInventory().setItem(4, f);
					p.getInventory().setItem(5, k);
					p.getInventory().setItem(0, s);
					
					p.updateInventory();
					
					p.sendMessage(String.valueOf(Main.prefix) + " §7» Você entrou no modo §c§lADMIN");
					
				} else {
					Main.admins.remove(p.getName());
					
					for (Player players : Bukkit.getOnlinePlayers()) {
						players.showPlayer(p);
					}
					
					p.getInventory().clear();
					
            		Proteção.setImortal(p, false);
            		Proteção.isImortal(p);
            		
					p.setGameMode(GameMode.SURVIVAL);
			        Zey.PvP.APIs.WarpAPI.setWarp(p, "Nenhuma");
										
					p.sendMessage(String.valueOf(Main.prefix) + " §7» Você saiu do modo §c§lADMIN");
					BuildCommand.embuild.remove(p);
				}
			}
		}
		return false;
	}
}
