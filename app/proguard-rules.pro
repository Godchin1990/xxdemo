# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Develop\android\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
-optimizationpasses 5          # 指定代码的压缩级别
-dontusemixedcaseclassnames   # 是否使用大小写混合
-dontpreverify           # 混淆时是否做预校验
-verbose                # 混淆时是否记录日志
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*  # 混淆时所采用的算法
-keep public class * extends android.app.Activity      # 保持哪些类不被混淆
-keep public class * extends android.support.v7.app.AppCompatActivity      # 保持哪些类不被混淆
-keep public class * extends android.support.v7.app.FragmentActivity      # 保持哪些类不被混淆
-keep public class * extends android.app.Application   # 保持哪些类不被混淆
-keep public class * extends android.app.Service       # 保持哪些类不被混淆
-keep public class * extends android.content.BroadcastReceiver  # 保持哪些类不被混淆
-keep public class * extends android.content.ContentProvider    # 保持哪些类不被混淆
-keep public class * extends android.app.backup.BackupAgentHelper # 保持哪些类不被混淆
-keep public class * extends android.preference.Preference        # 保持哪些类不被混淆
-keep public class com.android.vending.licensing.ILicensingService    # 保持哪些类不被混淆

-keepclasseswithmembernames class * {  # 保持 native 方法不被混淆
    native <methods>;
}
-keepclasseswithmembers class * {   # 保持自定义控件类不被混淆
    public <init>(android.content.Context, android.util.AttributeSet);
}
-keepclasseswithmembers class * {# 保持自定义控件类不被混淆
    public <init>(android.content.Context, android.util.AttributeSet, int);
}
-keepclassmembers class * extends android.app.Activity { # 保持自定义控件类不被混淆
    public void *(android.view.View);
}
-keepclassmembers enum * {     # 保持枚举 enum 类不被混淆
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
-keep class * implements android.os.Parcelable { # 保持 Parcelable 不被混淆  aidl文件不能去混淆.
    public static final android.os.Parcelable$Creator *;
}
#保持 Serializable 不被混淆
-keepnames class * implements java.io.Serializable

#rxjava rxandroid混淆
-dontwarn rx.**
-keep class rx.**{*;}

#友盟统计混淆
-dontwarn org.apache.**
-keep class org.apache.**{*;}
-dontwarn android.support-v4.**
-keep class android.support-v4.**{*;}
-dontwarn android.support.v7.**
-keep class android.support.v7.**{*;}
-dontwarn com.alimama.mobile.**
-keep class com.alimama.mobile.**{*;}
-dontwarn com.umeng.**
-keep class com.umeng.**{*;}
-keepattributes Signature  #过滤泛型（不写可能会出现类型转换错误，一般情况把这个加上就是了）
-keepattributes *Annotation*  #假如项目中有用到注解，应加入这行配置
-keep public class com.umeng.fb.** { *;}
-keep public class com.umeng.fb.ui.ThreadView { }
-repackageclass com.umeng.fb.example.proguard
-keepclassmembers class * {
    public <init>(org.json.JSONObject);
}

#Apps flyer
-dontwarn com.appsflyer.**
-keep class com.appsflyer.**{*;}
#-repackageclass com.umeng.fb.example.proguard

#shapeloadingview
-dontwarn com.mingle.widget.**
-keep class com.mingle.widget.**{*;}

#Yiba class
-keep public class * extends android.support.v4.view.ActionProvider
-keepclassmembers public class * extends android.support.v4.view.ActionProvider {
    <init>(android.content.Context);
}
-keep class com.yiba.www.Native.**{*;}
-keep class sharewe.model.**{*;}
-keep class com.yiba.filemanager.**{*;}
-keep class com.yiba.www.p2pmanager.p2pentity.**{*;}
-keep class com.yiba.www.wifitransfer.**{*;}
-keep class com.yiba.www.p2pmanager.**{*;}
-keep class com.yiba.www.receiver.**{*;}
-keep class com.yiba.www.manager.MWiFiManager
-keep public class com.yiba.filemanager.R$*{
    public static final int *;
}
-keep public class www.godchin.demo.R$*{
    public static final int *;
}
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

#btkf
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }
-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}
-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

#baidu
-keep class com.baidu.** { *; }

#lite database
-keep class  com.litesuits.orm.** { *; }

#google glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public enum com.bumptech.glide.load.resource.bitmap.ImageHeaderParser$** {
    **[] $VALUES;
    public *;
}

#circle imageview
-keep public class de.hdodenhof.circleimageview.CircleImageView
-keep public class org.apache.http.** {*;}

