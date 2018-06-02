package Comandos;

import java.util.ArrayList;
import Main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TesteClick
  implements Listener, CommandExecutor
{
	
	public static ItemStack kits;
	public static ItemMeta kitsmeta;
	public static ItemStack warps;
	public static ItemMeta warpsmeta;
	public static ItemStack click1;
	public static ItemMeta click1meta;
	public static ItemStack parkour;
	public static ItemMeta parkourmeta;
	public static ItemStack loja;
	public static ItemMeta lojameta;
  
  public static ArrayList<String> click = new ArrayList<>();
  public static ArrayList<String> jaesta = new ArrayList<>();
  
  @SuppressWarnings("deprecation")
public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args)
  {
    final Player p = (Player)sender;
    if (cmd.getName().equalsIgnoreCase("testclick"))
    {
      if (jaesta.contains(p.getName()))
      {
        p.sendMessage("§4Voce ja esta testando seu click !");
        return true;
      }
      Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
        	jaesta.add(p.getName());
        	p.sendMessage("§4Comecando o Test-Click em §c3 §4segundos");
         
        }
      }, 20L);
      Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
        	p.sendMessage("§4Comecando o Test-Click em §c2 §3segundos");
        
        }
      }, 40L);
      Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstace(), new Runnable()
      {
        public void run()
        {
           	p.sendMessage("§4Comecando o Test-Click em §c1 §2segundo");
          
        }
      }, 60L);
      Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getInstace(), new Runnable()
      {
		public void run()
        {
           	p.sendMessage("§4O Teste Click Comecou");
          
          p.sendMessage("§4Lembre-se de clicar no ar sem nenhum item na mao !");
          TesteClick.click.add(p.getName());
        }
      }, 80L);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstace(), new Runnable()
      {
		public void run()
        {
          if (TesteClick.click.contains(p.getName()))
          {
        	jaesta.remove(p.getName());
            click.remove(p.getName());
           
            p.sendMessage("§a§lVoce deu §f§l" + p.getLevel() + "§a§lClicks em 20 Segundos");
            p.setLevel(0);
          }
        }
      }, 500L);
      return true;
    }
    return true;
  }
  
  @EventHandler
  public void clicar(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((click.contains(p.getName())) && (e.getAction() == Action.LEFT_CLICK_AIR) && (p.getItemInHand().getType() == Material.AIR)) {
      p.setLevel(p.getLevel() + 1);
    }
  }
   @EventHandler
   public void clicando(PlayerInteractEvent e) {
   Player p = e.getPlayer();
  	if ((jaesta.contains(p.getName()))) {
  		
  	}
  }
}
