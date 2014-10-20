package me.planetguy.endgamerf.mbmachines.tileentities;

import java.util.Iterator;

import me.planetguy.endgamerf.api.Types;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityVaporizedItemPort extends TileEntityPort{
	
	public void onOutputsUpdated(){
		if(machine != null && ((TileEntity)machine).yCoord==this.yCoord-1){
			Iterator i=machine.contents(Types.VAPORIZED_ITEM);
			while(i.hasNext()){
				Object o=i.next();
				if(o instanceof ItemStack){
					TileEntity te=worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
					if(te instanceof TileEntityVaporizedItemPort){
						((TileEntityVaporizedItemPort) te).provide((ItemStack) o);
					}else{
						ItemStack stk=(ItemStack) o;
						Entity e;
						if(stk.getItem().hasCustomEntity(stk)){
							e=new Entity(worldObj){
								protected void entityInit() {}
								protected void readEntityFromNBT(
										NBTTagCompound p_70037_1_) {}
								protected void writeEntityToNBT(
										NBTTagCompound p_70014_1_) {}
							};
							e.setPosition(xCoord, yCoord+1, zCoord);
							e=stk.getItem().createEntity(worldObj, e, stk);
						}else{
							e=new EntityItem(worldObj, xCoord, yCoord+1, zCoord);
						}
						worldObj.spawnEntityInWorld(e);
					}
				}else{
					throw new RuntimeException("Machine passed a non-ItemStack thing as a "+Types.VAPORIZED_ITEM+" to ("+xCoord+","+yCoord+","+zCoord+")!");
				}
			}
		}
	}
	
	public void provide(ItemStack input){
		if(machine != null){
			machine.onReceive(Types.VAPORIZED_ITEM, input);
		}
	}

}
