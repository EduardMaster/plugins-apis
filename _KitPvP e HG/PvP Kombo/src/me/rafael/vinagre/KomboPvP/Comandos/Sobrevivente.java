package me.rafael.vinagre.KomboPvP.Comandos;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.rafael.vinagre.KomboPvP.Main;
import me.rafael.vinagre.KomboPvP.Listeners.SpamCheck;

public class Sobrevivente 
implements Listener, CommandExecutor
{
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList<String> dentro = new ArrayList();
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList<String> invencivel = new ArrayList();
	boolean evento = false;
	int fechando = 0;
	
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		if(!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("sobrevivente")){
			if(args.length == 0){
				if(evento == false){
				p.sendMessage("§c§lSOBREVIVENTE: §cEvento ja iniciou ou nao esta ocorrendo !");
				return true;
				}
				if(dentro.contains(p.getName())){
					p.sendMessage("§c§lSOBREVIVENTE: §cVoce ja esta dentro do evento !");
					return true;
				}
				else if(evento == true){
					World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Warps.sobrevivente.World"));
		              double x = Main.plugin.getConfig().getDouble("Warps.sobrevivente.X");
		              double y = Main.plugin.getConfig().getDouble("Warps.sobrevivente.Y");
		              double z = Main.plugin.getConfig().getDouble("Warps.sobrevivente.Z");
		              Location sobrevivente = new Location(w, x, y, z);
		              sobrevivente.setPitch((float)Main.plugin.getConfig().getDouble("Warps.sobrevivente.Pitch"));
		              sobrevivente.setYaw((float)Main.plugin.getConfig().getDouble("Warps.sobrevivente.Yaw"));
		              p.teleport(sobrevivente);
		              dentro.add(p.getName());
		              invencivel.add(p.getName());
		              p.getInventory().clear();
		              ItemStack kb = new ItemStack(Material.STICK);
		              ItemMeta kb2 = kb.getItemMeta();
		              kb2.addEnchant(Enchantment.KNOCKBACK, 3, true);
		              kb2.setDisplayName("§cEspetinho");
		              kb.setItemMeta(kb2);
		      	    ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		    	    ItemMeta sopas = sopa.getItemMeta();
		    	    sopas.setDisplayName("§6Sopa");
		    	    sopa.setItemMeta(sopas);
		              p.getInventory().addItem(kb);
		              for (int i = 0; i <= 34; i++) {
		      	        p.getInventory().addItem(sopa);
		      	      }
		              return true;
				}
			}
			if(args[0].equalsIgnoreCase("iniciar")){
				if(!p.hasPermission("kitpvp.admin")){
				   return true;
				}
			if(args.length == 0){
				p.sendMessage("§c§lSOBREVIVENTE: §cUse /sobrevivente iniciar <tempo>");
				return true;	
			}
			if(args.length == 1){
				p.sendMessage("§c§lSOBREVIVENTE: §cUse /sobrevivente iniciar <tempo>");
				return true;	
			}
			fechando = Integer.parseInt(args[1]);
			p.sendMessage("§c§lSOBREVIVENTE: §cIniciando evento.");
	          Bukkit.getScheduler().runTaskTimer(Main.plugin, new Runnable() {
		            @SuppressWarnings("deprecation")
					public void run() {
		            	evento = true;
		              {
		            	  for(Player b : Bukkit.getOnlinePlayers()){
					          b.sendMessage(" ");
					          b.sendMessage(" ");
		            		  SpamCheck.sendCenteredMessage(b, "§c§lSOBREVIVENTE");
		            		  SpamCheck.sendCenteredMessage(b, "§cIniciando evento !");
		            		  SpamCheck.sendCenteredMessage(b, "§cTempo para fechar entrada: §7" + fechando);
		            		  SpamCheck.sendCenteredMessage(b, "§cPessoas participando: §7" + dentro.size());
		            		  SpamCheck.sendCenteredMessage(b, "§cEsse evento perde XP !");
		            		  SpamCheck.sendCenteredMessage(b, "§cUse /sobrevivente !");
					          b.sendMessage(" ");
					          b.sendMessage(" ");
		            	  }
		              }
		              fechando -= 10;
		              if (fechando < 0) {
		            	  fechando = 0;
		            	  evento = false;
		            	  for(Player b : Bukkit.getOnlinePlayers()){
					      b.sendMessage(" ");
					      b.sendMessage(" ");
	            		  SpamCheck1.sendCenteredMessage(b, "§c§lSOBREVIVENTE");
	            		  SpamCheck1.sendCenteredMessage(b, "§cEvento iniciado !");
	            		  SpamCheck1.sendCenteredMessage(b, "§cPessoas participando: §7" + dentro.size());
	            		  SpamCheck1.sendCenteredMessage(b, "§cPvP ativado !");
	            		  SpamCheck1.sendCenteredMessage(b, "§cBoa sorte a todos !");
				          b.sendMessage(" ");
				          b.sendMessage(" ");
		            	  }
				        Bukkit.getScheduler().cancelAllTasks();
						invencivel.clear();
		              }
		            }
		          }, fechando, 360L);
			}
		}
		return true;
	}
	
	  @EventHandler
	  public void Invencibilidade(EntityDamageByEntityEvent e)
	  {
	    if (!(e.getEntity() instanceof Player)) {
	      return;
	    }
	    if (!(e.getDamager() instanceof Player)) {
	      return;
	    }
	    Player p = (Player)e.getDamager();
	    Player p1 = (Player)e.getEntity();
	    if (((dentro.contains(p.getName())) || (dentro.contains(p1.getName()))) && ((invencivel.contains(p1.getName())) || (invencivel.contains(p.getName())))) {
	      e.setCancelled(true);
	    }
	  }
	  
	  @EventHandler
	  public void Invencibilidade1(EntityDamageEvent e)
	  {
	    if (!(e.getEntity() instanceof Player)) {
	      return;
	    }
	    Entity e1 = e.getEntity();
	    if ((e1 instanceof Player))
	    {
	      Player p = (Player)e1;
	      if ((invencivel.contains(p.getName())) && (dentro.contains(p.getName()))) {
	        e.setCancelled(true);
	      }
	    }
	  }
	  
	  @EventHandler
	  public void comand(PlayerCommandPreprocessEvent e){
		  Player p = e.getPlayer();
		  if((dentro.contains(p.getName()) && (!(e.getMessage().toLowerCase().startsWith("/sobrevivente"))) && (!(e.getMessage().toLowerCase().startsWith("/admin"))))){
			  e.setCancelled(true);
			  p.sendMessage("§7» §cVoce nao pode executar este comando no evento.");
		  }
	  }
}