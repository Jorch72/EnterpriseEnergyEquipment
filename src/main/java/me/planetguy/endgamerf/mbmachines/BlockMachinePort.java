package me.planetguy.endgamerf.mbmachines;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import me.planetguy.endgamerf.mbmachines.tileentities.TileEntityEnergyInputPort;
import me.planetguy.lib.prefab.BlockContainerBase;

public class BlockMachinePort extends BlockContainerBase{

	public BlockMachinePort() {
		super(Material.iron, "mbMachinePort", TileEntityEnergyInputPort.class);
	}

}
