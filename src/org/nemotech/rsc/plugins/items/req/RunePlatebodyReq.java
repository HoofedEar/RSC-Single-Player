package org.nemotech.rsc.plugins.items.req;

import org.nemotech.rsc.model.player.InvItem;
import org.nemotech.rsc.model.player.Player;
import org.nemotech.rsc.plugins.listeners.executive.WieldExecutiveListener;

import static org.nemotech.rsc.plugins.Plugin.*;

/*
    Ensures that the player is allowed to equip the Rune Platebody
 */
@SuppressWarnings("unused")
public class RunePlatebodyReq implements WieldExecutiveListener {
    @Override
    public boolean blockWield(Player player, InvItem item) {
        if (item.getID() != 401) {
            return false;
        }
        if (player.getQuestStage(DRAGON_SLAYER) == 4) {
            return true;
        } else {
            message(player, "you have not earned the right to wear this yet");
            message(player, "you need to complete the dragon slayer quest");
            return false;
        }
    }
}
