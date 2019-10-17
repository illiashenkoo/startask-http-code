# StartaskHttpCode
[![JitPack](https://jitpack.io/v/illiashenkoo/startask-http-code.svg)](https://jitpack.io/#illiashenkoo/startask-http-code)

Represents an HTTP status code in Kotlin for Android.

![](https://raw.githubusercontent.com/illiashenkoo/startask-http-code/master/images/logo.png)
## Using in your projects

### ![Gradle](https://raw.githubusercontent.com/illiashenkoo/startask-http-code/master/images/ic_gradle.png) Gradle

The library is published to [JitPack](https://jitpack.io/#illiashenkoo/startask-http-code) repository.

1. Add the JitPack repository to your root build.gradle at the end of repositories.
```groovy
allprojects {
    repositories {
        //...
        maven { url 'https://jitpack.io' }
    }
}
```

2. Add the dependency

`${latest.version}` is [![](https://jitpack.io/v/illiashenkoo/startask-http-code.svg)](https://jitpack.io/#illiashenkoo/startask-http-code)

```groovy
dependencies {
    implementation "com.github.illiashenkoo:startask-http-code:${latest.version}"
}
```

### ![Kotlin](https://raw.githubusercontent.com/illiashenkoo/startask-http-code/master/images/ic_kotlin.png) Usage with Kotlin

1. Create a `HttpStatusCode` object
```kotlin
    HttpStatusCode.fromValue(200)
```

2. Use `HttpStatusCode` object
``` kotlin
    when (response.toHttpStatusCode()) {
        HttpStatusCode.OK -> {
            // do something
        }
        HttpStatusCode.NotFound -> {
            // do something
        }
        else -> {
            // do something
        }
    }
```

3. Use `HttpStatusCode` object

``` kotlin
    val statusCode = response.toHttpStatusCode()
    if(statusCode.isNoContent()){
        //do something
    }
```

4. Extension function for Retrofit2 Response
``` kotlin
    import net.codecision.startask.http.code.HttpStatusCode
    import retrofit2.Response
    
    fun <T> Response<T>.toHttpStatusCode(): HttpStatusCode {
        return HttpStatusCode.fromValue(code())
    }
```

[Look at the examples of using the library](https://github.com/illiashenkoo/startask-http-code/blob/master/sample/src/main/java/net/codecision/startask/http/code/sample/MainActivity.kt)

## License

[Apache License 2.0](https://github.com/illiashenkoo/startask-http-code/blob/master/LICENSE)

## Contacts

[Oleg Illiashenko](mailto:illiashenkoo.dev@gmail.com)

## Contributions and releases

All development (both new features and bug fixes) is performed in `develop` branch. 
This way `master` sources always contain sources of the most recently released version.
Please send PRs with bug fixes to `develop` branch.
Fixes to documentation in markdown files are an exception to this rule. They are updated directly in `master`.
                                                                          
The `develop` branch is pushed to `master` during release.