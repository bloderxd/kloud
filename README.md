# Cloud Architecture
This project is an example of cloud architecture and mvp implementation.

# What is Cloud architecture?
Sometimes in my android applications I really miss a beautiful solution to modules comunication, it's aways the same thing like static properties (not so static in kotlin, lol), saving instances and hope GC doesn't kill them, all this work only to develop a hello world (because I don't know how to do something different), it's boring... then I accepted the mission to change this, and cloud architecture is my attempt to change this boring scenario. And yes the project name is kloud with 'k' because of kotlin... well, I'm a revolutionary.

# How does it works?
Cloud architecture is based in a thing that I like too much, reactive programming, but don't worry, you don't need to think in how the hell you're going to do concurrency or something like that, you only need rxJava or rxWhateverLanguageYouAreCoding, and use a concept that I named Representers.

# Representer
Well, this is a concept that you have a class and a representative for it, just that. This class doesn't have any reference or instance in any place and only thing that knows it, is its representer but neither does that has the reference of class, it's like an protocol that you don't need to implement. Representers has all actions that class will need to do, and only thing that will call this actions is the cloud.

![alt tag](https://github.com/bloderxd/kloud/blob/master/app/src/main/res/drawable/representers-cloud.jpg) 

# Cloud
It's an abstraction that has a simple responsibility, say to representers to say to its classes to do something and how I said before it's totally reactive then you won't have aynchronous problems. Other classes can call any representers any time and doesn't matter where in stack an activity is or how deep a fragment is acting if you need to do something there, just tell to our friend cloud that you need that and you're problems are gone.

![alt tag](https://github.com/bloderxd/kloud/blob/master/app/src/main/res/drawable/cloud-post.jpg)
