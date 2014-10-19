package me.planetguy.endgamerf.mbmachines;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import me.planetguy.endgamerf.EndgameRFMod;
import me.planetguy.endgamerf.api.IMachineFrameBlock;
import me.planetguy.endgamerf.mbmachines.tileentities.TileEntityMultiblockFrame;
import me.planetguy.lib.multiblock.EnumMultiblock;
import me.planetguy.lib.prefab.BlockBase;
import me.planetguy.lib.prefab.BlockContainerBase;
import me.planetguy.lib.util.Debug;

public class BlockMultiblockFrame extends BlockContainerBase implements IMachineFrameBlock{

	public BlockMultiblockFrame(){
		super(Material.iron, "multiblockFrame", TileEntityMultiblockFrame.class);
	}
	
	public static void validateFrame(World w, int x, int y, int z){
		//filter by frame blocks
		int total=0;
		for(ForgeDirection dir:ForgeDirection.VALID_DIRECTIONS){
			total=total<<1;
			Block b=w.getBlock(x+dir.offsetX, y+dir.offsetY, z+dir.offsetZ);
			if(EndgameRFMod.isBlockAValidFrame(b)){
				total|=1;
			}
			
			Debug.dbg(total);
		}
		Debug.dbg(total);
		List<EnumMultiblock> e=EnumMultiblock.getPossiblePositions(total);
		
		Debug.dbg(e);
		//filter by center blocks
		EnumMultiblock result = null;
		for(EnumMultiblock mb:e){
			Block b=w.getBlock(x+mb.offsetsToInteriorBlock[0], y+mb.offsetsToInteriorBlock[1], z+mb.offsetsToInteriorBlock[2]);
			if(EndgameRFMod.isBlockAValidCore(b)){
				if(result == null){
					result=mb;
				}else{
					return; //ambiguous - no one center block at a possible position
				}
			}
		}
		TileEntityMultiblockFrame te=new TileEntityMultiblockFrame(result);
		w.setTileEntity(x, y, z, te);
	}
	
	
    public int onBlockPlaced(World w, int x, int y, int z, int side, float a, float b, float c, int meta){
    	validateFrame(w, x, y, z);
		return meta;
	}

}
