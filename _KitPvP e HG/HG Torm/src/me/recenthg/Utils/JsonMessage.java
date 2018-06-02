package me.recenthg.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class JsonMessage
{

private String message;

public JsonMessage(String message)
{
  this.message = ("[\"\", {\"text\":\"" + message + "\"");
}

public void addComand(String comando)
{
  this.message = (this.message + ",\"clickEvent\":{\"action\":\"run_command\",\"value\":\"" + comando + "\"}");
}

public void addSugestao(String comando)
{
  this.message = (this.message + ",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"" + comando + "\"}");
}

public void addURL(String link)
{
  this.message = (this.message + ",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"" + link + "\"}");
}

@SuppressWarnings("deprecation")
public void enviarOnline()
{
  Player[] arrayOfPlayer;
  int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length;
  for (int i = 0; i < j; i++)
  {
    Player s1 = arrayOfPlayer[i];
    net.minecraft.server.v1_7_R4.PacketPlayOutChat packet = new net.minecraft.server.v1_7_R4.PacketPlayOutChat(net.minecraft.server.v1_7_R4.ChatSerializer.a(this.message + "}]"));
    ((org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer)s1).getHandle().playerConnection.sendPacket(packet);
  }
}

public void enviar(Player p)
{
  net.minecraft.server.v1_7_R4.PacketPlayOutChat packet = new net.minecraft.server.v1_7_R4.PacketPlayOutChat(net.minecraft.server.v1_7_R4.ChatSerializer.a(this.message + "}]"));
  ((org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
}
}

