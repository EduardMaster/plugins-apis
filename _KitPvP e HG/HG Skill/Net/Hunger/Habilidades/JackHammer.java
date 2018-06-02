package Net.Hunger.Habilidades;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Net.Hunger.Main;
import Net.Hunger.Manager.Habilidade;

public class JackHammer implements Listener {
	
  @EventHandler(priority=EventPriority.NORMAL)
  public void onBlockBreak(BlockBreakEvent event)
  {
    Player p = event.getPlayer();
    Block b = event.getBlock();
    if ((Habilidade.getAbility(p).equalsIgnoreCase("jackhammer")) && (p.getItemInHand().getItemMeta().getDisplayName().equals("§aJackHammer §7Kit!")))
    {
      World w = (World)Bukkit.getServer().getWorlds().get(0);
      Double y = Double.valueOf(b.getLocation().getY() + 1.0D);
      Location l = new Location(w, b.getLocation().getX(), y.doubleValue(), b.getLocation().getZ());
      while ((l.getBlock().getType() != Material.BEDROCK) || (l.getBlock().getType() != Material.AIR))
      {
        l.getBlock().breakNaturally();
        Double localDouble1 = y;Double localDouble2 = y = Double.valueOf(y.doubleValue() + 1.0D);
        l.setY(y.doubleValue());
      }
    }
  }
}