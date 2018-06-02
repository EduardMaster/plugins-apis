package me.recenthg.stark.Comandos;

import me.recent.stark.Main;
import me.recent.stark.Strings;
import me.recenthg.stark.Eventos.Vitoria;
import me.recenthg.stark.Manager.Espectadores;
import me.recenthg.stark.Manager.Habilidade;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Desistir implements Listener, CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§8\u276e§2§l!§8\u276f §7Comandos apenas no servidor!");
			return true;
		}
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("desistir") && (p.hasPermission("HungerGames.c.Desistir"))) {
			p.setAllowFlight(true);
			p.sendMessage("§8\u276e§2§l!§8\u276f §7Você entrou no modo espectador");
			p.getInventory().clear();
			p.setGameMode(GameMode.CREATIVE);

			ItemStack kit = new ItemStack(Material.CHEST);
			ItemMeta rkit = kit.getItemMeta();
			rkit.setDisplayName("§6Transporte");
			kit.setItemMeta(rkit);
			p.getInventory().setItem(4, kit);

			Main.Watch.add(p.getName());
			Espectadores.DamageMobs.add(p);
			Main.Jogadores.remove(sender.getName());
			p.getInventory().setHelmet(new ItemStack(Material.AIR));
			p.getInventory().setChestplate(new ItemStack(Material.AIR));
			p.getInventory().setLeggings(new ItemStack(Material.AIR));
			p.getInventory().setBoots(new ItemStack(Material.AIR));
			p.updateInventory();
			Vitoria.verificaWin();
			Habilidade.removeAbility(p);
			Bukkit.getLogger().info("§a" + p.getName() + " §7Decidiu espectar A Partida!");
			Bukkit.broadcast("§a" + p.getName() + " §7Abandonou A Partida!", "hg.admin");
			for (Player pl : Bukkit.getOnlinePlayers()) {
				pl.hidePlayer(p);
			}
		} else {
			p.sendMessage(Strings.semperm);
		}
		return true;
	}
}