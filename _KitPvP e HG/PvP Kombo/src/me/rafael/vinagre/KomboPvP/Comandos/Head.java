package me.rafael.vinagre.KomboPvP.Comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import me.rafael.vinagre.KomboPvP.Main;

public class Head
  implements CommandExecutor, Listener {
  Main main;

  public Head(Main plugin) {
    plugin = this.main;
  }

  public Head() {
  }

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (!(sender instanceof Player)){
      sender.sendMessage("§f[§cErro§f] §cApenas jogadores podem usar isso");
      return true;
    }
    if ((sender instanceof Player)){
		Player p = (Player)sender;
		if (args.length == 0) {
			p.sendMessage("§7Use /head <player>");
		}
		if ((args.length != 0) && (args.length == 1)) {
			if (p.hasPermission("kitpvp.head")) {
        ItemStack skullItem = new ItemStack(Material.SKULL_ITEM);
        skullItem.setDurability((short)3);
        SkullMeta skullMeta = (SkullMeta)skullItem.getItemMeta();
        skullMeta.setOwner(args[0]);
        skullItem.setItemMeta(skullMeta);
        
        
        p.getInventory().addItem(new ItemStack[] { skullItem });
        p.sendMessage("§7Voce pegou uma cabeca");
			} else {
				p.sendMessage("§7Sem Permissão");
			}
      }
    }
    return false;
  }
}