#删除日志
-assumenosideeffects class android.util.Log {
    public static *** d(...);
    public static *** v(...);
    public static *** i(...);
}
#okhttp
-dontwarn okhttp3.**
-keep class okhttp3.**{*;}
-keep interface okhttp3.**{*;}
#okio
-dontwarn okio.**
-keep class okio.**{*;}
-keep interface okio.**{*;}
-dontwarn com.socks.**
-keep class  com.socks.**{*;}
-keep interface  com.socks.**{*;}
#facebook
-keep class com.facebook.ads.** { *; }
-dontwarn com.facebook.**
-keep public interface com.facebook.** {*;}
-keep class com.facebook.** {*;}
-keep enum com.facebook.**
-keepattributes Signature
-keep class com.facebook.android.** {*;}
-keep class android.webkit.WebViewClient
-keep class * extends android.webkit.WebViewClient
-keepclassmembers class * extends android.webkit.WebViewClient {
    <methods>;
}
##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-keep class sun.misc.Unsafe { *; }
#-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { *; }

##---------------End: proguard configuration for Gson  ----------

# Explicitly preserve all serialization members. The Serializable interface
# is only a marker interface, so it wouldn't save them.
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}
-keep public class * implements java.io.Serializable {*;}
#####################记录生成的日志数据,gradle build时在本项目根目录输出################
#apk 包内所有 class 的内部结构
-dump class_files.txt
#未混淆的类和成员
-printseeds seeds.txt
#列出从 apk 中删除的代码
-printusage unused.txt
#混淆前后的映射
-printmapping mapping.txt
#adjust
-keep class com.adjust.sdk.plugin.MacAddressUtil {
    java.lang.String getMacAddress(android.content.Context);
}
-keep class com.adjust.sdk.plugin.AndroidIdUtil {
    java.lang.String getAndroidId(android.content.Context);
}
-keep class com.google.android.gms.common.ConnectionResult {
    int SUCCESS;
}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient {
        com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
        getAdvertisingIdInfo (android.content.Context);
}
-keep class com.google.android.gms.ads.identifier.AdvertisingIdClient$Info {
    java.lang.String getId ();
    boolean isLimitAdTrackingEnabled();
}

#google map
-keep class * extends java.util.ListResourceBundle {
    protected Object[][] getContents();
}

-keep public class com.google.android.gms.common.internal.safeparcel.SafeParcelable {
    public static final *** NULL;
}

-keepnames @com.google.android.gms.common.annotation.KeepName class *
-keepclassmembernames class * {
    @com.google.android.gms.common.annotation.KeepName *;
}

-keepnames class * implements android.os.Parcelable {
    public static final ** CREATOR;
}


# 保持 native 方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}

# 保持自定义控件类不被混淆
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}
-keepclasseswithmembers class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclasseswithmembers class * {
    void onClick*(...);
}
-keepclasseswithmembers class * {
    *** *Callback(...);
}

# keep setters in Views so that animations can still work.
# see http://proguard.sourceforge.net/manual/examples.html#beans
-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}

# 保持自定义控件类不被混淆
-keepclassmembers class * extends android.app.Activity {
   public void *(android.view.View);
}

# 保持枚举 enum 类不被混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# 保持 Parcelable 不被混淆
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

-keepclassmembers class **.R$* {
    public static <fields>;
}

# http client
-keep class org.apache.http.** {*; }

# 微信
-keep class com.tencent.mm.sdk.openapi.WXMediaMessage {*;}
-keep class com.tencent.mm.sdk.openapi.** implements com.tencent.mm.sdk.openapi.WXMediaMessage$IMediaObject {*;}

# fastjson
-keep class com.alibaba.fastjson.**{*;}
# keep 所有的 javabean
-keep class com.goldnet.mobile.entity.**{*;}

-keep class org.apache.commons.lang.**{*;}

# 新浪微博
-keep class com.sina.**{*;}

#######
# 其它第三方库
#######
-dontwarn org.bouncycastle.**
-keep class org.bouncycastle.**{*;}

-dontwarn android-async-http-1.4.4.jar.**
-keep class android-async-http-1.4.4.jar.**{*;}

-dontwarn Decoder.**
-keep class Decoder.**{*;}

# volley
-dontwarn com.android.volley.jar.**
-keep class com.android.volley.**{*;}

# actionbarsherlock
-dontwarn com.actionbarsherlock.**
-keep class com.actionbarsherlock.**{*;}

# slidingmenu
-dontwarn com.jeremyfeinstein.slidingmenu.lib.**
-keep class com.jeremyfeinstein.slidingmenu.lib.**{*;}

-dontwarn com.cairh.app.sjkh.**
-keep class com.cairh.app.sjkh.**{*;}


