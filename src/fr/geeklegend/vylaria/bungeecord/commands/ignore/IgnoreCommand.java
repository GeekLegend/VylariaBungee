package fr.geeklegend.vylaria.bungeecord.commands.ignore;

import fr.geeklegend.vylaria.bungeecord.VylariaBungee;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class IgnoreCommand extends Command
{

	public IgnoreCommand()
	{
		super("ignore", null);
	}

	@Override
	public void execute(CommandSender sender, String[] args)
	{
		if (!(sender instanceof ProxiedPlayer))
		{
			return;
		}
		
		ProxiedPlayer player = (ProxiedPlayer) sender;
		
		if (VylariaBungee.getInstance().getBlockedMessage().contains(player))
		{
			VylariaBungee.getInstance().getBlockedMessage().remove(player);
		
			player.sendMessage(new TextComponent("§aLes messages privés ne sont plus bloqués."));
		} else
		{
			VylariaBungee.getInstance().getBlockedMessage().add(player);
			
			player.sendMessage(new TextComponent("§aLes messages privés sont maintenant bloqués."));
		}
	}

}
