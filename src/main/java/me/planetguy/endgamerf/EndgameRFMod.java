package me.planetguy.endgamerf;

import java.util.HashMap;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import me.planetguy.endgamerf.content.BlockMachineCore;
import me.planetguy.endgamerf.content.BlockMultiblockFrame;
import me.planetguy.endgamerf.content.ItemGigaCell;
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
import net.minecraft.world.IWorldAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Properties.modID)
public class EndgameRFMod {

	
	
	HashMap<String, IPrefabItem> map=new HashMap<String, IPrefabItem>();
	
	@EventHandler
	public void startup(FMLPreInitializationEvent pie){
		Prefabs.initialize(Properties.modID);
		
		BlockContainerBase.load(BlockMultiblockFrame.class, map);
		
		BlockContainerBase.load(BlockMachineCore.class, map);
		
		ItemBase.load(ItemGigaCell.class, map);
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e){
		CreativeTabs tab=new CreativeTabPrefab("foo", new ItemStack(Items.record_11));
		for(IPrefabItem item:map.values()){
			item.setCreativeTab(tab);
		}
	}
	
	
	public static boolean isBlockAValidFrame(Block b) {
		return b instanceof BlockMultiblockFrame;
	}

	public static boolean isBlockAValidCore(Block b) {
		return b==Blocks.coal_block;
	}
	
	public static void playSound(World w, double x, double y, double z, String name, float vol, float pitch){
		for(Object o:w.worldAccesses){
			IWorldAccess iwa=(IWorldAccess) o;
			iwa.playSound(Properties.modID+":"+name, x, y, z, vol, pitch);
		}
	}

}
