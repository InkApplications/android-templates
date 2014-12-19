def props = [:]
props.minSdkVersion = ask("Define the minimum Android SDK version this library should support [7]: ", 7, "minSdkVersion")

processTemplates "build.gradle", props