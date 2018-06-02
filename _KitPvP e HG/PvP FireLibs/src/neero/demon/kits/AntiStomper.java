/*     */ package neero.demon.kits;
/*     */ 
/*     */ /*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;

import neero.demon.Main;
import neero.demon.eventos.KitAPI;
import neero.demon.utils.Scoreboard;

/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ public class AntiStomper
/*     */   implements  CommandExecutor
/*     */ {
/*     */   public Main plugin;
/*     */   
/*     */   public AntiStomper(Main plugin)
/*     */   {
/*  33 */     this.plugin = plugin;
/*     */   }
/*     */   
/*  36 */   public static ArrayList<String> antistomper = new ArrayList();
/*  37 */   public static HashMap<Player, Player> hit = new HashMap();
/*     */   
/*     */   @EventHandler
/*     */   public void deathe(PlayerDeathEvent e) {
/*  41 */     Player p = e.getEntity();
/*     */     
/*  43 */     antistomper.remove(p);
/*  44 */     hit.remove(p);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void ent(PlayerJoinEvent e) {
/*  49 */     Player p = e.getPlayer();
/*     */     
/*  51 */     antistomper.remove(p);
/*  52 */     hit.remove(p);
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  57 */     Player jogador = (Player)sender;
/*  58 */     if (label.equalsIgnoreCase("antistomper2")) {
/*  59 */       if (jogador.hasPermission("kit2.antistomper"))
/*     */       {
	/*  56 */         if (!(KitAPI.getkit2(jogador) == ("Nenhum")))
/*     */         {
/*  63 */           jogador.sendMessage("§4§lKIT §7 §c§l§oVoce ja selecionou um kit !");
/*     */         }
/*     */         else
/*     */         {
/*  67 */           giveKit(jogador);
/*     */         }
/*     */         
/*     */       }
/*     */       else {
/*  72 */         jogador.sendMessage(ChatColor.RED + "Voce nao possue este kit !");
/*     */       }
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public static void giveKit(Player p)
/*     */   {
/*  81 */     p.sendMessage(ChatColor.GREEN + "§4§lKIT §7Voce escolheu Antistomper2! Pegue Outro Kit Para ir à Arena!");
			KitAPI.setKit2(p, "AntiStomper");
			Scoreboard.iscoriboard(p);
/*  88 */     antistomper.add(p.getName());
/*     */   }

}

/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\kits\antistomper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */