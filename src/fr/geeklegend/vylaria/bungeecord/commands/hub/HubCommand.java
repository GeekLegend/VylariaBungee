package fr.geeklegend.vylaria.bungeecord.commands.hub;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class HubCommand extends Command
{

	public HubCommand()
	{
		super("hub", null, "lobby", "leave");
	}

	@Override
	public void execute(CommandSender sender, String[] args)
	{
		if (!(sender instanceof ProxiedPlayer))
		{
			return;
		}
		
		ProxiedPlayer player = (ProxiedPlayer) sender;
		ServerInfo server = BungeeCord.getInstance().getServerInfo("lobby");
		
		if (server != null)
		{
			if (server.getName().equalsIgnoreCase(player.getServer().getInfo().getName()))
			{
				player.sendMessage(new TextComponent("§cVous êtes déjà connecter sur ce serveur."));
				
				return;
			}
			
			player.connect(server);
		}
	}

}
