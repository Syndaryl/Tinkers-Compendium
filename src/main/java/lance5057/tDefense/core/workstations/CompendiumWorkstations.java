package lance5057.tDefense.core.workstations;

import lance5057.tDefense.Reference;
import lance5057.tDefense.TinkersCompendium;
import lance5057.tDefense.core.workstations.blocks.FinishingAnvilBlock;
import lance5057.tDefense.core.workstations.gui.armorstation.ArmorStationContainer;
import lance5057.tDefense.core.workstations.gui.armorstation.ArmorStationGui;
import lance5057.tDefense.core.workstations.gui.finishinganvil.FinishingAnvilContainer;
import lance5057.tDefense.core.workstations.gui.finishinganvil.FinishingAnvilGui;
import lance5057.tDefense.core.workstations.tileentities.ArmorStationTile;
import lance5057.tDefense.core.workstations.tileentities.FinishingAnvilTile;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class CompendiumWorkstations {

	public static final int ArmorStationID = 0;
	public static final int FinishingAnvilID = 1;

	public static FinishingAnvilBlock finishingAnvil;
	private ItemBlock FinishingAnvilItem;

	public void preInit(FMLPreInitializationEvent e) {
		
	}

	public void init(FMLInitializationEvent e) {

	}

	public void postInit(FMLPostInitializationEvent e) {

	}

	public void registerItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry registry = event.getRegistry();
		
		FinishingAnvilItem = (ItemBlock) new ItemBlock(finishingAnvil).setRegistryName(finishingAnvil.getRegistryName());
		
		registry.register(FinishingAnvilItem);
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		TinkersCompendium.proxy.registerItemBlockRenderer(finishingAnvil, 0, "finishinganvil");
	}

	//@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();
		
		finishingAnvil = new FinishingAnvilBlock();

		registry.register(finishingAnvil);
		
		GameRegistry.registerTileEntity(FinishingAnvilTile.class, "finishinganviltile");
	}

	public static Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		
		switch (ID) {
		case ArmorStationID:
			return new ArmorStationContainer(player.inventory, (ArmorStationTile) world.getTileEntity(pos));
		case FinishingAnvilID:
			return new FinishingAnvilContainer(player.inventory, (FinishingAnvilTile) world.getTileEntity(pos));
		}
		return null;
	}

	public static Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		BlockPos pos = new BlockPos(x, y, z);
		
		switch (ID) {
		case ArmorStationID:
			return new ArmorStationGui(player.inventory, world, pos,
					(ArmorStationTile) world.getTileEntity(pos));
		case FinishingAnvilID:
			return new FinishingAnvilGui(player.inventory, world, pos,
					(FinishingAnvilTile) world.getTileEntity(pos));
		}
		return null;
	}
}
