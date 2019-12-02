package fr.geeklegend.vylaria.bungeecord.listeners.manager;

import fr.geeklegend.vylaria.bungeecord.VylariaBungee;
import fr.geeklegend.vylaria.bungeecord.listeners.other.PostLoginListener;
import fr.geeklegend.vylaria.bungeecord.listeners.other.ProxyPingListener;
import net.md_5.bungee.api.plugin.PluginManager;

public class ListenersManager
{
	
	private VylariaBungee instance;
	
	public ListenersManager(VylariaBungee instance)
	{
		this.instance = instance;
	}
	
	public void registerListeners()
	{
		PluginManager pluginManager = instance.getProxy().getPluginManager();
		pluginManager.registerListener(instance, new ProxyPingListener());
		pluginManager.registerListener(instance, new PostLoginListener());
	}
	
	public VylariaBungee getInstance()
	{
		return instance;
	}

}
