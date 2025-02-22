package org.nemotech.rsc.plugins.items;

import org.nemotech.rsc.event.ShortEvent;
import org.nemotech.rsc.model.player.InvItem;
import org.nemotech.rsc.model.player.Player;
import org.nemotech.rsc.model.World;
import org.nemotech.rsc.plugins.listeners.action.InvUseOnItemListener;
import org.nemotech.rsc.plugins.listeners.executive.InvUseOnItemExecutiveListener;

public class InvUseOnItem implements InvUseOnItemListener, InvUseOnItemExecutiveListener {

    int[] capes = { 183, 209, 229, 511, 512, 513, 514 };
    int[] dye = { 238, 239, 272, 282, 515, 516 };
    int[] newCapes = { 183, 512, 229, 513, 511, 514 };
    
    @Override
    public void onInvUseOnItem(Player player, InvItem item1, InvItem item2) {
        /**
         * Dye the wig with yellow dye and get blonde wig for Prince Ali rescue Quest
         */
        if(item1.getID() == 245 && item2.getID() == 239) {
            if(player.getInventory().remove(new InvItem(239)) > -1 && player.getInventory().remove(new InvItem(245)) > -1) {
                player.message("You dye the wig blond");
                player.getInventory().add(new InvItem(244));
                
                return;
            }
        }
        if(item1.getID() == 136 && item2.getID() == 783 || item1.getID() == 783 && item2.getID() == 136) {
            if(player.getInventory().remove(new InvItem(136)) > -1 && player.getInventory().remove(new InvItem(783)) > -1) {
                player.message("you mix the flour with the swamp tar");
                player.message("it mixes into a paste");
                player.getInventory().add(new InvItem(784));
                
                return;
            }
        }
        if(item1.getID() == 166 && item2.getID() == 600 || item1.getID() == 600 && item2.getID() == 166) {
            if(player.getInventory().remove(new InvItem(600)) > -1) {
                player.message("You light the candle");
                player.getInventory().add(new InvItem(602));
                
                return;
            }
        }
        if(item1.getID() == 166 && item2.getID() == 599|| item1.getID() == 599 && item2.getID() == 166) {
            if(player.getInventory().remove(new InvItem(599)) > -1) {
                player.message("You light the candle");
                player.getInventory().add(new InvItem(601));
                
                return;
            }
        }
        if(item1.getID() == 587 && item2.getID() == 457 || item1.getID() == 457 && item2.getID() == 587) {
            if(player.getInventory().remove(new InvItem(457)) > -1 && player.getInventory().remove(new InvItem(587)) > -1) {
                if(player.getMaxStat(15) >= 25) {
                    player.message("You mix the slime into your potion");
                    player.getInventory().add(new InvItem(588));
                    
                } else {
                    player.message("You need a level of 25 herblaw to mix this potion");
                }
            }
            return;
        }
        if(item1.getID() == 588 && item2.getID() == 377 || item1.getID() == 377 && item2.getID() == 588) {
            if(player.getInventory().remove(new InvItem(588)) > -1 && player.getInventory().remove(new InvItem(377)) > -1) {
                player.message("You rub the oil onto the fishing rod");
                player.getInventory().add(new InvItem(589));
                
            } 
            return;
        }
        if(item1.getID() == 778 && item2.getID() == 776 || item1.getID() == 776 && item2.getID() == 778) {
            if(player.getInventory().remove(new InvItem(776)) > -1) {
                player.message("you hold the glass to the sun");
                player.message("above the damp sticks");
                World.getWorld().getDelayedEventHandler().add(new ShortEvent(player) {
                    public void action() {
                        owner.message("the glass acts like a lens");
                        owner.message("and drys the sticks out");
                    }
                });
                player.getInventory().add(new InvItem(777));
                
                return;
            }
        }
        if(item1.getID() == 22 && item2.getID() == 772 || item1.getID() == 772 && item2.getID() == 22) {
            if(player.getInventory().remove(new InvItem(22)) > -1 && player.getInventory().remove(new InvItem(772)) > -1) {
                player.message("You mix the chocolate into the bucket");
                player.getInventory().add(new InvItem(770));
                
            }
            return;
        }
        if(item1.getID() == 770 && item2.getID() == 469 || item1.getID() == 469 && item2.getID() == 770) {
            if(player.getInventory().remove(new InvItem(770)) > -1 && player.getInventory().remove(new InvItem(469)) > -1) {
                player.message("You mix the snape grass into the bucket");
                player.getInventory().add(new InvItem(771));
                
            }
            return;
        }



        /**
         * Wine and combine Dyes
         */

        if(item1.getID() == 143 && item2.getID() == 141) { // wine
            if (player.getInventory().remove(new InvItem(143)) > -1 && player.getInventory().remove(new InvItem(141)) > -1) {
                player.message("You combine the grapes and water to make wine");
                player.getInventory().add(new InvItem(142));
                
                return;
            }
        }
        if (item1.getID() == 1276 && item2.getID() == 1277) {
            if (player.getInventory().remove(new InvItem(1276)) > -1 && player.getInventory().remove(new InvItem(1277)) > -1) {
                player.message("You combine the two parts.");
                player.getInventory().add(new InvItem(1278));
                
                return;
            }
        }
        if (item1.getID() == 238 && item2.getID() == 239 || item1.getID() == 239 && item2.getID() == 238) {
            if (player.getInventory().remove(new InvItem(239)) > -1 && player.getInventory().remove(new InvItem(238)) > -1) {
                player.getInventory().add(new InvItem(282));
                player.message("You mix the Dyes");
                
                return;
            }
        }
        if (item1.getID() == 238 && item2.getID() == 272 || item1.getID() == 272 && item2.getID() == 238) {
            if (player.getInventory().remove(new InvItem(272)) > -1 && player.getInventory().remove(new InvItem(238)) > -1) {
                player.getInventory().add(new InvItem(516));
                player.message("You mix the Dyes");
                
                return;
            }
        }
        if (item1.getID() == 239 && item2.getID() == 272 || item1.getID() == 272 && item2.getID() == 239) {
            if (player.getInventory().remove(new InvItem(272)) > -1 && player.getInventory().remove(new InvItem(239)) > -1) {
                player.getInventory().add(new InvItem(515));
                player.message("You mix the Dyes");
                
                return;
            }
        }


        for (Integer il : capes) {
            if (il == item1.getID()) {
                for (int i = 0; i < dye.length; i++) {
                    if (dye[i] == item2.getID()) {
                        if (player.getInventory().remove(new InvItem(item1.getID())) > -1 && player.getInventory().remove(new InvItem(item2.getID())) > -1) {
                            player.message("You dye the Cape");
                            player.getInventory().add(new InvItem(newCapes[i]));
                            
                            return;
                        }
                    }
                }
            } 
            else if (il == item2.getID()) {
                for (int i = 0; i < dye.length; i++) {
                    if (dye[i] == item1.getID()) {
                        if (player.getInventory().remove(new InvItem(item1.getID())) > -1 && player.getInventory().remove(new InvItem(item2.getID())) > -1) {
                            player.message("You dye the Cape");
                            player.getInventory().add(new InvItem(newCapes[i]));
                            
                            return;
                        }
                    }
                }
            }
        }
        if (item1.getID() == 273 && item2.getID() == 282 || item1.getID() == 282 && item2.getID() == 273) {
            if (player.getInventory().remove(new InvItem(282)) > -1 && player.getInventory().remove(new InvItem(273)) > -1) {
                player.getInventory().add(new InvItem(274));
                player.message("You dye the goblin armor");
                
                return;
            }
        }
        if (item1.getID() == 273 && item2.getID() == 272 || item1.getID() == 272 && item2.getID() == 273) {
            if (player.getInventory().remove(new InvItem(272)) > -1 && player.getInventory().remove(new InvItem(273)) > -1) {
                player.getInventory().add(new InvItem(275));
                player.message("You dye the goblin armor");
                
                return;
            }
        }
        else if (item1.getID() == 526 && combineKeys(player, item1, item2)) {
            return;
        } 
        else if (item2.getID() == 526 && combineKeys(player, item2, item1)) {
            return;
        }
    }

