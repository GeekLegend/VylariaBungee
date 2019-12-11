package fr.geeklegend.vylaria.bungeecord.listeners.other;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.md_5.bungee.api.Favicon;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PostLoginListener implements Listener
{
	
	@EventHandler
	public void onProxyPing(ProxyPingEvent event)
	{
		ServerPing serverPing = event.getResponse();
		
		serverPing.setDescription("§6Vylaria §f[§e1.8 ➲ §e1.13§f] §7| §6Sheepwars, UHC, ...\n          §bDiscord: discord.gg/rsW8RjG ");
		serverPing.setVersion(new ServerPing.Protocol("§b1.8+", serverPing.getVersion().getProtocol()));
		
		try {
			serverPing.setFavicon(Favicon.create(ImageIO.read(new File("favicon.png"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		event.setResponse(serverPing);
	}

}
