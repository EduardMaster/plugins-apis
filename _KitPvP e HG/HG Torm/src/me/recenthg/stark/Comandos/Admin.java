package me.recenthg.stark.Comandos;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.recent.stark.Main;
import me.recent.stark.Strings;
import me.recenthg.stark.Manager.Title;

public class Admin implements CommandExecutor {
	public static ArrayList<Player> admin = new ArrayList<Player>();
	public static HashMap<String, ItemStack[]> saveinv = new HashMap<String, ItemStack[]>();
	public static HashMap<String, ItemStack[]> armadura = new HashMap<String, ItemStack[]>();

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] Args) {
		if (Label.equalsIgnoreCase("admin")) {
			Player p = (Player) sender;
			if (!p.hasPermission("HungerGames.c.Admin")) {
				p.sendMessage(Strings.semperm);
				return true;
			}

			ItemStack AdmSair = new ItemStack(Material.SLIME_BALL);
			ItemMeta kAdmSair = AdmSair.getItemMeta();
			kAdmSair.setDisplayName(ChatColor.GREEN + "§6Sair Do Admin");
			AdmSair.setItemMeta(kAdmSair);

			ItemStack AdmTrocar = new ItemStack(Material.MAGMA_CREAM);
			ItemMeta kAdmTrocar = AdmTrocar.getItemMeta();
			kAdmTrocar.setDisplayName(ChatColor.GREEN + "§6Troca Rapida");
			AdmTrocar.setItemMeta(kAdmTrocar);

			ItemStack AdmTrocar1 = new ItemStack(Material.IRON_FENCE);
			ItemMeta kAdmTrocar1 = AdmTrocar1.getItemMeta();
			kAdmTrocar1.setDisplayName(ChatColor.GREEN + "§6Prender");
			AdmTrocar1.setItemMeta(kAdmTrocar1);

			ItemStack AdmTrocar12 = new ItemStack(Material.NETHER_STAR);
			ItemMeta kAdmTrocar12 = AdmTrocar12.getItemMeta();
			kAdmTrocar12.setDisplayName(ChatColor.GREEN + "§6Abrir Inventario");
			AdmTrocar12.setItemMeta(kAdmTrocar12);

			ItemStack AdmTrocar122 = new ItemStack(Material.YELLOW_FLOWER);
			ItemMeta kAdmTrocar122 = AdmTrocar122.getItemMeta();
			kAdmTrocar122.setDisplayName(ChatColor.GREEN + "§6Crashar");
			AdmTrocar122.setItemMeta(kAdmTrocar122);

			ItemStack knokback = new ItemStack(Material.STICK);
			ItemMeta knokbacka = knokback.getItemMeta();
			knokbacka.setDisplayName(ChatColor.GREEN + "§6Testar Anti-KnockBack");
			knokback.setItemMeta(knokbacka);
			knokbacka.addEnchant(Enchantment.KNOCKBACK, 10, true);
			knokback.setItemMeta(knokbacka);

			Player[] arrayOfPlayer;
			if ((!admin.contains(p)) && ((arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length != 0)) {
				Player Online = arrayOfPlayer[0];
				Online.hidePlayer(p);
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Voce Entrou No Modo Admin!");
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Voce Esta Invisivel Para Todos!");
				Title.sendTitle(p, "§a! §fVoce Entrou Modo Admin §a!");
				saveinv.put(p.getName(), p.getInventory().getContents());
				armadura.put(p.getName(), p.getInventory().getArmorContents());
				Main.Jogadores.remove(sender.getName());
				p.setHealth(20.0D);
				p.setGameMode(GameMode.CREATIVE);
				p.getInventory().clear();
				p.getInventory().setItem(4, AdmSair);
				p.getInventory().setItem(0, AdmTrocar);
				p.getInventory().setItem(8, knokback);
				p.getInventory().setItem(3, AdmTrocar122);
				p.getInventory().setItem(7, AdmTrocar12);
				p.getInventory().setItem(1, AdmTrocar1);
				admin.add(p);
				return true;
			}
			Player[] arrayOfPlayer1;
			if ((admin.contains(p)) && ((arrayOfPlayer1 = Bukkit.getServer().getOnlinePlayers()).length != 0)) {
				Player Online = arrayOfPlayer1[0];
				p.getInventory().clear();
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Voce Saiu Do Modo Admin!");
				p.sendMessage("§8\u276e§2§l!§8\u276f §7Voce Esta Visivel Para Todos!");
				Title.sendTitle(p, "§a! §fVoce Saiu Modo Admin §a!");
				Main.Jogadores.add(sender.getName());
				p.setGameMode(GameMode.SURVIVAL);
				admin.remove(p);
				Online.showPlayer(p);
				p.showPlayer(Online);
				p.getInventory().setContents((ItemStack[]) saveinv.get(p.getName()));
				p.getInventory().setArmorContents((ItemStack[]) armadura.get(p.getName()));

				return true;
			}
		}
		return false;
	
	}
}
