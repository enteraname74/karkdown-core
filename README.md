# karkdown-core
Core elements of the [karkdown software](https://github.com/enteraname74/Karkdown).

The aim of this project is to provide a set of tools to work with markdown elements in Kotlin.

## Supported markdown elements

Currently, the supported markdown elements are:

- bold, italic, strikethrough text
- header
- blockquote
- unordered list
- ordered list
- check list
- image
- link
- horizontal rule
- simple code blocks

## Using karkdown-core

1. Initialize a `FileManager`
```kotlin
val fileManager = FileManager()
```

2. Set the content of the file manager
```kotlin
// From a file
fileManager.fromFile(path = "/path/to/file.md")

// From lines
fileManager.fromLines(
    lines = listOf(
        "# Hello",
        "world",
    )
)
```
3. Use the file manager 

You have multiple methods to work with your markdown elements.

Example:
```kotlin
fileManager.createNewLine(
    pos = 2, 
    initialText = "> My blockquote"
)
val line = fileManager.getLineAt(pos = 2)
// > My blockquote
```
