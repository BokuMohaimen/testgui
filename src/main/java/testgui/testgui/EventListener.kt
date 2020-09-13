package testgui.testgui

import org.bukkit.Bukkit
import org.bukkit.Sound
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryType
import java.io.Console
import java.util.logging.Logger

class EventListener(var plg : Testgui, val log : Logger = plg.getLogger()) : Listener {
    init {
        plg.server.pluginManager.registerEvents(this, plg)
        log.info("イベントを登録しました。")
    }

    @EventHandler
    fun playerInteractEvent(e: InventoryClickEvent) {
        val player: Player? = e.whoClicked as? Player
        when (e.whoClicked.openInventory.title) {
            "INV1" -> {
                e.isCancelled = true

                if (e.clickedInventory?.type == InventoryType.CHEST) {
                    when (e.currentItem?.itemMeta?.displayName) {
                        "§6§lGOD" -> {
                            player?.sendMessage("§6§lGODボタンをクリックしました。")
                            player?.playSound(player?.getLocation(), "slot.godsoroi_2", 1.0f, 1.0f)
                        }

                        "ボタン2" -> {
                            player?.sendMessage("§c§lトーマスをクリックしました。")
                            player?.playSound(player?.getLocation(), Sound.ENTITY_EVOKER_DEATH, 1.0f, 1.0f)
                        }
                    }
                }
            }
        }
    }
}