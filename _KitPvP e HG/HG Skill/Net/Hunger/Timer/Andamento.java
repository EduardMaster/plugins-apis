package Net.Hunger.Timer;

import java.text.DecimalFormat;

import org.bukkit.Bukkit;

import Net.Hunger.Main;
import Net.Hunger.Comandos.CMDArena;
import Net.Hunger.Comandos.CMDMiniArena;
import Net.Hunger.Eventos.ChecarVitoria;
import Net.Hunger.Feast.BonusFeast;
import Net.Hunger.Feast.FeastManager;
import Net.Hunger.Feast.MiniFeast;
import Net.Hunger.Feast.MiniFeast2;

public class Andamento {
	
  private static Integer shed_id = null;

  public static void Checar() {
  ChecarVitoria.verificaWin();
  Bukkit.getScheduler().scheduleSyncDelayedTask(Main.instance, new Runnable()  {
  public void run() {
  Checar();
  }
  },600L);
  }
  
  public static void Iniciar(int Contagem) {
	Main.Andamento = Contagem;
    shed_id = Integer.valueOf(Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.instance, new Runnable() {
      public void run() {
        Main.Andamento += 1;
        if(Main.Andamento == 450) {
        MiniFeast.announceFeast();
        }
        if(Main.Andamento == 850) {
        MiniFeast2.announceFeast();
        }
        if(Main.Andamento == 900) {
        FeastManager.announceFeast(5);
        }
        if(Main.Andamento == 960) {
        FeastManager.announceFeast(4);
        }
        if(Main.Andamento == 1020) {
        FeastManager.announceFeast(3);
        }
        if(Main.Andamento == 1080) {
        FeastManager.announceFeast(2);
        }
        if(Main.Andamento == 1140) {
        FeastManager.announceFeast(1);
        }
        if(Main.Andamento == 1195) {
        DecimalFormat df = new DecimalFormat("##.#");
        Bukkit.broadcastMessage("§7[§a!§7] O Feast nascera nas coordenadas §f" + df.format(FeastManager.mainBlock.getLocation().getX()) + "§7,§f " + df.format(FeastManager.mainBlock.getLocation().getY()) + "§7,§f " + df.format(FeastManager.mainBlock.getLocation().getZ()) + "§7 em §f5 §7segundos!");
        }
        if(Main.Andamento == 1196) {
        DecimalFormat df = new DecimalFormat("##.#");
        Bukkit.broadcastMessage("§7[§a!§7] O Feast nascera nas coordenadas §f" + df.format(FeastManager.mainBlock.getLocation().getX()) + "§7,§f " + df.format(FeastManager.mainBlock.getLocation().getY()) + "§7,§f " + df.format(FeastManager.mainBlock.getLocation().getZ()) + "§7 em §f4 §7segundos!");
        }
        if(Main.Andamento == 1197) {
        DecimalFormat df = new DecimalFormat("##.#");
        Bukkit.broadcastMessage("§7[§a!§7] O Feast nascera nas coordenadas §f" + df.format(FeastManager.mainBlock.getLocation().getX()) + "§7,§f " + df.format(FeastManager.mainBlock.getLocation().getY()) + "§7,§f " + df.format(FeastManager.mainBlock.getLocation().getZ()) + "§7 em §f3 §7segundos!");
        }
        if(Main.Andamento == 1198) {
        DecimalFormat df = new DecimalFormat("##.#");
        Bukkit.broadcastMessage("§7[§a!§7] O Feast nascera nas coordenadas §f" + df.format(FeastManager.mainBlock.getLocation().getX()) + "§7,§f " + df.format(FeastManager.mainBlock.getLocation().getY()) + "§7,§f " + df.format(FeastManager.mainBlock.getLocation().getZ()) + "§7 em §f2 §7segundos!");
        }
        if(Main.Andamento == 1199) {
        DecimalFormat df = new DecimalFormat("##.#");
        Bukkit.broadcastMessage("§7[§a!§7] O Feast nascera nas coordenadas §f" + df.format(FeastManager.mainBlock.getLocation().getX()) + "§7,§f " + df.format(FeastManager.mainBlock.getLocation().getY()) + "§7,§f " + df.format(FeastManager.mainBlock.getLocation().getZ()) + "§7 em §f1 §7segundo!");
        }
        if(Main.Andamento == 1200) {
        FeastManager.spawnFeast();
        }
        if(Main.Andamento == 2400) {
        BonusFeast.announceFeast(1);
        BonusFeast.spawnFeast();
        }
        if(Main.Andamento == 3000) {
        CMDArena.criarAreaBatle();
        Bukkit.broadcastMessage("§7===========================");
        Bukkit.broadcastMessage("§7[§a!§7]§a§l ARENA §c§lPvP §a§lFINAL GERADA!");
        Bukkit.broadcastMessage("§7===========================");
        }
        if(Main.Andamento == 3600) {
        Bukkit.broadcastMessage("§7===========================");
        Bukkit.broadcastMessage("§7[§a!§7]§a§l MINI ARENA EM 5 MINUTOS!");
        Bukkit.broadcastMessage("§7===========================");
        }
        if(Main.Andamento == 3900) {
        CMDMiniArena.criarAreaBatle();
        Bukkit.broadcastMessage("§7===========================");
        Bukkit.broadcastMessage("§7[§a!§7]§a§l MINI ARENA GERADA!");
        Bukkit.broadcastMessage("§7[§a!§7]§a§l SUA HABILIDADE FOI DESATIVADA!");
        Bukkit.broadcastMessage("§7[§a!§7]§a§l TEMPO MAXIMO §c§l20 §a§lMINUTOS!");
        Bukkit.broadcastMessage("§7===========================");
        }
        if(Main.Andamento == 4400) {
        Bukkit.shutdown();
        }
        Bukkit.getPluginManager().callEvent(new Segundos());
       }
      }, 0L, 20L));
     }
    
   public static void cancel() {
   if (shed_id != null) {
    Bukkit.getServer().getScheduler().cancelTask(shed_id.intValue());
     shed_id = null;
    }
  }
}