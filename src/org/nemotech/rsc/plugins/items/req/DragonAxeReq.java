package org.nemotech.rsc.plugins.items.req;

import org.nemotech.rsc.model.player.InvItem;
import org.nemotech.rsc.model.player.Player;
import org.nemotech.rsc.plugins.listeners.executive.WieldExecutiveListener;

import static org.nemotech.rsc.plugins.Plugin.*;

/*
    Ensures that the player is allowed to wield the Dragon Axe
 */
@SuppressWarnings("unused")
public class DragonAxeReq implements WieldExecutiveListener {
    @Override
    public boolean blockWield(Player player, InvItem item) {
        if (item.getID() != 594) {
            return false;
        }

        if (player.getQuestStage(HEROS_QUEST) == 3) {
            return true;
        } else {
            message(player,"you have not earned the right to wear this yet");
            message(player,"you need to complete the Hero's guild entry quest");
            return false;
        }
    }
}