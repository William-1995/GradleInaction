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
