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
import Zey.PvP.Essencial.ListKits;
import Zey.PvP.Main.Main;

public class SortearKit implements CommandExecutor {

 @Override
 public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
  if (sender.hasPermission("zey.pvp.sortearkit")) {

   final ArrayList < String > Kit = new ArrayList < > ();
   for (ListKits s: ListKits.values()) {
    if (!Kit.contains(s.name())) {
     Kit.add(s.name().toLowerCase());

    }

   }
   Bukkit.broadcastMessage("               §c(!) §e§lKitPvP §c(!)         ");
   Bukkit.broadcastMessage("");
   Bukkit.broadcastMessage("          §aEstamos iniciando um §7Sorteio§a!  ");
   Bukkit.broadcastMessage("           §aPrêmio Ao Vencedor: §7Um Kit Aleatório!       ");
   Bukkit.broadcastMessage("              §aHorário de Inicio: §7" + HorarioAPI.getHorario());
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
     Bukkit.broadcastMessage("       §aO Sorteio de §7Um kit§a Foi Finalizado!");
     Bukkit.broadcastMessage("       §aO Ganhador Foi: §7" + random.getName());
     Bukkit.broadcastMessage("     §aHorário de Término: §7" + HorarioAPI.getHorario());
     Random r = new Random();
     int x = r.nextInt(Kit.size());
     Bukkit.broadcastMessage("         §aO Kit Ganho Foi: §7" + Kit.get(x));
     Bukkit.broadcastMessage("");
     Bukkit.broadcastMessage("           §c(!) §e§LSORTEIOS §c(!)    ");
     Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + random.getName() + " add kit." + Kit.get(x));


    }

   }.runTaskLater(Main.instance, 20 * 10);

  }
  return false;
 }

}