# Android Templates

Lazy bones android templates for InkApplications.

## Getting started

Install [lazybones](https://github.com/pledbrook/lazybones) using gvm or from [lazybones bintray](https://bintray.com/pledbrook/lazybones-templates/lazybones/view)

Edit/create `~/.lazybones/config.groovy` and add the following.

    bintrayRepositories = [
      "inkapplications/templates",
      "pledbrook/lazybones-templates"
    ]

Run `lazybones list` to see all the available templates.
Run `lazybones create <template name> <template version> <target directory>` to create a new
project for example run `lazybones create android-lib my-awesome-lib` to create a new android
library project.
