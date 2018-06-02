package br.com.alpha.APIs;

import java.util.*;

public abstract class NameFetcher
{
    private ArrayList<String> servers;
    private HashMap<String, Integer> fails;
    private int current;
    
    public NameFetcher() {
        (this.servers = new ArrayList<String>()).add("https://sessionserver.mojang.com/session/minecraft/profile/%player-uuid%#name#id");
        this.servers.add("https://craftapi.com/api/user/username/%player-uuid%#username#uuid");
        this.servers.add("https://us.mc-api.net/v3/name/%player-uuid%#name#uuid");
        this.servers.add("https://mcapi.ca/name/uuid/%player-uuid%#name#uuid");
        this.fails = new HashMap<String, Integer>();
        this.current = 0;
    }
    
    private String getNextServer() {
        if (this.current == this.servers.size() - 1) {
            this.current = 0;
        }
        else {
            ++this.current;
        }
        return this.servers.get(this.current);
    }
    
    public String loadFromServers(final UUID id) {
        String name = null;
        String server1 = this.getNextServer();
        name = this.load(id, server1);
        if (name == null) {
            name = this.load(id, this.getNextServer());
            if (name != null) {
                if (this.fails.containsKey(server1)) {
                    this.fails.put(server1, this.fails.get(server1) + 1);
                }
                else {
                    this.fails.put(server1, 1);
                }
            }
        }
        server1 = null;
        return name;
    }
    
    public abstract String load(final UUID p0, final String p1);
    
    public abstract String getUsername(final UUID p0);
}
