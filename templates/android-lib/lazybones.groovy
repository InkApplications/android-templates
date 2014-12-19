def props = [:]
// Lazybones tries to fine a value for $version if this is left in the build.gradle. This is to get it to stop complaining.
props.versionString = "\$version\${project.hasProperty('release') ? '' : '-SNAPSHOT'}"
props.minSdkVersion = ask("Define the minimum Android SDK version this library should support [7]: ", "7", "minSdkVersion")

processTemplates "build.gradle", props