package Zey.PvP.APIs;

import net.minecraft.server.v1_7_R4.*;

public class ChatInterativo
{
    public static void Comando(final String p, final String MensagemNoChat, final String ComandoAoClicar, final String MouseEncima) {
        final IChatBaseComponent base = (IChatBaseComponent)new ChatMessage(MensagemNoChat, new Object[0]);
        base.setChatModifier(new ChatModifier());
        base.getChatModifier().setChatClickable(new ChatClickable(EnumClickAction.RUN_COMMAND, ComandoAoClicar));
        base.getChatModifier().a(new ChatHoverable(EnumHoverAction.SHOW_TEXT, (IChatBaseComponent)new ChatMessage(MouseEncima, new Object[0])));
        final PlayerList list = MinecraftServer.getServer().getPlayerList();
        list.getPlayer(p).sendMessage(base);
    }
    
    public static void Link(final String p, final String Mensagem, final String LinkAoClicar, final String MouseEncima) {
        final IChatBaseComponent base = (IChatBaseComponent)new ChatMessage(Mensagem, new Object[0]);
        base.setChatModifier(new ChatModifier());
        base.getChatModifier().setChatClickable(new ChatClickable(EnumClickAction.OPEN_URL, LinkAoClicar));
        base.getChatModifier().a(new ChatHoverable(EnumHoverAction.SHOW_TEXT, (IChatBaseComponent)new ChatMessage(MouseEncima, new Object[0])));
        final PlayerList list = MinecraftServer.getServer().getPlayerList();
        list.getPlayer(p).sendMessage(base);
    }
}
