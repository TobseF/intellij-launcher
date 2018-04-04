import java.io.File
import java.nio.file.Path
import java.nio.file.Paths

var projectArg = System.getProperty("project")
val appData = System.getenv("LOCALAPPDATA")!!
var toolboxPath = "$appData/JetBrains/Toolbox"
var channelsPath = "$toolboxPath/apps/IDEA-U/ch-0/"
var runtimeSuffix = "/bin/idea64.exe"

fun isVersion(version: String) = version.matches("[0-9]+(\\.[0-9]+)*".toRegex())

fun runIntelliJ() {
    File(channelsPath).walkTopDown().maxDepth(1).map { it.name }.filter { isVersion(it) }.map { Version(it) }
            .sortedDescending().first().let { getPath(it) }.let {
                log(it)
                exec(it)
            }
}

fun log(path: Path) = println("executing $path with project ${projectArg ?: "- none"}")

fun exec(path: Path) = Runtime.getRuntime().exec("$path ${projectArg.orEmpty()}")

fun getPath(version: Version) = Paths.get(channelsPath + version.version + runtimeSuffix).toAbsolutePath()!!

fun main(args: Array<String>) {
    args.asIterable().first { it.startsWith("project=") }.substringAfter("project=").let { projectArg = it }
    runIntelliJ()
}

data class Version(val version: String) : Comparable<Version> {

    private fun String.split() = this.split("\\.".toRegex()).toTypedArray()

    override fun compareTo(other: Version): Int {
        val thisParts = version.split()
        val thatParts = other.version.split()
        val length = Math.max(thisParts.size, thatParts.size)
        for (i in 0 until length) {
            val thisPart = if (i < thisParts.size) Integer.parseInt(thisParts[i])
            else 0
            val thatPart = if (i < thatParts.size) Integer.parseInt(thatParts[i])
            else 0
            if (thisPart < thatPart) return -1
            if (thisPart > thatPart) return 1
        }
        return 0
    }
}