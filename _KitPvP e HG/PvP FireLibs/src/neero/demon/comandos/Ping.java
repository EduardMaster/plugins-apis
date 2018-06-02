/*    */ package neero.demon.comandos;
/*    */ 
/*    */ import java.lang.reflect.Field;
/*    */ import java.lang.reflect.Method;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ 
/*    */ public class Ping implements org.bukkit.command.CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args)
/*    */   {
/*    */     Method[] arrayOfMethod;
/*    */     int j;
/*    */     int i;
/*    */     Field[] arrayOfField;
/*    */     int m;
/*    */     int k;
/* 18 */     if (args.length > 0)
/*    */     {
/* 20 */       org.bukkit.entity.Player p = org.bukkit.Bukkit.getPlayer(args[0]);
/* 21 */       if (p != null)
/*    */       {
/* 23 */         String ping = null;
/* 24 */         j = (arrayOfMethod = p.getClass().getMethods()).length; for (i = 0; i < j; i++) { Method meth = arrayOfMethod[i];
/* 25 */           if (meth.getName().equals("getHandle")) {
/*    */             try
/*    */             {
/* 28 */               Object obj = meth.invoke(p, null);
/* 29 */               m = (arrayOfField = obj.getClass().getFields()).length; for (k = 0; k < m; k++) { Field field = arrayOfField[k];
/* 30 */                 if (field.getName().equals("ping")) {
/* 31 */                   ping = String.valueOf(field.getInt(obj));
/*    */                 }
/*    */               }
/*    */             }
/*    */             catch (Exception e)
/*    */             {
/* 37 */               e.printStackTrace();
/*    */             }
/*    */           }
/*    */         }
/* 41 */         sender.sendMessage("§7O ping de " + ChatColor.GRAY + p.getName() + " é: " + ChatColor.RED + ping + "ms");
/*    */       }
/*    */       else
/*    */       {
/* 45 */         sender.sendMessage(ChatColor.RED + "Player nao encontrado.");
/*    */       }
/* 47 */       return true;
/*    */     }
/* 49 */     if ((sender instanceof org.bukkit.entity.Player))
/*    */     {
/* 51 */       org.bukkit.entity.Player p = (org.bukkit.entity.Player)sender;
/* 52 */       String ping = null;
/* 53 */       j = (arrayOfMethod = p.getClass().getMethods()).length; for (i = 0; i < j; i++) { Method meth = arrayOfMethod[i];
/* 54 */         if (meth.getName().equals("getHandle")) {
/*    */           try
/*    */           {
/* 57 */             Object obj = meth.invoke(p, null);
/* 58 */             m = (arrayOfField = obj.getClass().getFields()).length; for (k = 0; k < m; k++) { Field field = arrayOfField[k];
/* 59 */               if (field.getName().equals("ping")) {
/* 60 */                 ping = String.valueOf(field.getInt(obj));
/*    */               }
/*    */             }
/*    */           }
/*    */           catch (Exception e)
/*    */           {
/* 66 */             e.printStackTrace();
/*    */           }
/*    */         }
/*    */       }
/* 70 */       sender.sendMessage(ChatColor.GRAY + "Seu ping é: " + ChatColor.RED + ping + "ms");
/*    */     }
/*    */     else
/*    */     {
/* 74 */       sender.sendMessage(ChatColor.GRAY + "Seu ping é: " + ChatColor.RED + "0ms");
/*    */     }
/* 76 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Infinite Sea\Desktop\Meus plugins\JaapaPvP.jar!\com\Nerio\net\commands\Ping.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */