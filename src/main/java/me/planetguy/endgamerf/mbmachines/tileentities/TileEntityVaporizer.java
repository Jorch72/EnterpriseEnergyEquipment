package me.planetguy.endgamerf.mbmachines.tileentities;

import java.util.Iterator;

import cpw.mods.fml.relauncher.Side;
import me.planetguy.endgamerf.EndgameRFMod;
import me.planetguy.endgamerf.Properties;
import me.planetguy.endgamerf.api.IMachineCore;
import me.planetguy.endgamerf.api.IMachineGui;
import me.planetguy.endgamerf.api.Types;
import me.planetguy.lib.util.ArrayIterator;
import me.planetguy.lib.util.Debug;
import me.planetguy.lib.util.EmptyIterator;
import me.planetguy.lib.util.SingleIterator;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityVaporizer extends TileEntity implements IMachineCore{

	public ItemStack inventory;
	
	public ItemStack object;
	
	@Override
	public Object onReceive(String form, Object input) {
		if(form.equals(Types.ITEM)){
			if(inventory==null){
				inventory=(ItemStack) input;
				return null;
			}else{
				return input;
			}
		}else if(form.equals(Types.ENERGY)){
			if(((Long) input)>=Properties.energyPerVaporizationOperation){
				EndgameRFMod.playSound(worldObj, xCoord, yCoord, zCoord, "eee_vaporizer", 1.0f,(float) Math.random());
				object=inventory;
				inventory=null;
			}
			return null;
		}else
			return null;
	}

	@Override
	public Iterator outputs(String form) {
		if(form.equals(Types.VAPORIZED_ITEM)){
			return new SingleIterator(object);
		}else{
			return EmptyIterator.instance;
		}
	}

	@Override
	public Iterator contents(String form) {
		return new ArrayIterator(new Object[]{inventory, object});
	}

	@Override
	public IMachineGui getGui() {
		return new IMachineGui(){
			
		};
	}

	
	

}
