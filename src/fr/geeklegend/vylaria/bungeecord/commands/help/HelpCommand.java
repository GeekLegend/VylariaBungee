package fr.geeklegend.vylaria.bungeecord.commands.help;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class HelpCommand extends Command
{

	public HelpCommand()
	{
		super("help", null, "aide");
	}

	@Override
	public void execute(CommandSender sender, String[] args)
	{
		if (!(sender instanceof ProxiedPlayer))
		{
			return;
		}
		
		ProxiedPlayer player = (ProxiedPlayer) sender;
		
		if (args.length == 0)
		{
			player.sendMessage(new TextComponent(" "));
			player.sendMessage(new TextComponent("§6/report <joueur> - Signaler un joueur."));
			player.sendMessage(new TextComponent("§6/bug <bug> - Signaler un bug."));
			player.sendMessage(new TextComponent("§6/msg <joueur> <message> - Envoyer un message privé."));
			player.sendMessage(new TextComponent("§6/ignore - Ignorer les messages privés."));
			player.sendMessage(new TextComponent("§6/lobby - Retourner sur le hub."));
			player.sendMessage(new TextComponent(" "));
		}
	}

}
