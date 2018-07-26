package cn.academy.ability.api.event;

import net.minecraft.entity.player.EntityPlayer;

/**
 * Fired at server when player's ability level has changed.
 * @author WeAthFolD
 */
public class LevelChangeEvent extends AbilityEvent {
    
    public LevelChangeEvent(EntityPlayer p) {
        super(p);
    }
    
}