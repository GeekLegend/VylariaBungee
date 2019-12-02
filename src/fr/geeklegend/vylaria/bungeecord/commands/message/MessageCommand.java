package fr.geeklegend.vylaria.bungeecord.commands.message;

import fr.geeklegend.vylaria.bungeecord.VylariaBungee;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class MessageCommand extends Command
{

	public MessageCommand()
	{
		super("message", null, "msg", "tell", "w");
	}

	@Override
	public void execute(CommandSender sender, String[] args)
	{
		if (!(sender instanceof ProxiedPlayer))
		{
			return;
		}
		
		ProxiedPlayer player = (ProxiedPlayer) sender;
		
		if (args.length <= 1)
		{
			player.sendMessage(new TextComponent("§cVeuillez utiliser cette commande: /msg <joueur> <message>"));
			
			return;
		}
		
		ProxiedPlayer target = ProxyServer.getInstance().getPlayer(args[0]);
		
		if (target == null)
		{
			player.sendMessage(new TextComponent("§cLe joueur " + args[0] + " n'est pas en ligne."));
			
			return;
		}
		
		StringBuilder builder = new StringBuilder();
		
		for (int i = 1; i < args.length; i++)
		{
			builder.append(args[i]).append(" ");
		}
		
		String message = builder.toString().trim();
		
		if (target.getName() == player.getName())
		{
			return;
		}

		if (!VylariaBungee.getInstance().getBlockedMessage().contains(target))
		{
			VylariaBungee.getInstance().getLastPlayerMessage().remove(player);
			VylariaBungee.getInstance().getLastPlayerMessage().remove(target);
			VylariaBungee.getInstance().getLastPlayerMessage().put(player, target);
			
			player.sendMessage(new TextComponent("§7§o(MP) Envoyer à " + target.getName() + ": " + message));
			target.sendMessage(new TextComponent("§7§o(MP) Reçu de " + player.getName() + ": " + message));
		} else
		{
			player.sendMessage(new TextComponent("§cLe joueur " + args[0] + " à bloquer vos messages privés."));
		}
	}

}
