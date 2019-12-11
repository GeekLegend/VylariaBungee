package fr.geeklegend.vylaria.bungeecord.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class BugCommand extends Command
{

	public BugCommand()
	{
		super("bug", null);
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
			player.sendMessage(new TextComponent("§cVeuillez utiliser la commande: /bug <bug>."));
		} else if (args.length > 0)
		{
			StringBuilder builder = new StringBuilder();
			
			for (int i = 0; i < args.length; i++)
			{
				builder.append(args[i]).append(" ");
			}
			
			String message = builder.toString().trim();
			
			for (ProxiedPlayer players : ProxyServer.getInstance().getPlayers())
			{
				if (players.hasPermission("vylaria.bug.alert"))
				{
					players.sendMessage(new TextComponent(" "));
					players.sendMessage(new TextComponent("§6Joueur: §e" + player.getName()));
					ComponentBuilder serverComponentBuilder = new ComponentBuilder("§6Serveur: §e" + player.getServer().getInfo().getName());
					TextComponent serverTextComponent = new TextComponent(serverComponentBuilder.create());
					serverTextComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§6Rejoindre le serveur").create()));
					serverTextComponent.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/server " + player.getServer().getInfo().getName()));
					players.sendMessage(serverTextComponent);
					players.sendMessage(new TextComponent("§6Bug: §e" + message));
					players.sendMessage(new TextComponent(" "));

				}
			}
			
			player.sendMessage(new TextComponent("§aMerci beaucoup de nous avoir notifier ce bug."));
			player.sendMessage(new TextComponent("§aGrâce a toi, nous allons pouvoir régler cela."));
		}
	}

}
