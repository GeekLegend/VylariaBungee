package fr.geeklegend.vylaria.bungeecord.commands.manager;

import fr.geeklegend.vylaria.bungeecord.VylariaBungee;
import fr.geeklegend.vylaria.bungeecord.commands.bug.BugCommand;
import fr.geeklegend.vylaria.bungeecord.commands.help.HelpCommand;
import fr.geeklegend.vylaria.bungeecord.commands.hub.HubCommand;
import fr.geeklegend.vylaria.bungeecord.commands.ignore.IgnoreCommand;
import fr.geeklegend.vylaria.bungeecord.commands.message.MessageCommand;

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
