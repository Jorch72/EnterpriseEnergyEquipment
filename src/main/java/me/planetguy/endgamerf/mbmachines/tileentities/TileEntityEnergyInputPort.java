package me.planetguy.endgamerf.mbmachines.tileentities;

import cofh.api.energy.IEnergyHandler;
import me.planetguy.endgamerf.api.v1.Types;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityEnergyInputPort extends TileEntityPort implements IEnergyHandler{

	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		return true;
	}

	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive,
			boolean simulate) {
		if(!simulate){
			if(this.machine!=null){
				this.machine.onReceive(Types.ENERGY, Integer.valueOf(maxReceive));
			}
		}
		return maxReceive;
	}

	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract,
			boolean simulate) {
		return 0;
	}

	@Override
	public int getEnergyStored(ForgeDirection from) {
		return 0;
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {
		return 0;
	}

}
