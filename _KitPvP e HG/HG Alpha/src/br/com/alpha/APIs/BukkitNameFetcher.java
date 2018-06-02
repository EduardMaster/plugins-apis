package br.com.alpha.APIs;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import net.minecraft.util.com.google.common.cache.Cache;
import net.minecraft.util.com.google.common.cache.CacheBuilder;
import net.minecraft.util.com.google.common.cache.CacheLoader;
import net.minecraft.util.com.google.gson.JsonObject;
import net.minecraft.util.com.google.gson.JsonParser;

public class BukkitNameFetcher extends NameFetcher
{
    private JsonParser parser;
    private Cache<UUID, String> uuidName;
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public BukkitNameFetcher() {
        this.parser = new JsonParser();
        this.uuidName = (Cache<UUID, String>)CacheBuilder.newBuilder().expireAfterWrite(1L, TimeUnit.DAYS).build((CacheLoader)new CacheLoader<UUID, String>() {
            public String load(final UUID id) throws Exception {
                return BukkitNameFetcher.this.loadName(id);
            }
        });
    }
    
    private String loadName(final UUID id) {
        String name = null;
        Player p = Bukkit.getPlayer(id);
        if (p != null) {
            name = p.getName();
            p = null;
        }
        else {
            name = this.loadFromServers(id);
        }
        return name;
    }
    
    public String load(UUID id, String server) {
        String name = null;
        try {
            String[] infos = server.split("#");
            String serverUrl = infos[0].replace("%player-uuid%", id.toString().replace("-", ""));
            URL url = new URL(serverUrl);
            java.io.InputStream is = url.openStream();
            InputStreamReader streamReader = new InputStreamReader(is, Charset.forName("UTF-8"));
            JsonObject object = this.parser.parse((Reader)streamReader).getAsJsonObject();
            if (object.has(infos[1]) && object.has(infos[2]) && object.get(infos[2]).getAsString().equalsIgnoreCase(id.toString().replace("-", ""))) {
                name = object.get(infos[1]).getAsString();
            }
            streamReader.close();
            is.close();
            object = null;
            streamReader = null;
            is = null;
            url = null;
            serverUrl = null;
            infos = null;
            server = null;
            id = null;
        }
        catch (Exception ex) {
            return null;
        }
        return name;
    }
    
    public String getUsername(final UUID id) {
        try {
            return (String)this.uuidName.get(id, null);
        }
        catch (Exception e) {
            return null;
        }
    }
}
