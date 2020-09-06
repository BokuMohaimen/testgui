package testgui.testgui

import org.bukkit.plugin.java.JavaPlugin

class Testgui : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        getCommand("mgui")?.setExecutor(guicommand)
        EventListener(this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}