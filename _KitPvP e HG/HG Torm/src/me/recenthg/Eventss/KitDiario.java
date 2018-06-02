package me.recenthg.Eventss;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import me.recenthg.Main;
import me.recenthg.Manager.ListKits;
import me.recenthg.Manager.Listeners;
import me.recenthg.Utils.Estado;

public class KitDiario extends Loja
  implements Listener
{
  @EventHandler
  public void clicar(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();

    if ((p.getItemInHand().getType() == Material.MINECART) && 
      (Main.estados == Estado.INICIANDO))
      Shop(p, 1, 0, 0);
  }

  public static void Shop(Player sender, int dia, int horas, int minutos)
  {
    Setup(sender);
    if ((getInt("Dia").intValue() <= Calendar.getInstance().get(5)) && 
      (getInt("Horas").intValue() <= Calendar.getInstance().get(11)) && 
      (getInt("Minutos").intValue() <= Calendar.getInstance().get(12))) {
      ArrayList<String> Kit = new ArrayList<String>();
      for (ListKits s : ListKits.values()) {
        if (!Kit.contains(s.name())) {
          Kit.add(s.name());
        }
      }
      Random r = new Random();
      int ra = r.nextInt(Kit.size());
      String kit = (String)Kit.get(ra);
      sender.sendMessage("§8[§2§l!§8] §7Você Ganhou Kit §4§l" + kit);
      Listeners.firework(sender);
      Loja.SetConfig("Dia", Calendar.getInstance().get(5) + dia);
      Loja.SetConfig("Horas", Calendar.getInstance().get(11) + horas);
      Loja.SetConfig("Minutos", Calendar.getInstance().get(12) + minutos);
      if (getString("Kit") != null) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + sender.getName() + " remove Effects.Kit." + getString("Kit"));

        Loja.SetConfig("Kit", null);
      }
      Loja.SetConfig("Kit", kit);
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + sender.getName() + " add Effects.Kit." + kit);
      if (Calendar.DATE == Loja.getInt("Dia")) {
          if (Calendar.DATE == Loja.getInt("Horas")) {
              if (Calendar.DATE == Loja.getInt("Minutos")) {
                  Loja.SetConfig("Dia", null);
                  Loja.SetConfig("Horas", null);
                  Loja.SetConfig("Minutos", null);
                  Loja.SetConfig("Kit", null);
              }
          }
      }
    }
    else
    {
      sender.sendMessage("§8[§2§l!§8] §7Pegue Outro Kit No §4" + getProxKIT(sender));
    }
  }
}