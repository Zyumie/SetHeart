package fr.zyumie.setheart;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Bukkit;

import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!sender.hasPermission("heal.player")) {
            sender.sendMessage("Vous n'avez pas la permission d'utiliser cette commande.");
            return false;
        }

        if (args.length != 2) {
            sender.sendMessage("Utilisation: /heal <nom du joueur> <nombre de cœurs>");
            return false;
        }

        String playerName = args[0];
        Player targetPlayer = Bukkit.getPlayer(playerName); // Replace the casting with Bukkit.getPlayer()

        if (targetPlayer == null) {
            sender.sendMessage("Le joueur " + playerName + " n'est pas connecté.");
            return false;
        }

        int health;
        try {
            health = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            sender.sendMessage("Le nombre de cœurs doit être un nombre entier.");
            return false;
        }

        if (health < 1 || health > 1000) {
            sender.sendMessage("Le nombre de cœurs doit être compris entre 1 et 1000.");
            return false;
        }

        targetPlayer.setHealth(health);
       // sender.sendMessage("Le nombre de cœurs du joueur " + playerName + " a été défini à " + health + ".");
        return true;
    }
}
