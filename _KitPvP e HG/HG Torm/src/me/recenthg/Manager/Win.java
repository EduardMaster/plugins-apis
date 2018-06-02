package me.recenthg.Manager;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.recenthg.Main;
import me.recenthg.Dinheiro.DinheiroM;
import me.recenthg.Utils.Estado;

public class Win
{
  public static void verificaWin()
  {
    if ((Main.estados == Estado.ANDAMENTO) && 
      (Main.Jogadores.size() == 1))
      for (String s : Main.Jogadores) {
        final Player p = Bukkit.getPlayer(s);
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 4.0F, 4.0F);

        ItemStack mlg = new ItemStack(Material.WATER_BUCKET);
        ItemMeta mlgmeta = mlg.getItemMeta();
        mlgmeta.setDisplayName("§6MLG");
        mlg.setItemMeta(mlgmeta);
        p.getInventory().setItem(4, mlg);

        ItemStack mapa = new ItemStack(Material.MAP);
        ItemMeta mapameta = mapa.getItemMeta();
        mapameta.setDisplayName("§6MAPA");
        mapa.setItemMeta(mapameta);
        p.getInventory().setItem(3, mapa);
        
        DinheiroM.darDinheiro(p, 100);
        p.sendMessage("§aVoce ganhou §e100§a de ECoins");
        if (new Random().nextInt(100)<27) {
        	DinheiroM.darElo(p, 150);
        	p.sendMessage("§a+150 de Elo");
        }
        if (new Random().nextInt(100)<85) {
        	DinheiroM.darElo(p, 30);
        	p.sendMessage("§a+30 de Elo");
        }
        
    	DinheiroM.darElo(p, 60);
    	p.sendMessage("§a+60 de Elo");

        Location pLoc = p.getLocation();
        Location winnerLoc = new Location(p.getWorld(), pLoc.getBlockX(), 110.0D, pLoc.getBlockZ());
        for (int i = 0; i < 1; i++) {
          for (int x = -2; x < 2; x++) {
            for (int z = -2; z < 2; z++) {
              Block b = winnerLoc.clone().add(x, -2.0D, z).getBlock();
              Block b2 = winnerLoc.clone().add(x, -1.0D, z).getBlock();
              b.setType(Material.GLASS);
              b2.setType(Material.CAKE_BLOCK);
              p.teleport(winnerLoc);
            }
          }
        }
        
        Manager.addWin(p);
        Main.estados = Estado.FINALIZANDO;
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
          public void run() {
            Listeners.firework(p);
            Bukkit.broadcastMessage("§7» §a" + p.getName() + " §7Ganhou O Torneio « ");
          }
        }
        , 0L, 20L);

        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
        {
          @SuppressWarnings("deprecation")
		public void run() {
            p.kickPlayer("§aVoce Ganhou A Partida");

            Bukkit.shutdown();
            for (Player ps : Bukkit.getOnlinePlayers())
              if (!ps.getName().equals(p.getName())) {
                ps.kickPlayer("§a" + p.getName() + " §7Ganhou A Partida");
              }
              else
              {
                Main.Jogadores.size();
              }
          }
        }
        , 500L);
      }
  }
}