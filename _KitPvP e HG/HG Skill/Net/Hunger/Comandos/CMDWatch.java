package Net.Hunger.Comandos;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Net.Hunger.Main;
import Net.Hunger.Eventos.ChecarVitoria;
import Net.Hunger.Manager.EspectadoresManager;
import Net.Hunger.Manager.Habilidade;

public class CMDWatch implements Listener, CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    if(!(sender instanceof Player)) {
    sender.sendMessage("§7[§a!§7] §aComandos apenas no servidor!");
    return true;
    }
    Player p = (Player)sender;
    if(cmd.getName().equalsIgnoreCase("watch") && (p.hasPermission("HungerGames.c.Watch"))) {
    p.setAllowFlight(true);
    p.sendMessage("§7[§a!§7] Você entrou no modo espectador");
    p.sendMessage("§7[§a!§7] Ultilize /ir para se teleportar até algum jogador!");
    p.getInventory().clear();
    p.setGameMode(GameMode.CREATIVE);

    ItemStack kit = new ItemStack(Material.SLIME_BALL);
	ItemMeta rkit = kit.getItemMeta();
	rkit.setDisplayName("§aMenu De Transporte.");
	kit.setItemMeta(rkit);
	p.getInventory().setItem(4, kit);
    
	Main.Watch.add(p.getName());
    EspectadoresManager.DamageMobs.add(p);
    Main.Jogadores.remove(sender.getName());
    p.getInventory().setHelmet(new ItemStack(Material.AIR));
    p.getInventory().setChestplate(new ItemStack(Material.AIR));
    p.getInventory().setLeggings(new ItemStack(Material.AIR));
    p.getInventory().setBoots(new ItemStack(Material.AIR));
    p.updateInventory();
    ChecarVitoria.verificaWin();
    Habilidade.removeAbility(p);
    Bukkit.getLogger().info(p.getName() + " Decidiu espectar!");
    Bukkit.broadcast(p.getName() + " §7Dediciu assistir a partida!", "hg.admin");
	for (Player pl : Bukkit.getOnlinePlayers()) {
    pl.hidePlayer(p);
    }
    } else {
    p.sendMessage("§7[§a?§7] Você não possue permissão para isso!");
    }
   return true;
  }
}