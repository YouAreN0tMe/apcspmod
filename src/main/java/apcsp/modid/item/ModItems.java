package apcsp.modid.item;


import java.util.List;

import apcsp.modid.Apcspmod;
import apcsp.modid.item.custom.ChiselItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    //^ this creates a new item to create another you just have to copy this line and change the item id
    //  also if you add a new item you have to add it in the registerModItems function
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));
    public static final Item ZOMBIFIED_SCRAP = registerItem("zombified_scrap", new Item(new Item.Settings()));
    public static final Item HEAVIER_CORE = registerItem("heavier_core", new Item(new Item.Settings()));

    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(3)));

    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.apcspmod.cauliflower"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Apcspmod.MOD_ID, name), item);
    //  ^ this registers the new item
    }

    public static void registerModItems() {
        Apcspmod.LOGGER.info("Registering Mod Items for " + Apcspmod.MOD_ID);
    //  ^ this just tell the LOGGER what its doing rn
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
            entries.add(ZOMBIFIED_SCRAP);
            entries.add(HEAVIER_CORE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(CAULIFLOWER);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.add(STARLIGHT_ASHES);
        });
    }

    
    //  this adds the Pink Garnet to the Ingredients tab of creative mode
}