    private boolean combineKeys(Player player, final InvItem firstHalf, final InvItem secondHalf) {
        if (secondHalf.getID() != 527) {
            return false;
        }
        if (player.getInventory().remove(firstHalf) > -1 && player.getInventory().remove(secondHalf) > -1) {
            player.message("You combine the key halves to make a crystal key.");
            player.getInventory().add(new InvItem(525, 1));

        }
        return true;
    }

    @Override
    public boolean blockInvUseOnItem(Player player, InvItem item1, InvItem item2) {
        if(item1.getID() == 1276 && item2.getID() == 1277)
            return true;
        if(item1.getID() == 238 && item2.getID() == 239 || item1.getID() == 239 && item2.getID() == 238)
            return true;
        if(item1.getID() == 238 && item2.getID() == 272 || item1.getID() == 272 && item2.getID() == 238)
            return true;
        if(item1.getID() == 239 && item2.getID() == 272 || item1.getID() == 272 && item2.getID() == 239)
            return true;
        if(item1.getID() == 273 && item2.getID() == 282 || item1.getID() == 282 && item2.getID() == 273)
            return true;
        if(item1.getID() == 273 && item2.getID() == 272 || item1.getID() == 272 && item2.getID() == 273)
            return true;
        if(item1.getID() == 136 && item2.getID() == 783 || item1.getID() == 783 && item2.getID() == 136)
            return true;
        if(item1.getID() == 166 && item2.getID() == 600 || item1.getID() == 600 && item2.getID() == 166) 
            return true;
        if(item1.getID() == 166 && item2.getID() == 599 || item1.getID() == 599 && item2.getID() == 166) 
            return true;
        if(item1.getID() == 587 && item2.getID() == 457 || item1.getID() == 457 && item2.getID() == 587) 
            return true;
        if(item1.getID() == 588 && item2.getID() == 377 || item1.getID() == 377 && item2.getID() == 588) 
            return true;
        if(item1.getID() == 778 && item2.getID() == 776 || item1.getID() == 776 && item2.getID() == 778)
            return true;
        if(item1.getID() == 22 && item2.getID() == 772 || item1.getID() == 772 && item2.getID() == 22)
            return true;
        if(item1.getID() == 770 && item2.getID() == 469 || item1.getID() == 469 && item2.getID() == 770) 
            return true;
        /**
         * prince ali rescue dye wig and yellow die to blond wig
         */
        if(item1.getID() == 245 && item2.getID() == 239 || item1.getID() == 239 && item2.getID() == 245)
            return true;
        if(item1.getID() == 526 && item2.getID() == 527 || item1.getID() == 527 && item2.getID() == 526)
            return true;
        if(item1.getID() == 143 && item2.getID() == 141)
            return true;

        for(int il : capes) {
            if(il == item1.getID()) {
                return true;
            }
        }
        return false;
    }
}
