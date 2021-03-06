package me.planetguy.endgamerf;

import java.util.HashMap;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import me.planetguy.endgamerf.api.v1.IMachineCore;
import me.planetguy.endgamerf.api.v1.IMachineFrameBlock;
import me.planetguy.endgamerf.mbmachines.BlockMachineCore;
import me.planetguy.endgamerf.mbmachines.BlockMachinePort;
import me.planetguy.endgamerf.mbmachines.BlockMultiblockFrame;
import me.planetguy.endgamerf.test.ItemGigaCell;
import me.planetguy.lib.PLHelper;
import me.planetguy.lib.prefab.BlockBase;
import me.planetguy.lib.prefab.BlockContainerBase;
import me.planetguy.lib.prefab.CreativeTabPrefab;
import me.planetguy.lib.prefab.IPrefabItem;
import me.planetguy.lib.prefab.ItemBase;
import me.planetguy.lib.prefab.Prefabs;
import net.minecraft.block.Block;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IWorldAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Properties.modID, dependencies="required-after:planetguyLib")
public class EndgameRFMod {

	public static PLHelper helper=new PLHelper(Properties.modID);
	
	HashMap<String, IPrefabItem> map=new HashMap<String, IPrefabItem>();
	
	@EventHandler
	public void startup(FMLPreInitializationEvent pie){
		
		helper.load(BlockMultiblockFrame.class, map);
		
		helper.load(BlockMachineCore.class, map);
		
		helper.load(BlockMachinePort.class, map);
		
		helper.load(ItemGigaCell.class, map);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e){
		CreativeTabs tab=new CreativeTabPrefab(Properties.modID, new ItemStack(Items.record_11));
		for(IPrefabItem item:map.values()){
			item.setCreativeTab(tab);
		}
	}
	
	
	public static boolean isBlockAValidFrame(Block b) {
		return b instanceof IMachineFrameBlock;
	}

	public static boolean isBlockAValidCore(TileEntity te) {
		return te instanceof IMachineCore;
	}
	
	/**
	 * Plays the named (locally-named) sound at the given location.
	 * @param volume the volume relative to the original file; 1.0 is no change
	 * @param pitch the pitch (and length compression) relative to the original file; 1.0 is no change
	 */
	public static void playSound(World w, double x, double y, double z, String name, float volume, float pitch){
		helper.playSound(w, x, y, z, name, volume, pitch);
	}

}
