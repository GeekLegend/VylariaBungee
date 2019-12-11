package fr.geeklegend.vylaria.bungeecord.commands;

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
			player.sendMessage(new TextComponent("§e===== §e§lAide §e====="));
			player.sendMessage(new TextComponent("§e/report <joueur> §7- Signaler un joueur."));
			player.sendMessage(new TextComponent("§e/bug <bug> §7- Signaler un bug."));
			player.sendMessage(new TextComponent("§e/msg <joueur> <message> §7- Envoyer un message privé."));
			player.sendMessage(new TextComponent("§e/ignore §7- Ignorer les messages privés."));
			player.sendMessage(new TextComponent("§e/lobby §7- Retourner sur le hub."));
			player.sendMessage(new TextComponent(" "));
		}
	}

}
