
-keep class org.nick.sample.databinding.* {*;}

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