package Zey.PvP.Commands;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import Zey.PvP.Essencial.HorarioAPI;
import Zey.PvP.Essencial.ListVips;
import Zey.PvP.Main.Main;

public class SortearVip implements CommandExecutor {

 @Override
 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
  if (sender.hasPermission("zey.pvp.sortearvip")) {

   final ArrayList < String > Vip = new ArrayList < > ();
   for (ListVips s: ListVips.values()) {
    if (!Vip.contains(s.name())) {
     Vip.add(s.name().toLowerCase());

    }

   }
   Bukkit.broadcastMessage("               §c(!) §e§lKitPvP §c(!)         ");
   Bukkit.broadcastMessage("");
   Bukkit.broadcastMessage("          §aEstamos iniciando um §7Sorteio§a!  ");
   Bukkit.broadcastMessage("      §aPrêmio Ao Vencedor: §7Um  Vip de 15 Dias!       ");
   Bukkit.broadcastMessage("   §aHorário de Inicio: §7" + HorarioAPI.getHorario());
   Bukkit.broadcastMessage("");
   Bukkit.broadcastMessage("                 §c(!) §e§LSORTEIOS §c(!)            ");
   new BukkitRunnable() {

    @SuppressWarnings("deprecation")
    public void run() {
     ArrayList < Player > Players = new ArrayList < > ();

     for (Player all: Bukkit.getOnlinePlayers()) {
      if (!Players.contains(all)) {
       Players.add(all);
      }
     }

     Player random = Players.get(new Random().nextInt(Players.size()));
     Bukkit.broadcastMessage("           §c(!) §e§lKitPvP §c(!) ");
     Bukkit.broadcastMessage("");
     Bukkit.broadcastMessage("   §aO Sorteio de §7Um Vip§a Foi Finalizado!");
     Bukkit.broadcastMessage("     §aO Ganhador Foi: §7" + random.getName());
     Bukkit.broadcastMessage("  §aHorário de Término: §7" + HorarioAPI.getHorario());
     Random r = new Random();
     int x = r.nextInt(Vip.size());
     Bukkit.broadcastMessage("         §aO Vip Ganho Foi: §7" + Vip.get(x));
     Bukkit.broadcastMessage("");
     Bukkit.broadcastMessage("           §c(!) §e§LSORTEIOS §c(!)    ");
     Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + random.getName() + " group set " + Vip.get(x));


    }

   }.runTaskLater(Main.instance, 20 * 10);

  }
  return false;
 }

}