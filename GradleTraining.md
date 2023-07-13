# Gradle training

## Groovy fundamentals:

### Collection

- List
  ```
    def arr = [1, 2]
    arr << 3
    for (item in items ) {
      println
    }
  ```
- Map
  ```
    def map = [a:2, b: new Date()]
    map.put("aaa", "bbb")
    println map
  ```

### Range

```
  def range=1..10
  for (r in range) {
    println r
  }
```

### Closure

```
def myClosure = {
  println "I am a closure"
}
<!-- myClosure.call() -->
myClosure()

def closureMethod = {int a, int b ->
  println "$a, $b"
}
closureMethod 1, 2
```

### Strategy

```
def totalPrices(prices, selector) {
    int total = 0
    for (int price:prices)
          if (selector(price))
             total += price
    total
}

println totalPrices([1,2,3,4,5,6,7,8,9,10]) {it < 10}
```

### Delegate

```
def a = {
    println "a this:" + this // this
    println "a owner:" + owner // point to b
    def b = {
        println "b this:" + this
        println "b owner: "+ owner // current scope
   }
   b.call()
}
a.call()
println this
```

```
def scriptClosure = {
   println "scriptClosure this: " + this
   println "scriptClosur owner: " + owner
   println "scriptClosure delegate: " + delegate
}
println "Before setDelegate()"
scriptClosure.call()
scriptClosure.setDelegate("abc")
println "After setDelegate()"
scriptClosure.call()
```

### Domain Specific Language (DSL)

```
class EmailDsl {
    def toText
    def fromText
    def body

    def static make (closure) {
       EmailDsl e = new EmailDsl();
       closure.delegate = e;
       closure()
       println e.buildResult()
    }

    def to (String toText) {
       this.toText = toText
    }

    def from (String fromText) {
       this.fromText = fromText
    }

    def body (String body) {
       this.body = body
    }

    def buildResult () {
       return """From $this.fromText To $this.toText, Body: $this.body """
    }
}

EmailDsl.make {
    to 'E1'
    from 'E2'
    body " Hello groovy DSL "
}
```
# Gradle
## Fundamentals
### Init Gradle
A settings.gradle file is used to config a root/parent project.
### Gradle Wrapper
The Wrapper is a script that invokes a declared version of Gradle, downloading it beforehand if necessary.
[Official documentation](https://docs.gradle.org/current/userguide/gradle_wrapper.html)
- A gradlew script in the Linux OS
- A gradlew.bat script in the Window OS
- Under root project's gradle/wrapper folder, which includes the configuration and a jar to run a JVM application.
### Gradle Deamon
[Official documentation](https://docs.gradle.org/current/userguide/gradle_daemon.html)
## Build Gradle Project
### Build Script
A build script is the current build.gradle's configuration.
### Task
A Task represents a single atomic piece of work for a build, such as compiling classes or generating javadoc.
[Official documentation](https://docs.gradle.org/current/dsl/org.gradle.api.Task.html)
### Plugin
A couple of reusable tasks.
### Project
- Project
- All Projects
- Sub Projects
