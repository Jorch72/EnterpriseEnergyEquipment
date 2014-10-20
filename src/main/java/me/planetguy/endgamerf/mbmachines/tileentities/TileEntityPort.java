package me.planetguy.endgamerf.mbmachines.tileentities;

import me.planetguy.endgamerf.api.IMachineCore;
import me.planetguy.endgamerf.api.IMachinePort;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityPort extends TileEntity implements IMachinePort{
	
	public IMachineCore machine;
	
	public void validate(){
		machine=null;
		for(ForgeDirection dir:ForgeDirection.VALID_DIRECTIONS){
			TileEntity te=worldObj.getTileEntity(xCoord+dir.offsetX, yCoord+dir.offsetY, zCoord+dir.offsetZ);
			if(machine==null){
				machine=(IMachineCore) te;
				super.validate();
			}else{
				super.invalidate();
				return;
			}
		}
	}

	@Override
	public void onOutputsUpdated() {}
	

}
