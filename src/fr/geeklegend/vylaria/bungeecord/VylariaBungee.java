package fr.geeklegend.vylaria.bungeecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.geeklegend.vylaria.bungeecord.commands.manager.CommandsManager;
import fr.geeklegend.vylaria.bungeecord.listeners.manager.ListenersManager;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;

public class VylariaBungee extends Plugin
{
	
	private static VylariaBungee instance;
	
	private Map<ProxiedPlayer, ProxiedPlayer> lastPlayerMessage;
	
	private List<ProxiedPlayer> blockedMessage;
	
	@Override
	public void onEnable()
	{
		instance = this;
		
		lastPlayerMessage = new HashMap<ProxiedPlayer, ProxiedPlayer>();
		
		blockedMessage = new ArrayList<ProxiedPlayer>();
		
		new ListenersManager(this).registerListeners();
		new CommandsManager(this).registerCommands();
	}
	
	@Override
	public void onDisable()
	{
		instance = null;
	}
	
	public static VylariaBungee getInstance()
	{
		return instance;
	}
	
	public Map<ProxiedPlayer, ProxiedPlayer> getLastPlayerMessage()
	{
		return lastPlayerMessage;
	}
	
	public List<ProxiedPlayer> getBlockedMessage()
	{
		return blockedMessage;
	}

}
