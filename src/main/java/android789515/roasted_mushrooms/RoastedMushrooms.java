package android789515.roasted_mushrooms;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoastedMushrooms implements ModInitializer {
	public static final String MOD_ID = "roasted_mushrooms";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
      RegistryKey<Item> roastedBrownMushroom = RegistryKey.of(
         RegistryKeys.ITEM,
         Identifier.of(MOD_ID, "roasted_brown_mushroom")
      );

      final Item ROASTED_BROWN_MUSHROOM = new Item(
         new Item.Settings().food(
            new FoodComponent.Builder()
               .saturationModifier(.1f)
               .hunger(1)
               .build()
         )
      );
      
      Registry.register(
            Registries.ITEM,
            roastedBrownMushroom,
            ROASTED_BROWN_MUSHROOM
      );
      
      RegistryKey<Item> roastedRedMushroom = RegistryKey.of(
         RegistryKeys.ITEM,
         Identifier.of(MOD_ID, "roasted_red_mushroom")
      );

      final Item ROASTED_RED_MUSHROOM = new Item(
         new Item.Settings().food(
            new FoodComponent.Builder()
            .saturationModifier(.1f)
            .hunger(1)
            .build()
         )
      );

      Registry.register(
         Registries.ITEM,
         roastedRedMushroom,
         ROASTED_RED_MUSHROOM
      );

      ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
         .register((itemGroup) -> {
            itemGroup.add(ROASTED_BROWN_MUSHROOM);
            itemGroup.add(ROASTED_RED_MUSHROOM);
         });

		LOGGER.info("Hello Fabric world!");
	}
}
