package org.nemotech.rsc.plugins.items;

import org.nemotech.rsc.model.player.InvItem;
import org.nemotech.rsc.model.player.Player;
import org.nemotech.rsc.plugins.listeners.executive.WieldExecutiveListener;

import static org.nemotech.rsc.plugins.Plugin.LOST_CITY;
import static org.nemotech.rsc.plugins.Plugin.message;

@SuppressWarnings("unused")
public class DragonSword implements WieldExecutiveListener {
    @Override
    public boolean blockWield(Player player, InvItem item) {
        if (item.getID() == 593 && player.getQuestStage(LOST_CITY) != 4) {
            message(player,"You must complete the Lost City quest to wield this weapon.");
            return false;
        }
        return true;
    }
}
