package fr.geeklegend.vylaria.bungeecord.commands.manager;

import fr.geeklegend.vylaria.bungeecord.VylariaBungee;
import fr.geeklegend.vylaria.bungeecord.commands.BugCommand;
import fr.geeklegend.vylaria.bungeecord.commands.HelpCommand;
import fr.geeklegend.vylaria.bungeecord.commands.HubCommand;
import fr.geeklegend.vylaria.bungeecord.commands.IgnoreCommand;
import fr.geeklegend.vylaria.bungeecord.commands.MessageCommand;

public class CommandsManager
{

	private VylariaBungee instance;
	
	public CommandsManager(VylariaBungee instance)
	{
		this.instance = instance;
	}
	
	public void registerCommands()
	{
		instance.getProxy().getPluginManager().registerCommand(instance, new HubCommand());
		instance.getProxy().getPluginManager().registerCommand(instance, new HelpCommand());
		instance.getProxy().getPluginManager().registerCommand(instance, new MessageCommand());
		instance.getProxy().getPluginManager().registerCommand(instance, new IgnoreCommand());
		instance.getProxy().getPluginManager().registerCommand(instance, new BugCommand());
	}
	
}
