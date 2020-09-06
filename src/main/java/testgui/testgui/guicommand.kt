package testgui.testgui

import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

object guicommand : CommandExecutor{
    val util = Util()
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val player = (sender as? Player)
        if (args.isEmpty()) {
            sender.sendMessage("Usage: /mgui open")
            return false
        }
        return when(args[0]) {
            "open" -> {
                if ((sender as? Player) != null) {
                    player?.sendMessage("インベントリーを開きます。")
                    val guiList : Map<Int, ItemStack?> = mapOf(4 to util.createItem(ItemStack(Material.IRON_NUGGET),"§6§lGOD", listOf("ボタンのテスト"), 547),
                            22 to util.createItem(ItemStack(Material.IRON_HOE),"ボタン2", listOf("ボタン2"), 29))
                    val inventory = util.createInventoryGUI("INV1",27,guiList)

                    player?.openInventory(inventory)
                }
                true
            }

            else -> {
                sender.sendMessage("ELSE")
                true
            }
        }
    }
}