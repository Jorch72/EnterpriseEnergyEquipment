package me.planetguy.endgamerf.content;

import me.planetguy.lib.multiblock.EnumMultiblock;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMultiblockFrame extends TileEntity{
	
	public final EnumMultiblock position;
	
	public TileEntityMultiblockFrame(){
		this(null);
	}
	
	public TileEntityMultiblockFrame(EnumMultiblock block){
		position=block;
	}

}
