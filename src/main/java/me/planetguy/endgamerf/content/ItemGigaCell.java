package me.planetguy.endgamerf.content;

import cofh.api.energy.IEnergyHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import me.planetguy.endgamerf.EndgameRFMod;
import me.planetguy.lib.prefab.ItemBase;

public class ItemGigaCell extends ItemBase{

	public ItemGigaCell() {
		super("gigaCell");
		// TODO Auto-generated constructor stub
	}
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World w, int x, int y, int z, int side, float par8, float par9, float par10){
		TileEntity te=w.getTileEntity(x, y, z);
		EndgameRFMod.playSound(w, x, y, z, "eee_vaporizer", 1.0f,(float) Math.random());
		if(te instanceof IEnergyHandler){
			((IEnergyHandler) te).receiveEnergy(ForgeDirection.values()[side], Integer.MAX_VALUE, false);
			return true;
		}

		return false;
	}

}
