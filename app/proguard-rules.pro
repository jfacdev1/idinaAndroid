# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.

# Keep application classes and their members
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.view.View
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Fragment
-keep public class * extends androidx.fragment.app.Fragment
-keep public class * extends android.app.Dialog

# Keep native methods
-keepclasseswithmembernames class * {
    native <methods>;
}

# Keep custom views and their methods
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(***);
    *** get*();
}

# Keep setters in Views for animation
-keepclassmembers public class * extends android.view.View {
   void set*(***);
   *** get*();
}

# Keep Parcelable implementations
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

# Keep Serializable classes
-keepnames class * implements java.io.Serializable
-keepclassmembers class * implements java.io.Serializable {
    static final long serialVersionUID;
    private static final java.io.ObjectStreamField[] serialPersistentFields;
    private void writeObject(java.io.ObjectOutputStream);
    private void readObject(java.io.ObjectInputStream);
    java.lang.Object writeReplace();
    java.lang.Object readResolve();
}

# Keep R
-keep class **.R$* {
    <fields>;
}

# Keep BuildConfig
-keep class com.idina.languageadventure.BuildConfig { *; }

# Keep Kotlin metadata
-keepclassmembers class **.R$* {
    public static <fields>;
}

# Keep @Keep annotations
-keep,allowobfuscation @interface android.support.annotation.Keep
-keep @android.support.annotation.Keep class * {*;}
-keepclasseswithmembers class * {
    @android.support.annotation.Keep <methods>;
}
-keepclasseswithmembers class * {
    @android.support.annotation.Keep <fields>;
}
-keepclasseswithmembers class * {
    @android.support.annotation.Keep <init>(...);
}

# Keep ViewModels
-keep class * extends androidx.lifecycle.ViewModel {
    protected void onCleared();
}

# Keep LiveData
-keep class * extends androidx.lifecycle.LiveData {
    void setValue(java.lang.Object);
    void postValue(java.lang.Object);
}

# Keep data binding
-keep class androidx.databinding.** { *; }
-keep class com.idina.languageadventure.databinding.** { *; }

# Keep LibGDX classes
-keep class com.badlogic.gdx.** { *; }
-keep class com.badlogic.gdx.backends.android.AndroidApplicationConfiguration { *; }
-keep class com.badlogic.gdx.backends.android.AndroidFragmentApplication { *; }
-keep class com.badlogic.gdx.backends.android.AndroidApplication { *; }
-keep class com.badlogic.gdx.utils.GdxNativesLoader { *; }
-keep class com.badlogic.gdx.utils.SharedLibraryLoader { *; }
-keep class com.badlogic.gdx.physics.box2d.** { *; }
-keep class com.badlogic.gdx.graphics.g3d.** { *; }
-keep class com.badlogic.gdx.graphics.glutils.** { *; }
-keep class com.badlogic.gdx.assets.** { *; }
-keep class com.badlogic.gdx.files.** { *; }
-keep class com.badlogic.gdx.audio.** { *; }
-keep class com.badlogic.gdx.graphics.g2d.** { *; }
-keep class com.badlogic.gdx.graphics.** { *; }
-keep class com.badlogic.gdx.math.** { *; }
-keep class com.badlogic.gdx.utils.** { *; }
-keep class com.badlogic.gdx.Application { *; }
-keep class com.badlogic.gdx.ApplicationListener { *; }
-keep class com.badlogic.gdx.Gdx { *; }
-keep class com.badlogic.gdx.Screen { *; }
-keep class com.badlogic.gdx.Game { *; }
-keep class com.badlogic.gdx.graphics.GL20 { *; }
-keep class com.badlogic.gdx.graphics.GL30 { *; }
-keep class com.badlogic.gdx.graphics.GL30 { *; }
-keep class com.badlogic.gdx.graphics.GL31 { *; }
-keep class com.badlogic.gdx.graphics.GL32 { *; }

# Keep Koin
-keep class org.koin.** { *; }
-keepclassmembers class * {
    @org.koin.core.annotation.KoinReflector <methods>;
}

# Keep Firebase
-keep class com.google.firebase.** { *; }
-keep class com.google.android.gms.** { *; }
-keep class com.google.protobuf.** { *; }
-keep class com.google.errorprone.annotations.** { *; }
-keep class com.google.j2objc.** { *; }
-keep class com.google.firebase.provider.** { *; }

# Keep Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
    **[] $VALUES;
    public *;
}

# Keep Room
-keep class * extends androidx.room.RoomDatabase
-keep class * extends androidx.room.Entity
-keep class * extends androidx.room.Dao
-keepclassmembers class * {
    @androidx.room.* *;
}

# Keep Coroutines
-keepclassmembernames class kotlinx.** {
    volatile <fields>;
}

# Keep Retrofit
-keepattributes Signature
-keepattributes *Annotation*
-keep class okhttp3.** { *; }
-keep interface okhttp3.** { *; }
-keep class retrofit2.** { *; }
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn org.conscrypt.**

# Keep Gson
-keep class com.google.gson.** { *; }
-keep class com.google.gson.stream.** { *; }
-keep class com.google.gson.examples.android.model.** { *; }
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer
-keep class com.google.gson.Gson { *; }

# Keep annotations
-keepattributes *Annotation*
-keepattributes InnerClasses
-keepattributes EnclosingMethod
-keepattributes Signature
-keepattributes Exceptions
-keepattributes SourceFile,LineNumberTable
-keepattributes RuntimeVisibleAnnotations,AnnotationDefault
-keepattributes *Annotation*
-keep class * extends java.lang.annotation.Annotation { *; }
-keepclassmembers class * {
    @* <fields>;
}
-keepclassmembers class * {
    @* <methods>;
}

# Keep resources
-keepclassmembers class **.R$* {
    public static <fields>;
}

# Keep the application class
-keep public class com.idina.languageadventure.IdinaApplication
-keep public class com.idina.languageadventure.ui.MainActivity
-keep public class com.idina.languageadventure.game.IdinaGame

# Keep all classes that have @Keep annotation
-keep @androidx.annotation.Keep class * {*;}
-keepclassmembers class * {
    @androidx.annotation.Keep <fields>;
}
-keepclassmembers class * {
    @androidx.annotation.Keep <methods>;
}
-keepclassmembers class * {
    @androidx.annotation.Keep <init>(...);
}
