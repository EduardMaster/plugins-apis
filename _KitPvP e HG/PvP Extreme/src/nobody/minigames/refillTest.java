package nobody.minigames;

import java.util.Random;

import nobody.eventos.Join;
import nobody.eventos.KitAPI;
import nobody.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class refillTest
{
  Random rand = new Random();
  
  public refillTest(final Player p)
  {
    if (KitAPI.refillTest.contains(p.getName()))
    {
      p.sendMessage("§eExtreme§fKits »  §fVocê já está em um treino");
      return;
    }
    new BukkitRunnable()
    {
      int seconds = 5;
      
      public void run()
      {
        if (this.seconds > 0)
        {
          p.sendMessage("§eExtreme§fKits »  §aMinigame Iniciando em " + this.seconds + " segundos!");
          this.seconds -= 1;
          return;
        }
        if (this.seconds == 0)
        {
          this.seconds = -1;
          p.getInventory().clear();
          p.sendMessage("§eExtreme§fKits »  §7O Desafio §cComeçou!!");
          KitAPI.refillTest.add(p.getName());
          KitAPI.refillTestTime.put(p.getName(), Integer.valueOf(refillTest.this.getTime(p) + 1));
          ItemStack sopa = Methodos.itemStack(Material.MUSHROOM_SOUP, "§aSopa");
          int r = refillTest.this.rand.nextInt(16);
          Methodos.fillLinhaInventory(p.getInventory(), r + 9, sopa, sopa, sopa, sopa, sopa, sopa, sopa, sopa, 
            sopa);
        }
        KitAPI.refillTestTime.put(p.getName(), Integer.valueOf(refillTest.this.getTime(p) + 1));
        p.setLevel(refillTest.this.getTime(p));
        if (refillTest.this.hasRefiled(p))
        {
          p.setExp(0.0F);
          p.sendMessage("§eExtreme§fKits »  §7Você terminou seu refil , ele foi feito em §c" + StringTimer.timerChecker(((Integer)KitAPI.refillTestTime.get(p.getName())).intValue()));
          p.teleport(Bukkit.getWorld("world").getSpawnLocation());
          Join.entrar(p);
          KitAPI.refillTest.remove(p.getName());
          KitAPI.refillTestTime.remove(p.getName());
          cancel();
          
          return;
        }
        if ((!KitAPI.refillTest.contains(p.getName())) && (this.seconds < 0)) {
          cancel();
        }
        if (this.seconds >= 60)
        {
          p.sendMessage("§eExtreme§fKits »  §cSe passou 1 minuto e você não terminou o refil , teste cancelado");
          cancel();
        }
      }
    }.runTaskTimer(Main.instance, 0L, 20L);
  }
  
  private int getTime(Player p)
  {
    if (!KitAPI.refillTestTime.containsKey(p.getName())) {
      return 0;
    }
    return ((Integer)KitAPI.refillTestTime.get(p.getName())).intValue();
  }
  
  private boolean hasRefiled(Player p)
  {
    try
    {
      if (p.getInventory().getItem(0).getType() == Material.AIR) {
        return false;
      }
      if (p.getInventory().getItem(1).getType() == Material.AIR) {
        return false;
      }
      if (p.getInventory().getItem(2).getType() == Material.AIR) {
        return false;
      }
      if (p.getInventory().getItem(3).getType() == Material.AIR) {
        return false;
      }
      if (p.getInventory().getItem(4).getType() == Material.AIR) {
        return false;
      }
      if (p.getInventory().getItem(5).getType() == Material.AIR) {
        return false;
      }
      if (p.getInventory().getItem(6).getType() == Material.AIR) {
        return false;
      }
      if (p.getInventory().getItem(7).getType() == Material.AIR) {
        return false;
      }
      if (p.getInventory().getItem(8).getType() == Material.AIR) {
        return false;
      }
    }
    catch (Exception e)
    {
      return false;
    }
    return true;
  }
}
