# intellij-launcher
Kotlin script that launches the latest installed IntelliJ with a specified project.
This can be useful to launch IntelliJ e.g. on system startup.
It provides a permanent shortcut which survives any update.

## Requirements
* IntelliJ Ultimate (can be changed)
* Java Runtime or [blaze](https://github.com/fizzed/blaze)

## Usage
Yes there are many ways to run that thing:wink:

### Variant 1 (Windows only)
Run intellij-runner.exe with click/bash/link
``` shell
intellij-runner.exe project={your-path}
```

### Variant 2
Run intellij-runner.jar with click/bash/link
``` shell
java -jar intellij-runner.jar project={your-path}
```

### Variant 3
Rename script to `.kts` and run as kotlin script.
``` shell
kotlinc -script intellij-runner.kts
```

### Variant 4
Run wih script with [blaze](https://github.com/fizzed/blaze):
``` shell
java -jar blaze.jar runIntelliJ

# or with project
java -jar -Dproject=C:\Users\your-project blaze.jar runIntelliJ
```
