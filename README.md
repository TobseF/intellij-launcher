# intellij-launcher
Kotlin script that launches the latest installed IntelliJ with a specified project

## Usage

**Variant 1**
Rename script to `.kts` and run as kotlin script.

**Variant 2**
Run wih  [blaze](https://github.com/fizzed/blaze):
``` shell
java -jar blaze.jar runIntelliJ

# or with project
java -jar -Dproject=C:\Users\your-project blaze.jar runIntelliJ
```
