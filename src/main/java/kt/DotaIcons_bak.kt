/**
 * 提供该插件可用图标
 */
package kt
import com.intellij.openapi.util.IconLoader
import com.intellij.util.PlatformIcons
import model.DotaIcon
import java.lang.Exception
import javax.swing.Icon

object DotaIcons_bak {
    @JvmField
    val DOTA_ICON = load("/icons/dota_logo.png")

    private fun load(resourcePath: String): Icon {
        val icon = try {
            val url = DotaIcon::class.java.getResource(resourcePath)
            IconLoader.findIcon(url, true)
        } catch (e: Exception) {
            null
        }

        return icon ?: PlatformIcons.FILE_ICON
    }
}
