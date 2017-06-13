# Cloud Architecture
This project is an example of cloud architecture and mvp implementation.

# What is Cloud architecture?
Sometimes in my android applications I really miss a beautiful solution to modules comunication, it's aways the same thing like static properties (not so static in kotlin, lol), saving instances and hope GC doesn't kill them, all this work only to develop a hello world (because I don't know how to do something different), it's boring... then I accepted the mission to change this, and cloud architecture is my attempt to change this boring scenario. And yes the project name is kloud with 'k' because of kotlin... well, I'm a revolutionary.

# How does it works?
Cloud architecture is based in a thing that I like too much, reactive programming, but don't worry, you don't need to think in how the hell you're going to do concurrency or something like that, you only need rxJava or rxWhateverLanguageYouAreCoding, and use a concept that I named Representers.

# Representer
Well, this is a concept that you have a class and a representative for it, just that. This class doesn't have any reference or instance in any place and only thing that knows it, is its representer but neither does that has the reference of class, it's like an protocol that you don't need to implement. Representers has all actions that class will need to do, and only thing that will call this actions is the cloud.

![alt tag](https://github.com/bloderxd/kloud/blob/master/app/src/main/res/drawable/representers_cloud.jpg) 

# Cloud
It's an abstraction that has a simple responsibility, say to representers to say to its classes to do something and how I said before it's totally reactive then you won't have aynchronous problems. Other classes can call any representers any time and doesn't matter where in stack an activity is or how deep a fragment is acting if you need to do something there, just tell to our friend cloud that you need that and you're problems are gone.

![alt tag](https://github.com/bloderxd/kloud/blob/master/app/src/main/res/drawable/cloud_post.jpg)

# Time to code!
This repo is a implementation of this idea, you can see all this concepts in action, but let's show some simple examples with all cloud abstraction ready to be used:

Let's suppose you have two classes and you need to tell Bar class to update something from Foo class and when the update finishes, you need to notify Foo that update finished:

```kotlin
class Foo {

    fun updateBar() {}
    fun onBarUpdated() {}
}

class Bar {

    fun update() {}
    fun tellFooUpdateIsFinished() {}
}
```

Well, in a normal scenario you'd need these two classes instances and let these all methods public and a controller to make all comunication between them and... sorry, I slept, this is too boring, then let's make in a reactive and in a cloud way:

First of all, let's create our Foo and Bar representers:

```kotlin
sealed class FooRepresenter : Cloud.Representer {
    object onBarUpdated : FooRepresenter()
}

sealed class BarRepresenter : Cloud.Representer {
    object update : BarRepresenter()
}
```

Now let's implement in classes:

```kotlin
class Foo : Fragment(), CloudProtocol<FooRepresenter> {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerReceiver()
    }

    private fun updateBar() {
        cloud().post(BarRepresenter.update)
    }
    
    private fun onBarUpdated() {
        // Do something
    }
    
    override fun onReceive(event: FooRepresenter) {
        when(event) {
            is FooRepresenter.onBarUpdated -> onBarUpdated()
        }
    }
    
    override fun getRepresenter(): Class<FooRepresenter> = FooRepresenter::class.java
}

class Bar : Fragment(), CloudProtocol<BarRepresenter> {

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        registerReceiver()
    }

    private fun update() {
        // Update then call tellFooUpdateIsFinished()
    }
    
    private fun tellFooUpdateIsFinished() {
        cloud().post(FooRepresenter.onBarUpdated)
    }
    
    override fun onReceive(event: BarRepresenter) {
        when(event) {
            is BarRepresenter.update -> update()
        }
    }
    
    override fun getRepresenter(): Class<BarRepresenter> = BarRepresenter::class.java
}
```
These two classes are talking with each other without public properties, instances references, in a asynchrony way and in a clean and robust way.

# Reactive Problem
"I like reactive programming but to use in particular places, not in all the application... it becomes too magic to understand and maintain" Did you've already heard it? Me too, and I agree with that in some points, some times I find some reactive solutions and libs that doesn't make sense to use, it's just make a simple thing in a hard thing to implement and maintain, but when I thought about cloud architecture I tried to think in this case and the question is "This solves all problems in the world?" -> "no", "This solves my problem with my applications's context?" -> "yes". I'm just trying to say that you don't need to use something because it's nice, but use if you're sure that's will be usefull in your day-to-day. In my opinion Cloud architecture is simple to implement, simple to understand and simple to maintain.

# Contributing 
Hey! I like when people gives awesome ideas, if you have some other kotlin implementation tips or ideas about the architecture, please let me know.

# License

```
The MIT License (MIT)

Copyright (c) 2016 Bloder

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
