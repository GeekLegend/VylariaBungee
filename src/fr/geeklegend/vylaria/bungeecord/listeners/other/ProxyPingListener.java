package fr.geeklegend.vylaria.bungeecord.listeners.other;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ProxyPingListener implements Listener
{
	
	@EventHandler
	public void onPostLogin(PostLoginEvent event)
	{
		ProxiedPlayer player = event.getPlayer();
		
		player.setTabHeader(new TextComponent("§e§lVYLARIA"), new TextComponent("§bTwitter: @Vylaria_Fr\n§eplay.vylaria.eu"));
	}

}
