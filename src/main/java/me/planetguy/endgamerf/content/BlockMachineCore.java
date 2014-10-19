package me.planetguy.endgamerf.content;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import me.planetguy.endgamerf.mbmachines.TileEntityVaporizer;
import me.planetguy.lib.prefab.BlockContainerBase;

public class BlockMachineCore extends BlockContainerBase{

	protected BlockMachineCore() {
		super(Material.iron, "blockMachineCore", TileEntityVaporizer.class); //TODO TE classes
	}

}
