/*    */ package br.nikao.comandos;
/*    */ 
/*    */ import br.nikao.outros.KitAPI;
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class Fly
/*    */   implements CommandExecutor
/*    */ {
/* 15 */   public static ArrayList<String> fly = new ArrayList();
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 19 */     if (!(sender instanceof Player)) {
/* 20 */       sender.sendMessage("§cApenas jogadores podem executar esse comando");
/* 21 */       return true;
/*    */     }
/* 23 */     if (args.length == 0) {
/* 24 */       Player p = (Player)sender;
/* 25 */       if (p.hasPermission("ng.fly")) {
/* 26 */         if (KitAPI.getkit(p) == "Nenhum") {
/* 27 */           if (fly.contains(p.getName())) {
/* 28 */             p.sendMessage("§c§lSeu fly foi desativado com sucesso !");
/* 29 */             fly.remove(p.getName());
/* 30 */             p.setAllowFlight(false);
/*    */           } else {
/* 32 */             p.sendMessage("§a§lSeu fly foi ativado com sucesso !");
/* 33 */             p.setAllowFlight(true);
/* 34 */             fly.add(p.getName());
/*    */           }
/*    */         } else {
/* 37 */           p.sendMessage("§c§lO Fly só pode ser ativo no spawn !");
/* 38 */           p.setAllowFlight(false);
/*    */         }
/*    */       }
/*    */     }
/* 42 */     if (args.length == 1) {
/* 43 */       Player p = (Player)sender;
/* 44 */       if (p.hasPermission("ng.setarfly")) {
/* 45 */         Player k = Bukkit.getPlayer(args[0]);
/* 46 */         if (k == null) {
/* 47 */           p.sendMessage("§cEsse jogador não existe ou está offline");
/* 48 */           return true;
/*    */         }
/* 50 */         if (fly.contains(k.getName())) {
/* 51 */           k.sendMessage("§c§lSeu fly foi §cdesativado §c§lpor: §e" + p.getName());
/* 52 */           p.sendMessage("§7Você §cdesativou §7o fly de: §a" + k.getName());
/* 53 */           fly.remove(k.getName());
/* 54 */           k.setAllowFlight(false);
/*    */         } else {
/* 56 */           k.sendMessage("§a§lSeu fly foi §aativado §a§lpor: §e" + p.getName());
/* 57 */           p.sendMessage("§7Você §aativou §7o fly de: §a" + k.getName());
/* 58 */           k.setAllowFlight(true);
/* 59 */           fly.add(k.getName());
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 64 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Vini\Downloads\KitPvP.jar!\br\nikao\comandos\Fly.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */