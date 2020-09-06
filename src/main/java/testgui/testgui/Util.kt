package testgui.testgui

import org.bukkit.Bukkit
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

class Util {
    fun createInventoryGUI(name: String,size: Int,itemList: Map<Int, ItemStack?>) : Inventory {
        val inventory = Bukkit.createInventory(null,size,name)
        itemList.forEach { (index,element) ->
            inventory.setItem(index, element)
        }
        return inventory
    }

    fun createItem(item: ItemStack, name: String?, lore: List<String?>, modeldata: Int): ItemStack? {
        val itemMeta = item.itemMeta
        itemMeta!!.setDisplayName(name)
        itemMeta.setCustomModelData(modeldata)
        itemMeta.lore = lore
        item.itemMeta = itemMeta
        return item
    }
}