<img alt="KODEIN" src="https://raw.githubusercontent.com/kosi-libs/Kodein/master/doc/modules/ROOT/images/kodein-di-logo.svg" width="700">

[![Kotlin](https://img.shields.io/badge/Kotlin-1.8.20-blue.svg?style=flat&logo=kotlin)](https://kotlinlang.org)
[![Maven Central](https://img.shields.io/maven-central/v/org.kodein.di/kodein-di)](https://mvnrepository.com/artifact/org.kodein.di/kodein-di)
![Github Actions](https://github.com/kosi-libs/Kodein/workflows/build%20and%20publish%20a%20snapshot/badge.svg)
[![MIT License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/kosi-libs/Kodein/blob/master/LICENSE.txt)
[![Slack channel](https://img.shields.io/badge/Chat-Slack-green.svg?style=flat&logo=slack)](https://kotlinlang.slack.com/messages/kodein/)

KOtlin DEpendency INjection
===========================

**_KODEIN_** is a very simple and yet very useful dependency retrieval container. it is very easy to use and configure.

**_KODEIN_** works:

- On the JVM.
- On Android.
- On Javascript (both in the browser and on Node.js).
- On Native platforms (such as iOS).

**_KODEIN_** allows you to:

- Lazily instantiate your dependencies when needed
- Stop caring about dependency initialization order
- Easily bind classes or interfaces to their instance or provider
- Easily debug your dependency bindings and recursions

**_KODEIN_** provides extensions to be integrable into:

- [Android](https://developer.android.com/)
- [Compose (Android / Desktop)](https://kosi-libs.org/kodein/7.19/framework/compose.html)
- [Ktor](https://ktor.io/)
- [TornadoFX](https://tornadofx.io/)

An example is always better than a thousand words:

```kotlin
val di = DI {
    bindProvider<Dice> { RandomDice(0, 5) }
    bindSingleton<DataSource> { SqliteDS.open("path/to/file") }
}

class Controller(private di: DI) {
    private val ds: DataSource by di.instance()
}
```

**_KODEIN_** is a good choice because:

- It proposes a very simple and readable declarative DSL
- It is not subject to type erasure (as Java is)
- It integrates nicely with Android
- It proposes a very kotlin-esque idiomatic API
- It is fast and optimized (makes extensive use of `inline`)
- It can be used in plain Java

Kotlin & JVM compatibility
---------

|   Kodein    | Kotlin |   JDK   |      Compose       |
|:-----------:|:------:|:-------:|:------------------:|
|   7.21.0    | 1.8.20 | min 17  |     Compatible     |
|   7.20.1    | 1.8.10 | min 1.8 |     Compatible     |
|   7.19.0    | 1.8.10 | min 1.8 |     Compatible     |
|   7.18.0    | 1.8.0  | min 1.8 |     Compatible     |
|   7.17.1    | 1.8.0  | min 1.8 |     Compatible     |
|   7.17.0    | 1.8.0  | min 1.8 |         No         |
|   7.16.0    | 1.7.20 | min 1.8 |     Compatible     |
|   7.15.1    | 1.7.20 | min 1.8 | Compatible (no JS) |
|   7.15.0    | 1.7.20 | min 1.8 |         No         |
|   7.14.0    | 1.7.10 | min 1.8 |     Compatible     |
|   7.13.1    | 1.7.0  | min 1.8 |     Compatible     |
|   7.13.0    | 1.7.0  | min 1.8 |         No         |
|   7.12.0    | 1.6.21 | min 1.8 |     Compatible     |
|   7.10.0    | 1.6.10 | min 1.8 |     Compatible     |
|    7.7+     |  1.5+  | min 1.8 |     Compatible     |
|    7.6+     |  1.5+  | min 1.8 |         -          |
|    7.1+     |  1.4+  | min 1.8 |         -          |
|    7.0+     | 1.3.72 | min 1.8 |         -          |
|    6.5.5    | 1.3.72 | min 1.8 |         -          |
|    6.5.4    | 1.3.71 | min 1.8 |         -          |
|    6.5.3    | 1.3.70 | min 1.8 |         -          |
|    6.5.0    | 1.3.61 | min 1.8 |         -          |
|    6.4.1    | 1.3.50 | min 1.8 |         -          |
|    6.3+     | 1.3.40 | min 1.8 |         -          |
|    6.2+     | 1.3.30 |   1.6   |         -          |
|    6.1+     | 1.3.20 |   1.6   |         -          |
|    6.0+     | 1.3.0  |   1.6   |         -          |
|    5.0+     | 1.2.30 |   1.6   |         -          |
|    4.1+     | 1.1.3  |   1.6   |         -          |
| 4.0.0-beta2 | 1.1.0  |   1.6   |         -          |

Read more
---------

**_KODEIN_** 7+ is the current major version, but documentation is available for previous versions.

**[Kodein documentation](https://kosi-libs.org/kodein/)**

Support
-------

Support is held in the [Kodein Slack channel](https://kotlinlang.slack.com/messages/kodein/)
(you can get an invitation to the Kotlin Slack [here](https://slack.kotlinlang.org/)).

Testimonies
-----------

&nbsp;

> At [Collokia](https://www.collokia.com/) we use Kodein in all of our backend service infrastructure and all modules in those services are loosely coupled through injection with Kodein.
> It allows us to have nice module independence, and to opt-out of injection during testing or build separate modules in support of testing.  
> It is a key component and building block in our architecture.  
> -- [Jayson Minard](https://github.com/apatrida)

&nbsp;

> At [Moovel Group GmbH](https://www.moovel.com/de/en), we have successfully used the wonderful Kodein library into in [this Android app](https://play.google.com/store/apps/details?id=com.daimler.moovel.android).
> As we improved it, we found Kodein to be much more useful than Dagger2 as it simplified our code throughout.  
> Kodein is in my view, much easier to understand, doesn't have that nasty ceremony, and has really nice debug messages.  
> We are also working now on other projects where we are using Kodein as well.  
> -- [Sorin Albu-Irimies](https://github.com/sorinirimies)

&nbsp;

> Kodein has been instrumental in moving our entire production application to Kotlin at [InSite Applications](https://insiteapplications.com). It uses standard Kotlin idioms and features for ultimate clarity and simplicity. It was clear to us from the beginning that Kodein would be our DI solution. Our devs love it so much that they've transitioned to using it in their personal apps, both Java and Kotlin!  
> -- [Eliezer Graber](https://github.com/eygraber)

&nbsp;

> At [Compsoft Creative](https://www.compsoft.co.uk), Kodein is central our new Kotlin based app architecture, giving us a solid underpinning to all apps we develop and allowing a simple yet powerful way to de-couple our services with a library that is lightweight and perfect for mobile apps.  
> -- [Daniel Payne](https://github.com/CompsoftCreative)

&nbsp;

> Kodein is used in [the android app of the OhelShem school](https://github.com/OhelShem/android).  
> -- [Yoav Sternberg](https://github.com/yoavst)&nbsp;

&nbsp;

> Kodein was created at [Dental Monitoring](https://dental-monitoring.com/) with the opinion that Dagger2 is way too verbose and complex.
> It is now used in almost all our projects: the server, the internal production software & the Android application.  
> Kodein is very easy to use and set up: it allows our team to easily share code and patterns, as well as quickly bootstrapping new ideas.  
> -- [Salomon Brys](https://github.com/SalomonBrys)

&nbsp;

If you are using KODEIN, please [let us know](mailto:contact@kodein.net)!
