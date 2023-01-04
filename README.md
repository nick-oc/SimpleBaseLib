# Android 基类
基于kotlin\
简单封装一下 [BaseActivity](library/src/main/java/org/nick/master/library/BaseActivity.kt)
和 [CommonAdapter](library/src/main/java/org/nick/master/library/adapter/CommonAdapter.kt)

## 使用

1. 添加仓库
```
repositories {
    ...
    maven { url 'https://jitpack.io' }
}
```

2.添加插件，特性，依赖
```
plugins {
    id 'kotlin-kapt'
}

···

android {
    ···
    buildFeatures {
        viewBinding true
        dataBinding true
    }
}
···

dependencies {
    implementation 'com.github.nick-oc:SimpleBaseLib:0.0.4'
}
```

3.混淆
```
-keep class 包名.databinding.* {*;}
```