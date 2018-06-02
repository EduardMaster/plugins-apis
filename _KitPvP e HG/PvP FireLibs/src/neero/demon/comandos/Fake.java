/*     */ package neero.demon.comandos;
/*     */ 
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.kitteh.tag.AsyncPlayerReceiveNameTagEvent;
/*     */ import org.kitteh.tag.TagAPI;
/*     */ 
/*     */ public class Fake implements CommandExecutor, Listener
/*     */ {
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  17 */
/*  20 */     Player p = (Player)sender;
/*  21 */     if ((cmd.getName().equalsIgnoreCase("fake")) && 
/*  22 */       (p.hasPermission("fire.fake")))
/*     */     {
/*  24 */       if (args.length == 0)
/*     */       {
/*  26 */         p.sendMessage(ChatColor.AQUA + "Nicks disponiveis: " + ChatColor.WHITE + " atticjnr, ZeBucetinha, IceCubeHD1, Popoloco23, akrat, HaxyPvP, vexx21322, Mielsen, ManningQB18, Frewp, MiniMatt");
/*  27 */         p.sendMessage(ChatColor.AQUA + "Para voltar ao nick padrao use:" + ChatColor.WHITE + " /Fake #");
/*  28 */         return true;
/*     */       }
/*  30 */       String nick = "";
/*  31 */       String[] arrayOfString; int j = (arrayOfString = args).length; for (int i = 0; i < j; i++) { String arg = arrayOfString[i];
/*  32 */         nick = nick + arg + " ";
/*     */       }
/*  34 */       nick = nick.substring(0, nick.length() - 1);
/*  35 */       if (args[0].equals("atticjnr"))
/*     */       {
/*  37 */         p.setDisplayName(nick);
/*  38 */         p.setPlayerListName(nick);
/*  39 */         p.sendMessage(ChatColor.WHITE + "Agora seu nick é " + ChatColor.AQUA + nick);
/*     */       }
/*  41 */       if (args[0].equals("IceCubeHD1"))
/*     */       {
/*  43 */         p.setDisplayName(nick);
/*  44 */         p.setPlayerListName(nick);
/*  45 */         p.sendMessage(ChatColor.WHITE + "Agora seu nick é " + ChatColor.AQUA + nick);
/*     */       }
/*  47 */       if (args[0].equals("Popoloco23"))
/*     */       {
/*  49 */         p.setDisplayName(nick);
/*  50 */         p.setPlayerListName(nick);
/*  51 */         p.sendMessage(ChatColor.WHITE + "Agora seu nick é " + ChatColor.AQUA + nick);
/*     */       }
/*  53 */       if (args[0].equals("akrat"))
/*     */       {
/*  55 */         p.setDisplayName(nick);
/*  56 */         p.setPlayerListName(nick);
/*  57 */         p.sendMessage(ChatColor.WHITE + "Agora seu nick é " + ChatColor.AQUA + nick);
/*     */       }
/*  59 */       if (args[0].equals("HaxyPvP"))
/*     */       {
/*  61 */         p.setDisplayName(nick);
/*  62 */         p.setPlayerListName(nick);
/*  63 */         p.sendMessage(ChatColor.WHITE + "Agora seu nick é " + ChatColor.AQUA + nick);
/*     */       }
/*  65 */       if (args[0].equals("vexx21322"))
/*     */       {
/*  67 */         p.setDisplayName(nick);
/*  68 */         p.setPlayerListName(nick);
/*  69 */         p.sendMessage(ChatColor.WHITE + "Agora seu nick é " + ChatColor.AQUA + nick);
/*     */       }
/*  71 */       if (args[0].equals("Mielsen"))
/*     */       {
/*  73 */         p.setDisplayName(nick);
/*  74 */         p.setPlayerListName(nick);
/*  75 */         p.sendMessage(ChatColor.WHITE + "Agora seu nick é " + ChatColor.AQUA + nick);
/*     */       }
/*  77 */       if (args[0].equals("ManningQB18"))
/*     */       {
/*  79 */         p.setDisplayName(nick);
/*  80 */         p.setPlayerListName(nick);
/*  81 */         p.sendMessage(ChatColor.WHITE + "Agora seu nick é " + ChatColor.AQUA + nick);
/*     */       }
/*  83 */       if (args[0].equals("Frewp"))
/*     */       {
/*  85 */         p.setDisplayName(nick);
/*  86 */         p.setPlayerListName(nick);
/*  87 */         p.sendMessage(ChatColor.WHITE + "Agora seu nick é " + ChatColor.AQUA + nick);
/*     */       }
/*  89 */       if (args[0].equals("MiniMatt"))
/*     */       {
/*  91 */         p.setDisplayName(nick);
/*  92 */         p.setPlayerListName(nick);
/*  93 */         TagAPI.refreshPlayer(p);
/*  94 */         p.sendMessage(ChatColor.WHITE + "Agora seu nick é " + ChatColor.AQUA + nick);
/*     */       }
/*  96 */       if (args[0].equals("ZeBucetinha"))
/*     */       {
/*  98 */         p.setDisplayName(nick);
/*  99 */         p.setPlayerListName(nick);
/* 100 */         TagAPI.refreshPlayer(p);
/* 101 */         p.sendMessage(ChatColor.WHITE + "Agora seu nick é " + ChatColor.AQUA + nick);
/*     */       }
/* 103 */       if (args[0].equalsIgnoreCase("#"))
/*     */       {
/* 105 */         p.setDisplayName(p.getName());
/* 106 */         p.setPlayerListName(p.getName());
/* 107 */         p.sendMessage(ChatColor.AQUA + "Você voltou ao seu §bnick §fpadrao!");
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 114 */     return true;
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onNameTag(AsyncPlayerReceiveNameTagEvent e)
/*     */   {
/* 120 */     Player p = e.getNamedPlayer();
/* 121 */     e.setTag(p.getDisplayName());
/*     */   }
/*     */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\commands\Fake.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */