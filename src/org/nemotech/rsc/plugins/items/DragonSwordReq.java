package org.nemotech.rsc.plugins.items;

import org.nemotech.rsc.model.player.InvItem;
import org.nemotech.rsc.model.player.Player;
import org.nemotech.rsc.plugins.listeners.executive.WieldExecutiveListener;

import static org.nemotech.rsc.plugins.Plugin.*;

/*
    Ensures that the player is allowed to wield the Dragon Sword
 */
@SuppressWarnings("unused")
public class DragonSwordReq implements WieldExecutiveListener {
    @Override
    public boolean blockWield(Player player, InvItem item) {
        if (item.getID() == 593 && player.getQuestStage(LOST_CITY) == 4) {
            return true;
        } else {
            message(player,"you have not earned the right to wear this yet");
            message(player,"you need to complete the Lost city of zanaris quest");
            return false;
        }
    }
}
