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
    implementation 'com.github.nick-oc:SimpleBaseLib:1.0.0'
}
```

3.混淆

```
-keep class 包名.databinding.* {*;}

# 继承BaseXX类时如果不想在构造传参，需要添加以下规则,还需要keep住基类的派生类
-keep class org.nick.master.library.* {*;}
-keep class org.nick.master.library.adapter.* {*;}
-keep public class * extends org.nick.master.library.BaseActivity
-keep public class * extends org.nick.master.library.BaseFragment
-keep public class * extends org.nick.master.library.BaseDialog
-keep public class * extends org.nick.master.library.adapter.CommonAdapter

# 用到了 AbsCommonActivity 时,需要下面这个
-keep class org.nick.master.library.databinding.* {*;}

# keep 泛型
-keepattributes Signature
```