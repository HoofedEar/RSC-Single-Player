package org.nemotech.rsc.client.action.impl;

import java.util.ArrayList;
import java.util.Map;

import org.nemotech.rsc.external.EntityManager;
import org.nemotech.rsc.model.player.InvItem;
import org.nemotech.rsc.model.player.Player;
import org.nemotech.rsc.model.World;
import org.nemotech.rsc.util.Formulae;
import org.nemotech.rsc.client.sound.SoundEffect;
import org.nemotech.rsc.plugins.PluginManager;
import org.nemotech.rsc.client.action.ActionHandler;

import static org.nemotech.rsc.plugins.Plugin.*;

public class WieldHandler implements ActionHandler {

    public void handleWield(int index) {
        Player player = World.getWorld().getPlayer();
        if (player.isBusy() && !player.inCombat()) {
            return;
        }

        player.reset();

        InvItem item = player.getInventory().get(index);
        int id = item.getID();

        StringBuilder requirements = new StringBuilder();

        for (Map.Entry<Integer, Integer> e : EntityManager.getItemWieldableDef(id).getStatsRequired()) {
            if (player.getMaxStat(e.getKey()) < e.getValue()) {
                requirements.append(e.getValue()).append(" ").append(Formulae.STAT_NAMES[e.getKey()]).append(", ");
            }
        }
        if (!requirements.toString().equals("")) {
            player.getSender().sendMessage("You must have at least " + requirements.substring(0, requirements.length() - 2) + " to use this item");
            return;
        }
        if (EntityManager.getItemWieldableDef(id).femaleOnly() && player.isMale()) {
            player.getSender().sendMessage("This piece of armor is for a female only");
            return;
        }
        ArrayList<InvItem> items = player.getInventory().getItems();
        for (InvItem i : items) {
            if (item.wieldingAffectsItem(i) && i.isWielded()) {
                handleUnwield(i, false);
            }
        }

        // Items that require certain quests be completed
        if (id == 594 && player.getQuestStage(HEROS_QUEST) != -1) { // Dragon Axe
            message(player, "you have not earned the right to wear this yet");
            message(player, "you need to complete the Hero's guild entry quest");
            return;
        } else if (id == 593 && player.getQuestStage(LOST_CITY) != -1) { // Dragon sword
            message(player, "you have not earned the right to wear this yet");
            message(player, "you need to complete the Lost city of zanaris quest");
            return;
        } else if (id == 401 && player.getQuestStage(DRAGON_SLAYER) != -1) { // Rune plate body
            message(player, "you have not earned the right to wear this yet");
            message(player, "you need to complete the dragon slayer quest");
            return;
        }

        boolean canWield = PluginManager.getInstance().blockDefaultAction("Wield", new Object[]{player, item});
        if (canWield) {
            return;
        }

        item.setWield(true);
        player.getSender().sendSound(SoundEffect.CLICK);
        int pos = EntityManager.getItemWieldableDef(id).getWieldPos();
        player.updateWornItems(pos, EntityManager.getItemWieldableDef(id).getSprite());
        player.getSender().sendInventory();
        player.getSender().sendEquipmentStats();
    }

    public void handleUnwield(int index) {
        Player player = World.getWorld().getPlayer();
        handleUnwield(player.getInventory().get(index), true);
    }

    public void handleUnwield(InvItem item, boolean sound) {
        Player player = World.getWorld().getPlayer();
        if (player.isBusy() && !player.inCombat()) {
            return;
        }

        player.reset();
        int id = item.getID();
        if (PluginManager.getInstance().blockDefaultAction("Unwield", new Object[]{player, item})) {
            return;
        }
        item.setWield(false);
        if (sound) {
            player.getSender().sendSound(SoundEffect.CLICK);
        }
        int pos = EntityManager.getItemWieldableDef(id).getWieldPos();
        player.updateWornItems(pos, player.getAppearance().getSprite(pos));
        player.getSender().sendInventory();
        player.getSender().sendEquipmentStats();
    }
}