package me.planetguy.endgamerf.mbmachines;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import me.planetguy.lib.prefab.BlockContainerBase;

public class BlockMachinePort extends BlockContainerBase{

	protected BlockMachinePort() {
		super(Material.iron, "mbMachinePort", TileEntityEnergyInputPort.class);
	}

}
