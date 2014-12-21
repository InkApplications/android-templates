import uk.co.cacoethes.util.NameType
import org.apache.commons.io.FileUtils

def props = [:]

// settings.gradle

def libraryName = ask("Define what this library will be called [android-lib]: ", "android-lib", "name")
props.libraryName = transformText(libraryName, from: NameType.CAMEL_CASE, to: NameType.HYPHENATED)

// Move the library directory
def destFile = new File(projectDir, props.libraryName);
FileUtils.moveDirectory(new File(projectDir, "library"), destFile)

processTemplates "settings.gradle", props

// build.gradle
// Lazybones tries to fine a value for $version if this is left in the build.gradle. This is to get it to stop complaining.
props.versionString = "\$version\${project.hasProperty('release') ? '' : '-SNAPSHOT'}"
props.minSdkVersion = ask("Define the minimum Android SDK version this library should support [7]: ", "7", "minSdkVersion")

processTemplates "build.gradle", props

// gradle.properties
props.version = ask("Define the version number [1.0.0]: ", "1.0.0", "version")
props.group = ask("Define the group [com.example]: ", "com.example", "group")
props.description = ask("Define the description of this project [An example project]: ", "An example project", "description")

processTemplates "gradle.properties", props
